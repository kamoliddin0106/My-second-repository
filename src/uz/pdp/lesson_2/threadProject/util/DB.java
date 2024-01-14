package uz.pdp.lesson_2.threadProject.util;

import uz.pdp.lesson_2.threadProject.classes.File;

import java.util.ArrayList;
import java.util.List;

public interface DB {
    List<File> FILES=new ArrayList<>();
    static void inItData(){
        DB.FILES.add(new File("file.mp4",10));
        DB.FILES.add(new File("file.mp3",20));
        DB.FILES.add(new File("file.mp4",12));
        DB.FILES.add(new File("file.mp4",11));
        DB.FILES.add(new File("file.mp3",25));
        DB.FILES.add(new File("file.mp4",80));
        DB.FILES.add(new File("file.mp3",40));




    }
}
