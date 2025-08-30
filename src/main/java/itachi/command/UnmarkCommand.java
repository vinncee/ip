package itachi.command;

import java.io.IOException;

import itachi.ItachiException;
import itachi.Storage;
import itachi.Ui;
import itachi.task.Task;
import itachi.task.TaskList;

/**
 * Represents a command to unmark a task in the task list.
 */
public class UnmarkCommand extends Command {

    /** The index of the task to be unmarked (0-based). */
    private int index;

    /**
     * Creates an UnmarkCommand for the inputted task index.
     *
     * @param index the 0-based index of the task to unmark
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the command by marking the task as not done, saving the updated
     * task list to storage, and displaying confirmation via the UI.
     *
     * @param tasks the TaskList containing all tasks
     * @param ui the UI instance used to display output
     * @param storage the Storage instance used to persist tasks
     * @throws ItachiException if any errors related to Itachi operations occur
     * @throws IOException if there is an I/O error while accessing storage
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ItachiException, IOException {
        if (index < 0 || index >= tasks.size()) {
            ui.showLine();
            ui.showMessage("No such task number");
            ui.showLine();
            return;
        }

        Task task = tasks.get(this.index);
        task.markAsNotDone();
        storage.save(tasks.getTasks());
        ui.showLine();
        ui.showMessage("Nice! I've marked this task as NOT done:");
        ui.showMessage(task.toString());
        ui.showLine();
    }
}


