package com.hxy.security.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.hxy.security.test.entitys.SysUser;
import com.hxy.security.test.mapper.MenuMapper;
import com.hxy.security.test.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUserName, username);
        SysUser user = userMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(user)) {
            throw new RuntimeException("用戶信息不存在");
        }

        // 2023/6/25 0025 封装权限
        List<String> lstUserResource = menuMapper.selectPermsByUserId(user.getId());
        UserDetailsImpl userDetails = new UserDetailsImpl(user, lstUserResource);
        log.info("userDetails = {}", userDetails);

        return userDetails;
    }
}
