package uz.pdp.lesson_7.homework.classes.Task;

import uz.pdp.lesson_7.homework.classes.enums.Task.TaskStatus;

import java.util.UUID;

public class Task {
    private UUID id=UUID.randomUUID();
    private String title;
    private String description;
    private TaskStatus status=TaskStatus.IN_PROGRESS;


    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        if(status.equals(TaskStatus.COMPLETED)){
            return title+" task completed!";
        }else{
            return title;
        }
    }
}
