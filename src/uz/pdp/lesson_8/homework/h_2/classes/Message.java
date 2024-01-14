package uz.pdp.lesson_8.homework.h_2.classes;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Message implements Serializable {
    private String text;
    private ZonedDateTime dateTime;
    private UUID fromId;
    private UUID toId;

    public Message(String text, ZonedDateTime dateTime, UUID fromId, UUID toId) {
        this.text = text;
        this.dateTime = dateTime;
        this.fromId = fromId;
        this.toId = toId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UUID getFromId() {
        return fromId;
    }

    public void setFromId(UUID fromId) {
        this.fromId = fromId;
    }

    public UUID getToId() {
        return toId;
    }

    public void setToId(UUID toId) {
        this.toId = toId;
    }
}
