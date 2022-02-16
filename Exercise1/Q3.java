package Exercise1;

import java.util.Scanner;

//Q3) Write a java program to show following menu to the user:
//
//*******Menu*******
//1. Calculate Area of Circle
//2. Calculate Circumference of a Circle
//3. Exit.
//Choose an option (1-3):
//
//Take radius as user input.
//
//Hint: Use Switch statement to act on the menu. Also area and circumference methods should be static
public class Q3 {
    static double area(double r) {
        return (3.14 * r * r);

    }

    static double circumference(double r) {
        return (2 * 3.14 * r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius");
        double radius = sc.nextDouble();
        System.out.println("Choose an option 1-3");
        System.out.println("1. Calculate Area of Circle " +
                "2. Calculate Circumference of a Circle " +
                "3.Exit.");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println(area(radius));
                break;

            case 2:
                System.out.println(circumference(radius));
                break;
            case 3:

                System.out.println("Exit");
                break;
            default:
                System.out.println("Wrong input");


        }


    }
}
