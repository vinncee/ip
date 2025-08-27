package itachi.command;

import java.io.IOException;

import itachi.task.TaskList;
import itachi.Ui;
import itachi.ItachiException;
import itachi.Storage;

public class DeleteCommand extends Command {
    private int taskNumber;

    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ItachiException, IOException {
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            ui.showLine();
            System.out.println("No such task number");
            ui.showLine();
            return;
        }
        tasks.remove(taskNumber - 1);
        storage.save(tasks.getTasks());
        System.out.println("Task " + this.taskNumber + " deleted");
    }
}
