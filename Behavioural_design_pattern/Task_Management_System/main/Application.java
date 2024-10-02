package com.companyname.main;

import com.companyname.taskmanagement.chainofresponsibility.*;
import com.companyname.taskmanagement.command.*;
import com.companyname.taskmanagement.models.*;
import com.companyname.utilities.*;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set up Chain of Responsibility
        TaskHandler itHandler = new ITTaskHandler();
        TaskHandler hrHandler = new HRTaskHandler();
        TaskHandler adminHandler = new AdminTaskHandler();

        itHandler.setNextHandler(hrHandler);
        hrHandler.setNextHandler(adminHandler);

        while (true) {
            System.out.println("Enter task name (or type 'exit' to quit):");
            String taskName = scanner.nextLine();

            if ("exit".equalsIgnoreCase(taskName)) {
                Logging.info("Exiting program.");
                break;
            }

            System.out.println("Enter department (IT, HR, Admin):");
            String department = scanner.nextLine();

            try {
                Validation.validateString(taskName, "Task name is required.");
                Validation.validateString(department, "Department is required.");

                Task task = new Task(taskName, department);
                Command assignTaskCommand = new AssignTaskCommand(task, itHandler);
                TaskInvoker taskInvoker = new TaskInvoker(assignTaskCommand);

                taskInvoker.assignTask();
            } catch (IllegalArgumentException e) {
                Logging.error(e.getMessage());
            }
        }

        scanner.close();
    }
}
