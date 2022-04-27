package com.nanfa.domaindemo.command;

import com.alibaba.cola.dto.Response;
import com.nanfa.domaindemo.convertor.UserProfileConvertor;
import com.nanfa.domaindemo.domain.user.UserProfile;
import com.nanfa.domaindemo.dto.UserProfileAddCmd;
import com.nanfa.domaindemo.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserProfileAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:25 PM
 */
@Component
public class UserProfileAddCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileAddCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.create(userProfile);
        return Response.buildSuccess();
    }
}
