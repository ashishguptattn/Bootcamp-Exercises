package Exercise1;


import java.util.Scanner;
//Q1) Write a class with FirstName, LastName & age field. Print Firstname, LastName & age using static block, static method & static variable respectively.
public class Details {


    static
    {
        System.out.print("Ashish");
    }
    static void print(String LastName)
    {

        System.out.print(LastName);
    }
    static int age=21;
    public static void main(String[] args)
    {
        String LastName;


        Details.print(" Gupta " );
        System.out.print(Details.age);




    }
    }

