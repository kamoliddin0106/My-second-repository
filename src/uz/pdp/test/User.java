package uz.pdp.test;

import java.util.UUID;

public class User {
    private String name;
    private UUID id =  UUID.randomUUID();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " " + id;
    }
}
