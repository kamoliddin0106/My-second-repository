package uz.pdp.lesson_8.homework.h_2.db;

import uz.pdp.lesson_8.homework.h_2.classes.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MessRepo implements Repository<Message>{
    List<Message> messages;
    private static final String path = "src/uz/pdp/lesson_8/homework/h_2/db/Messages.txt";
    private static MessRepo singleton;

    private MessRepo(List<Message> messages) {
        this.messages = messages;
    }

    public static MessRepo getInstance() {
        if (singleton == null) {
            singleton = new MessRepo(loadData());
        }
        return singleton;
    }

    @SuppressWarnings("unchecked")
    private static List<Message> loadData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Message>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(Message message) {
        messages.add(message);
        uploadData();
    }

    private void uploadData() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path)))
        {
            outputStream.writeObject(messages);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Message message) {
    }

    @Override
    public List<Message> findAll() {
        return messages;
    }

    @Override
    public void delete(Message message) {
        messages.remove(message);
        uploadData();
    }
}
