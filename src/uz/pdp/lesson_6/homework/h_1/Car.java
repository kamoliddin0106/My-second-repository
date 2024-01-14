package uz.pdp.lesson_6.homework.h_1;

import java.time.Duration;
import java.time.LocalDateTime;

public class Car {
    private LocalDateTime finishTime;
    private String  name;
    Duration duration;

    public Car(LocalDateTime finishTime, String name) {
        this.finishTime = finishTime;
        this.name = name;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
