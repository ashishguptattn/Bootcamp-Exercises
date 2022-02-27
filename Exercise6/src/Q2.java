import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//2) Use a singleThreadExecutor, newCachedThreadPool() and newFixedThreadPool() to submit a list of tasks and wait for completion of all tasks.
class FixedThreadPool implements Runnable
{

    @Override
    public void run() {
        for(int i=0;i<2;i++)
        {

            System.out.println("Hello "+i+"by thread"+Thread.currentThread().getName());
            try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        }

    }
}



public class Q2 {
    public static void main(String[] as) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            FixedThreadPool fixedThreadPool = new FixedThreadPool();
            Thread t=new Thread(fixedThreadPool);
            executorService.execute(fixedThreadPool);

        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        System.out.println("Done");
        System.out.println();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            FixedThreadPool fixedThreadPool = new FixedThreadPool();
            executorService1.execute(fixedThreadPool);

        }
        executorService1.shutdown();
        while (!executorService1.isTerminated()) {

        }
        System.out.println("using newSingleThreadExecutor");
        System.out.println();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            FixedThreadPool fixedThreadPool = new FixedThreadPool();
            executorService2.execute(fixedThreadPool);

        }
        executorService2.shutdown();
        while (!executorService2.isTerminated()) {

        }
        System.out.println("using newCachedThreadExecutor");

    }
}
