package com.invillia.acme.payment.exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 8434848896131968965L;

    public ServiceException(String message, Exception cause) {
        super(message, cause);
    }
}
