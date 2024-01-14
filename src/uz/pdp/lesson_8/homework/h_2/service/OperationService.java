package uz.pdp.lesson_8.homework.h_2.service;

import uz.pdp.lesson_8.homework.h_2.classes.Message;
import uz.pdp.lesson_8.homework.h_2.classes.User;
import uz.pdp.lesson_8.homework.h_2.db.MessRepo;
import uz.pdp.lesson_8.homework.h_2.db.UserRepo;
import uz.pdp.lesson_8.homework.h_2.util.Input;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class OperationService {
    private static UserRepo userRepo = UserRepo.getInstance();
    private static MessRepo messRepo = MessRepo.getInstance();

    public static void messaging() {
        while (true) {
            List<User> userList = showAndGetAllUsersExceptCurrent();
            if (messageBySelectingUser(userList) == null) {
                LoginService.C_USER = null;
                return;
            }
        }

    }

    private static Object messageBySelectingUser(List<User> userList) {
        int i = Input.inputInt("""
                Choose(0-log out)""") - 1;
        if (i == -1) {
            return null;
        }
        Objects.checkIndex(i, userList.size());
        messageWithUser(userList.get(i));
        return "r";
    }

    private static void messageWithUser(User user) {
        while (true){
            ArrayList<Message> messages = correctTimeAndGetUserMessages(user);
            if (sendMessage(user,messages)==null) {
                return;
            }
        }
    }

    private static Object sendMessage(User user, ArrayList<Message> messages) {
        showMessages(messages);


        String text = Input.inputStr("Text(0-exit)");
        if (text.equals("0")){
            return null;
        }
        CompletableFuture<Void> future=CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Message message = new Message(text, ZonedDateTime.now(LoginService.C_USER.getZoneId()), LoginService.C_USER.getId(), user.getId());
            messRepo.save(message);
            return;
        });
        System.out.println("loading...");
        future.join();
        return "r";
    }

    private static void showMessages(ArrayList<Message> messages) {
        if (messages.isEmpty()) {
            System.out.println("No messages");
            return;
        }
        System.out.println();
        for (Message message : messages) {
            int hour = message.getDateTime().getHour();
            int minute = message.getDateTime().getMinute();
            String formattedHour = (hour < 10) ? "0" + hour : String.valueOf(hour);
            String formattedMinute = (minute < 10) ? "0" + minute : String.valueOf(minute);

            if (message.getToId().equals(LoginService.C_USER.getId())) {
                System.out.println(message.getText() + "(" + formattedHour + ":" + formattedMinute + ")");
            } else {
                System.out.println("\t\t\t" + message.getText() + "(" + formattedHour + ":" + formattedMinute + ")");
            }
        }

        System.out.println();
    }

    private static ArrayList<Message> correctTimeAndGetUserMessages(User user) {
        List<Message> messages = messRepo.findAll();
        ArrayList<Message> messagesWithUser = new ArrayList<>();
        for (Message message : messages) {
            if (isRightMessage(user, message)) {
                toCorrectTimeZone(message);
                messagesWithUser.add(message);
            }
        }
        return messagesWithUser;
    }

    private static void toCorrectTimeZone(Message message) {
        message.setDateTime(message.getDateTime().withZoneSameInstant(LoginService.C_USER.getZoneId()));
    }

    private static boolean isRightMessage(User user, Message message) {
        return (message.getFromId().equals(LoginService.C_USER.getId()) || message.getToId().equals(LoginService.C_USER.getId())) && (message.getFromId().equals(user.getId()) || message.getToId().equals(user.getId()));
    }

    private static List<User> showAndGetAllUsersExceptCurrent() {
        List<User> users = new ArrayList<>();
        int i = 1;
        for (User user : userRepo.findAll()) {
            if (!user.equals(LoginService.C_USER)) {
                System.out.println((i++) + "." + user.getName());
                users.add(user);
            }
        }
        return users;
    }
}
