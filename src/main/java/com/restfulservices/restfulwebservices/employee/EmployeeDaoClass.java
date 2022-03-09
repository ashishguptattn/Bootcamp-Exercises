package com.restfulservices.restfulwebservices.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoClass {
    public static List<Employee> users = new ArrayList<>();
    public static int count = 3;

    static {
        users.add(new Employee(1, "Adam", 20));
        users.add(new Employee(2, "Eve", 21));
        users.add(new Employee(3, "Jack", 22));
    }

    public List<Employee> findAll() {
        return users;
    }

    public Employee save(Employee user) {
        if (user.getId() == null) {
            user.setId(++count);
        }
        users.add(user);
        return user;
    }

    public Employee findOne(int id) {
        for (Employee user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public Employee deleteById(int id) {
        Iterator<Employee> iterator = users.iterator();
        while (iterator.hasNext()) {
            Employee user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public Employee update(int id, String name, int age) {
        Iterator<Employee> iterator = users.iterator();
        while (iterator.hasNext()) {
            Employee user = iterator.next();
            if (user.getId() == id) {
                user.setName(name);
                user.setAge(age);
                return user;
            }


        }
        throw new RuntimeException("Could not update");

    }

}

