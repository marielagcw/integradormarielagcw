package com.marielagcw.exception;

public class BadRequestExceptionService extends RuntimeException {
    public BadRequestExceptionService(String message) {
        super(message);
    }
}
