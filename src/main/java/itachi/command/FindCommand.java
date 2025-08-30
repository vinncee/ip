package itachi.command;

import java.util.ArrayList;

import itachi.Storage;
import itachi.Ui;
import itachi.task.Task;
import itachi.task.TaskList;



public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> allTasks = tasks.getTasks();
        ArrayList<Task> matched = new ArrayList<>();

        for (Task t : allTasks) {
            if (t.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matched.add(t);
            }
        }

        if (matched.isEmpty()) {
            System.out.println("No matching tasks found for: " + keyword);
        } else {
            System.out.println("Here are the matching tasks:");
            for (int i = 0; i < matched.size(); i++) {
                System.out.println((i + 1) + ". " + matched.get(i).toString());
            }
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
