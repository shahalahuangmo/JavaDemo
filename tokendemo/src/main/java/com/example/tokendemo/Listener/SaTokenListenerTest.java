package com.example.tokendemo.Listener;

import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.stp.SaLoginModel;
import org.springframework.stereotype.Component;

/**
 * @Description: 描述内容
 * @Auther: pengnanfa
 * @Date: 2021/12/27 /11:24 上午
 */
@Component
public class SaTokenListenerTest implements SaTokenListener {
    @Override
    public void doLogin(String loginType, Object loginId, SaLoginModel loginModel) {
        System.out.println("1111");
    }

    @Override
    public void doLogout(String loginType, Object loginId, String tokenValue) {
        System.out.println("1111");
    }

    @Override
    public void doKickout(String loginType, Object loginId, String tokenValue) {

    }

    @Override
    public void doReplaced(String loginType, Object loginId, String tokenValue) {

    }

    @Override
    public void doDisable(String loginType, Object loginId, long disableTime) {

    }

    @Override
    public void doUntieDisable(String loginType, Object loginId) {

    }

    @Override
    public void doCreateSession(String id) {

    }

    @Override
    public void doLogoutSession(String id) {

    }
}
