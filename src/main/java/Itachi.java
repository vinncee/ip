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
                try {
                    checkInput(input, list);
                } catch (ItachiException e) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("--------------------------------------------------");
                }

                }

                // if (input.toLowerCase().startsWith("todo")) {
                // String desc = input.substring(5);
                // Task task = new Todo(desc);
                // list.add(task);
                // printTasksAdded(task, list.size());

                // } else if (input.toLowerCase().startsWith("deadline")) {
                //     String[] parts = input.split("/by", 2);
                //     String desc = parts[0].substring(9).trim();
                //     String by = parts[1].trim();
                //     Task task = new Deadline(desc, by);
                //     list.add(task);
                //     printTasksAdded(task, list.size());

                // } else if (input.toLowerCase().startsWith("event")) {
                //     String[] parts = input.split("/from|/to");
                //     String desc = parts[0].substring(6).trim();
                //     String from = parts[1].trim();
                //     String to = parts[2].trim();
                //     Task task = new Event(desc, from, to);
                //     list.add(task);
                //     printTasksAdded(task, list.size());
                // }
            }

        }
       

    private static void printTasksAdded(Task task, int numTasks) {
        System.out.println("-------------------------------------");
        System.out.println("Got it. I've added this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " + numTasks + " tasks in the list!");
        System.out.println("-------------------------------------");
    }

    private static void checkInput(String input, ArrayList<Task> list) throws ItachiException {
        if (input == null || input.trim().isEmpty()) {
            throw new ItachiException("baka no empty messages!");
        }
        String[] parts = input.trim().split(" ",2);
        String type = input.split(" ")[0].toLowerCase();
        switch(type) {
            case "todo":
                if (parts.length < 2 || parts[1].trim().isEmpty()) {
                    throw new ItachiException("you not gonna key in what u wanna do?");
                }
                String toDoDesc = parts[1].trim();
                Task todo = new Todo(toDoDesc);
                list.add(todo);
                printTasksAdded(todo, list.size());
                break;
            
            case "deadline":
                if (parts.length < 2 || !parts[1].contains("/by")) {
                    throw new ItachiException("no empty messages and please write '/by' followed by the deadline");
                }   
                String[] deadlineParts = parts[1].split("/by", 2);
                String deadlineDesc = deadlineParts[0].trim();
                String by = deadlineParts[1].trim();
                if (deadlineDesc.isEmpty() || by.isEmpty()) {
                    throw new ItachiException("Write what you gonna do and the deadline");
                }
                Task deadline = new Deadline(deadlineDesc, by);
                list.add(deadline);
                printTasksAdded(deadline, list.size());
                break;
            case "event":
                if (parts.length < 2 || !parts[1].contains("/from") || !parts[1].contains("/to")) {
                    throw new ItachiException("Write the description followed by '/from' time, and '/to' time! ");
                }
                String[] eventParts = parts[1].split("/from|/to");
                if (eventParts.length < 3) {
                    throw new ItachiException("Please write description, '/from' date and '/to' date");
                }
                String eventDesc = eventParts[0];
                String from = eventParts[1];
                String to = eventParts[2];
                if (eventDesc.isEmpty() || from.isEmpty() || to.isEmpty()) {
                    throw new ItachiException("Please write in the description, '/from' date and '/to' date!");
                }
                Task event = new Event(eventDesc, from, to);
                list.add(event);
                printTasksAdded(event, list.size());
                break;
            default:
            throw new ItachiException("TYPE IN A PROPER COMMAND!");
    
        }
    }

}
