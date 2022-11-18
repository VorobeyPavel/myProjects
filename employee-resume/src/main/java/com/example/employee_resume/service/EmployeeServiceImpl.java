package com.example.employee_resume.service;

import com.example.employee_resume.dao.EmployeeRepository;
import com.example.employee_resume.dto.EmployeeDTO;
import com.example.employee_resume.entity.Employee;
import com.example.employee_resume.exeptions.EmployeeNotFoundException;
import com.example.employee_resume.service.mapper.EmployeeDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is the employee service class
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDTOMapper employeeDTOMapper;

    /**
     * Get list of all employees
     * @return list of all employees
     */
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeDTOMapper.toListEmployeeDTO(employeeList);
    }

    /**
     * Get pages of all employees
     * @param pageable page number, size page and sort option
     * @return pages of all employees
     */
    @Override
    public List<EmployeeDTO> getPageEmployees(Pageable pageable) {
        List<Employee> employeeList = employeeRepository.findAll(pageable).getContent();
        return employeeDTOMapper.toListEmployeeDTO(employeeList);
    }


    /**
     * Searches for an employee by id
     * @param id employee number in the database
     * @return employeeDTO
     */
    @Override
    public EmployeeDTO getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee with id = " + id + " not found!"));
        return employeeDTOMapper.toEmployeeDTO(employee);
    }


    /**
     * Save a new employee or update employee
     * @param employee new employee
     * @return operation progress message
     */
    @Override
    public EmployeeDTO saveEmployee(Employee employee) {
        if (employee.getId() != null) {
            employeeRepository.findById(employee.getId()).orElseThrow(() ->
                    new EmployeeNotFoundException("Employee with id = " + employee.getId() + " not found!"));
        }
        employeeRepository.save(employee);
        return employeeDTOMapper.toEmployeeDTO(employee);
    }


    /**
     * Removes an employee by id
     * @param id employee number in the database
     */
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee with id = " + id + " not found!"));
        employeeRepository.deleteById(id);
    }


    /**
     * Searches for an employee by name
     * @param name employee name in database
     * @return collection of related EmployeeDTO
     */
    @Override
    public List<EmployeeDTO> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employeeDTOMapper.toListEmployeeDTO(employees);
    }

}
