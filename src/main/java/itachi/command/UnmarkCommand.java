package itachi.command;
import java.io.IOException;

import itachi.ItachiException;
import itachi.Storage;
import itachi.Ui;
import itachi.command.Command;
import itachi.task.Task;
import itachi.task.TaskList;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ItachiException, IOException {
        if (index < 0 || index >= tasks.size()) {
            ui.showLine();
            System.out.println("No such task number");
            ui.showLine();
            return;
        }

        Task task = tasks.get(this.index);
        task.markAsNotDone();
        storage.save(tasks.getTasks());
        ui.showLine();
        System.out.println("Nice! I've marked this task as NOT done:");
        System.out.println(task);
        ui.showLine();
    }
}


