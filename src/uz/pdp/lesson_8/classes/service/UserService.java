package uz.pdp.lesson_8.classes.service;

import uz.pdp.lesson_2.threadProject.util.Input;
import uz.pdp.lesson_8.classes.entity.User;
import uz.pdp.lesson_8.classes.db.UserRepo;

import java.util.List;

public class UserService {

    private static final UserRepo USER_REPO = UserRepo.getInstance();

    public static void printAll() {
        List<User> all = USER_REPO.findAll();
        int i = 1;
        for (User user : all) {
            System.out.println(i + ": " + user.getName() + user.getAge() + "yoshda");
            i++;
        }
        System.out.println("=======================");
    }

    public static void addUser() {
        User user= new User(
                Input.inputStr("Enter name"),
                Input.inputInt("Enter age")
        );
        USER_REPO.save(user);
    }


    public static void deleteUser() {
        User user = chooseUser();
        USER_REPO.delete(user);
    }

    private static User chooseUser() {
        printAll();
        int i = Input.inputInt("Choose") - 1;
        return USER_REPO.findAll().get(i);
    }

    public static void updateUser() {
        User user = chooseUser();
        USER_REPO.update(user);
        
    }
}
