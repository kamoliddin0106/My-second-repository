package uz.pdp.lesson_9.homework.db;

import java.util.List;

public interface Repository <T>{
    void save(T t);
    void update(T t);
    List<T> findAll();
    void delete(T t);
}
