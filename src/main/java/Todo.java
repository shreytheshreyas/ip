public class Todo extends Task{
    Todo(String todoDescription, int todoTaskId, boolean isdone){
        super(todoDescription,todoTaskId,isdone);
    }

    Todo(String todoDescription, int todoTaskId) {
        this(todoDescription,todoTaskId,false);
    }
    Todo(){
        this("",0,false);
    }

    //Make use of toString
    public String displayItem(){
        return getTaskId() + ". " + "[T]" + "[" + displayStatusSymbol() + "] " + getTaskDescription();
    }
}
