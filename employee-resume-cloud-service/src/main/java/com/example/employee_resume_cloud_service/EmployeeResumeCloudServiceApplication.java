package com.example.employee_resume_cloud_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EmployeeResumeCloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeResumeCloudServiceApplication.class, args);
    }

}
