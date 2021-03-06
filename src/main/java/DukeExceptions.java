import java.util.HashMap;

public class DukeExceptions extends Exception{

    private final HashMap<String,String> exceptionMessages; // Made use of HashMap collection

    DukeExceptions() {
        exceptionMessages = new HashMap<>();

        exceptionMessages.put("todo","☹ OOPS!!! The description of a todo cannot be empty.");
        exceptionMessages.put("deadline description","☹ OOPS!!! The description of a deadline cannot be empty.");
        exceptionMessages.put("deadline date","☹ OOPS!!! Deadline needs to contain the date");
        exceptionMessages.put("event description","☹ OOPS!!! The description of a event cannot be empty.");
        exceptionMessages.put("event date","☹ OOPS!!! Event needs to contain the date");
        exceptionMessages.put("task done","☹ OOPS!!! You have got to specify the task number");
        exceptionMessages.put("task delete","☹ OOPS!!! You have got to specify the task number");
        exceptionMessages.put("data retrieval","☹ OOPS!!! The file could not be found");
        exceptionMessages.put("data storage","☹ OOPS!!! The data could not be written to the file");
        exceptionMessages.put("default","☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public void addTaskExceptionType(String type) throws Exception {
        throw new Exception(exceptionMessages.get(type));
    }

    public void fileExceptionType(String type) {
        System.out.println(exceptionMessages.get(type));
    }
}

