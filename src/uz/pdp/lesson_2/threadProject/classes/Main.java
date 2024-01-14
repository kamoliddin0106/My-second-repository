package uz.pdp.lesson_2.threadProject.classes;

import uz.pdp.lesson_2.threadProject.util.DB;
import uz.pdp.lesson_2.threadProject.util.Input;

public class Main {

    static {
        DB.inItData();
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.err.println("\n" + t.getName() + " " + "stopped!");
        });
        System.out.println("Welcome to File Downloading Project!");
        while (true) {
            displayMenu();
            switch (Input.inputInt("Choose:")) {
                case 1 -> FileService.addFile();
                case 2 -> FileService.deleteFile();
                case 3 -> FileService.showFiles();
                case 0 -> System.exit(0);
            }
        }


    }

    private static void displayMenu() {
        System.out.println("""
                             
                1-Add file
                2-Delete file
                3-Show Files
                0-Exit
                                
                """);
    }

}
