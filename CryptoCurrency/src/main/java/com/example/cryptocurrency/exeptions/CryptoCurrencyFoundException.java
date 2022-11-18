package com.example.cryptocurrency.exeptions;


public class CryptoCurrencyFoundException extends RuntimeException{

    /**
     * Constructor for ResourceNotFoundException
     *
     * @param message message
     */
    public CryptoCurrencyFoundException(String message) {
        super(message);
    }
}
