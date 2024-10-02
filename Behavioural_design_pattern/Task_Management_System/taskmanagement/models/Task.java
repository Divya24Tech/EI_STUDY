package com.companyname.taskmanagement.models;

import com.companyname.utilities.Logging;

public class Task {
    private String name;
    private String department;

    public Task(String name, String department) {
        if (name == null || name.isEmpty()) {
            Logging.error("Task name cannot be null or empty.");
            throw new IllegalArgumentException("Invalid task name.");
        }
        if (department == null || department.isEmpty()) {
            Logging.error("Department cannot be null or empty.");
            throw new IllegalArgumentException("Invalid department.");
        }
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
