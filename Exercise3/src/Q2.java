import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//2) Given the following class
//Employee class{ Double Age; Double Salary; String Name}
// Design the class in such a way that the default sorting should work on firstname and lastname.
//Also, Write a program to sort Employee objects based on salary using Comparator.
class Employee implements Comparable<Employee>, Comparator<Employee> {
    int age;
    double salary;
    String name;

    public String toString() {
        return ("Name: " + name + "Salary: " + salary + "Age: " + age);
    }

    Employee() {
    }

    Employee(String Fullname, double salary, int age) {
        this.name = Fullname;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public int compareTo(Employee employee) {


        return name.compareTo(employee.name);
    }

    @Override
    public int compare(Employee emp1, Employee emp2) {

        if (emp1.salary < emp2.salary) {
            return 1;

        } else if (emp1.salary > emp2.salary) {
            return -1;
        } else
            return 0;
    }
}
    public class Q2 {
        public static void main(String[] as) {
            Employee emp1 = new Employee("Ashish Gupta", 15000, 21);
            Employee emp2 = new Employee("Lakshay Rawat", 15100, 21);
            Employee emp3 = new Employee("Ashish Tyagi", 15150, 21);
            Employee emp4 = new Employee("Megha Sharma", 15100, 21);
            Employee emp5 = new Employee("Govind Kumar", 15200, 21);
            Employee emp6 = new Employee("Ayush Gupta", 15030, 21);
            List<Employee> list = new ArrayList<Employee>();
            list.add(emp1);
            list.add(emp2);
            list.add(emp3);
            list.add(emp4);
            list.add(emp5);
            list.add(emp6);
            Collections.sort(list);

            System.out.println(list);
            System.out.println();

            Collections.sort(list, new Employee());
            System.out.println(list);


        }
    }

