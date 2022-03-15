package com.springdatajpa.springdatajpaexercise.repos;

import com.springdatajpa.springdatajpaexercise.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    @Query("select firstName,lastName from Employee where salary>(select avg(salary) from Employee)")
    List<Object[]> findAllEmployeesPartialData(Sort sort);

    @Modifying
    @Query("UPDATE Employee SET salary=:salary where salary>(select avg(salary) from Employee)")
    void updateSalary(@Param("salary")int salary);

    @Query(value = "select empId,empFirstname,empAge from employeetable where empLastname=:lastName",nativeQuery = true)
    List<Object[]> findAllEmployeesPartialData(@Param("lastName")String lastName);

    @Modifying
    @Query(value = "delete from employeetable where empAge=:age",nativeQuery = true)
    void deleteEmployeesWithAgeGreaterThan(@Param("age") int age);

}
