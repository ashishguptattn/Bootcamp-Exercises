package Exercise1;
//Q4) Create a two dimensional array of integers and display:

import java.util.Scanner;

// sum of all elements of each column
       //sum of all elements of each row
public class Q4 {
   public static void main(String[] args) {


      Scanner sc = new Scanner(System.in);
      System.out.println("Enter rows and column resp.");
      int row = sc.nextInt();
      int col = sc.nextInt();

      int[][] arr = new int[row][col];

      for (int i = 0; i < row; i++) {
         for(int j=0;j<col;j++)
         {
            arr[i][j]=sc.nextInt();
         }

      }
      int sum1=0,sum2=0;
      //sum of rows
      for(int i=0;i<row;i++)
      {
         for(int j=0;j<col;j++)
         {
            sum1+=arr[i][j];
         }
         System.out.println("Sum of rows"+i+" "+sum1);
         sum1=0;
         System.out.println();
      }
      //sum of colums
      for(int j=0;j<col;j++)
      {
         for(int i=0;i<arr[0].length;i++)
         {
            sum2+=arr[i][j];
         }
         System.out.println("Sum of colums"+j+" "+sum2);
         sum2=0;
      }
   }




}
