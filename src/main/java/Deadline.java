import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    protected LocalDateTime by;

    public Deadline(String description, LocalDateTime by) throws MyException {
        super(description);
        this.by = by;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm");
        return "D" + " | " + (isDone ? "done" : "not done" ) + " | " + description + " | " + formatter.format(by);
    }
}
