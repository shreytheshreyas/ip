import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class TaskList {
    private final ArrayList<Task> taskList; //Made use of ArrayList Collection
    private int numOfTasks;
    private final FileHandler dukeFileHandler;
    private final DukeExceptions exceptionHandler;

    public TaskList() {
        dukeFileHandler = new FileHandler();
        taskList = new ArrayList<>();
        retrieveArrayListInfo();
        numOfTasks = 0;
        exceptionHandler = new DukeExceptions();
    }

    public void retrieveArrayListInfo(){
        try{
            dukeFileHandler.readDataFromFile(taskList);
        } catch (FileNotFoundException e){
            System.out.println("Something went wrong");
        }
    }

    public void listTasks(ArrayList<Task> taskList, int numOfItems) {
        for (int i = 0; i < numOfItems; i++) {
            System.out.println(taskList.get(i).displayItem());
        }
    }

    public int addTaskItem(ArrayList<Task> taskList, String item, int numOfItems, String typeOfTask) throws Exception {

        switch (typeOfTask) {
        case "todo":
            if (item.equals("")) {
                exceptionHandler.exceptionType("todo");
            }

            taskList.add(new Todo(item,numOfItems));
            break;
        case "deadline":
            if (item.equals("")) {
                exceptionHandler.exceptionType("deadline description");
            }
            if (item.contains("/by")) {
                String dateOfDeadline = item.substring(item.indexOf("/by"));
                taskList.add(new Deadline(item.substring(0, item.indexOf("/by") - 1), dateOfDeadline, numOfItems));
            } else {
                exceptionHandler.exceptionType("deadline date");
            }
            break;
        case "event":
            if (item.equals("")) {
                exceptionHandler.exceptionType("event description");
            }
            if (item.contains("/at")) {
                String dateOfEvent = item.substring(item.indexOf("/at"));
                taskList.add(new Event(item.substring(0, item.indexOf("/at") - 1), dateOfEvent, numOfItems));
            } else {
                exceptionHandler.exceptionType("event date");
            }
            break;
        default:
            exceptionHandler.exceptionType("default");
        }

        System.out.println("Got it. I've added this task: ");
        System.out.println("\t" + taskList.get(numOfItems++).displayItem());
        System.out.println("Now you have " + numOfItems + " tasks in the list.");
        return numOfItems;
    }

    public void parseUserInput(String userInput) throws Exception{
        String []userInputWords = userInput.split(" ");

        if (userInputWords[0].compareToIgnoreCase("done") == 0) {
            if (userInputWords.length == 1) {
                exceptionHandler.exceptionType("task done");
            }

            int taskId = Integer.parseInt(userInputWords[1]) - 1;
            if (taskId < numOfTasks) {
                taskList.get(taskId).setIsDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(taskList.get(taskId).displayItem());
            } else {
                System.out.println("task not in list");
            }

        }else if (userInput.compareToIgnoreCase("list") == 0) {
            listTasks(taskList,numOfTasks);
        } else {

            String typeOfTask = "";

            if (userInputWords[0].compareToIgnoreCase("todo") == 0) {
                System.out.println(userInputWords[0]);
                typeOfTask = "todo";
            }

            if (userInputWords[0].compareToIgnoreCase("deadline") == 0) {
                typeOfTask = "deadline";
            }

            if (userInputWords[0].compareToIgnoreCase("event") == 0) {
                typeOfTask = "event";
            }

            String updatedInput = userInput.replaceFirst(userInputWords[0] , ""); //removes the todo,event and deadline text piece


            numOfTasks = addTaskItem(taskList, updatedInput, numOfTasks,typeOfTask);
            

        }
    }
    public void saveData() {
        try{
            dukeFileHandler.writeDataToFile(taskList);
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }
}
