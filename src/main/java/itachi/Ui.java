package itachi;

import java.util.Scanner;

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
}
