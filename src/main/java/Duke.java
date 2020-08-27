import java.util.Scanner;

public class Duke {

    public static int addListItem(String[] itemList, String item, int numOfItems){
        itemList[numOfItems++] = item;
        System.out.println("\tadded: " + item);
        return numOfItems;
    }

    public static void listItems(String[] itemList, int numOfItems){
        for(int i = 0; i < numOfItems; i++){
            System.out.println(i+1 + ". " + itemList[i]);
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
        String [] itemList = new String[100];
        int numOfItems = 0;

        System.out.println(logo);
        System.out.println("Hello! I'm Duke");
        System.out.print("What can I do for you?\n");
        lineInput = input.nextLine();

        while(lineInput.compareToIgnoreCase("bye") != 0){
            if(lineInput.compareToIgnoreCase("list") == 0){
                listItems(itemList,numOfItems);
            }
            else {
                numOfItems = addListItem(itemList, lineInput, numOfItems);
            }

            lineInput = input.nextLine();
        }

        System.out.println("\tBye. Hope to see you again soon!");
    }
}
