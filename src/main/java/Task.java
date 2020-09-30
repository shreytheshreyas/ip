public abstract class Task {
    private final String taskDescription;
    private int taskId;
    private boolean isDone;
    private static final String TICK_MARK = "\u2713";
    private static final String CROSS_MARK = "\u2718";

    Task(String taskDescription,int taskId,boolean isDone){
        this.taskDescription = taskDescription;
        this.taskId = taskId + 1;
        this.isDone = isDone;
    }

    Task(){
        this("",0,false);
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

    public boolean getIsDone() {
        return isDone;
    }
    public int getTaskId(){
        return taskId;
    }

    public void updateTaskId (int newTaskId) {
        taskId = newTaskId;
    }

    abstract String displayItem();
}
