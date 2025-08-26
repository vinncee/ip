package itachi.command;

import java.io.IOException;

import itachi.ItachiException;
import itachi.Storage;
import itachi.Ui;
import itachi.task.Task;
import itachi.task.TaskList;

/**
 * Represents a command to mark a task as done.
 * The index inputted by user represents the index
 * of the task in the TaskList to be marked
 */
public class MarkCommand extends Command{

    /** The 0-based index of the task to mark as done. */
    private int index;

    /**
     * Creates a MarkCommand for a specific task index.
     *
     * @param index the 0-based index of the task to mark
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Marks the task at the given index in the TaskList as done.
     * Updates the storage and prints confirmation via the UI.
     *
     * @param tasks the TaskList containing all tasks
     * @param ui the UI instance used to display output
     * @param storage the Storage instance used to persist tasks
     * @throws ItachiException if any errors related to Itachi operations occur
     * @throws IOException if there is an error while accessing storage
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ItachiException, IOException {
        if (index < 0 || index >= tasks.size()) {
            ui.showLine();
            System.out.println("No such task number");
            ui.showLine();
            return;
        }

        Task task = tasks.get(this.index);
        task.markAsDone();
        storage.save(tasks.getTasks());
        ui.showLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task);
        ui.showLine();
    }
}
