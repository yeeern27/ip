import java.util.Scanner;
import java.util.ArrayList;


public class Ern {
    public static void main(String[] args) {
        String logo = " ____             \n"
                + "|  __|  ___  ____ \n"
                + "| |__ / ___|  __ |\n"
                + "|  __|  |  | | | |  \n"
                + "| |__|  |  | | | |  \n"
                + "|____|__|  |_| |_|\n";
        System.out.println("Hello! I'm \n" + logo);
        System.out.println("What can I do for you?");
        String line = "_______________________________\n";
        System.out.println(line);

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(line);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(line);
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println(line);
                System.out.println("Here are the tasks in your list: ");
                for (int i = 0; i < tasks.size(); i++) {
                    Task task = tasks.get(i);
                    System.out.println(" " + (i + 1) + ". [" + task.getStatusIcon() + "]" + task.getDescription());
                }
                System.out.println(line);
            } else if (input.toLowerCase().startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5).trim()) - 1;
                if (index >= 0 && index < tasks.size()) {
                    tasks.get(index).markAsDone();
                    System.out.println(line);
                    System.out.println("Nice! I have marked this as Done!: ");
                    System.out.println("[" + tasks.get(index).getStatusIcon() + "] " + tasks.get(index).getDescription());
                    System.out.println(line);
                } else {
                    System.out.println("Invalid index!");
                }
            } else if (input.toLowerCase().startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7).trim()) - 1;
                if (index >= 0 && index < tasks.size()) {
                    tasks.get(index).markAsNotDone();
                    System.out.println(line);
                    System.out.println("OK! I have marked this as Not Done!: ");
                    System.out.println("[" + tasks.get(index).getStatusIcon() + "] " + tasks.get(index).getDescription());
                    System.out.println(line);
                } else {
                    System.out.println("Invalid index!");
                }
            } else {
                tasks.add(new Task(input));
                System.out.println(line);
                System.out.println("Added: " + input);
                System.out.println(line);
            }
        }
        scanner.close();
    }
}

