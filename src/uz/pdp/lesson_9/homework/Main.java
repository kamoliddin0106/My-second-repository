package uz.pdp.lesson_9.homework;

import uz.pdp.lesson_8.classes.service.UserService;
import uz.pdp.lesson_8.homework.h_2.util.Input;
import uz.pdp.lesson_9.homework.db.StudentRepo;
import uz.pdp.lesson_9.homework.service.StudentService;

public class Main {
    public static void main(String[] args) {
       while (true){
           StudentService.printAll();
           System.out.println("""
                   1-Add student
                   2-Delete student
                   3-Update student
                   """);
           switch (Input.inputInt("Choose")){
               case 1 -> StudentService.addStudent();
               case 2 -> StudentService.deleteStudent();
               case 3 -> StudentService.updateStudent();
           }
       }

    }
}
