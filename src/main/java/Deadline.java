public class Deadline extends Task{
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String toString() {
        return "D" + " | " + (isDone ? "done" : "not done" ) + " | " + description + " | " + by ;
    }
}

