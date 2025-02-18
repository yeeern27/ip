import java.util.Scanner;

public class Ern {

    private final Storage storage;
    private TaskList taskList;
    private final Parser parser;
    private final Ui ui;

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

    public static void main(String[] args) {
        new Ern().run();
    }
}

