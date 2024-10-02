package com.companyname.taskmanagement.chainofresponsibility;

import com.companyname.taskmanagement.models.Task;
import com.companyname.utilities.Logging;

public class HRTaskHandler extends TaskHandler {

    @Override
    public void handleTask(Task task) {
        if ("HR".equalsIgnoreCase(task.getDepartment())) {
            Logging.info("Task handled by HR department.");
        } else if (nextHandler != null) {
            Logging.info("Task passed from HR to next department.");
            nextHandler.handleTask(task);
        } else {
            Logging.error("No handler found for this task.");
        }
    }
}
