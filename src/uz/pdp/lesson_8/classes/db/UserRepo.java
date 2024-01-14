package uz.pdp.lesson_8.classes.db;

import uz.pdp.lesson_2.threadProject.util.Input;
import uz.pdp.lesson_8.classes.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements Repository<User> {

    private static final String PATH = "src/uz/pdp/lesson_8/classes/db/user_db.txt";

    private List<User> users;

    private static UserRepo singleton;

    public UserRepo(List<User> users) {
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
        try (
                InputStream is = new FileInputStream(PATH);
                ObjectInputStream inputStream = new ObjectInputStream(is)
        ) {
            return (List<User>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(User user) {
        users.add(user);
        upLoadData();
    }

    private void upLoadData() {
        try (
                OutputStream os = new FileOutputStream(PATH);
                ObjectOutputStream outputStream = new ObjectOutputStream(os);
        ) {
            outputStream.writeObject(users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        if (user != null) {
            user.setName(Input.inputStr("enter name"));
            user.setAge(Input.inputInt("enter age"));
            upLoadData();
        }
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void delete(User user) {
        users.remove(user);
        upLoadData();
    }
}
