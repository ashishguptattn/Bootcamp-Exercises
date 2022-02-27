//3) Use Synchronize method to enable synchronization between multiple threads trying to access method at same time.



public class Q3 {
    int count = 0;

    public synchronized void increment() {

        count++;
    }

    public static void main(String[] as) throws InterruptedException {
        Q3 q3 = new Q3();
        q3.doWork();
        System.out.println("Count:"+q3.count);
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++)
                    increment();

            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++)
                increment();

            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }
}





