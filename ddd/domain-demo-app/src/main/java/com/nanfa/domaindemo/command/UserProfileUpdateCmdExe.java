package com.nanfa.domaindemo.command;

import com.alibaba.cola.dto.Response;
import com.nanfa.domaindemo.convertor.UserProfileConvertor;
import com.nanfa.domaindemo.domain.user.UserProfile;
import com.nanfa.domaindemo.dto.UserProfileUpdateCmd;
import com.nanfa.domaindemo.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}