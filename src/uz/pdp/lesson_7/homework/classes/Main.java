package uz.pdp.lesson_7.homework.classes;

import uz.pdp.lesson_2.threadProject.util.Input;
import uz.pdp.lesson_7.homework.service.TaskService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hush kelibsiz");
        while (true) {
            displayMenu();
            switch (Input.inputInt("Choose:")) {
                case 1 -> TaskService.add();
                case 2 -> TaskService.complete();
                default -> {
                    return;
                }
            }

        }

    }

    private static void displayMenu() {
        TaskService.showTasks();
        System.out.println("""
                1-Add task:
                2-Complete task:
                """);
    }
}
