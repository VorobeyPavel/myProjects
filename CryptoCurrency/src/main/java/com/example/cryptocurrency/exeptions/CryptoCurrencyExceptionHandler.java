package com.example.cryptocurrency.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;


@ControllerAdvice
public class CryptoCurrencyExceptionHandler {

    @ExceptionHandler(CryptoCurrencyFoundException.class)
    public ResponseEntity<?> handleCryptoCurrencyNotFound(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("message", exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValid.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("message", exception.getMessage()));
    }



}
