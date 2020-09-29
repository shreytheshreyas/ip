public class Deadline extends Task{
    private String dateOfDeadline;

    Deadline(String deadlineDescription, String dateOfDeadline,int deadlineTaskId,boolean isDone){
        super(deadlineDescription,deadlineTaskId,isDone);
        this.dateOfDeadline = dateOfDeadline;
    }
    Deadline(String deadlineDescription,String dateOfDeadline, int deadlineTaskId){
        this(deadlineDescription,dateOfDeadline,deadlineTaskId,false);
    }
    Deadline(String deadlineDescription, int deadlineTaskId){
        this(deadlineDescription,"",deadlineTaskId,false);
    }

    Deadline(){
        this("","",0,false);
    }
    //returns date in the required UI format.
    public String getFormattedDate(){
        dateOfDeadline = dateOfDeadline.replaceFirst("/by","by:");
        return " (" + dateOfDeadline + ")";
    }
    //return the date in the required file format.
    public String getFileFormattedDate() {
        return dateOfDeadline.replaceFirst("by: ","");
    }
    //Make use of toString instead of displayItem()
    public String displayItem(){
        if (dateOfDeadline.compareTo("") != 0) {
            return getTaskId() + ". " + "[D]" + "[" + displayStatusSymbol() + "]" + " " + getTaskDescription() + getFormattedDate();
        }

        return getTaskId() + ". " + "[D]" + "[" + displayStatusSymbol() + "]" + " " + getTaskDescription();
    }
}
