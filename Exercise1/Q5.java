package Exercise1;
import java.lang.Object;
//Q5) Create a class named Employee with fields firstname,lastname,age and designation.
//The class should:
//
//have all types of constructors to initialize the object
//class should also have setter methods to update a particular field
//Override its toString method to display a meaningful message using all these fields.
class Employee
{
    String firstname,lastname,designation;
    int age;
  public Employee()
  {
      firstname="Ashish ";
      lastname="Gupta ";
      designation="Trainee ";
      age=21;
  }
  public Employee(String a,String b,String c,int d)
  {
      firstname=a;
      lastname=b;
      designation=c;
      age=d;

  }
  void setFirstname(String a)
  {
       firstname=a;
  }
  void setLastname(String b)
  {
     lastname=b;
  }
  void setDesignation(String c)
  {
       designation=c;
  }
  void setAge(int d)
  {
      age=d;
  }
  public String toString()
  {
      return "My name is "+this.firstname+this.lastname+"i am a "+this.designation+"and i am "+this.age+" "+"years old";
  }

}
public class Q5 {
    public static void main(String[] args)
    {
        Employee obj=new Employee();
        System.out.print(obj.firstname);
        System.out.print(obj.lastname);
        System.out.print(obj.designation);
        System.out.print(obj.age);
        System.out.println();

        Employee obj1=new Employee("Raj ","Sharma ","Trainee ",22);
        System.out.print(obj1.firstname);
        System.out.print(obj1.lastname);
        System.out.print(obj1.designation);
        System.out.print(obj1.age);

        obj1.setFirstname("Gaurav ");
        obj1.setLastname("Sharma ");
        obj1.setDesignation("Trainee ");
        obj1.setAge(23);
        System.out.println();
        System.out.print(obj1.firstname);
        System.out.print(obj1.lastname);
        System.out.print(obj1.designation);
        System.out.print(obj1.age);
        System.out.println();
        System.out.println(obj1.toString());

    }
}
