//1) Create and Run a Thread using Runnable Interface and Thread class and show usage of sleep and join methods in the created threads.
class Thread1 extends Thread
{
    public void run()
    {
        for(int i=0;i<=10;i++)
        {
            if(i%2==0)
            {
                System.out.println("Even numbers: "+i);
            }
        }
        System.out.println();
        try
        {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread2 implements Runnable
{
   public void run()
   {
       for(int i=0;i<=10;i++)
       {
           if(i%2==1)
           {
               System.out.println("Odd numbers: "+i);
           }
       }
   }
}

public class ThreadClass {
    public static void main(String[] as) throws InterruptedException {
        Thread1 thread1=new Thread1();
        Thread2 thread2=new Thread2();
        Thread thread=new Thread(thread2);
        thread1.start();
        thread1.join();
        thread.start();



    }
}
