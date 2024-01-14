package uz.pdp.lesson_8.homework.h_1.classes;

import uz.pdp.lesson_2.threadProject.util.Input;
import uz.pdp.lesson_8.homework.h_1.service.LoginService;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Chat program");
        while(true){
            switch (Input.inputInt("Tanlang")){
                case 1 -> LoginService.login();
                case 2 -> LoginService.register();
            }
        }


//        AdminService.chat();
    }
}
