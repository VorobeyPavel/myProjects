package com.example.employee_resume.controller;

import com.example.employee_resume.dto.EmployeeDTO;
import com.example.employee_resume.entity.Employee;
import com.example.employee_resume.exeptions.MethodArgumentNotValid;
import com.example.employee_resume.service.EmployeeService;
import com.example.employee_resume.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * This is the rest controller class
 */
@RestController
@RequestMapping("/api")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * @see EmployeeServiceImpl#getAllEmployees()
     */
    @GetMapping("/employees/all")
    public List<EmployeeDTO> getAllEmployees() {
        return  employeeService.getAllEmployees();
    }

    /**
     * Get pages of all employees
     * @param page - page number
     * @param sortBy - sort option
     * @return page with the first five employees from the database
     */
    @GetMapping("/employees")
    public List<EmployeeDTO> getPageEmployees(
            @RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy){
        return  employeeService.getPageEmployees(PageRequest
                .of(page.orElse(0), 5, Sort.Direction.ASC,sortBy.orElse("id")));
    }

    
    /**
     * @see EmployeeServiceImpl#getEmployee(Long)
     */
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id ){

        EmployeeDTO employeeDTO = employeeService.getEmployee(id);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    
    /**
     * @see com.example.employee_resume.service.EmployeeServiceImpl#saveEmployee(Employee)
     */
    @PostMapping("/employees")
    public EmployeeDTO addNewEmployee(@Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    
    /**
     * @see com.example.employee_resume.service.EmployeeServiceImpl#saveEmployee(Employee)
     */
    @PutMapping("/employees")
    public EmployeeDTO updateEmployee(@Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    
    /**
     * @see com.example.employee_resume.service.EmployeeServiceImpl#deleteEmployee(Long)
     */
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }

    
    /**
     * @see com.example.employee_resume.service.EmployeeServiceImpl#findAllByName(String) 
     */
    @GetMapping("/employees/name/{name}")
    public List<EmployeeDTO> showAllEmployeesByName(@PathVariable String name){
        return employeeService.findAllByName(name);
    }


}
