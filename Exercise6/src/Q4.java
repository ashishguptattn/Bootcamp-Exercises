//4) WAP to show usage of Callable and demonstrate how it is different from Runnable

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;
//In Runnable interface threads don't return any value

//In Callable interface threads can return value,it can be stored in Future
public class Q4 {
    public static void main(String[] as) {
        Thread t=new Thread(()->{
        for(int i=0;i<5;i++)
        {
            System.out.println("Hello:"+i);
        }
    });
        t.start();

        ExecutorService executorService= Executors.newCachedThreadPool();
       Future<Integer> future= executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random=new Random();
                int duration=random.nextInt(2000);

                System.out.println("Started running...");
                System.out.println("Stopped running...");
                return duration;
            }
        });
        executorService.shutdown();
        try
        {
            System.out.println("The duration is:"+future.get());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
