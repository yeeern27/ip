import java.util.Scanner;
import java.util.ArrayList;


public class Ern {

    private static final String line = "_______________________________\n";

    public static void main(String[] args) {
        sayHi();

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            try {
                if (input.equalsIgnoreCase("bye")) {
                    sayBye();
                    break;
                } else if (input.equalsIgnoreCase("list")) {
                    printTasklist(tasks);
                } else if (input.toLowerCase().startsWith("mark ")) {
                    markTaskAsDone(input, tasks);
                } else if (input.toLowerCase().startsWith("unmark ")) {
                    unmarkTask(input, tasks);
                } else if (input.toLowerCase().startsWith("todo ")) {
                    addToDoTask(input, tasks);
                } else if (input.toLowerCase().startsWith("deadline ")) {
                    addDeadline(input, tasks);
                } else if (input.toLowerCase().startsWith("event ")) {
                    addEvent(input, tasks);
                } else {
                    throw new MyException("something wrong, please check!");
                }
            } catch (MyException e) {
                System.out.println("OOPS! " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void sayHi() {
        String logo = " ____             \n"
                + "|  __|  ___  ____ \n"
                + "| |__ / ___|  __ |\n"
                + "|  __|  |  | | | |  \n"
                + "| |__|  |  | | | |  \n"
                + "|____|__|  |_| |_|\n";
        System.out.println("Hello! I'm \n" + logo);
        System.out.println("What can I do for you?");
        System.out.println(line);
    }

    private static void sayBye() {
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line);
    }

    private static void printTasklist(ArrayList<Task> tasks) {
        System.out.println(line);
        System.out.println("Here are the tasks in your list: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + tasks.get(i));
        }
        System.out.println(line);
    }

    private static void markTaskAsDone(String input, ArrayList<Task> tasks) {
        try {
            int index = Integer.parseInt(input.substring(5).trim()) - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.get(index).markAsDone();
                System.out.println(line);
                System.out.println("Nice! I have marked this as Done!: ");
                System.out.println("[" + tasks.get(index).getStatusIcon() + "] " + tasks.get(index).getDescription());
                System.out.println(line);
            } else {
                throw new MyException("Give me a proper number!!!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void unmarkTask(String input, ArrayList<Task> tasks) {
        try {
            int index = Integer.parseInt(input.substring(7).trim()) - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.get(index).markAsNotDone();
                System.out.println(line);
                System.out.println("OK! I have marked this as Not Done!: ");
                System.out.println("[" + tasks.get(index).getStatusIcon() + "] " + tasks.get(index).getDescription());
                System.out.println(line);
            } else {
                throw new MyException("Give me a proper number!!!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addToDoTask(String input, ArrayList<Task> tasks) throws MyException{
        String description = input.substring(5).trim();
        if (description.isEmpty()) {
            throw new MyException("Description empty! Tell me what you wanna do");
        }
        tasks.add(new ToDo(description));
        System.out.println(line);
        System.out.println("Got it. I've added this task: ");
        System.out.println(" " + tasks.get(tasks.size() - 1));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(line);
    }

    private static void addDeadline(String input, ArrayList<Task> tasks) throws MyException {
        String[] parts = input.substring(9).split(" /by ", 2);
        if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new MyException("Wrong deadline format! Type properly");
        }
        tasks.add(new Deadline(parts[0], parts[1]));
        System.out.println(line);
        System.out.println("Got it. I've added this task: ");
        System.out.println(" " + tasks.get(tasks.size() - 1));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(line);
    }

    private static void addEvent(String input, ArrayList<Task> tasks) throws MyException {
        String[] parts = input.substring(6).split(" /from |/to ", 3);
        if (parts.length != 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
            throw new MyException("Wrong event format! Type properly");
        }
        tasks.add(new Event(parts[0], parts[1], parts[2]));
        System.out.println(line);
        System.out.println("Got it. I've added this task: ");
        System.out.println(" " + tasks.get(tasks.size() - 1));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(line);
    }
}

