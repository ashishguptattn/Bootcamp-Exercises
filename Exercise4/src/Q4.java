import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Q4) WAP using java 8:
//
//Collect all  even numbers from a list using stream
//Given a list of objects of following class:
//           class Employee{
//           String fullName;
//           Long salary;
//           String city;
//           }
//
//          Get list of all unique firstNames of employees where their salary is less than 5000 and who live in delhi.
//          Note: Full name is concatenation of first name, middle name and last name with single space in between.


class Employee{
           String fullName;
           long salary;
           String city;
           Employee(String fullName,long salary,String city)
           {
               this.fullName=fullName;
               this.salary=salary;
               this.city=city;
           }
           public String toString()
           {
               return "EmployeeName: "+fullName+" Salary "+salary+" City "+city;
           }
           }

public class Q4 {
    public static void main(String[] as)
    {
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        System.out.println("Even numbers: "+list.stream().filter(e->e%2==0).collect(Collectors.toList()));
        Employee emp1=new Employee("Ashish Gupta",4000,"Delhi");
        Employee emp2=new Employee("Lakshay Rawat",5100,"Delhi");
        Employee emp3=new Employee("Ayush Tyagi",3000,"Up");
        Employee emp4=new Employee("Govind Kumar",2000,"Jammu");
        Employee emp5=new Employee("Sailesh Gupta",2500,"Delhi");
        List<Employee> list1=Arrays.asList(emp1,emp2,emp3,emp4,emp5);
        System.out.println(list1.stream().filter(e->e.city.equals("Delhi")).filter(e-> e.salary<5000).collect(Collectors.toList()));





    }
}
