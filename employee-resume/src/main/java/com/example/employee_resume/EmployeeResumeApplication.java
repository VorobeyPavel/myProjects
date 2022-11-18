package com.example.employee_resume;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Pavel Vorobey
 * @version 1.1
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class EmployeeResumeApplication {

    /**
     * Application start method
     * @param args command line values
     */
    public static void main(String[] args) {
        SpringApplication.run(EmployeeResumeApplication.class, args);
    }

}
