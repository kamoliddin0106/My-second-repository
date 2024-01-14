package uz.pdp.lesson_8.classes.entity;

import uz.pdp.lesson_2.threadProject.util.Input;

import uz.pdp.lesson_8.classes.service.UserService;



public class Main {
    public static void main(String[] args) {
        while (true) {
            UserService.printAll();

            System.out.println("""
                    1- Add user
                    2- Delete user
                    3- Update user
                    """);
            switch (Input.inputInt("Choose")) {
                case 1 ->{
                    UserService.addUser();
                }
                case 2->{
                    UserService.deleteUser();
                }
                case 3->{
                    UserService.updateUser();
                }

            }
        }


       /* Pattern pattern = Pattern.compile("/?=.*[/w].+");
        Matcher matcher = pattern.matcher("sfd1896dv");
        boolean matches = matcher.matches();
        System.out.println(matches);*/
    }

}
