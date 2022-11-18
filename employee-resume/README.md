

        This is Spring Boot Rest project 
    ___________________________________________________________________________________________________________________

        Technology Used

    Spring Boot and Spring Cloud
    Language JAVA
    PostgreSQL  database
    Hibernate-validator
    Lombok
    ____________________________________________________________________________________________________________________
    
        How to start this project

    Create database clevertec 
    Run employee-resume-cloud-service 

    ____________________________________________________________________________________________________________________

        Interaction with the service

    Get employee by id
    http://localhost:8080/api/employees/{id}
    ____________________________________________________________________________________________________________________

    Get all employee
    http://localhost:8080/api/employees/all
    ____________________________________________________________________________________________________________________

    Get all employee with pagination
    http://localhost:8080/api/employees?page=2
    ____________________________________________________________________________________________________________________

    Save employee
    http://localhost:8080/api/employees
    "name": "Anton",
    "surname": "Kurs",
    "department": "IT",
    "salary": 1250 
    ____________________________________________________________________________________________________________________

    Update employee
    http://localhost:8080/api/employees
    "id": 99,
    "name": "Anna",
    "surname": "Smirnova",
    "department": "sale",
    "salary": 1250
    ____________________________________________________________________________________________________________________

    Delete employee by id
    http://localhost:8080/api/employees/{id}
    ____________________________________________________________________________________________________________________
    
    Get all employee by name
    http://localhost:8080/api/employees/name/{name}
    ____________________________________________________________________________________________________________________