package uz.pdp.lesson_9.homework.db;

import uz.pdp.lesson_9.homework.Student;

import java.util.List;

public class StudentRepo implements Repository<Student>{

    private List<Student>  students;

    private static StudentRepo studentRepo;

    public StudentRepo(List<Student> students) {
        this.students = students;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public List<Student> findAll(Student student) {
        return null;
    }

    @Override
    public void delete(Student student) {

    }
}
