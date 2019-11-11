package com.invillia.acme.auth.exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -8992150641488568519L;

    public BusinessException(String message) {
        super(message);
    }
}
