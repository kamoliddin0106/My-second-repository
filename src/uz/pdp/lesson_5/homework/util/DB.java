package uz.pdp.lesson_5.homework.util;

import uz.pdp.lesson_5.homework.MusicNames;

import java.util.HashMap;

public interface DB {
    HashMap<MusicNames,String> musics=generate();

    static HashMap<MusicNames, String> generate() {
        HashMap<MusicNames,String> musics=new HashMap<>();
        musics.put(MusicNames.AMIR,"C://Users/Hewlett-Packard/Downloads/Telegram Desktop/Amir.mp3");
        return musics;
    }
}
