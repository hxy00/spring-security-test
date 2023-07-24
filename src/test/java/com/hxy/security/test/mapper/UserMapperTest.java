package com.hxy.security.test.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hxy.security.test.entitys.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class UserMapperTest {

    @Resource
    private SysUserMapper userMapper;

    @Test
    void test() {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getId, 1072806377661009920L);
        SysUser tbUser = userMapper.selectOne(queryWrapper);
        log.info("tbUser = {}", tbUser);
    }
}