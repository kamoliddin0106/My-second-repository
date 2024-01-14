package uz.pdp.lesson_2.dop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Test test = new Test();

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    test.increment();

                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(test.counter);
            }
        });
        thread.start();

        while (true) {
            System.out.println("enter num");
            Thread.sleep(1000);
            test.decrement(scanner.nextInt());
        }

    }
}
