import java.util.Scanner;

public class Duke {

    public static int addTaskItem(Task[] itemList, String item, int numOfItems){
        itemList[numOfItems++] = new Task(item);
        System.out.println("\tadded: " + item);
        return numOfItems;
    }

    public static void listTasks(Task[] TaskList, int numOfItems){
        for(int i = 0; i < numOfItems; i++){
            System.out.println(i+1 + ".["+TaskList[i].displayStatusSymbol()+"]" + TaskList[i].getTaskDescription());
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
                    System.out.println("["+ TaskList[taskId].displayStatusSymbol() + "]" + TaskList[taskId].getTaskDescription());
                } else{
                    System.out.println("task not in list");
                }

            }else if (lineInput.compareToIgnoreCase("list") == 0) {
                    listTasks(TaskList,numOfTasks);
                    } else {
                    numOfTasks = addTaskItem(TaskList, lineInput, numOfTasks);
                    }

                lineInput = input.nextLine();

        }

        System.out.println("\tBye. Hope to see you again soon!");
    }
}
