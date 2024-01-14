package uz.pdp.lesson_7.homework.service;


import uz.pdp.lesson_2.threadProject.util.Input;
import uz.pdp.lesson_7.homework.classes.Task.Task;
import uz.pdp.lesson_7.homework.classes.enums.Task.TaskStatus;
import uz.pdp.lesson_7.homework.DB;

public class TaskService {

    public static void showTasks() {
        int i=0;
        for (Task task : DB.TASKS) {
            System.out.println(i+1+". "+task);
            i++;
        }
    }

    public static void add() {
        Task task = generateNewTask();
        DB.TASKS.add(task);
        System.out.println("Task added succesfully!");
    }
    private static Task generateNewTask(){
        return new Task(Input.inputStr("Enter title:"),
                Input.inputStr(("Enter description:")));
    }

    public static void complete() {
        showTasks();
        Task task= chooseTask();
        task.setStatus(TaskStatus.COMPLETED);
        System.out.println("Task finished succesfully!");


    }

    private static Task chooseTask() {
        int index=Input.inputInt("Choose:")-1;
        return DB.TASKS.get(index);
    }
}
