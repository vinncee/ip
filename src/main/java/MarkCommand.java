import java.io.IOException;

public class MarkCommand extends Command{
    private int index;

    public MarkCommand(int index) {
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
        task.markAsDone();
        storage.save(tasks.getTasks());
        ui.showLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task);
        ui.showLine();
    }
}
