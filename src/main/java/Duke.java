import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        Scanner input = new Scanner(System.in);
        String lineInput;
        TaskList myTaskList = new TaskList();

        System.out.println(logo);
        System.out.println("Hello! I'm Duke");
        System.out.print("What can I do for you?\n");
        lineInput = input.nextLine();

        while (lineInput.compareToIgnoreCase("bye") != 0) {
            try {
                myTaskList.parseUserInput(lineInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            lineInput = input.nextLine();
        }

        myTaskList.saveData();
        System.out.println("\tBye. Hope to see you again soon!");
    }
}
