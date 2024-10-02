package com.companyname.taskmanagement.chainofresponsibility;

import com.companyname.taskmanagement.models.Task;
import com.companyname.utilities.Logging;

public class AdminTaskHandler extends TaskHandler {

    @Override
    public void handleTask(Task task) {
        if ("Admin".equalsIgnoreCase(task.getDepartment())) {
            Logging.info("Task handled by Admin department.");
        } else if (nextHandler != null) {
            Logging.info("Task passed from Admin to next department.");
            nextHandler.handleTask(task);
        } else {
            Logging.error("No handler found for this task.");
        }
    }
}
