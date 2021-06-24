package com.gouli.authentication.controller;

import com.alibaba.fastjson.JSON;
import com.gouli.authentication.entity.LogUser;
import com.gouli.authentication.entity.Oauth2Token;
import com.gouli.common.core.auth.ValidateCode;
import com.gouli.common.core.excetion.CustomException;
import com.gouli.common.core.filter.IgnoreReposeAdvice;
import com.gouli.common.core.responseresult.ResponseData;
import com.gouli.common.core.responseresult.ResultCodeEnum;
import com.gouli.common.redis.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


/**
 * 认证中心
 *
 * @author pengnanfa
 * @date 2021/1/15 8:45
 */
@Api(tags = "认证中心")
@RestController
@RequestMapping("/oauth")
@AllArgsConstructor
@Slf4j
public class AuthController {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 验证码位数
     */
    private final static int CODE_NUMBER = 4;
    /**
     * 验证码缓存时间
     */
    private final static long CODE_CACHE_TIME = 60 * 2 * 5L;

    private final TokenEndpoint tokenEndpoint;

    @ApiOperation("OAuth2认证生成token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grant_type", defaultValue = "password", value = "授权模式", required = true),
            @ApiImplicitParam(name = "client_id", defaultValue = "client", value = "Oauth2客户端ID", required = true),
            @ApiImplicitParam(name = "client_secret", defaultValue = "123456", value = "Oauth2客户端秘钥", required = true),
            @ApiImplicitParam(name = "refresh_token", value = "刷新token"),
            @ApiImplicitParam(name = "username", value = "登录用户名"),
            @ApiImplicitParam(name = "password", value = "登录密码"),
            @ApiImplicitParam(name = "code", value = "小程序code"),
            @ApiImplicitParam(name = "encryptedData", value = "包括敏感数据在内的完整用户信息的加密数据"),
            @ApiImplicitParam(name = "iv", value = "加密算法的初始向量"),
    })
    @PostMapping("/token")
    @IgnoreReposeAdvice
    public ResponseData<Oauth2Token> postAccessToken(
            @ApiIgnore Principal principal,
            @ApiIgnore @RequestParam Map<String, String> parameters
    ) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2Token oauth2Token = Oauth2Token.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .build();
        return ResponseData.success(oauth2Token);
    }

    @ApiOperation("用户密码模式登录，获取Token")
    @PostMapping("/login")
    public ResponseData<Oauth2Token> login(@Valid @RequestBody LogUser logUser) {

        if (logUser.getValidateCode() == null) {
            throw new CustomException(ResultCodeEnum.VALIDATE_EXIST);
        }
        Object oldCode = redisUtils.getString(logUser.getValidateKey());
        if (oldCode == null) {
            throw new CustomException(ResultCodeEnum.VALIDATE_EXPIRED);
        }
        if (!logUser.getValidateCode().toLowerCase().equals(oldCode.toString().toLowerCase())) {
            throw new CustomException(ResultCodeEnum.VALIDATE_ERROR);
        }

        String url = "http://localhost:8600/oauth/token";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, "grant_type=password&username=" + logUser.getUsername() + "&password=" + logUser.getPassword() + "");
        Request req = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Authorization", "Basic YWRtaW46YWRtaW4xMjM0NTY=")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        try {
            Response response = client.newCall(req).execute();
            ResponseData<Oauth2Token> oAuth2AccessToken;
            if (response.isSuccessful()) {
                Object result = jsonToBean(response.body(), ResponseData.class);
                oAuth2AccessToken = (ResponseData<Oauth2Token>) result;
                return oAuth2AccessToken;
            }
        } catch (Exception e) {
            throw new CustomException(ResultCodeEnum.USER_LOGIN_ERROR);
        }
        throw new CustomException(ResultCodeEnum.USER_LOGIN_ERROR);
    }

    private Object jsonToBean(ResponseBody body, Class clazz) throws IOException {
        String json = new String(body.bytes());
        Object obj = JSON.parseObject(json, clazz);
        return obj;
    }

    /**
     * 获取验证码
     *
     * @return
     */
    @GetMapping("/getCode")
    public ValidateCode getCode() {
        String key = UUID.randomUUID().toString();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(CODE_NUMBER);
        for (int i = 0; i < CODE_NUMBER; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        String code = sb.toString();
        redisUtils.setString(key, code, CODE_CACHE_TIME);
        ValidateCode validateCode = new ValidateCode();
        validateCode.setCodeKey(key);
        validateCode.setCodeValue(code);
        return validateCode;
    }


    /**
     * 加密字符串
     *
     * @return
     */
    @GetMapping("/encryptedString")
    public String encryptedString(String str) {
        return passwordEncoder.encode(str);
    }


}

