import java.util.ArrayList;
import java.util.Scanner;

public class Itachi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Itachi\nWhat can I do for you?");
        ArrayList<Task> list = new ArrayList<>();
        
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("-------------------------------------");
                System.out.println("byeee see u in the leaf village again!");
                System.out.println("-------------------------------------");
                break;

            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("-------------------------------------");
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i+1 + ". " + list.get(i).toString());
                }
                System.out.println("-------------------------------------");

            } else if (input.toLowerCase().startsWith("mark ")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                Task task = list.get(index);
                task.markAsDone();
                System.out.println("-------------------------------------");
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(task.toString());
                System.out.println("-------------------------------------");

            } else if (input.toLowerCase().startsWith("unmark ")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                Task task = list.get(index);
                task.markAsNotDone();
                System.out.println("-------------------------------------");
                System.out.println("Sure! I've marked this task as NOT done");
                System.out.println(task.toString());
                System.out.println("-------------------------------------");

            } else {
                Task task = new Task(input);
                list.add(task);
                System.out.println("-------------------------------------");
                System.out.println("added: " + input);
                System.out.println("-------------------------------------");
            }

        }
       
    }
}
