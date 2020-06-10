package com.example.cj.perfectj.exception;

import java.util.Map;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cj.perfectj.tool.Response;
import com.example.cj.perfectj.tool.ResponseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;

/**
 * Created on 2020-04-19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Response handleException(HttpServletRequest request, Throwable throwable) {
        Map<String, String[]> params = request.getParameterMap();
        Map<String, Object> map = Maps.transformValues(
                params, arr -> (arr == null || arr.length == 0) ? null : arr.length == 1 ? arr[0] : arr
        );
        if (throwable instanceof PerfectjException) {
            logger.warn("handle:{},  msg: {}, params:{}", throwable.getClass().getName(), throwable.getMessage(), toJSON(map), throwable);
            return ResponseUtil.buildFail(throwable.getMessage());
        } else {
            logger.error("handle:{},  msg: {}, params:{}", throwable.getClass().getName(), throwable.getMessage(), toJSON(map), throwable);
            return ResponseUtil.buildError(throwable.getMessage());
        }
    }

    private String toJSON(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}