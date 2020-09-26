import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> taskList; //Made use of ArrayList Collection
    private int numOfTasks;
    public DukeExceptions exceptionHandler;

    public TaskList() {
        taskList = new ArrayList<>();
        numOfTasks = 0;
        exceptionHandler = new DukeExceptions();
    }

    public void listTasks(ArrayList<Task> taskList, int numOfItems) {
        for (int i = 0; i < numOfItems; i++) {
            System.out.println(taskList.get(i).displayItem());
        }
    }

    public void updateTaskListIdOrder() {
        for (int i = 0; i < numOfTasks; i++) {
            taskList.get(i).updateTaskId(i+1);
        }
    }

    public void addTaskItem(String item, String typeOfTask) throws Exception {

        switch (typeOfTask) {
        case "todo":
            if (item.equals("")) {
                exceptionHandler.exceptionType("todo");
            }

            taskList.add(new Todo(item,numOfTasks));
            break;
        case "deadline":
            if (item.equals("")) {
                exceptionHandler.exceptionType("deadline description");
            }
            if (item.contains("/by")) {
                String dateOfDeadline = item.substring(item.indexOf("/by"));
                taskList.add(new Deadline(item.substring(0, item.indexOf("/by") - 1), dateOfDeadline, numOfTasks));
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
                taskList.add(new Event(item.substring(0, item.indexOf("/at") - 1), dateOfEvent, numOfTasks));
            } else {
                exceptionHandler.exceptionType("event date");
            }
            break;
        default:
            exceptionHandler.exceptionType("default");
        }

        System.out.println("Got it. I've added this task: ");
        System.out.println("\t" + taskList.get(numOfTasks++).displayItem());
        System.out.println("Now you have " + numOfTasks + " tasks in the list.");
    }

    public void deleteTaskItem(int taskId) {
        System.out.println("Got it. I've removed this task: ");
        System.out.println("\t" + taskList.get(taskId).displayItem());
        taskList.remove(taskList.get(taskId));
        numOfTasks--;
        System.out.println("Now you have " + numOfTasks + " tasks in the list.");
        updateTaskListIdOrder();
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

        } else if (userInput.compareToIgnoreCase("list") == 0) {
            listTasks(taskList,numOfTasks);
        } else if (userInputWords[0].compareToIgnoreCase("delete") == 0) {
            if (userInputWords.length == 1) {
                exceptionHandler.exceptionType("task delete");
            }
            int taskId = Integer.parseInt(userInputWords[1]) - 1;
            if (taskId < numOfTasks) {
                deleteTaskItem(taskId);
            } else {
                System.out.println("task not in list");
            }
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

            addTaskItem(updatedInput, typeOfTask);
        }
    }
}
