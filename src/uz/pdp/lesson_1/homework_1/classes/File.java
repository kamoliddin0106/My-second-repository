package uz.pdp.lesson_1.homework_1.classes;

public class File {
    private String name;
    private int size;
    private int downloaded = 0;
    Status status = Status.NEW;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(int downloaded) {
        this.downloaded = downloaded;
    }

    @Override
    public String toString() {
        return name + ".mp4. " + size + "mb";
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
