package itachi;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
        //System.out.println(msg);
        showMessage(msg);
    }

    public void showLine() {
        //System.out.println("-------------------------------------");
        showMessage("--------------------------------------");
    }

    public void showError(String errorMsg) {
        String msg = "Error: " + errorMsg;
        System.out.println(msg);
        messages.add(msg);
    }

    public String readCommand() {
        return this.scanner.nextLine().trim();
    }

    public void showFindResult(TaskList matchedTasks) {
        if (matchedTasks.getTasks().isEmpty()) {
            System.out.println("-------------------------------------");
            String msg = " No matching tasks found.";
            System.out.println(" No matching tasks found.");
            messages.add(msg);
            System.out.println("-------------------------------------");
        } else {
            System.out.println("-------------------------------------");
            System.out.println(" Here are the matching tasks in your list:");
            for (int i = 0; i < matchedTasks.size(); i++) {
                String msg = (i + 1) + ". " + matchedTasks.getTasks().get(i);
                System.out.println(" " + (i + 1) + ". " + matchedTasks.getTasks().get(i));
                messages.add(msg);
            }
        }
    }

    public List<String> getMessage() {
        return new ArrayList<>(messages);
    }

    public void showMessage(String msg) {
        System.out.println(msg); // optional for console
        messages.add(msg);
    }

}
