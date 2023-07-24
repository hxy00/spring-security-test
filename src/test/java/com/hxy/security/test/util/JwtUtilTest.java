package com.hxy.security.test.util;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
class JwtUtilTest {

    @Test
    void createJWT() {
        Date date = new Date(System.currentTimeMillis() + 1000 * 60 * 10);

        String subject = "test1";
        String jwt = JwtUtil.createJWT(subject, date.getTime());
        log.info("jwt = {}", jwt);
    }

    @Test
    void parseJWT() throws Exception {
//        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJ0ZXN0MiI6InRlc3QyIiwidGVzdDMiOiJ0ZXN0MyIsImV4cCI6MTY4ODAzMjU3NywidGVzdDEiOiJ0ZXN0MSIsImlhdCI6MTY4ODAzMTk4N30.nVH60ttTYEvB62CdOAysZvjroIsduXiGYaCvjvBomrc";
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1YTE3NDNhN2NlNDU0N2JkYmYxYmRiYzk0ZTM5MjUwNiIsInN1YiI6InRlc3QxIiwiaXNzIjoic2ciLCJpYXQiOjE2ODk5MDUwMjgsImV4cCI6MzM3OTgxMDY1Nn0.wkpw2LQZB6SiMhnBJNiotnK4E9_DFnuHGat4BsBA-M8";
        Claims claims = JwtUtil.parseJWT(jwt);
        log.info("claims = {}", claims);
    }
}