package com.restfulservices.restfulwebservices.employee;
//Create a simple REST ful service in Spring Boot which returns the Response "Welcome to spring boot".
//Create an Employee Bean(id, name, age) and service to  perform different operations related to employee.
//Implement GET http request for Employee to get list of employees.
//Implement GET http request using path variable top get one employee
//Implement POST http request for Employee to create a new employee.
//Implement Exception Handling for resource not found
//Implement DELETE http request for Employee to delete employee
//Implement PUT http request for Employee to update employee
//Apply validation while create a new employee using POST http Request.
//Configure actuator in your project to check the health of application and get the information about various beans configured in your application

import javax.validation.constraints.Size;


public class Employee {
    private Integer id;
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    private Integer age;

    public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
