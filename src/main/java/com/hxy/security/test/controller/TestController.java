package com.hxy.security.test.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @GetMapping("/test1")
//    @PreAuthorize("hasAuthority('query')")
    @PreAuthorize("@ex.hasAuthority('query')")
    public String test1() {
        return "hello1";
    }
}
