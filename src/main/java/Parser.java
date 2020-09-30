public class Parser {
    private final DukeExceptions exceptionHandler;
    private final TaskList dukeTaskList;

    public Parser() {
        exceptionHandler = new DukeExceptions();
        dukeTaskList = new TaskList();
    }

    public String getTaskType(String userCommand){
        String typeOfTask;
        if (userCommand.compareToIgnoreCase("todo") == 0) {
            typeOfTask = "todo";
        }else if (userCommand.compareToIgnoreCase("deadline") == 0) {
            typeOfTask = "deadline";
        }else if (userCommand.compareToIgnoreCase("event") == 0) {
            typeOfTask = "event";
        }else {
            typeOfTask = "";
        }
        return typeOfTask;
    }

    /**
     * Responsible for handling a input that is given by the user
     * for task recording such as add and deleting tasks and listing
     * all previously entered tasks. The function saves the data after
     * after the conclusion of each command
     * <p>
     * The function also throws custom exceptions if the input entered by
     * user does not make logical sense
     *
     * @param userInput The input that is entered by the user in the program
     **/
    public void parseUserInput(String userInput) throws Exception{
        String []userInputWords = userInput.split(" ");

        if (userInputWords[0].compareToIgnoreCase("done") == 0) {
            if (userInputWords.length == 1) {
                exceptionHandler.addTaskExceptionType("task done");
            }
            int taskId = Integer.parseInt(userInputWords[1]) - 1;
            if (taskId < dukeTaskList.getNumOfTasks()) {
                dukeTaskList.finishedTask(taskId);
                System.out.println(dukeTaskList.displayTask(taskId));
            } else {
                System.out.println("task not in list");
            }
        } else if (userInput.compareToIgnoreCase("list") == 0) {
            dukeTaskList.listTasks(); //method to list tasks
        } else if (userInputWords[0].compareToIgnoreCase("delete") == 0) {
            if (userInputWords.length == 1) {
                exceptionHandler.addTaskExceptionType("task delete");
            }
            int taskId = Integer.parseInt(userInputWords[1]) - 1;
            if (taskId < dukeTaskList.getNumOfTasks()) {
                dukeTaskList.deleteTaskItem(taskId);
            } else {
                System.out.println("task not in list");
            }
        } else if (userInputWords[0].compareToIgnoreCase("find") == 0){
            String requiredKeyword = userInputWords[1];
            dukeTaskList.findTask(requiredKeyword);
        } else {
            String typeOfTask = getTaskType(userInputWords[0]);
            String updatedInput = userInput.replaceFirst(userInputWords[0] , ""); //removes the todo,event and deadline text piece
            dukeTaskList.addTaskItem(updatedInput, typeOfTask);
        }
        dukeTaskList.saveData();
    }

}
