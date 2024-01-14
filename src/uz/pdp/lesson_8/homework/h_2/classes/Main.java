package uz.pdp.lesson_8.homework.h_2.classes;

import uz.pdp.lesson_2.threadProject.util.Input;
import uz.pdp.lesson_8.homework.h_2.service.LoginService;

public class Main {
    public static void main(String[] args) {
        while (true) {
            switch (displayMenu()) {
                case 1 -> LoginService.register();
                case 2 -> LoginService.login();
            }

        }
    }

    private static int displayMenu() {
        return Input.inputInt("""      
                1.Register
                2.Login
                
                Choose""");
    }

}
