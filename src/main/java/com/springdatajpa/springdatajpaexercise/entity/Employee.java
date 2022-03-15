package com.springdatajpa.springdatajpaexercise.entity;

import javax.persistence.*;

//Create an employeeTable table with the following fields: empId, empFirstName, empLastName, empSalary, empAge.
//Create an Employee entity having following fields: id, firstName, lastName, salary, age which maps to the table columns given in above.
@Entity
@Table(name = "employeetable")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "empId")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "pmode",discriminatorType = DiscriminatorType.STRING) //- This is for single_table
public class Employee {
    @Embedded
    SalaryStructure salaryStructure;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empid")
    private int id;
    @Column(name = "empfirstname")
    private String firstName;
    @Column(name = "emplastname")
    private String lastName;
    @Column(name = "empage")
    private int age;
    @Column(name = "empsalary")
    private int salary;

    public SalaryStructure getSalaryStructure() {
        return salaryStructure;
    }

    public void setSalaryStructure(SalaryStructure salaryStructure) {
        this.salaryStructure = salaryStructure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
