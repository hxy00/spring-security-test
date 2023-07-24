package com.hxy.security.test.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
public class PasswordEncoderTest {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void passwordEncoderTest () {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);

        System.out.println(passwordEncoder.matches("123456", "$2a$10$T7hxtXjjmC.PILqwNDBs.u0Lrh9FKPst4iIGmJgiL4xyS7GvzOesi"));

    }

}
