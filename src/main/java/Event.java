public class Event extends Task{
    private String dateOfEvent;

    Event(String eventDescription, String dateOfEvent, int eventTaskId, boolean isdone){
        super(eventDescription, eventTaskId,isdone);
        this.dateOfEvent = dateOfEvent;
    }

    Event(String eventDescription, String dateOfEvent, int eventTaskId) {
        this(eventDescription,dateOfEvent,eventTaskId,false);
    }
    Event(String eventDescription, int eventTaskId){
        this(eventDescription,"",eventTaskId,false);
    }

    Event(){
        this("","",0,false);
    }

    public String getFormattedDate(){
        dateOfEvent = dateOfEvent.replaceFirst("/at","at:");
        return " (" + dateOfEvent + ")";
    }

    public String getFileFormattedDate() {
        return dateOfEvent.replaceFirst("at: ","");
    }
    public String displayItem(){
        if (dateOfEvent.compareTo("") != 0) {
            return getTaskId() + ". " + "[E]" + "[" + displayStatusSymbol() + "]" + " " + getTaskDescription() + getFormattedDate();
        }

        return getTaskId() + ". " + "[E]" + "[" + displayStatusSymbol() + "]" + " " + getTaskDescription();
    }
}
