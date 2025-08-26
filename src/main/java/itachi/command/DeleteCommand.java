package itachi.command;
import itachi.task.TaskList;
import itachi.Ui;

import java.io.IOException;

import itachi.ItachiException;
import itachi.Storage;

/**
 * Represents a command that deletes a task from the task list.
 * <p>
 * When executed, it removes the task at the specified task number from the
 * {@link TaskList} and updates the storage accordingly.
 */
public class DeleteCommand extends Command {
    /** The 1-based index of the task to be deleted. */
    private int taskNumber;

    /**
     * Constructs a {@code DeleteCommand} with the specified task number.
     *
     * @param taskNumber the 1-based index of the task to delete
     */
    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Executes the delete operation.
     * <p>
     * If the task number is invalid where it is less than 1 or greater
     * than the number of tasks, it prints an error message.
     * Otherwise, it removes the task from the {@link TaskList},
     * updates the {@link Storage}, and prints a confirmation message.
     *
     * @param tasks   the task list from which a task will be deleted
     * @param ui      the user interface for displaying messages
     * @param storage the storage to save updated tasks
     * @throws ItachiException if an error occurs during deletion
     * @throws IOException     if an I/O error occurs while saving tasks
     */
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
