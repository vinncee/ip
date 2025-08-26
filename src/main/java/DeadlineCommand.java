import java.io.IOException;

public class DeadlineCommand extends Command {
    private String description;
    private String by;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ItachiException, IOException{
        Deadline deadline = new Deadline(this.description, this.by);
        tasks.add(deadline);
        storage.save(tasks.getTasks());
        ui.showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(deadline);
        System.out.println("Now you have " + tasks.size() + " tasks in the list!");
        ui.showLine();
    }

}