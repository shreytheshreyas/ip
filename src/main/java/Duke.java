import java.util.Scanner;

public class Duke {

    public static int addTaskItem(Task[] TaskList, String item, int numOfItems, String typeOfTask){

        switch(typeOfTask){
        case "todo":
            TaskList[numOfItems] = new Todo(item,numOfItems);
            break;

        case "deadline":
            if(item.contains("/by")) {
                String dateOfDeadline = item.substring(item.indexOf("/by"));
                TaskList[numOfItems] = new Deadline(item.substring(0, item.indexOf("/by") - 1), dateOfDeadline, numOfItems);
            }else{
                TaskList[numOfItems] = new Deadline(item,numOfItems);
            }
            break;

        case "event":
            if(item.contains("/at")) {
                String dateOfEvent = item.substring(item.indexOf("/at"));
                TaskList[numOfItems] = new Event(item.substring(0, item.indexOf("/at") - 1), dateOfEvent, numOfItems);
            }else{
                TaskList[numOfItems] = new Event(item,numOfItems);
            }
            break;

        default:
            System.out.println("Not a valid Task");
            return numOfItems;
        }

        System.out.println("Got it. I've added this task: ");
        System.out.println("\t" + TaskList[numOfItems++].displayItem());
        System.out.println("Now you have " + numOfItems + " tasks in the list.");
        return numOfItems;
    }

    public static void listTasks(Task[] TaskList, int numOfItems){
        for(int i = 0; i < numOfItems; i++){
            System.out.println(TaskList[i].displayItem());
        }
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        Scanner input = new Scanner(System.in);
        String lineInput;
        Task [] TaskList = new Task[100];
        int numOfTasks = 0;

        System.out.println(logo);
        System.out.println("Hello! I'm Duke");
        System.out.print("What can I do for you?\n");
        lineInput = input.nextLine();

        while(lineInput.compareToIgnoreCase("bye") != 0){
            String []lineInputWords = lineInput.split(" ");

            if(lineInputWords[0].compareToIgnoreCase("done") == 0){
                int taskId = Integer.parseInt(lineInputWords[1]) - 1;
                if(taskId < numOfTasks){
                    TaskList[taskId].setIsDone();
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println(TaskList[taskId].displayItem());
                } else{
                    System.out.println("task not in list");
                }

            }else if (lineInput.compareToIgnoreCase("list") == 0) {
                    listTasks(TaskList,numOfTasks);
                    } else {

                    String typeOfTask = "";
                    if(lineInputWords[0].compareToIgnoreCase("todo") == 0){
                        typeOfTask = "todo";
                    }

                    if(lineInputWords[0].compareToIgnoreCase("deadline") == 0){
                    typeOfTask = "deadline";
                    }

                    if(lineInputWords[0].compareToIgnoreCase("event") == 0){
                    typeOfTask = "event";
                    }

                    lineInput = lineInput.replaceFirst(lineInputWords[0] + " ", ""); //removes the todo,event and deadline text piece
                    numOfTasks = addTaskItem(TaskList, lineInput, numOfTasks,typeOfTask);
                    }

                lineInput = input.nextLine();
        }

        System.out.println("\tBye. Hope to see you again soon!");
    }
}
