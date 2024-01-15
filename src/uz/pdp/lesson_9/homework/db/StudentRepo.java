package uz.pdp.lesson_9.homework.db;

import uz.pdp.lesson_8.homework.h_2.util.Input;
import uz.pdp.lesson_9.homework.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements Repository<Student> {

    private static final String PATH = "src/uz/pdp/lesson_9/homework/db/students_db.txt";

    private List<Student> students;

    private static StudentRepo singleton;

    public StudentRepo(List<Student> students) {
        this.students = students;
    }

    public static StudentRepo getInstance() {
        if (singleton == null) {
            singleton = new StudentRepo(loadData());
        }
        return singleton;
    }

    @SuppressWarnings("unchecked")
    private static List<Student> loadData() {
        try (
                InputStream is = new FileInputStream(PATH);
                ObjectInputStream inputStream = new ObjectInputStream(is);
        ) {
            return (List<Student>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(Student student) {
        students.add(student);
        uploadData();
    }

    private void uploadData() {
        try (
                OutputStream os = new FileOutputStream(PATH);
                ObjectOutputStream outputStream = new ObjectOutputStream(os);
        ) {
            outputStream.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Student student) {
        if (student != null) {
            student.setName(Input.inputStr("Enter name"));
            student.setAge(Input.inputInt("Enter age"));
        }
    }

    @Override
    public List<Student> findAll(Student student) {
        return students;
    }

    @Override
    public void delete(Student student) {
        students.remove(student);
        uploadData();
    }
}
