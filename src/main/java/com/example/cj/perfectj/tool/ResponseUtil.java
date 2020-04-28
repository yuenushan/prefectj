package com.example.cj.perfectj.tool;

/**
 * Created on 2020-04-17
 */
public class ResponseUtil {

    private static final Integer SUCCESS = 0;
    private static final String SUCCESS_MESSAGE = "success";
    private static final Integer FAIL = 1;
    private static final String FAIL_MESSAGE = "fail";
    private static final Integer ERROR = 500;

    public static Response buildSuccess(Object data) {
        return new Response(SUCCESS, SUCCESS_MESSAGE, data);
    }

    public static Response buildSuccess(Object data, String message) {
        return new Response(SUCCESS, message, data);
    }

    public static Response buildFail() {
        return new Response(FAIL, FAIL_MESSAGE, null);
    }

    public static Response buildFail(String message) {
        return new Response(FAIL, message, null);
    }

    public static Response buildFail(int status, String message) {
        return new Response(status, message, null);
    }

    public static Response buildError(String message) {
        return new Response(ERROR, message, null);
    }
}