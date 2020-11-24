package com.example.demo.config.security.dto;

import com.example.demo.system.model.domain.Role;
import com.example.demo.system.model.domain.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Slf4j
public class SecurityUser implements UserDetails {

    /**
     * 当前登录用户
     */
    private transient User currentUserInfo;
    /**
     * 角色
     */
    private transient List<Role> roleList;

    public SecurityUser() {
    }

    public SecurityUser(User user) {
        if (user != null) {
            this.currentUserInfo = user;
        }
    }

    public SecurityUser(User user, List<Role> roleList) {
        if (user != null) {
            this.currentUserInfo = user;
            this.roleList = roleList;
        }
    }

    /**
     * 获取当前用户所具有的角色
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (!CollectionUtils.isEmpty(this.roleList)) {
            for (Role role : this.roleList) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRoleCode());
                authorities.add(simpleGrantedAuthority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.currentUserInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return this.currentUserInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
