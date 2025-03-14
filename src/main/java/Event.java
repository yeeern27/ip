import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, LocalDateTime from, LocalDateTime to) throws MyException {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm");
        return "E" + " | " + (isDone ? "done" : "not done" ) + " | " + description + " | " + formatter.format(from) + " | " + formatter.format(to);
    }
}
