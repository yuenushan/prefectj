package com.example.cj.perfectj.exception;

/**
 * Created on 2020-04-19
 */
public class PerfectjException extends RuntimeException {

    public PerfectjException(String message) {
        super(message);
    }

    public PerfectjException(String message, Throwable cause) {
        super(message, cause);
    }
}
