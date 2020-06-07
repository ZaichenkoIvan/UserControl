package com.myn.usercontrol.controller;

import com.myn.usercontrol.exception.UserIdNegativeRuntimeException;
import com.myn.usercontrol.exception.UserNotExistRuntimeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler({
            SQLException.class,
            UserIdNegativeRuntimeException.class,
            UserNotExistRuntimeException.class,
            Throwable.class
    })
    public String handleException() {
        return "errorSpring";
    }
}
