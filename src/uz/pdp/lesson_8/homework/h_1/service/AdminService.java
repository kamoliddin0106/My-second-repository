package uz.pdp.lesson_8.homework.h_1.service;

import uz.pdp.lesson_2.threadProject.util.Input;
import uz.pdp.lesson_8.homework.h_1.classes.Message;
import uz.pdp.lesson_8.homework.h_1.classes.User;
import uz.pdp.lesson_8.homework.h_1.util.DB;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class AdminService {
    private static User c_user;

    public static void chat() {
        while (true) {
            authenticate();
            main_operation();
        }
    }

    private static void main_operation() {
        System.out.println("\nHello," + c_user.getName());
        while (true) {
            switch (displayMenu()) {
                case 1 -> sendMessage();
                case 2 -> {
                    return;
                }
            }
        }
    }

    private static void sendMessage() {
        while (true) {
            User user = chooseUserToSend(showUsersExceptCurrent());
            if (user == null) {
                return;
            }
            sendAndGetMessage(user);
        }
    }

    private static int displayMenu() {
        System.out.println("""
                                
                1. Send messages
                2. Exit
                """);
        return Input.inputInt("Choose");
    }

    private static void sendAndGetMessage(User user) {
        while (true) {
            showAllMessages(user);
            String text = Input.inputStr("\nYour text(0-exit)");
            if (text.equals("0"))
                return;
            else {
                System.out.println("loading...");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            Message message = new Message(
                    text,
                    ZonedDateTime.now(c_user.getZoneId()),
                    c_user.getId(),
                    user.getId()
            );
            DB.messages.add(message);
        }
    }




    private static User chooseUserToSend(ArrayList<User> users) {
        int i = Input.inputInt("Choose(0-exit)") - 1;
        if (i == -1) {
            return null;
        }
        Objects.checkIndex(i, users.size());
        return users.get(i);
    }

    private static ArrayList<User> showUsersExceptCurrent() {
        ArrayList<User> usersEX = new ArrayList<>();
        int i = 1;
        System.out.println();
        for (User user : DB.users) {
            if (!user.equals(c_user)) {
                usersEX.add(user);
                System.out.println(i + "." + user.getName());
                i++;
            }
        }
        return usersEX;
    }

    private static void showAllMessages(User user) {
        ArrayList<Message> messages = getAllMessageByOutUser(user);
        messages.sort(Comparator.comparing(Message::getDateTime));
        printAll(messages);
    }


    private static void printAll(ArrayList<Message> messages) {
        if (messages.isEmpty()) {
            System.out.println("No messages\n");
        }
        System.out.println();
        for (Message message : messages) {
            String minute = String.valueOf(message.getDateTime().getMinute());
            String hour = String.valueOf(message.getDateTime().getHour());
            if (minute.length() == 1) {
                minute = "0" + minute;
            }
            if (hour.length() == 1) {
                hour = "0" + hour;
            }
            if (message.getFromId() == c_user.getId()) {
                System.out.println("\t\t\t\t" + message.getText() + "[" + hour + ":" + minute + "]");
            } else
                System.out.println(message.getText() + "[" + hour + ":" + minute + "]");
        }
    }

    private static ArrayList<Message> getAllMessageByOutUser(User user) {
        ArrayList<Message> messages = new ArrayList<>();
        for (Message message : DB.messages) {
            if (isCorrectMessage(user, message)) {
                message.setDateTime(message.getDateTime().withZoneSameInstant(c_user.getZoneId()));
                messages.add(message);
            }
        }
        return messages;

    }

    private static boolean isCorrectMessage(User user, Message message) {
        return (message.getToId().equals(c_user.getId()) && message.getFromId().equals(user.getId())) ||
                (message.getToId().equals(user.getId()) && message.getFromId().equals(c_user.getId()));
    }

    private static void authenticate() {
        showUsers();
        int i = Input.inputInt("Choose") - 1;
        Objects.checkIndex(i, DB.users.size());
        c_user = DB.users.get(i);
    }

    private static void showUsers() {
        for (int i = 0; i < DB.users.size(); i++) {
            System.out.println(i + 1 + "." + DB.users.get(i).getName());
        }
    }
}
