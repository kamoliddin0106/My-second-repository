package uz.pdp.lesson_6.classes;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate=simpleDateFormat.parse("01/05/2007");


        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(()->{
            Date  currentDate=new Date();

            long birthTime= birthDate.getTime();
            long currentTime=currentDate.getTime();
            long l=currentTime-birthTime;

            long year=l/(1000L*60*60*24*365);
            long day=l/(1000L*60*60*24)-year*365;
            long hour=l/(1000L*60*60)-year*365*24-day*24;
            long minut=l/(1000L*60)-year*365*24*60-day*24*60-hour*60;
            long second=l/(1000L)-year*365*24*60*60-day*24*60*60-hour*60*60-minut*60;
            System.out.println(year+" yil "+day+" kun "+ hour+" soat "+ minut+" minut "+ second +" sekund");

        },0,1, TimeUnit.SECONDS);
    }
}