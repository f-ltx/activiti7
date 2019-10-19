package cn.ltx.activiti7.entity;

import org.activiti.engine.task.Task;

public class TaskView {
    private Task task;
    private Apply apply;

    public TaskView(Task task, Apply apply) {
        this.task = task;
        this.apply = apply;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }
}
