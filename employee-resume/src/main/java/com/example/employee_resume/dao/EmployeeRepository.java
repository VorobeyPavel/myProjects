package com.example.employee_resume.dao;


import com.example.employee_resume.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is the employee repository interface
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAll();

    List<Employee> findAllByName(String name);

    Employee findFirstByOrderByIdDesc();

    long count();
}
