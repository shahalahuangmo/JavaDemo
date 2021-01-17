package com.gouli.authentication.controller;

import com.alibaba.fastjson.JSON;;
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
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 认证中心
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

    private final TokenEndpoint tokenEndpoint;

    @ApiOperation("OAuth2认证生成token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grant_type", defaultValue = "password", value = "授权模式", required = true),
            @ApiImplicitParam(name = "client_id", defaultValue = "client", value = "Oauth2客户端ID", required = true),
            @ApiImplicitParam(name = "client_secret", defaultValue = "123456", value = "Oauth2客户端秘钥", required = true),
            @ApiImplicitParam(name = "refresh_token", value = "刷新token"),
            @ApiImplicitParam(name = "username", defaultValue = "admin", value = "登录用户名"),
            @ApiImplicitParam(name = "password", defaultValue = "123456", value = "登录密码"),
            @ApiImplicitParam(name = "code", value = "小程序code"),
            @ApiImplicitParam(name = "encryptedData", value = "包括敏感数据在内的完整用户信息的加密数据"),
            @ApiImplicitParam(name = "iv", value = "加密算法的初始向量"),
    })
    @PostMapping("/token")
    @IgnoreReposeAdvice
    public Oauth2Token postAccessToken(
            @ApiIgnore Principal principal,
            @ApiIgnore @RequestParam Map<String, String> parameters
    ) throws HttpRequestMethodNotSupportedException {
        log.info("请求登录");
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2Token oauth2Token = Oauth2Token.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .build();
        return oauth2Token;
    }

    @ApiOperation("用户密码模式登录，获取Token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", defaultValue = "admin", value = "登录用户名"),
            @ApiImplicitParam(name = "password", defaultValue = "123456", value = "登录密码"),
            @ApiImplicitParam(name = "validateKey", value = "验证码key"),
            @ApiImplicitParam(name = "validateCode", value = "验证码coke"),
    })
    @PostMapping("/login")
    public Oauth2Token login(HttpServletRequest request) throws Exception {
        log.info("请求登录");
        String code = request.getParameter("validateCode");
        String key = request.getParameter("validateKey");

        if (code == null) {
            throw new CustomException(ResultCodeEnum.VALIDATE_EXIST);
        }
        Object old_code = redisUtils.getString(key);
        if (old_code == null) {
            throw new CustomException(ResultCodeEnum.VALIDATE_EXPIRED);
        }
        if (!code.equals(old_code.toString())) {
            throw new CustomException(ResultCodeEnum.VALIDATE_ERROR);
        }
        String url = "http://localhost:8001/oauth/token";
        Map<String, Object> map = new HashMap<>();
        map.put("grant_type", "password");
        map.put("username", request.getParameter("username"));
        map.put("password", request.getParameter("password"));

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=password&username=macro&password=123456");
        Request req = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Authorization", "Basic YWRtaW46YWRtaW4xMjM0NTY=")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(req).execute();
        Oauth2Token oAuth2AccessToken;
        if (response.isSuccessful()) {
            Object result = JSONTOBean(response.body(), Oauth2Token.class);
            oAuth2AccessToken = (Oauth2Token) result;
            return oAuth2AccessToken;
        }
        throw new CustomException(ResultCodeEnum.USER_LOGIN_ERROR);
    }

    private Object JSONTOBean(ResponseBody body, Class clazz) throws IOException {
        String json = new String(body.bytes());
        Object obj = JSON.parseObject(json, clazz);
        return obj;
    }

    /**
     * 获取验证码
     * @return
     */
    @GetMapping("/getCode")
    public ResponseData getCode() {
        String key = UUID.randomUUID().toString();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        String code = sb.toString();
        redisUtils.setString(key,code, 120L);
        ValidateCode validateCode = new ValidateCode();
        validateCode.setCodeKey(key);
        validateCode.setCodeValue(code);
        return ResponseData.success(validateCode);
    }

}

