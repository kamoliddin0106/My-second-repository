package uz.pdp.lesson_3.homewor_3_1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(200);
                for (int i = 0; i < 5; i++) {
                    System.out.println("🔴");
                    Thread.sleep(500);
                }
                System.out.println("\t");
                for (int i = 0; i < 2; i++) {
                    System.out.println("🟡");
                    Thread.sleep(500);
                }
                System.out.println("\t  ");
                for (int i = 0; i < 3; i++) {
                    System.out.println("🟢");
                    Thread.sleep(500);
                }
                System.out.println();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 2000, 2000, TimeUnit.MILLISECONDS);
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " " + thread.getState());
        }
    }
}
