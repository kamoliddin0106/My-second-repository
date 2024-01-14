package uz.pdp.lesson_3.classes;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                Thread.sleep(300);
                System.out.println("Task1 tugadi");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.execute(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Task2 tugadi");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });*/
        /*ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.schedule(()->{
            System.out.println("Task1 boshlandi");
            try {
                Thread.sleep(3000);
                System.out.println("Task2 tugadi");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },1, TimeUnit.SECONDS);

        executorService.schedule(()->{
            System.out.println("Task2 boshlandi");
            System.out.println("Task2 tugadi");
        },1100,TimeUnit.MILLISECONDS);*/
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future <Boolean> checkUzCardValid = executorService.submit(() -> {
            Thread.sleep(2000);
            System.out.println("Checked");
            return true;
        });

        Future <Boolean> checkHumoCardValid = executorService.submit(() -> {
            Thread.sleep(2000);
            System.out.println("Checked");
            return true;
        });

        Boolean isUzCardValid = checkUzCardValid.get();
        Boolean isHumoValid = checkHumoCardValid.get();

        if(isHumoValid&&isUzCardValid){
            System.out.println("transferring...");
        }


    }
}
