public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return "E" + " | " + (isDone ? "done" : "not done" ) + " | " + description + " | " + from + " | " + to;
    }
}
