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
        ArrayList<String> tasks = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(line);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(line);
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println(line);
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
                System.out.println(line);
            } else {
                    tasks.add(input);
                    System.out.println(line);
                    System.out.println("Added: " + input);
                    System.out.println(line);
                }
            }
        scanner.close();
    }
}
