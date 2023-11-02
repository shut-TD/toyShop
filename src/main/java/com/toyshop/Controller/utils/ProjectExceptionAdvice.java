package com.toyshop.Controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public R doException(Exception ex){

        ex.printStackTrace();
        return new R(500,"服务器故障，请稍后再试");
    }
}
