package com.hxy.security.test.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hxy.security.test.entitys.EdouCustomerAcct;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class EdouCustomerAcctMapperTest {

    @Resource
    private EdouCustomerAcctMapper customerAcctMapper;

    @Test
    void test() {
        LambdaQueryWrapper<EdouCustomerAcct> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EdouCustomerAcct::getAcctCode, "5387361224");
        EdouCustomerAcct edouCustomerAcct = customerAcctMapper.selectOne(queryWrapper);
        log.info("edouCustomerAcct = {}", edouCustomerAcct);
    }
}