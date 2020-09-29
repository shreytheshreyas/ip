import java.util.Scanner;

public class Duke {
    private Ui userInterface;

    public Duke() {
        userInterface = new Ui();
    }

    public void runApplication() {
        userInterface.printIntroMessage();
        userInterface.userCommandHandler();
        userInterface.endApplication();
    }
    public static void main(String[] args) {
        new Duke().runApplication();
    }
}
