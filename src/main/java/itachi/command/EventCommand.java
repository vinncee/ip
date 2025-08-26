package itachi.command;
import java.io.IOException;

import itachi.ItachiException;
import itachi.Storage;
import itachi.Ui;
import itachi.command.Command;
import itachi.task.Event;
import itachi.task.TaskList;

public class EventCommand extends Command {
    private String description;
    private String from;
    private String to;

    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ItachiException, IOException{
        Event event = new Event(this.description, this.from, this.to);
        tasks.add(event);
        storage.save(tasks.getTasks());
        ui.showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(event);
        System.out.println("Now you have " + tasks.size() + " tasks in the list!");
        ui.showLine();
    }
}
