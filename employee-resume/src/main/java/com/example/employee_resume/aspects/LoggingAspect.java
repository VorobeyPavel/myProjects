package com.example.employee_resume.aspects;

import com.example.employee_resume.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * This is the logging class
 */
@Component
@Aspect
@Slf4j
public class LoggingAspect {


    /**
     * Logging an attempt to save a new employee
     * @param joinPoint employee parameters
     */
    @Before("execution( * com.example.employee_resume.dao.EmployeeRepository.save(*))")
    public void beforeAddNewEmployeeAdvice(JoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        for (Object obj : arguments) {
            if (obj instanceof Employee employee) {
                if (employee.getId()==null){
                    log.info("Attempt to add a new worker: "+Arrays.toString(arguments));
                }else {
                    log.info("Attempt to change worker options: id = "+employee.getId());
                }
            }
        }
    }

    /**
     * Logging saving a new employee
     * @param joinPoint employee parameters
     */
    @AfterReturning("execution(  * com.example.employee_resume.dao.EmployeeRepository.save(*))")
    public void AfterReturningAddNewEmployeeAdvice(JoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        log.info("Employee {} saved", Arrays.toString(arguments));
    }

    /**
     * logging an error saving a new employee
     * @param joinPoint employee parameters
     * @param exception save error
     */
    @AfterThrowing(pointcut = "execution( * com.example.employee_resume.dao.EmployeeRepository.save(*))",
            throwing = "exception")
    public void afterAddNewEmployeeAdvice(JoinPoint joinPoint, Throwable exception){
        Object[] arguments = joinPoint.getArgs();
        log.error("You entered the wrong data format "+Arrays.toString(arguments));
    }


    /**
     * Logging an attempt to remove a new employee
     * @param joinPoint employee parameters
     */
    @Before("execution( * com.example.employee_resume.dao.EmployeeRepository.deleteById(*))")
    public void beforeDeleteEmployeeAdvice(JoinPoint joinPoint){
        Object[] arguments = joinPoint.getArgs();
        log.info("Attempt to remove an employee with id = "+ Arrays.toString(arguments));
    }


    /**
     * Logging the error of deleting a new employee
     * @param joinPoint employee parameters
     * @param exception delete error
     */
    @AfterThrowing(pointcut = "execution( * com.example.employee_resume.dao.EmployeeRepository.deleteById(*))",
            throwing = "exception")
    public void afterThrowingDeleteEmployeeAdvice(JoinPoint joinPoint, Throwable exception){
        Object[] arguments = joinPoint.getArgs();
        log.error("Employee with id = "+Arrays.toString(arguments)+" does not exist");
    }

    /**
     * Logging deletion employee
     * @param joinPoint employee parameters
     */
    @AfterReturning("execution( * com.example.employee_resume.dao.EmployeeRepository.deleteById(*))")
    public void AfterDeleteEmployeeAdvice(JoinPoint joinPoint){
        Object[] arguments = joinPoint.getArgs();
        log.info("Employee with id = "+Arrays.toString(arguments)+" removed");
    }

}
