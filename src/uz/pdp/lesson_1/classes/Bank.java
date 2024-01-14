package uz.pdp.lesson_1.classes;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private Account[] accounts;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public Bank(int initialBalance) {
        this.accounts = new Account[100];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(initialBalance);
        }
    }

    public void transfer(int from, int to, int amount) {
        lock.lock();
        Account fromAccount = accounts[from];
        Account toAccount = accounts[to];
        if (fromAccount.getBalance() < amount) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {

        }
        System.out.println(fromAccount + "$ dan " + toAccount + "$ ga Qiymat: " + amount + "$");
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        condition.signalAll();
        lock.unlock();
    }


    @Override
    public String toString() {
        for (Account account : accounts) {
            System.out.println(account.getName() + " " + account.getBalance());
        }
        return "";
    }


}

