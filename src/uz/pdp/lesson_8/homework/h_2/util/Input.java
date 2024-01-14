package uz.pdp.lesson_8.homework.h_2.util;

import java.util.Scanner;

public interface Input {
    static int inputInt(String msg){
        Scanner scannerInt = new Scanner(System.in);
        System.out.println(msg);
        return scannerInt.nextInt();
    }
    static String inputStr(String msg){
        Scanner scannerStr = new Scanner(System.in);
        System.out.println(msg);
        return scannerStr.nextLine();
    }
}
