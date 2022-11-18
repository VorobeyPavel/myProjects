package com.example.employee_resume.service.mapper.impl;

import com.example.employee_resume.dto.EmployeeDTO;
import com.example.employee_resume.entity.Employee;
import com.example.employee_resume.service.mapper.EmployeeDTOMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for convert to dto objects
 */
@Component
public class EmployeeDTOMapperImpl implements EmployeeDTOMapper {

    /**
     * Method for convert Employee to EmployeeDTO
     *
     * @param employee entity employee
     * @return EmployeeDTO
     */
    @Override
    public EmployeeDTO toEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .department(employee.getDepartment())
                .salary(employee.getSalary())
                .build();
    }

    /**
     * Method for convert list employee to list employeeDTO
     *
     * @param employees list employee
     * @return listEmployeeDTO
     */
    @Override
    public List<EmployeeDTO> toListEmployeeDTO(List<Employee> employees) {
        return employees.stream().map(this::toEmployeeDTO).collect(Collectors.toList());
    }

}
