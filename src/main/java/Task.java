public abstract class Task {
    private  String taskDescription;
    private int taskId;
    private boolean isDone;
    private static String TICK_MARK = "\u2713";
    private static String CROSS_MARK = "\u2718";

    Task(String taskDescription,int taskId){
        this.taskDescription = taskDescription;
        this.taskId = taskId + 1;
        this.isDone = false;
    }

    Task() {
        this("",0);
    }

    public String displayStatusSymbol() {
        return (isDone ? TICK_MARK : CROSS_MARK);
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setIsDone() {
        isDone = true;
    }

    public int getTaskId(){
        return taskId;
    }

    public void updateTaskId (int newTaskId) {
        taskId = newTaskId;
    }

    abstract String displayItem();
}
