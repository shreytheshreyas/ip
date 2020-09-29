import java.util.Scanner;

public class Ui {
    private String logo;
    private Parser myParser;
    //constructor
    public Ui() {
        myParser = new Parser();
        logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

    }

    public void printIntroMessage() {
        System.out.println(logo);
        System.out.println("Hello! I'm Duke");
        System.out.print("What can I do for you?\n");
    }

    public void userCommandHandler() {
        Scanner input = new Scanner(System.in);
        String lineInput;

        lineInput = input.nextLine();

        while (lineInput.compareToIgnoreCase("bye") != 0) {
            try {
                myParser.parseUserInput(lineInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            lineInput = input.nextLine();
        }
    }

    public void endApplication() {
        System.out.println("\tBye. Hope to see you again soon!");
    }
}
