package com.example.employee_resume.service.mapper;

import com.example.employee_resume.dto.EmployeeDTO;
import com.example.employee_resume.entity.Employee;

import java.util.List;

public interface EmployeeDTOMapper {

    EmployeeDTO toEmployeeDTO(Employee employee);

    List<EmployeeDTO> toListEmployeeDTO(List<Employee> employees);
}
