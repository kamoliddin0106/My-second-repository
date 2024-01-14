package uz.pdp.lesson_2.dop;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    int counter = 0;
    Lock lock = new ReentrantLock();


    public void increment() {
        lock.lock();
        counter++;
        lock.unlock();

    }

    public void decrement(int n) {
        lock.lock();
        counter-=n;
        System.out.println(counter);
        System.out.println("decrement worked");
        lock.unlock();
    }


}