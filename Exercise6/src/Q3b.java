//3) Use Synchronized block to enable synchronization between multiple threads trying to access method at same time.


class Block
{
    String name;
    public void doRun(String name)
    {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Work done by " + name);
            }
        }
    }
}




class BlockSynchronization extends Thread {
    String name;
    Block b;
    BlockSynchronization(String name,Block b)
    {
        this.name=name;
        this.b=b;
    }
    public void run() {
        b.doRun(name);
    }

}
public class Q3b {
    public static void main(String[] as)
    {
        Block b=new Block();
        BlockSynchronization b1=new BlockSynchronization("Ashish",b);
        BlockSynchronization b2=new BlockSynchronization("Ayush",b);
        b1.start();
        b2.start();
    }
}
