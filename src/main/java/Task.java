public abstract class Task {
    private  String taskDescription;
    private int taskId;
    private boolean isDone;

    Task(String taskDescription,int taskId){
        this.taskDescription = taskDescription;
        this.taskId = taskId + 1;
        this.isDone = false;
    }

    Task(){
        this("",0);
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

    public int getTaskId(){
        return taskId;
    }

    abstract String displayItem();
}
