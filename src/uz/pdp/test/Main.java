package uz.pdp.test;

import uz.pdp.lesson_1.homework_1.util.Input;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        while (true){
            String enteredName = Input.inputStr("Enter name: ");
            Optional<User> opt = findUser(enteredName);
            opt.ifPresentOrElse(
                    (user -> System.out.println(user)),
                    ()-> System.out.println("Try again...)")
            );
        }
    }

    private static Optional<User> findUser(String enteredName) {
        for (User user : DB.users) {
            if(user.getName().equalsIgnoreCase(enteredName)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
