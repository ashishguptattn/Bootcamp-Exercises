package com.jpa.springdatajpaemployee;

import com.jpa.springdatajpaemployee.entity.Employee;
import com.jpa.springdatajpaemployee.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//(1) Create an Employee Entity which contains following fields
//
//Name
//
//Id
//
//Age
//
//Location
//
//(2) Set up EmployeeRepository with Spring Data JPA
//
//(3) Perform Create Operation on Entity using Spring Data JPA
//
//(4) Perform Update Operation on Entity using Spring Data JPA
//
//(5) Perform Delete Operation on Entity using Spring Data JPA
//
//(5) Perform Read Operation on Entity using Spring Data JPA
//
//(6) Get the total count of the number of Employees
//
//(7) Implement Pagination and Sorting on the bases of Employee Age
//
//(8) Create and use finder to find Employee by Name
//
//(9) Create and use finder to find Employees starting with A character
//
//(10) Create and use finder to find Employees Between the age of 28 to 32

@SpringBootTest
class SpringDataJpaEmployeeApplicationTests {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setName("Mirnal");
        employee.setAge(22);
        employee.setLocation("UP");
        employeeRepository.save(employee);

    }

    @Test
    public void testRead() {
        Employee employee = employeeRepository.findById(1L).get();
        assertNotNull(employee);
        assertEquals("Ayush", employee.getName());
    }

    @Test
    public void testUpdate() {
        Employee employee = employeeRepository.findById(1L).get();
        employee.setAge(22);
        employeeRepository.save(employee);
    }

    @Test
    public void testDelete() {
        if (employeeRepository.existsById(1L))
            employeeRepository.deleteById(1L);
    }

    @Test
    public void testCount() {
        System.out.println("Total count: " + employeeRepository.count());
    }

    @Test
    public void testFindByName() {
        List<Employee> employees = employeeRepository.findByName("ashish");
        employees.forEach(e -> System.out.println(e.getId()));
    }

    @Test
    public void testFindByNameLike() {
        List<Employee> employees = employeeRepository.findByNameLike("A%");
        employees.forEach(e -> System.out.println(e.getId()));
    }

    @Test
    public void testFindByAgeBetween() {
        List<Employee> employees = employeeRepository.findByAgeBetween(20, 22);
        employees.forEach(e -> System.out.println(e.getId()));
    }

    @Test
    public void testFindAllPaging() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<Employee> result = employeeRepository.findAll(pageable);
        result.forEach(e -> System.out.println(e.getAge()));
    }

    @Test
    public void testFindAllSorting() {
        employeeRepository.findAll(Sort.by("age")).forEach(e -> System.out.println(e.getAge()));
    }

}
