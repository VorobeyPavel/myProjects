package com.example.employee_resume;

import com.example.employee_resume.dao.EmployeeRepository;
import com.example.employee_resume.dto.EmployeeDTO;
import com.example.employee_resume.entity.Employee;
import com.example.employee_resume.exeptions.EmployeeNotFoundException;
import com.example.employee_resume.service.EmployeeService;
import com.example.employee_resume.service.mapper.EmployeeDTOMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@SpringBootTest
class EmployeeResumeApplicationTests {

    @MockBean
    EmployeeDTOMapper employeeDTOMapper;

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeRepository employeeRepository;


    @Test
    void getAllEmployees(){
        Employee employeeOne = new Employee(7L,"Anna","Kovaleva", "IT", 1500);
        Employee employeeTwo = new Employee(4L,"Elena","Smirnova", "HR", 1200);
        List<Employee> employees = Arrays.asList(employeeOne,employeeTwo);
        List<EmployeeDTO> employeesDTO = employeeDTOMapper.toListEmployeeDTO(employees);

        when(employeeRepository.findAll()).thenReturn(employees);

        List<EmployeeDTO> actual = employeeService.getAllEmployees();

        verify(employeeRepository, times(1)).findAll();

        assertEquals(employeesDTO,actual);
    }

    @Test
    void getPageEmployees(){
        Employee employeeOne = new Employee(7L,"Anna","Kovaleva", "IT", 1500);
        Employee employeeTwo = new Employee(4L,"Elena","Smirnova", "HR", 1200);
        List<Employee> employees = Arrays.asList(employeeOne,employeeTwo);


        List<EmployeeDTO> employeesDTO = employeeDTOMapper.toListEmployeeDTO(employees);

        Pageable pageable = PageRequest.of(0, 2, Sort.Direction.ASC,"id");
        Page<Employee> employeePage = new PageImpl<>(employees);

        when(employeeRepository.findAll(pageable)).thenReturn(employeePage);
        when(employeeDTOMapper.toListEmployeeDTO(employees)).thenReturn(employeesDTO);

        List<EmployeeDTO> actual = employeeService.getPageEmployees(pageable);

        verify(employeeRepository, times(1)).findAll(pageable);
        verify(employeeDTOMapper, times(2)).toListEmployeeDTO(employees);

        assertEquals(employeesDTO,actual);
    }


    @Test
    void getEmployeeById() {

        Employee employee = new Employee(4L,"zhenya","sidorov", "IT", 900);
        EmployeeDTO employeeDTO = new EmployeeDTO(4L,"zhenya","sidorov", "IT", 900);

        when(employeeRepository.findById(4L)).thenReturn(Optional.of(employee));
        when(employeeDTOMapper.toEmployeeDTO(employee)).thenReturn(employeeDTO);

        EmployeeDTO byId = employeeService.getEmployee(4L);

        verify(employeeRepository, times(1)).findById(4L);
        verify(employeeDTOMapper, times(1)).toEmployeeDTO(employee);

        assertEquals(employeeDTO, byId);
    }


    @Test
    void getEmployeeByIdThrowException() {
        when(employeeRepository.findById(5L)).thenThrow(EmployeeNotFoundException.class);

        assertThrows(EmployeeNotFoundException.class, ()-> employeeService.getEmployee(5L));
    }


    @Test
    public void addNewEmployeeTest(){
        Mockito.when(employeeRepository.save(new Employee("Elena","Smirnova", "HR", 1200)))
                .thenReturn(new Employee( 2L,"Elena","Smirnova", "HR", 1200));

        Mockito.when(employeeDTOMapper.toEmployeeDTO(new Employee("Elena","Smirnova", "HR", 1200)
                )).thenReturn(new EmployeeDTO(2L,"Elena","Smirnova", "HR", 1200));

        Employee employeeAdd = new Employee("Elena","Smirnova", "HR", 1200);
        EmployeeDTO employeeDTOService = employeeService.saveEmployee(employeeAdd);

        EmployeeDTO employeeDTO = new EmployeeDTO(2L,"Elena","Smirnova", "HR", 1200);

        Mockito.verify(employeeRepository, Mockito.times(1)).save(employeeAdd);

        Assertions.assertEquals(employeeDTO, employeeDTOService);
    }


    @Test
    public void updateEmployeeTest(){

        Employee employee = new Employee(7L,"Anna","Kovaleva", "IT", 1500);
        EmployeeDTO employeeDTO = new EmployeeDTO(7L,"Anna","Kovaleva", "IT", 1500);

        when(employeeRepository.save(employee)).thenReturn(employee);
        when(employeeDTOMapper.toEmployeeDTO(employee)).thenReturn(employeeDTO);
        when(employeeRepository.findById(7L)).thenReturn(Optional.of(employee));

        EmployeeDTO employeeDTOService = employeeService.saveEmployee(employee);

        verify(employeeRepository, times(1)).findById(7L);
        verify(employeeRepository, times(1)).save(employee);
        verify(employeeDTOMapper, times(1)).toEmployeeDTO(employee);

        assertEquals(employeeDTO, employeeDTOService);
    }


    @Test
    void saveEmployeeThrowException() {
        Employee employee = new Employee(7L,"Anna","Kovaleva", "IT", 1500);

        when(employeeRepository.findById(7L)).thenThrow(EmployeeNotFoundException.class);

        assertThrows(EmployeeNotFoundException.class, ()-> employeeService.saveEmployee(employee));
    }


    @Test
    void deleteEmployeeById(){
        Employee employee = new Employee("Elena","Smirnova", "HR", 1200);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        employeeService.deleteEmployee(1L);

        verify(employeeRepository, times(1)).deleteById(1L);
    }


    @Test
    void deleteEmployeeThrowException() {
        when(employeeRepository.findById(1L)).thenThrow(EmployeeNotFoundException.class);

        assertThrows(EmployeeNotFoundException.class, ()-> employeeService.deleteEmployee(3L));
    }


    @Test
    void findAllByNameTest(){
        List<Employee> employees = Arrays.asList(new Employee(),new Employee());
        List<EmployeeDTO> employeesDTO = employeeDTOMapper.toListEmployeeDTO(employees);

        when(employeeRepository.findAll()).thenReturn(employees);
        when(employeeDTOMapper.toListEmployeeDTO(employees)).thenReturn(employeesDTO);

        List<EmployeeDTO> actual = employeeService.findAllByName(null);

        verify(employeeRepository, times(1)).findAllByName(null);
        verify(employeeDTOMapper, times(1)).toListEmployeeDTO(employees);

        assertEquals(employeesDTO,actual);
    }


}
