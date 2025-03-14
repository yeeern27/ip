import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Parser class handles the interpretation of user command, and then execute the commands.
 */
public class Parser {

    private final TaskList taskList;
    private final Ui ui;
    private final Storage storage;

    /**
     * Constructs a Parser with given Tasklist, Ui & Storage
     *
     * @param taskList TaskList to manage tasks
     * @param ui Ui to handle user interaction
     * @param storage Storage to handle save and load from file
     */
    public Parser(TaskList taskList, Ui ui, Storage storage) {
        this.taskList = taskList;
        this.ui = ui;
        this.storage = storage;
    }

    /**
     * Parse the user input and execute the commands
     *
     * @param input User input
     * @throws MyException When error occurs during parsing or execution
     */
    public void parse(String input) throws MyException {
        if (input.equalsIgnoreCase("bye")) {
            return;
        } else if (input.equalsIgnoreCase("list")) {
            ui.printTasklist(taskList.getTasks());
        } else if (input.toLowerCase().startsWith("mark ")) {
            markTaskAsDone(input);
        } else if (input.toLowerCase().startsWith("unmark ")) {
            unmarkTask(input);
        } else if (input.toLowerCase().startsWith("todo ")) {
            addToDoTask(input);
        } else if (input.toLowerCase().startsWith("deadline ")) {
            addDeadline(input);
        } else if (input.toLowerCase().startsWith("event ")) {
            addEvent(input);
        } else if (input.toLowerCase().startsWith("delete ")) {
            delete(input);
        } else if (input.toLowerCase().startsWith("find ")) {
            find(input);
        } else {
            throw new MyException("something wrong, please check!");
        }
        storage.saveToFile(taskList.getTasks());
    }

    /**
     * Mark task to be done based on input
     * @param input User Input
     * @throws MyException When error occurs or when input is invalid
     */
    private void markTaskAsDone(String input) throws MyException {
        try {
            int index = Integer.parseInt(input.substring(5).trim()) - 1;
            taskList.markTaskAsDone(index);
            ui.markTaskAsDone(taskList.getTask(index));
        } catch (NumberFormatException e) {
            throw new MyException("Give me a proper number!!!");
        }
    }

    /**
     * Unmark task as done based on input
     * @param input User Input
     * @throws MyException When error occurs or when input is invalid
     */
    private void unmarkTask(String input) throws MyException {
        try {
            int index = Integer.parseInt(input.substring(7).trim()) - 1;
            taskList.unmarkTask(index);
            ui.unmarkTask(taskList.getTask(index));
        } catch (NumberFormatException e) {
            throw new MyException("Give me a proper number!!!");
        }
    }

    /**
     * Add a Todo Task based on input
     * @param input User Input
     * @throws MyException When error occurs or when input is invalid
     */
    private void addToDoTask(String input) throws MyException{
        String description = input.substring(5).trim();
        if (description.isEmpty()) {
            throw new MyException("Description empty! Tell me what you wanna do");
        }
        taskList.addTask(new ToDo(description));
        ui.addTask(taskList.getTask(taskList.size()-1), taskList.size());
    }

    /**
     * Add a deadline Task based on input
     * @param input User Input
     * @throws MyException When error occurs or when input is invalid
     */
    private void addDeadline(String input) throws MyException {
        String[] parts = input.substring(9).split(" /by ", 2);
        if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new MyException("Wrong deadline format! Type properly");
        }

        try {
            LocalDateTime by = LocalDateTime.parse(parts[1].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            taskList.addTask(new Deadline(parts[0].trim(), by));
            ui.addTask(taskList.getTask(taskList.size()-1), taskList.size());
        } catch (DateTimeParseException e) {
            throw new MyException("Invalid date format! Please check for right format");
        }
    }

    /**
     * Add an event Task based on input
     * @param input User Input
     * @throws MyException When error occurs or when input is invalid
     */
    private void addEvent(String input) throws MyException {
        String[] parts = input.substring(6).split(" /from |/to ", 3);
        if (parts.length != 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
            throw new MyException("Wrong event format! Type properly");
        }
        try {
            LocalDateTime from = LocalDateTime.parse(parts[1].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            LocalDateTime to = LocalDateTime.parse(parts[2].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            taskList.addTask(new Event(parts[0].trim(), from, to));
            ui.addTask(taskList.getTask(taskList.size()-1), taskList.size());
        } catch (DateTimeParseException e) {
            throw new MyException("Invalid date format! Please check for right format");
        }
    }

    /**
     * Delete a task based on input
     * @param input User Input
     * @throws MyException When error occurs or when input is invalid
     */
    private void delete(String input) throws MyException {
        try {
            int index = Integer.parseInt(input.substring(7).trim()) - 1;
            Task removedTask = taskList.getTask(index);
            taskList.deleteTask(index);
            ui.delete(removedTask, taskList.size());
        } catch (NumberFormatException e) {
            throw new MyException("Give me a proper number!!!");
        }
    }

    /**
     * find the task that matches with the keyword in the input
     * @param input User Input with keywords
     * @throws MyException When error occurs or when input is invalid
     */
    private void find(String input) throws MyException {
        String keyword = input.substring(5).trim().toLowerCase();
        if (keyword.isEmpty()) {
            throw new MyException("Keyword empty! Type properly");
        }

        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : taskList.getTasks()) {
            if (task.getDescription().toLowerCase().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        ui.printMatchingTasks(matchingTasks);
    }
}
