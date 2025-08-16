import java.util.ArrayList;
import java.util.Scanner;

public class Itachi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Itachi\nWhat can I do for you?");
        ArrayList<String> list = new ArrayList<>();
        
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("-------------------------------------");
                System.out.println("byeee see u in the leaf village again!");
                System.out.println("-------------------------------------");
                break;

            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("-------------------------------------");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i+1 + ". " + list.get(i));
                }
                System.out.println("-------------------------------------");

            } else {
                list.add(input);
                System.out.println("-------------------------------------");
                System.out.println("added: " + input);
                System.out.println("-------------------------------------");
            }

        }
       
    }
}
