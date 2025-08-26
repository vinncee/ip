import java.io.IOException;

public class ToDoCommand extends Command{
    private String description;

    public ToDoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ItachiException, IOException {
        Todo todo = new Todo(this.description);
        tasks.add(todo);
        storage.save(tasks.getTasks());
        ui.showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(todo);
        System.out.println("Now you have " + tasks.size() + " tasks in the list!");
        ui.showLine();
    }
}
