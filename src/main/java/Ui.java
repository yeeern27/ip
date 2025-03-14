import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public static final String line = "_______________________________\n";
    public final Scanner scanner = new Scanner(System.in);

    public void sayHi() {
        String logo = " ____             \n"
                + "|  __|  ___  ____ \n"
                + "| |__ / ___|  __ |\n"
                + "|  __|  |  | | | |  \n"
                + "| |__|  |  | | | |  \n"
                + "|____|__|  |_| |_|\n";
        System.out.println("Hello! I'm \n" + logo);
        System.out.println("What can I do for you?");
    }

    public void sayBye() {
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line);
    }

    public void printTasklist(ArrayList<Task> tasks) {
        System.out.println(line);
        System.out.println("Here are the tasks in your list: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + tasks.get(i));
        }
        System.out.println(line);
    }

    public void markTaskAsDone(Task task) {
        System.out.println(line);
        System.out.println("Nice! I have marked this as Done!: ");
        System.out.println("[" + task.getStatusIcon() + "] " + task.getDescription());
        System.out.println(line);
    }

    public void unmarkTask(Task task) {
        System.out.println(line);
        System.out.println("OK! I have marked this as Not Done!: ");
        System.out.println("[" + task.getStatusIcon() + "] " + task.getDescription());
        System.out.println(line);
    }

    public void addTask(Task task, int size) {
        System.out.println(line);
        System.out.println("Got it. I've added this task: ");
        System.out.println(" " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
        System.out.println(line);
    }

    public void delete(Task task, int size) {
        System.out.println(line);
        System.out.println("Noted. I've deleted this task: ");
        System.out.println(" " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
        System.out.println(line);
    }

    public void showError(String message){
        System.out.println(line);
        System.out.println("OOPS! " + message);
        System.out.println(line);
    }

    public void showLoadingError(MyException e) {
        System.out.println(line);
        System.out.println("OOPS, " + e.getMessage());
        System.out.println(line);
    }
}
