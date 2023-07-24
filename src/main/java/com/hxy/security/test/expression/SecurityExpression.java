package com.hxy.security.test.expression;

import com.hxy.security.test.service.impl.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ex")
public class SecurityExpression {
    public final boolean hasAuthority(String authority) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> sysUserMenus = userDetails.getSysUserMenus();
        return sysUserMenus.contains(authority);
    }
}
