package cn.ltx.activiti7.entity;

import org.activiti.engine.task.Task;

/**
 * @author Administrator
 */
public class TaskApply {
    private Task task;
    private Apply apply;

    public TaskApply(Task task, Apply apply) {
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
