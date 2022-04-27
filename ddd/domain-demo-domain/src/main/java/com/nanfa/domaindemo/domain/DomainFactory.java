package com.nanfa.domaindemo.domain;

import com.nanfa.domaindemo.domain.user.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile(){
        return new UserProfile();
    }

}
