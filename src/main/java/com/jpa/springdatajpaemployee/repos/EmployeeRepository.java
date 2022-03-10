package com.jpa.springdatajpaemployee.repos;


import com.jpa.springdatajpaemployee.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {
    List<Employee> findByName(String name);

    List<Employee> findByNameLike(String name);

    List<Employee> findByAgeBetween(int age1, int age2);


}
