package com.example.employee_resume.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This is entity class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 2, message = "name must be min 2 symbols")
    @Column(name = "employee_name")
    private String name;

    @NotNull
    @Size(min = 2, message = "surname must be min 2 symbols")
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "department")
    private String department;

    @NotNull
    @Column(name = "salary")
    private int salary;

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }
}
