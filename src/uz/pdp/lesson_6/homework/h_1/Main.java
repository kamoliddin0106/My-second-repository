package uz.pdp.lesson_6.homework.h_1;

import uz.pdp.lesson_6.homework.util.DB;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            Random random = new Random();
            int sleep = random.nextInt(1,11);
            try {
                Thread.sleep(1000L*sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Car car = new Car(LocalDateTime.now(),"Nexia");
            DB.CARS.add(car);
            Duration duration = Duration.between(LocalDateTime.now(),LocalDateTime.now().plusSeconds(sleep));
            car.setDuration(duration);
            car.setFinishTime(LocalDateTime.now().plusSeconds(sleep));
            cars(car);
        });
        thread.start();


        Thread thread1 = new Thread(()->{
            Random random = new Random();
            int sleep = random.nextInt(1,11);
            try {
                Thread.sleep(1000L*sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Car car = new Car(LocalDateTime.now(),"Matiz");
            DB.CARS.add(car);
            Duration duration = Duration.between(LocalDateTime.now(),LocalDateTime.now().plusSeconds(sleep));
            car.setDuration(duration);
            cars(car);
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            Random random = new Random();
            int sleep = random.nextInt(1,11);
            try {
                Thread.sleep(1000L*sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Car car = new Car(LocalDateTime.now(),"Tico");
            DB.CARS.add(car);
            Duration duration = Duration.between(LocalDateTime.now(),LocalDateTime.now().plusSeconds(sleep));
            car.setDuration(duration);
            cars(car);
        });
        thread2.start();

        Thread thread3 = new Thread(()->{
            Random random = new Random();
            int sleep = random.nextInt(1,11);
            try {
                Thread.sleep(1000L*sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Car car = new Car(LocalDateTime.now(),"Spark");
            DB.CARS.add(car);
            Duration duration = Duration.between(LocalDateTime.now(),LocalDateTime.now().plusSeconds(sleep));
            car.setDuration(duration);
            cars(car);
        });
        thread3.start();



    }

    private static void cars(Car car) {
        long m = car.getDuration().toMinutes();
        long s = car.getDuration().toSeconds();
        System.out.printf(car.getName() + " %02d:%02d%n",m,s);
    }
}
