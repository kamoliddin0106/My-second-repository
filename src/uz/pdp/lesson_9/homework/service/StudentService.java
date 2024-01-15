package uz.pdp.lesson_9.homework.service;

import uz.pdp.lesson_9.homework.Student;
import uz.pdp.lesson_9.homework.db.StudentRepo;

import java.util.List;

public class StudentService {

    private static final StudentRepo studentRepo = StudentRepo.getInstance();

    public static void printAll() {
        List<Student> all = studentRepo.findAll();
        int i = 1;
        for (Student student : all) {
            System.out.println(i + ": " + student.getName() + student.getAge() + "yoshda");
            i++;
        }
    }

    public static void addStudent() {

    }

    public static void deleteStudent() {

    }

    public static void updateStudent() {

    }
}
