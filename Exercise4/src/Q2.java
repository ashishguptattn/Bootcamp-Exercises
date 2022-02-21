//Q2) Using (instance) Method reference create and apply add and subtract method and using (Static) Method reference create and apply multiplication method for the functional interface created
interface Operations
{
    int methods(int a,int b);

}

 class A
{
    public static int multiply(int a,int b)
    {
        return a*b;
    }

}
public class Q2 {
public static void main(String[] as)
{
    Operations multiply=A::multiply;
    System.out.println(multiply.methods(1,2));
    Operations add1=(a,b)->a+b;
    System.out.println(add1.methods(1,2));
    Operations sub=(a,b)->a-b;
    System.out.println(sub.methods(1,2));

}
}
