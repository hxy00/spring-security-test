package com.hxy.security.test.filter;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.hxy.security.test.service.impl.UserDetailsImpl;
import com.hxy.security.test.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("token");
        if (ObjectUtils.isEmpty(token)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        UserDetailsImpl userDetails;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String userId = (String) claims.get("sub");
            String value = (String) redisTemplate.opsForValue().get("login:" + userId);
            userDetails = JSON.parseObject(value, UserDetailsImpl.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("用户token非法");
        }
        if (ObjectUtils.isEmpty(userDetails)) {
            throw new RuntimeException("用户未登录");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
