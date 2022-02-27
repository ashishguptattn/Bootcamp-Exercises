import java.util.concurrent.locks.ReentrantLock;

//5) Write a program to simulate a deadlock in java and then improve the program to handle the deadlock using reentrant lock.
public class ReentrantLockQ5 {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockQ5 reentrantLockQ5 = new ReentrantLockQ5();
        Account account1 = new Account("12345", 10000);
        Account account2 = new Account("123456", 20000);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                reentrantLockQ5.lock(account1, account2);
                reentrantLockQ5.transfer(account1, account2, 100);
                reentrantLockQ5.unLock(account1, account2);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                reentrantLockQ5.lock(account2, account1);
                reentrantLockQ5.transfer(account2, account1, 100);
                reentrantLockQ5.unLock(account2, account1);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Total balance for both account: " + (account1.getAmount() + account2.getAmount()));
    }

    private void transfer(Account fromAccount, Account toAccount, Integer amount) {
        System.out.println("Transferring amount: " + amount + " from account: " + fromAccount.getAccountNumber() + " to account: " + toAccount.getAccountNumber());
        toAccount.setAmount(toAccount.getAmount() - amount);
        fromAccount.setAmount(fromAccount.getAmount() + amount);
    }

    private void lock(Account fromAccount, Account toAccount) {
        while (true) {
            Boolean fromAccountLocked = fromAccount.getLock().tryLock();
            Boolean toAccountLocked = toAccount.getLock().tryLock();
            if (fromAccountLocked && toAccountLocked) {
                return;
            }
            if(fromAccountLocked) {
                fromAccount.getLock().unlock();
            }
            if(toAccountLocked) {
                toAccount.getLock().unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void unLock(Account fromAccount, Account toAccount) {
        fromAccount.getLock().unlock();
        toAccount.getLock().unlock();
    }
}

class Account {
    private String accountNumber;
    private Integer amount;
    private ReentrantLock lock;

    public Account(String accountNumber, Integer amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.lock = new ReentrantLock();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}