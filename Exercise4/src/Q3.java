//Q3)Create a thread using lambda function
public class Q3 {
    public static void main(String[] as)
    {
        Thread thread=new Thread(()->System.out.println(("In main thread")));
        thread.run();

    }
}


