package uz.pdp.lesson_2.threadProject.classes;

import uz.pdp.lesson_2.threadProject.util.DB;
import uz.pdp.lesson_2.threadProject.util.Input;

import java.util.Optional;

public class FileService {
    public static void addFile() {
        int i = 0;
        for (File file : DB.FILES) {
            System.out.println(i + 1 + " " + file.toString());
            i++;
        }
        File file = new File(Input.inputStr("Enter the name of File:"),
                Input.inputInt("Enter the size of File: "));
        DB.FILES.add(file);
        System.out.println("File succesfully added!");
    }

    public static void deleteFile() {
        int i = 0;
        for (File file : DB.FILES) {
            System.out.println(i + 1 + " " + file.toString());
            i++;
        }
        int index = Input.inputInt("Choose file (0 -back): ") - 1;
        if (index == -1) {
            return;
        }
        DB.FILES.remove(index);
        System.out.println("Card succesfully removed");


    }

    public static void showFiles() {
        while(true) {
            Optional<File> fileOpt = chooseFile();
            if (fileOpt.isPresent()) {
                File file = fileOpt.get();
                file.showInfo();
            }else{
                break;
            }
        }

    }

    private static Optional<File> chooseFile() {
        showAllFiles();
        int index= Input.inputInt("choose file(0 -exit)")-1;
        if(index==-1){
            return Optional.empty();
        }
        return Optional.of(DB.FILES.get(index));

    }

    private static void showAllFiles() {
        int i=1;
        for (File file : DB.FILES) {
            System.out.println(i+" "+file);
            i++;
        }
    }
}
