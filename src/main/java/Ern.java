import java.util.Scanner;

/**
 * Ern class that represents the main class for the Ern Chatbot
 * It initialise and manage the components of the chatbot
 */
public class Ern {

    private final Storage storage;
    private TaskList taskList;
    private final Parser parser;
    private final Ui ui;

    /**
     * Construct the Ern Chatbot
     * Initialise the user interface, storage, taskList, and parser
     * Load task from storage file
     */
    public Ern(){
        ui = new Ui();
        storage = new Storage();

        try {
            taskList = new TaskList(storage.loadFromFile());
        } catch (MyException e){
            ui.showLoadingError(e);
            taskList = new TaskList();
        }
        parser = new Parser(taskList, ui, storage);
    }

    /**
     * Execute the Ern Chatbot
     * Say Hi to user, load existing tasks, and process user input until user say bye
     * Catch and throw any exception error when running
     */
    public void run(){
        ui.sayHi();

        if(!taskList.getTasks().isEmpty()){
            ui.printTasklist(taskList.getTasks());
        }

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            try {
                parser.parse(input);
                if (input.equalsIgnoreCase("bye")){
                    break;
                }
            } catch (MyException e){
                ui.showError(e.getMessage());
            }
        }
        scanner.close();
        ui.sayBye();
    }

    /**
     * Main method of the Ern application
     * Creates a new Ern object and run it
     *
     * @param args Command Line arguments
     */
    public static void main(String[] args) {
        new Ern().run();
    }
}

