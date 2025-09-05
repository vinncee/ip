package itachi;

import java.io.IOException;
import java.util.List;

import itachi.command.Command;
import itachi.task.TaskList;

public class Itachi {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Itachi(String filepath) {
        assert filepath != null && !filepath.isEmpty() : "Filepath can't be null or empty";
        this.ui = new Ui();
        this.storage = new Storage(filepath);

        try {
            this.tasks = new TaskList(storage.load());
        } catch (IOException e) {
            this.ui.showError("unable to load file");
            this.tasks = new TaskList();
        }

        assert this.tasks != null : "TaskList should never be null";

        if (!this.tasks.isEmpty()) {
            this.ui.showLine();
            ui.showMessage("Here are your saved tasks!");
            this.tasks.printAllTasks(this.ui);
            this.ui.showLine();
        }
    }

    public void run() {
        assert ui != null : "UI should never be null";
        assert tasks != null : "TaskList should never be null";
        assert storage != null : "Storage should never be null";
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String userCommand = this.ui.readCommand();
                this.ui.showLine();
                Command c = Parser.parse(userCommand);
                c.execute(this.tasks, this.ui, this.storage);
                isExit = c.isExit();
            } catch (ItachiException | IOException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public List<String> getResponse(String input) {
        assert ui != null : "UI should never be null";
        assert tasks != null : "TaskList should never be null";
        assert storage != null : "Storage should never be null";
        assert input != null : "Input string should not be null";
        ui.startNewCommand(); // clear previous messages
        try {
            Command c = Parser.parse(input);
            c.execute(this.tasks, this.ui, this.storage);
            return ui.getMessage(); // return all messages from this command
        } catch (ItachiException | IOException e) {
            ui.showError(e.getMessage());
            return ui.getMessage();
        }
    }

    public static void main(String[] args) {
        new Itachi("data/itachi.txt").run();
    }
}




