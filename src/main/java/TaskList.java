import java.util.ArrayList;

/**
 * TaskList class manages a list of tasks, and have methods to add, delete, mark and unmark task
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * A TaskList with an ArrayList of Task objects
     *
     * @param tasks The ArrayLlist of Task objects to initialize the TaskList with
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Constructs an empty TaskList
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Add task to the TaskList
     *
     * @param task The Task Object to add
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Delete task from the TaskList
     *
     * @param index Index of task to delete
     * @throws MyException When the index is out of bound
     */
    public void deleteTask(int index) throws MyException {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            throw new MyException("Give me a proper number!!!");
        }
    }

    /**
     * Mark a task as done
     *
     * @param index Index of task to be marked done
     * @throws MyException When the index is out of bound
     */
    public void markTaskAsDone(int index) throws MyException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
        } else {
            throw new MyException("Give me a proper number!!!");
        }
    }

    /**
     * Unmark a marked task
     *
     * @param index Index of task to be unmarked
     * @throws MyException When the index is out of bound
     */
    public void unmarkTask(int index) throws MyException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsNotDone();
        } else {
            throw new MyException("Give me a proper number!!!");
        }
    }

    /**
     * Retrieves the ArrayList of Task Objects
     *
     * @return The Arraylist of Task objects
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Retrieves a task with specified index
     *
     * @param index The index of task to be retrieved
     * @return The Task object that is at the required index
     * @throws MyException If the index is out of bound
     */
    public Task getTask(int index) throws MyException {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        } else {
            throw new MyException("Give me a proper number!!!");
        }
    }

    /** Retrieves the number of tasks in the list
     *
     * @return the number of tasks in the list
     */
    public int size(){
        return tasks.size();
    }
}
