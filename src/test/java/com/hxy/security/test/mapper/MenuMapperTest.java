package com.hxy.security.test.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MenuMapperTest {

    @Resource
    private MenuMapper menuMapper;

    @Test
    void selectPermsByUserId() {
        List<String> lstMenus = menuMapper.selectPermsByUserId(3L);
        log.info("lstMenus = {}", lstMenus);
    }
}