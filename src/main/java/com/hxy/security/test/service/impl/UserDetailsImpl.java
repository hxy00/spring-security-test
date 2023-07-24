package com.hxy.security.test.service.impl;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hxy.security.test.entitys.SysUser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Slf4j
public class UserDetailsImpl implements UserDetails {

    private SysUser sysUser;

    private List<String> sysUserMenus;

    @JSONField(serialize = false)
    private List<GrantedAuthority> lstGrantedAuthority;

    public UserDetailsImpl(SysUser sysUser, List<String> sysUserMenus) {
        this.sysUser = sysUser;
        this.sysUserMenus = sysUserMenus;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtils.isNotEmpty(lstGrantedAuthority)) {
            return lstGrantedAuthority;
        }
        lstGrantedAuthority = sysUserMenus.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return lstGrantedAuthority;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUserName();
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
