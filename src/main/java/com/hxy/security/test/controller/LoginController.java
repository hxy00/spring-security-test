package com.hxy.security.test.controller;

import com.hxy.security.test.entitys.ResBean;
import com.hxy.security.test.entitys.SysUser;
import com.hxy.security.test.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/user")
public class LoginController {

    @Resource
    private ILoginService iLoginService;

    @PostMapping("/login")
    public ResBean<String> userLogin(@RequestBody SysUser user) {
        return iLoginService.userLogin(user);
    }

    @GetMapping("/logout")
    public ResBean<String> logout() {
       return iLoginService.logout();
    }
}
