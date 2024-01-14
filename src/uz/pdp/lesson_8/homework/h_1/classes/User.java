package uz.pdp.lesson_8.homework.h_1.classes;

import java.time.ZoneId;
import java.util.UUID;

public class User {
    private UUID id = UUID.randomUUID();
    private String name;
    private String number;
    private String password;
    private ZoneId zoneId;

    public User(String name, String number, String password, ZoneId zoneId) {
        this.name = name;
        this.number = number;
        this.password = password;
        this.zoneId = zoneId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
}
