package com.invillia.acme.order.exception;

public class EntityException extends RuntimeException {


    private static final long serialVersionUID = 4312560098186753573L;

    public EntityException(String message, Exception cause) {
        super(message, cause);
    }
}
