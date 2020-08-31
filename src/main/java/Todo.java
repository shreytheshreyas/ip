public class Todo extends Task{
    Todo(String todoDescription, int todoTaskId){
        super(todoDescription,todoTaskId);
    }

    Todo(){
        this("",0);
    }

    public String displayItem(){
        return getTaskId() + ". " + "[T]" + "[" + displayStatusSymbol() + "]"+ " " + getTaskDescription();
    }
}
