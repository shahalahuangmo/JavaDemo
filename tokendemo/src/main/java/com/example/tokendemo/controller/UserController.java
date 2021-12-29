package com.example.tokendemo.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 用户登录操作
 *
 * @Author pengnanfa
 * @Date 2021-12-16 22:08
 */
@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {

    private ObjectMapper objectMapper = new ObjectMapper();

    // region 无指定端登录登出

    /**
     * 测试登录
     * 浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if ("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    /**
     * 测试下线
     * 浏览器访问： http://localhost:8081/user/off?id=10001
     *
     * @param id
     * @return
     */
    @RequestMapping("off")
    public String off(Long id) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if (id != null) {
            StpUtil.logout(id);
            return "下线成功";
        }
        return "下线失败";
    }

    // endregion 无指定端登录登出

    // region PC端登录登出

    /**
     * 测试登录
     * 浏览器访问： http://localhost:8081/user/doLoginPc?username=zhang&password=123456
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("doLoginPc")
    public String doLoginPc(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if ("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001, "Pc");
            return "登录成功";
        }
        return "登录失败";
    }

    /**
     * 测试下线，浏览器访问： http://localhost:8081/user/offPc?id=10001
     *
     * @param id
     * @return
     */
    @RequestMapping("offPc")
    public String offPc(Long id) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if (id != null) {
            StpUtil.logout(id, "Pc");
            return "下线成功";
        }
        return "下线成功";
    }

    // endregion PC端登录登出

    // region App端登录登出

    /**
     * 测试登录
     * 浏览器访问： http://localhost:8081/user/doLoginApp?username=zhang&password=123456
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("doLoginApp")
    public String doLoginApp(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if ("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001, "App");
            return "登录成功";
        }
        return "登录失败";
    }

    /**
     * 测试下线，浏览器访问： http://localhost:8081/user/offApp?id=10001
     *
     * @param id
     * @return
     */
    @RequestMapping("offApp")
    public String offApp(Long id) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if (id != null) {
            StpUtil.logout(id, "App");
            return "下线成功";
        }
        return "下线失败";
    }

    // endregion App端登录登出

    // region 查询登录状态

    /**
     * 查询登录状态
     * 浏览器访问： http://localhost:8081/user/isLogin
     *
     * @return
     */
    @RequestMapping("isLogin")
    public String isLogin() throws JsonProcessingException {

        if (StpUtil.isLogin()) {
            SaSession saSession = StpUtil.getSession();
            log.info("saSession: {}", objectMapper.writeValueAsString(saSession));


            SaSession saSession1 = StpUtil.getTokenSession();
            log.info("TokenSession: {}", objectMapper.writeValueAsString(saSession1));
        }

        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    // endregion 查询登录状态

    //region 踢人下线

    /**
     * 踢人下线
     * 浏览器访问： http://localhost:8081/user/kickOut?id=10001
     *
     * @param id
     * @return
     */
    @RequestMapping("kickOut")
    public String kickOut(Long id) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if (id != null) {
            StpUtil.kickout(id);
            return "踢人下线成功";
        }
        return "踢人下线失败";
    }

    /**
     * 踢人下线App
     * 浏览器访问： http://localhost:8081/user/kickOutByTokenValue?token=721b6f81-1cc3-4fa4-9c1e-550617bf08cd
     *
     * @param token
     * @return
     */
    @RequestMapping("kickOutByTokenValue")
    public String kickOutByTokenValue(String token) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if (StringUtils.hasText(token)) {
            StpUtil.kickoutByTokenValue(token);
            return "踢人下线成功";
        }
        return "踢人下线失败";
    }


    /**
     * 踢人下线Pc
     * 浏览器访问： http://localhost:8081/user/kickOutPc?id=10001
     *
     * @param id
     * @return
     */
    @RequestMapping("kickOutPc")
    public String kickOutPc(Long id) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if (id != null) {
            StpUtil.kickout(id, "Pc");
            return "踢人下线成功";
        }
        return "踢人下线失败";
    }

    /**
     * 踢人下线App
     * 浏览器访问： http://localhost:8081/user/kickOutApp?id=10001
     *
     * @param id
     * @return
     */
    @RequestMapping("kickOutApp")
    public String kickOutApp(Long id) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if (id != null) {
            StpUtil.kickout(id, "App");
            return "踢人下线成功";
        }
        return "踢人下线失败";
    }

    //endregion  踢人下线

    //region 账号封禁

    /**
     * 封禁指定账号
     * 浏览器访问： http://localhost:8081/user/disable?id=10001&disableTime=60
     *
     * @param id
     * @param disableTime 单位min
     * @return
     */
    @RequestMapping("disable")
    public String disable(Long id, Integer disableTime) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if (id != null) {
            if (disableTime == null) {
                //24小时
                disableTime = 60 * 24;
            }
            //封禁时长，单位：秒 (此值为-1时，代表永久封禁)
            StpUtil.disable(id, disableTime * 60);
            return "封禁账号成功";
        }
        return "封禁账号失败";
    }

    /**
     * 获取指定账号是否已被封禁 (true=已被封禁, false=未被封禁)
     * 浏览器访问： http://localhost:8081/user/isDisable?id=10001
     *
     * @param id
     * @return
     */
    @RequestMapping("isDisable")
    public String isDisable(String id) {
        if (id != null) {
            // 获取指定账号是否已被封禁 (true=已被封禁, false=未被封禁)
            return StpUtil.isDisable(id) ? "账号已被封禁" : "账号未被封禁";
        }
        return "查询失败";
    }

    /**
     * 获取指定账号剩余封禁时间，单位：秒
     * 浏览器访问： http://localhost:8081/user/getDisableTime?id=10001
     *
     * @param id
     * @return
     */
    @RequestMapping("getDisableTime")
    public String getDisableTime(String id) {
        if (id != null) {
            //获取指定账号剩余封禁时间，单位：秒
            return "剩余封禁时间: " + StpUtil.getDisableTime(id) + "s";
        }
        return "查询失败";
    }

    /**
     * 解除封禁
     * 浏览器访问： http://localhost:8081/user/untieDisable?id=10001
     *
     * @param id
     * @return
     */
    @RequestMapping("untieDisable")
    public String untieDisable(Long id) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if (id != null) {
            StpUtil.untieDisable(id);
            return "解除封禁账号成功";
        }
        return "解除封禁账号失败";
    }

    //endregion  账号封禁

}

