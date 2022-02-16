package Exercise1;

import java.util.Scanner;

//Q2) Write a program to read user input until user writes XDONE and then show the entered text by the user on commandline
public class Q2 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a text");
        String str=sc.nextLine();
        StringBuilder str1=new StringBuilder("");
        while(!str.equals("XDONE"))
        {

            str1.append(str);
            str=sc.nextLine();

        }
        System.out.println(str1);
    }
}
