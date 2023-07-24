package com.hxy.security.test.util;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.hxy.security.test.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 统一异常处理
 */
@Slf4j
@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception e) {
        log.error("!!!出错啦!!!", e);
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        if (e instanceof MaxUploadSizeExceededException) {
            mv.addObject("code", ResultCode.FAILED.getCode());
            mv.addObject("summary", "文件大小不允许超过规定的大小");
            mv.addObject("success", Boolean.FALSE);
        } else if (e instanceof MybatisPlusException) {
            mv.addObject("code", ResultCode.FAILED.getCode());
            mv.addObject("summary", e.getMessage());
            mv.addObject("success", Boolean.FALSE);
        } else if (e instanceof RuntimeException) {
            mv.addObject("code", ResultCode.FAILED.getCode());
            mv.addObject("summary", e.getMessage());
            mv.addObject("success", Boolean.FALSE);
        } else {
            mv.addObject("code", ResultCode.FAILED.getCode());
            mv.addObject("summary", ResultCode.FAILED.getMessage());
            mv.addObject("success", Boolean.FALSE);
        }
        return mv;
    }
}
