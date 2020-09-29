import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class TaskList {
    private final ArrayList<Task> taskList;
    private int numOfTasks;
    private final FileHandler dukeFileHandler;
    private final DukeExceptions exceptionHandler;

    public TaskList() { //TaskList
        dukeFileHandler = new FileHandler();
        taskList = new ArrayList<>();
        retrieveArrayListInfo();
        numOfTasks = taskList.isEmpty() ? 0 : taskList.size();
        exceptionHandler = new DukeExceptions();
    }

    public void retrieveArrayListInfo(){ //TaskList
        try{
            dukeFileHandler.readDataFromFile(taskList);
        } catch (FileNotFoundException e){
            exceptionHandler.fileExceptionType("data retrieval");
        }
    }

    public void saveData() { //TaskList
        try{
            dukeFileHandler.writeDataToFile(taskList);
        } catch (IOException e) {
            exceptionHandler.fileExceptionType("data storage");
        }
    }

    public void listTasks() {
        if(numOfTasks == 0) {
            System.out.println("You have no tasks in the list");
        }

        for (int i = 0; i < numOfTasks; i++) {
            System.out.println(taskList.get(i).displayItem());
        }
    }

    public void updateTaskListIdOrder() { //TaskList
        for (int i = 0; i < numOfTasks; i++) {
            taskList.get(i).updateTaskId(i+1);
        }
    }

    public void addTaskItem(String item, String typeOfTask) throws Exception { //TaskList

        switch (typeOfTask) {
        case "todo":
            if (item.equals("")) {
                exceptionHandler.addTaskExceptionType("todo");
            }

            taskList.add(new Todo(item,numOfTasks));
            break;
        case "deadline":
            if (item.equals("")) {
                exceptionHandler.addTaskExceptionType("deadline description");
            }
            if (item.contains("/by")) {
                String dateOfDeadline = item.substring(item.indexOf("/by"));
                taskList.add(new Deadline(item.substring(0, item.indexOf("/by") - 1), dateOfDeadline, numOfTasks));
            } else {
                exceptionHandler.addTaskExceptionType("deadline date");
            }
            break;
        case "event":
            if (item.equals("")) {
                exceptionHandler.addTaskExceptionType("event description");
            }
            if (item.contains("/at")) {
                String dateOfEvent = item.substring(item.indexOf("/at"));
                taskList.add(new Event(item.substring(0, item.indexOf("/at") - 1), dateOfEvent, numOfTasks));
            } else {
                exceptionHandler.addTaskExceptionType("event date");
            }
            break;
        default:
            exceptionHandler.addTaskExceptionType("default");
        }

        System.out.println("Got it. I've added this task: ");
        System.out.println("\t" + taskList.get(numOfTasks++).displayItem());
        System.out.println("Now you have " + numOfTasks + " tasks in the list.");
    }

    public void deleteTaskItem(int taskId) { //TaskList
        System.out.println("Got it. I've removed this task: ");
        System.out.println("\t" + taskList.get(taskId).displayItem());
        taskList.remove(taskList.get(taskId));
        numOfTasks--;
        System.out.println("Now you have " + numOfTasks + " tasks in the list.");
        updateTaskListIdOrder();
    }

    public void findTask(String keyword){  // TaskList
        boolean taskFound = false;

        for(Task t:taskList) {
            if(t.displayItem().contains(keyword)) {
                if(!taskFound) {
                    taskFound = true;
                    System.out.println("Here are the matching tasks in your list: ");
                }
                System.out.println(t.displayItem());
            }
        }
        if(!taskFound) {
            System.out.println("No Task in the list contains the keyword you entered");
        }
    }

    public int getNumOfTasks() { //newly added method
        return numOfTasks;
    }

    public void finishedTask(int taskId) {
        taskList.get(taskId).setIsDone();
        System.out.println("Nice! I've marked this task as done: ");
    }

    public String displayTask(int taskId) {
        return taskList.get(taskId).displayItem();
    }

//    public void parseUserInput(String userInput) throws Exception{ //Paser
//        String []userInputWords = userInput.split(" ");
//
//        if (userInputWords[0].compareToIgnoreCase("done") == 0) {
//            if (userInputWords.length == 1) {
//                exceptionHandler.addTaskExceptionType("task done");
//            }
//            int taskId = Integer.parseInt(userInputWords[1]) - 1;
//            if (taskId < numOfTasks) {
//                taskList.get(taskId).setIsDone();
//                System.out.println("Nice! I've marked this task as done: ");
//                System.out.println(taskList.get(taskId).displayItem());
//            } else {
//                System.out.println("task not in list");
//            }
//
//        } else if (userInput.compareToIgnoreCase("list") == 0) {
//            listTasks(taskList,numOfTasks);
//        } else if (userInputWords[0].compareToIgnoreCase("delete") == 0) {
//            if (userInputWords.length == 1) {
//                exceptionHandler.addTaskExceptionType("task delete");
//            }
//            int taskId = Integer.parseInt(userInputWords[1]) - 1;
//            if (taskId < numOfTasks) {
//                deleteTaskItem(taskId);
//            } else {
//                System.out.println("task not in list");
//            }
//        } else if (userInputWords[0].compareToIgnoreCase("find") == 0){
//            String requiredKeyword = userInputWords[1];
//            findTask(requiredKeyword);
//        } else {
//
//            String typeOfTask = "";
//
//            if (userInputWords[0].compareToIgnoreCase("todo") == 0) {
//                System.out.println(userInputWords[0]);
//                typeOfTask = "todo";
//            }
//
//            if (userInputWords[0].compareToIgnoreCase("deadline") == 0) {
//                typeOfTask = "deadline";
//            }
//
//            if (userInputWords[0].compareToIgnoreCase("event") == 0) {
//                typeOfTask = "event";
//            }
//
//            String updatedInput = userInput.replaceFirst(userInputWords[0] , ""); //removes the todo,event and deadline text piece
//
//            addTaskItem(updatedInput, typeOfTask);
//        }
//    }

}
