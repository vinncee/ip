package itachi;
import java.util.Scanner;

import itachi.task.TaskList;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.println("\"Hello! I'm Itachi\nWhat can I do for you?");
    }

    public void showLine() {
        System.out.println("-------------------------------------");
    }

    public void showError(String errorMsg) {
        System.out.println("Error: " + errorMsg);
    }

    public String readCommand() {
        return this.scanner.nextLine().trim();
    }

    public void showFindResult(TaskList matchedTasks) {
        if (matchedTasks.getTasks().isEmpty()) {
            System.out.println("-------------------------------------");
            System.out.println(" No matching tasks found.");
            System.out.println("-------------------------------------");
        } else {
            System.out.println("-------------------------------------");
            System.out.println(" Here are the matching tasks in your list:");
            for (int i = 0; i < matchedTasks.size(); i++) {
                System.out.println(" " + (i + 1) + ". " + matchedTasks.getTasks().get(i));
            }
        }
    }
}
