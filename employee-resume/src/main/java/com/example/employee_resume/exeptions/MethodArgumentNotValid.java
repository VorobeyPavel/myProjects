package com.example.employee_resume.exeptions;

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
