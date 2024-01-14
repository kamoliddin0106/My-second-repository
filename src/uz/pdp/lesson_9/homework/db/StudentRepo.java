package uz.pdp.lesson_9.homework.db;

import uz.pdp.lesson_9.homework.Student;

import java.util.List;

public class StudentRepo implements Repository<Student>{

    private List<Student>  students;

    private static StudentRepo singleton;

    public StudentRepo(List<Student> students) {
        this.students = students;
    }

    public static StudentRepo getInstance(){
        if(singleton == null){
            singleton = new StudentRepo(loadData());
        }
        return singleton;
    }

    private static List<Student> loadData() {
        return null;
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
