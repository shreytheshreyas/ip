public class Event extends Task{
    private String dateOfEvent;

    Event(String eventDescription, String dateOfEvent, int eventTaskId){
        super(eventDescription, eventTaskId);
        this.dateOfEvent = dateOfEvent;
    }

    Event(String eventDescription, int eventTaskId){
        this(eventDescription,"",eventTaskId);
    }

    Event(){
        this("","",0);
    }

    public String getFormattedDate(){
        dateOfEvent = dateOfEvent.replaceFirst("/at","at:");
        return " (" + dateOfEvent + ")";
    }

    public String displayItem(){
        if (dateOfEvent.compareTo("") != 0) {
            return getTaskId() + ". " + "[E]" + "[" + displayStatusSymbol() + "]" + " " + getTaskDescription() + getFormattedDate();
        }

        return getTaskId() + ". " + "[E]" + "[" + displayStatusSymbol() + "]" + " " + getTaskDescription();
    }
}
