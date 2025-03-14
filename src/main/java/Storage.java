import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Storage {
    private final String filePath;

    public Storage() {
        this.filePath = getFilePath();
    }
    private String getFilePath() {
        URL location = Ern.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            File jarFile = new File(location.toURI());
            File dataDir = new File(jarFile.getParentFile(), "data");
            if (!dataDir.exists()) {
                dataDir.mkdirs();
            }
            return Paths.get(dataDir.toString(), "Ern.txt").toString();
        } catch (URISyntaxException e) {
            return "./data/Ern.txt";
        }
    }

    public ArrayList<Task> loadFromFile() throws MyException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()){
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                throw new MyException("Error creating file: " + e.getMessage());
            }
        }

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(" \\| ");
                    Task task = null;

                    switch (parts[0].trim()) {
                    case "T":
                        if (parts.length > 2) {
                            task = new ToDo(parts[2]);
                        }
                        break;
                    case "D":
                        if (parts.length > 3) {
                            try{
                                LocalDateTime by = LocalDateTime.parse(parts[3], DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm"));
                                task = new Deadline(parts[2], by);
                            } catch (DateTimeParseException e){
                                System.out.println("Error Loading deadline: " + e);
                            }
                        }
                        break;
                    case "E":
                        if (parts.length > 4) {
                            try{
                                LocalDateTime from = LocalDateTime.parse(parts[3], DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm"));
                                LocalDateTime to = LocalDateTime.parse(parts[4], DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm"));
                                task = new Event(parts[2], from, to);
                            } catch (DateTimeParseException e){
                                System.out.println("Error Loading Event: " + e);
                            }
                        }
                        break;
                    default:
                        throw new MyException("Invalid task format! Type properly: " + parts[0].trim());
                    }
                    if (parts[1].equals("done")) {
                        task.markAsDone();
                    }
                    tasks.add(task);
                }
            } catch (IOException e) {
                throw new MyException("Error loading file: " + e.getMessage());
            }
        }
        return tasks;
    }

    public void saveToFile(ArrayList<Task> tasks) throws MyException {
        String filePath = getFilePath();
        try {
            FileWriter writer = new FileWriter(filePath);
            for (Task task : tasks) {
                writer.write(task.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new MyException("Error saving file: " + e.getMessage());
        }
    }
}

