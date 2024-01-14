package uz.pdp.lesson_1.homework_1.service;

import uz.pdp.lesson_1.homework_1.classes.File;
import uz.pdp.lesson_1.homework_1.classes.Status;
import uz.pdp.lesson_1.homework_1.util.DB;
import uz.pdp.lesson_1.homework_1.util.Input;


public class FileService {

    public static void addFile() {
        File file = new File(
                Input.inputStr("File nomi"),
                Input.inputInt("Sizeni kiriting")
        );
        DB.files.add(file);
    }

    public static void deleteFile() {
        DB.files.remove(chooseFile());
    }

    private static int chooseFile() {
        int i = 0;
        for (File file : DB.files) {
            System.out.println(i + 1 + " " + file);
            i++;
        }
        return Input.inputInt("Tanlang") - 1;
    }


    public static void showFiles() {
        int i = chooseFile();
        File file = DB.files.get(i);
        System.out.println("File: " + file.getName() + ".mp4 ");
        System.out.println("Size: " + file.getSize() + "mb");
        System.out.println("Download: " + file.getDownloaded() + "%");
        System.out.println("Status: " + file.getStatus());
        System.out.println();
        if (file.getStatus().equals(Status.DOWNLOADED)) {
            System.out.println("Bu faylni yuklab bo'lgansiz");
            return;
        }
        if (file.getStatus().equals(Status.DOWNLOADING)) {
            System.out.println("""
                    1-Back
                    """);
            if (Input.inputInt("Tanlang") == 1) {
                System.out.println("Ortga qaytdingiz...)");
                return;
            }
        } else {
            System.out.println("""
                    1-Download
                    2-Back
                    """);
            switch (Input.inputInt("Tanlang")) {
                case 1 -> {
                    System.out.println("downloading...");
                    Thread thread = new Thread(() -> {
                        if (file.getStatus().equals(Status.NEW)) {
                            int i1 = file.getDownloaded();
                            for (int j = 1; j <= 101; j++) {
                                file.setDownloaded(i1++);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                file.setStatus(Status.DOWNLOADING);
                            }
                            file.setStatus(Status.DOWNLOADED);
                        }
                    });
                    thread.start();
                }
                case 2 -> {
                    return;
                }
            }

        }

    }


}
