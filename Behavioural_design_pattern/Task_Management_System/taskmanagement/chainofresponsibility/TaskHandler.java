package com.companyname.taskmanagement.chainofresponsibility;

import com.companyname.taskmanagement.models.Task;

public abstract class TaskHandler {
    protected TaskHandler nextHandler;

    public void setNextHandler(TaskHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleTask(Task task);
}
