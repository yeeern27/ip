import java.util.Scanner;

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
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(line);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(line);
                break;
            }
            System.out.println(line);
            System.out.println(input);
            System.out.println(line);
        }
        scanner.close();
    }



}
