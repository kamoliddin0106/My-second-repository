package uz.pdp.lesson_2.homework_2.classes;

import uz.pdp.lesson_1.homework_1.util.Input;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Thread thread = getThread(random);
        while (true) {
            displayMenu();
            switch (Input.inputInt("Tanlang")) {
                case 1 -> {
                    getThread(random);
                    thread.start();
                }
                case 2 -> System.exit(0);
            }
        }


    }

    private static void displayMenu() {
        System.out.println("""
                1-Pul o'tkazish
                2-Qaytish
                """);
    }

    private static Thread getThread(Random random) {
        Bank bank = new Bank(100);
        return new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                int from = random.nextInt(0, 100);
                int to = from;
                while (to == from) {
                    to = random.nextInt(0, 100);
                }
                bank.transfer(from, to, random.nextInt(10, 100));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println();
            System.out.println("Raxmat...)");
        });
    }
}