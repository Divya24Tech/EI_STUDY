package com.companyname.taskmanagement.command;

import com.companyname.taskmanagement.models.Task;
import com.companyname.taskmanagement.chainofresponsibility.TaskHandler;
import com.companyname.utilities.Logging;

public class AssignTaskCommand implements Command {
    private Task task;
    private TaskHandler handler;

    public AssignTaskCommand(Task task, TaskHandler handler) {
        this.task = task;
        this.handler = handler;
    }

    @Override
    public void execute() {
        Logging.info("Executing task assignment command.");
        handler.handleTask(task);
    }
}
