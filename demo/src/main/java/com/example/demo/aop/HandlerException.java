package com.example.demo.aop;

import com.example.demo.exception.ServerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HandlerException {
    @ExceptionHandler(value = ServerException.class)
    @ResponseBody
    public String exceptionHandler(Exception e) {
        return "异常，原因: " + e.getMessage();
    }
}
