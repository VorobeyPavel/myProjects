package com.example.employee_resume.service;

import com.example.employee_resume.dto.EmployeeDTO;
import com.example.employee_resume.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * This is the employee service interface
 */
public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    List<EmployeeDTO> getPageEmployees(Pageable pageable);

    EmployeeDTO saveEmployee(Employee employee);

    EmployeeDTO getEmployee(Long id);

    void deleteEmployee(Long id);

    List<EmployeeDTO> findAllByName(String name);
}
