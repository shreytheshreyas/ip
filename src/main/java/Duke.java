/**
 * <h1>Duke - Your Personal Task Manager!</h1>
 * Duke helps you to record all your
 * upcoming tasks, deadlines anf event.
 * <p>
 * Duke allows helps you to keep track of the tasks
 * that are still pending and are finished and stores them
 * away safely so that you can access them later if you decide
 * to leave the application
 *
 * @author  Shreyas Kumar
 * @version 0.2
 * @since   2020-09-29
 * */
public class Duke {
    private final Ui userInterface;

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
