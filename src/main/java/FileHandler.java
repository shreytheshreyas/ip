import java.util.Formatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileHandler {
    private final File dukeFile;

    //constructor
    FileHandler () {
        dukeFile = new File ("data/duke.txt");
    }
    //create file
    public void createFile () {
        final Formatter x;

        try {
            x = new Formatter("data/duke.txt");
            System.out.println("New file was created");
        } catch (Exception e) {
            System.out.println("File cannot be created");
        }
    }

    //open and read data from file
    public void  readDataFromFile(ArrayList<Task> taskList) throws FileNotFoundException {
        if (!dukeFile.exists()) {
            createFile();
        }

        Scanner fileScanner = new Scanner(dukeFile);
        int numOfTasks = 0;

        while(fileScanner.hasNext()) {
            String fileText = fileScanner.nextLine();
            String[] fileTextWords = fileText.split(" | ");
            boolean isDone = fileTextWords[1].equals("1");
            switch(fileTextWords[0]) {
            case "T": taskList.add(new Todo(fileTextWords[2],numOfTasks++,isDone));
            case "D": taskList.add(new Deadline(fileTextWords[2],fileTextWords[3],numOfTasks++,isDone));
            case "E": taskList.add(new Event(fileTextWords[2],fileTextWords[3],numOfTasks++,isDone));
            }
        }

    }
    //open and write/append data into file
    public void writeDataToFile(ArrayList<Task> taskList) throws IOException{
        FileWriter dukeFileWriter = new FileWriter(dukeFile.getPath());

        for (Task t:taskList) {
            int isTaskDone = t.getIsDone() ? 1 : 0;
            if (t instanceof Todo) {
                dukeFileWriter.write("T | " + isTaskDone + " | "+ t.getTaskDescription() + System.lineSeparator());
            } else if (t instanceof Deadline) {
                dukeFileWriter.write("D | " + isTaskDone + " | " + t.getTaskDescription() + " | " + ((Deadline) t).getFormattedDate() + System.lineSeparator());
            } else if(t instanceof Event){
                dukeFileWriter.write("E | " + isTaskDone + " | " + t.getTaskDescription() + " | " + ((Event) t).getFormattedDate() + System.lineSeparator());
            }
        }

        dukeFileWriter.close();
    }
}
