
import java.util.Scanner;

public class Itachi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Itachi\nWhat can I do for you?");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("***************************************");
                System.out.println("Byeeee. See u in the leaf village again!");
                System.out.println("***************************************");
                break;
            } else {
                System.out.println("***************************************");
                System.out.println(input);
                System.out.println("***************************************");
            }
        }
    }
}
