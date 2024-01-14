package uz.pdp.lesson_8.homework.h_2.service;

import uz.pdp.lesson_8.homework.h_2.classes.User;
import uz.pdp.lesson_8.homework.h_2.db.UserRepo;
import uz.pdp.lesson_8.homework.h_2.util.Input;
import uz.pdp.lesson_8.homework.h_2.db.Zones;

import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginService {

    private static UserRepo userRepo = UserRepo.getInstance();
    public static User C_USER;
    public static void register() {
        Pattern p_number=Pattern.compile("(\\+998)(9[0134])([0-9]{7})");
        Pattern p_password=Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)).{8,}");


        String name = Input.inputStr("Name");
        String number = getPhoneNumber(p_number);
        String password = getPasswordOut(p_password);
        ZoneId zoneID = getZoneID();

        User user = new User(name, number, password, zoneID);
        userRepo.save(user);
        C_USER=user;
        OperationService.messaging();
    }

    private static ZoneId getZoneID() {
        int zone = Input.inputInt("""
                                
                1. Tashkent
                2. Tokyo
                3. New York
                                
                Choose""") - 1;
        return Zones.zones.get(zone);

    }


    private static String getPasswordOut(Pattern pattern) {
        while (true){
            String password = Input.inputStr("Password");
            Matcher matcher=pattern.matcher(password);
            if (matcher.matches()) {
                return password;
            }
            System.out.println("Incorrect");
        }
    }

    private static String getPhoneNumber(Pattern pattern) {
        while (true) {
            String number = Input.inputStr("Number");
            Matcher number_pat = pattern.matcher(number);
            if (number_pat.matches()){
                return number;
            }
            System.out.println("Incorrect");
        }
    }

    public static void login() {
        String phone = Input.inputStr("Phone number");
        String password = Input.inputStr("Password");

        for (User user : userRepo.findAll()) {
            if (user.getPhone().equals(phone) && user.getPassword().equals(password)){
                C_USER=user;
                OperationService.messaging();
                return;
            }
        }
        System.out.println("Incorrect");

    }
}
