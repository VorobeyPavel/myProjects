package com.example.cryptocurrency.exeptions;

public class MethodArgumentNotValid extends RuntimeException{

    /**
     * Constructor for MethodArgumentNotValid
     *
     * @param message message
     */
    public MethodArgumentNotValid(String message) {
        super(message);
    }
}
