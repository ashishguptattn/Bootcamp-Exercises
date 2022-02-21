//Q5)Implement multiple inheritance with default method inside interface.

interface Parent
{
    default void display()
    {
        System.out.println("Parent");
    }
}
interface Child1 extends Parent
{
    default void display()
    {
        System.out.println("Child1");
    }
}
interface Child2 extends Parent
{
    default void display()
    {
        System.out.println("Child2");
    }
}

public class Q5  implements Child1,Child2
{
    public void display()
    {
        Child1.super.display();
        Child2.super.display();
        System.out.println("Multiple Inheritance");
    }
        public static void main(String[] as)
    {
        new Q5().display();
    }


}
