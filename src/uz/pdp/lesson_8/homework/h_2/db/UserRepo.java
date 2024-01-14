package uz.pdp.lesson_8.homework.h_2.db;


import uz.pdp.lesson_8.homework.h_2.classes.User;
import uz.pdp.lesson_8.homework.h_2.util.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements Repository<User> {

    List<User> users;
    private static final String PATH = "src/uz/pdp/lesson_8/homework/h_2/db/Users.txt";
    private static UserRepo singleton;

    private UserRepo(List<User> users) {
        this.users = users;
    }

    public static UserRepo getInstance() {
        if (singleton == null) {
            singleton = new UserRepo(loadData());
        }
        return singleton;
    }

    @SuppressWarnings("unchecked")
    private static List<User> loadData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATH))) {
            return (List<User>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(User user) {
        users.add(user);
        uploadData();
    }

    private void uploadData() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            outputStream.writeObject(users);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void delete(User user) {
        users.remove(user);
        uploadData();
    }
}
