public class Deadline extends Task{
    private String dateOfDeadline;

    Deadline(String deadlineDescription, String dateOfDeadline,int deadlineTaskId){
        super(deadlineDescription,deadlineTaskId);
        this.dateOfDeadline = dateOfDeadline;
    }

    Deadline(String deadlineDescription, int deadlineTaskId){
        this(deadlineDescription,"",deadlineTaskId);
    }

    Deadline(){
        this("","",0);
    }

    public String getFormattedDate(){
        dateOfDeadline = dateOfDeadline.replaceFirst("/by","by:");
        return " (" + dateOfDeadline + ")";
    }

    public String displayItem(){
        if(dateOfDeadline.compareTo("") != 0) {
            return getTaskId() + ". " + "[D]" + "[" + displayStatusSymbol() + "]" + " " + getTaskDescription() + getFormattedDate();
        }

        return getTaskId() + ". " + "[D]" + "[" + displayStatusSymbol() + "]" + " " + getTaskDescription();
    }
}
