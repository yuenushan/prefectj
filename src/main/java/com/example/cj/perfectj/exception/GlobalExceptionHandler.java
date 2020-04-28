package com.example.cj.perfectj.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cj.perfectj.tool.Response;
import com.example.cj.perfectj.tool.ResponseUtil;

/**
 * Created on 2020-04-19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Response handleException(Throwable throwable) {
        if (throwable instanceof PerfectjException) {
            logger.warn(throwable.getMessage(), throwable);
            return ResponseUtil.buildFail(throwable.getMessage());
        }
        logger.error(throwable.getMessage(), throwable);
        return ResponseUtil.buildError(throwable.getMessage());
    }
}