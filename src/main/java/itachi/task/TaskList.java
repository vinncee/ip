package itachi.task;
import java.util.ArrayList;

import itachi.task.Task;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void remove(int index) {
        tasks.remove(index);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

     public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int size() {
        return tasks.size();
    }

    public TaskList find(String keyword) {
        ArrayList<Task> matched = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                matched.add(task);
            }
        }
        return new TaskList(matched);
    }

    public boolean isEmpty() {
        if (tasks.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printAllTasks() {
        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toSaveFormat());
        }
    }

   
}


