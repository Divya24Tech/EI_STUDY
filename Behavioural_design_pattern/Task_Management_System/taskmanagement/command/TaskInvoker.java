package com.companyname.taskmanagement.command;

import com.companyname.utilities.Logging;

public class TaskInvoker {
    private Command command;

    public TaskInvoker(Command command) {
        this.command = command;
    }

    public void assignTask() {
        Logging.info("Invoking task command.");
        command.execute();
    }
}
