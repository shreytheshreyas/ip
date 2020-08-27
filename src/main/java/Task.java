public class Task {
    private String taskDescription;
    private boolean isDone;

    Task(String taskDescription){
        this.taskDescription = taskDescription;
        this.isDone = false;
    }

    Task(){
        this("");
    }

    public String displayStatusSymbol(){
        return (isDone ? "\u2713" : "\u2718");
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    public void setIsDone(){
        isDone = true;
    }




}
