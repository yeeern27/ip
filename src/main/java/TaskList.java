import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int index) throws MyException {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            throw new MyException("Give me a proper number!!!");
        }
    }

    public void markTaskAsDone(int index) throws MyException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
        } else {
            throw new MyException("Give me a proper number!!!");
        }
    }

    public void unmarkTask(int index) throws MyException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsNotDone();
        } else {
            throw new MyException("Give me a proper number!!!");
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index) throws MyException {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        } else {
            throw new MyException("Give me a proper number!!!");
        }
    }

    public int size(){
        return tasks.size();
    }
}
