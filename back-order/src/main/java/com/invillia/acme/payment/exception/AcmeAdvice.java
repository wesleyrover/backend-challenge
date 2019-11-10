package com.invillia.acme.payment.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AcmeAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handler(Exception e){
        log.error("Error: {}", e);
        if(e instanceof ServiceException){
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(e.getMessage());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
