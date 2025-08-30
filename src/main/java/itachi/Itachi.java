package itachi;

import java.io.IOException;

import itachi.command.Command;
import itachi.task.TaskList;

public class Itachi {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Itachi(String filepath) {
        this.ui = new Ui();
        this.storage = new Storage(filepath);

        try {
            this.tasks = new TaskList(storage.load());
        } catch (IOException e) {
            this.ui.showError("unable to load file");
            this.tasks = new TaskList();
        }

        if (!this.tasks.isEmpty()) {
            this.ui.showLine();
            System.out.println("Here are your saved tasks!");
            this.tasks.printAllTasks();
            this.ui.showLine();
        }
    }

    public void run() {
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

    public static void main(String[] args) {
        new Itachi("data/itachi.txt").run();
    }
}




