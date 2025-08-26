import java.io.IOException;

public class ListCommand extends Command {

    @Override 
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ItachiException, IOException {
        ui.showLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
    }
}
