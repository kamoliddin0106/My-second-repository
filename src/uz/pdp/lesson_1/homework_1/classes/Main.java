package uz.pdp.lesson_1.homework_1.classes;

import uz.pdp.lesson_1.homework_1.service.FileService;
import uz.pdp.lesson_1.homework_1.util.Input;

public class Main {
    public static void main(String[] args) {
        while (true){
            displayMenu();
            switch (Input.inputInt("Tanlang")){
                case 1->{
                    FileService.addFile();
                }
                case 2->{
                    FileService.deleteFile();
                }
                case 3->{
                    FileService.showFiles();
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("""
                1-Add file
                2-Delete file
                3-Show files
                """);
    }
}
