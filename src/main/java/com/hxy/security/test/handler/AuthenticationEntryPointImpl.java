package com.hxy.security.test.handler;

import com.alibaba.fastjson.JSON;
import com.hxy.security.test.entitys.ResBean;
import com.hxy.security.test.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败handler
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResBean<String> resBean = new ResBean<>();
        resBean.setCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        resBean.setSummary("认证失败");

        String json = JSON.toJSONString(resBean);
        WebUtils.renderString(httpServletResponse, json);
    }
}
