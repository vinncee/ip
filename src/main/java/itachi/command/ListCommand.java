package itachi.command;

import java.io.IOException;

import itachi.ItachiException;
import itachi.Storage;
import itachi.Ui;
import itachi.task.TaskList;

/**
 * A command that lists all tasks currently in the TaskList.
 * <p>
 * When executed, it prints each task with its index in the list.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command by printing all tasks in the given TaskList.
     *
     * @param tasks the TaskList containing all tasks
     * @param ui the UI instance used to display output
     * @param storage the Storage instance used to persist tasks (not used here)
     * @throws ItachiException if any errors related to Itachi operations occur
     * @throws IOException if there is an I/O error while accessing storage
     */
    @Override 
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ItachiException, IOException {
        ui.showLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
    }
}
