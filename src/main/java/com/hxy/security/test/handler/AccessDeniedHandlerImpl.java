package com.hxy.security.test.handler;

import com.alibaba.fastjson.JSON;
import com.hxy.security.test.entitys.ResBean;
import com.hxy.security.test.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 授权失败handler
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResBean<String> resBean = new ResBean<>();
        resBean.setCode(String.valueOf(HttpStatus.FORBIDDEN.value()));
        resBean.setSummary("暂无权限");

        String json = JSON.toJSONString(resBean);
        WebUtils.renderString(httpServletResponse, json);
    }
}
