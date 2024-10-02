package com.companyname.taskmanagement.chainofresponsibility;

import com.companyname.taskmanagement.models.Task;
import com.companyname.utilities.Logging;

public class ITTaskHandler extends TaskHandler {

    @Override
    public void handleTask(Task task) {
        if ("IT".equalsIgnoreCase(task.getDepartment())) {
            Logging.info("Task handled by IT department.");
        } else if (nextHandler != null) {
            Logging.info("Task passed from IT to next department.");
            nextHandler.handleTask(task);
        } else {
            Logging.error("No handler found for this task.");
        }
    }
}
