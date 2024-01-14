package uz.pdp.lesson_6.homework.h_2;

import uz.pdp.lesson_1.homework_1.util.Input;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ishga kirmasdan oldin nafaqaga chiqish obyektiga xush kelibsiz");
        System.out.println();
        String birthday = Input.inputStr("Tug'ilgan kuningizni kiritng(dd/MM/yyyy)");

        int year = Integer.parseInt(birthday.substring(6,10));
        int month = Integer.parseInt(birthday.substring(3, 5));
        int day = Integer.parseInt(birthday.substring(0, 2));

        LocalDate date = LocalDate.of(year, month, day);
        LocalDateTime retire = date.plusYears(50).atStartOfDay();
        System.out.println("Nafaqaga chiqquningizcha....");

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            LocalDateTime now = LocalDateTime.now();

            long years = ChronoUnit.YEARS.between(now, retire);
            LocalDateTime tempDateTime = now.plusYears(years);
            long days = ChronoUnit.DAYS.between(tempDateTime, retire);
            tempDateTime = tempDateTime.plusDays(days);
            long hours = ChronoUnit.HOURS.between(tempDateTime, retire);
            tempDateTime = tempDateTime.plusHours(hours);
            long minutes = ChronoUnit.MINUTES.between(tempDateTime, retire);
            tempDateTime = tempDateTime.plusMinutes(minutes);
            long seconds = ChronoUnit.SECONDS.between(tempDateTime, retire);

            System.out.println(years + " yil " + days + " kun " + hours + " soat " + minutes + " daqiqa " + seconds + " soniya qoldi");
        }, 0, 1, TimeUnit.SECONDS);
    }
}