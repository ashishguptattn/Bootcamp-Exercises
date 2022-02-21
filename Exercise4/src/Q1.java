import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*Q1) Write the following a functional interface and implement it using lambda:

        First number is greater than second number or not Parameter (int ,int ) Return boolean
        Increment the number by 1 and return incremented value Parameter (int) Return int
        Concatination of 2 string Parameter (String , String ) Return (String)
        Convert a string to uppercase and return . Parameter (String) Return (String)

 */
interface Myinterface
{
     boolean display(int a,int b);
}
interface Myinterface2
{
    int add(int a);
}
interface Myinterface3
{
    String concat(String a,String b);
}
interface Myinterface4
{
    String upperCase(String a);
}
public class Q1 {
    public static void main(String[] as)
    {

        Myinterface myinterface=(a,b)-> a>b;
        System.out.println(myinterface.display(3,2));
        Myinterface2 myinterface2=(a)->a+1;
        System.out.println(myinterface2.add(1));
        Myinterface3 myinterface3=(a,b)->a+b;
        System.out.println(myinterface3.concat("Ashish","Gupta"));
        Myinterface4 myinterface4=(a)->a.toUpperCase();
        System.out.println((myinterface4.upperCase("ashish")));




    }
}
