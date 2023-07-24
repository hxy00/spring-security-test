package com.hxy.security.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.hxy.security.test.entitys.ResBean;
import com.hxy.security.test.entitys.SysUser;
import com.hxy.security.test.service.ILoginService;
import com.hxy.security.test.util.JwtUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public ResBean<String> userLogin(SysUser user) {
        ResBean<String> resBean = new ResBean<>();
        Authentication authentication = null;
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
            authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        if (ObjectUtils.isEmpty(authentication)) {
            throw new RuntimeException("登录失败，用户名或密码错误");
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String userId = userDetails.getSysUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);

        String Json = JSON.toJSONString(userDetails);
        redisTemplate.opsForValue().set("login:" + userId, Json);

        resBean.setResult(jwt);
        return resBean;
    }

    @Override
    public ResBean<String> logout() {
        ResBean<String> resBean = new ResBean<>();
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticationToken.getPrincipal();
        Long userId = userDetails.getSysUser().getId();

        redisTemplate.delete("login:" + userId);
        resBean.setResult("注销成功");
        return resBean;
    }
}
