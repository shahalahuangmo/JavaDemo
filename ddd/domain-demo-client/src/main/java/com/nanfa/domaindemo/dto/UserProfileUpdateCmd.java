package com.nanfa.domaindemo.dto;

import com.nanfa.domaindemo.dto.clientobject.UserProfileCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserProfileUpdateCmd extends CommonCommand {

    @NotNull
    private UserProfileCO userProfileCO;
}
