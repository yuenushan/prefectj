package com.example.cj.perfectj.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created on 2020-04-18
 */
@Component
public class ApiMonitorInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ApiMonitorInterceptor.class);

    ThreadLocal<Long> startTimeMap = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        startTimeMap.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("url", request.getRequestURI());
        map.put("method", request.getMethod());
        map.put("duration", System.currentTimeMillis() - startTimeMap.get());
        map.put("success", ex == null);
        ObjectMapper objectMapper = new ObjectMapper();
        startTimeMap.remove();
        logger.info(objectMapper.writeValueAsString(map));
    }
}
