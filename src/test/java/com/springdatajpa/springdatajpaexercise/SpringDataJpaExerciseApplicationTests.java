package com.springdatajpa.springdatajpaexercise;

import com.springdatajpa.springdatajpaexercise.entity.Employee;
import com.springdatajpa.springdatajpaexercise.entity.SalaryStructure;
import com.springdatajpa.springdatajpaexercise.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//JPQL:
//
//Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
//Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
//Delete all employees with minimum salary.

//Native SQL Query:
//
//Display the id, first name, age of all employees where last name ends with "singh"
//Delete all employees with age greater than 45(Should be passed as a parameter)
@SpringBootTest
class SpringDataJpaExerciseApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCreateEmployee()
	{
		Employee employee=new Employee();
		employee.setFirstName("Lakshay");
		employee.setLastName("Rawat");
		employee.setAge(22);
		employee.setSalary(18000);
		SalaryStructure salaryStructure=new SalaryStructure();
		salaryStructure.setBasicsalary(10000);
		salaryStructure.setBonussalary(2000);
		salaryStructure.setSpecialallowancesalary(1500);
		salaryStructure.setTaxamount(5000);
		employee.setSalaryStructure(salaryStructure);
		repository.save(employee);
	}
	@Test
	public void testFindAllStudentsPartialData()
	{
		List<Object[]> data=repository.findAllEmployeesPartialData(Sort.by("age").and(Sort.by("salary").descending()));
		for(Object[] objects:data)
		{
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}

	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdateSalary()
	{
		repository.updateSalary(20000);
	}
	@Test
	public void testFindAllEmployeesPartialData()
	{
		List<Object[]> objects=repository.findAllEmployeesPartialData("Singh");
		for(Object[] object:objects)
		{
			System.out.println(object[0]+" "+object[1]+" "+object[2]);
		}
	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteEmployeesWithAgeGreaterThan()
	{
		repository.deleteEmployeesWithAgeGreaterThan(45);
	}


}
