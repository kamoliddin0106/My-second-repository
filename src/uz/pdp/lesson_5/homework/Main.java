package uz.pdp.lesson_5.homework;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import uz.pdp.lesson_2.threadProject.util.Input;
import uz.pdp.lesson_5.homework.util.DB;

import javax.sound.sampled.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static void main(String[] args) throws LineUnavailableException,
            IOException, UnsupportedAudioFileException, JavaLayerException, InterruptedException {
        System.out.println("Disko dasturiga xush kelibsiz");
        while (true) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            String audioFilePath = selectMusic();
            InputStream inputStream = new FileInputStream(audioFilePath);
            Player player = new Player(inputStream);


            int t = Input.inputInt("Necha sekundan so'ng boshlansin");
            AtomicInteger time = new AtomicInteger(t);

            executorService.execute(() -> {
                try {
                    while (true) {
                        if (time.get() == -1) {
                            executorService.shutdown();
                            break;
                        }
                        System.out.println(time.getAndDecrement());
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            executorService.awaitTermination(t, TimeUnit.SECONDS);

            executorService.execute(() -> {
                try {
                    Thread.sleep(500);
                    while (true) {
                        if (Input.inputInt("0-stop") == 0) {
                            player.close();
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            player.play();
        }
    }

    private static String selectMusic() {
        System.out.println("""
                1.Amir phone
                """);
        if (Input.inputInt("Tanlang") == 1) {
            return DB.musics.get(MusicNames.AMIR);
        }
        return selectMusic();
    }
}
