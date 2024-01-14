package uz.pdp.lesson_5.classes;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        int size = 500_000_000;
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 10);
        }

        long start = System.currentTimeMillis();
        System.out.println("Started");
        int counter = 0;
        for (int i : arr) {
            if (i >= 5) {
                counter++;
            }
        }

        System.out.println("Counter:" + counter);

        System.out.println("Finished");
        long end = System.currentTimeMillis();

        System.out.println("Time:" + (end - start));


        long start1 = System.currentTimeMillis();
        System.out.println("Fork join started");

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CounterTask counterTask = new CounterTask(0, size, arr);
        Integer res = forkJoinPool.invoke(counterTask);
        System.out.println("Counter: " + res);

        System.out.println("Fork join finished");

        long end1 = System.currentTimeMillis();
        System.out.println("Fork time:" + (end1 - start1));

    }
}

