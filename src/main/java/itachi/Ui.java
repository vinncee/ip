package itachi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import itachi.task.TaskList;

public class Ui {
    private Scanner scanner;
    private List<String> messages;


    public Ui() {
        this.scanner = new Scanner(System.in);
        this.messages = new ArrayList<>();
    }


    public void startNewCommand() {
        messages.clear();
    }

    public void showWelcome() {
        String msg = "\"Hello! I'm Itachi\nWhat can I do for you?";
        showMessage(msg);
    }

    public void showLine() {
        showMessage("--------------------------------------");
    }

    public void showError(String errorMsg) {
        String msg = "Error: " + errorMsg;
        this.showMessage(msg);
    }

    public String readCommand() {
        return this.scanner.nextLine().trim();
    }

    public void showFindResult(TaskList matchedTasks) {
        if (matchedTasks.getTasks().isEmpty()) {
            this.showMessage("-------------------------------------");
            String msg = " No matching tasks found.";
            this.showMessage(" No matching tasks found.");
            this.showMessage("-------------------------------------");
        } else {
            this.showMessage("-------------------------------------");
            this.showMessage(" Here are the matching tasks in your list:");
            for (int i = 0; i < matchedTasks.size(); i++) {
                String msg = (i + 1) + ". " + matchedTasks.getTasks().get(i);
                this.showMessage(" " + (i + 1) + ". " + matchedTasks.getTasks().get(i));
            }
        }
    }

    public List<String> getMessage() {
        return new ArrayList<>(messages);
    }

    public void showMessage(String msg) {
        System.out.println(msg); // optional for console output
        messages.add(msg);
    }

}
