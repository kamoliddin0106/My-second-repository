package uz.pdp.lesson_8.homework.h_2.db;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public interface Zones {
    List<ZoneId> zones=generate();

    static List<ZoneId> generate() {
        List<ZoneId> zones1 = new ArrayList<>();
        zones1.add(ZoneId.of("Asia/Tashkent"));
        zones1.add(ZoneId.of("Asia/Tokyo"));
        zones1.add(ZoneId.of("America/New_York"));
        return zones1;
    }
}
