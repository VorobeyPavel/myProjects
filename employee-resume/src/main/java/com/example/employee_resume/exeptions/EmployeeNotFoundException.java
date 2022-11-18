package com.example.employee_resume.exeptions;


public class EmployeeNotFoundException extends RuntimeException{

    /**
     * Constructor for ResourceNotFoundException
     *
     * @param message message
     */
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
