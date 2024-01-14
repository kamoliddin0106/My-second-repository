package uz.pdp.lesson_8.homework.h_2.classes;

import com.sun.source.doctree.SerialTree;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.UUID;

public class User implements Serializable {
    private UUID id = UUID.randomUUID();
    private String name;
    private String phone;
    private String password;

    private ZoneId zoneId;

    public User(String name, String phone, String password, ZoneId zoneId) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.zoneId = zoneId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getPhone() {
        return phone;
    }


    public String getPassword() {
        return password;
    }


    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
}
