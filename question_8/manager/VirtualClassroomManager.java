package manager;

import models.Classroom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VirtualClassroomManager {
    private ClassroomManager classroomManager;
    private static final Logger LOGGER = Logger.getLogger(VirtualClassroomManager.class.getName());
    private boolean isRunning;

    public VirtualClassroomManager() {
        classroomManager = new ClassroomManager();
        isRunning = true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            try {
                LOGGER.info("Enter command: ");
                String command = scanner.nextLine();
                String[] tokens = command.split(" ", 3);
                processCommand(tokens);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error processing command: " + e.getMessage(), e);
            }
        }
    }

    private void processCommand(String[] tokens) {
        switch (tokens[0]) {
            case "add_classroom":
                classroomManager.addClassroom(tokens[1]);
                break;
            case "list_classrooms":
                classroomManager.listClassrooms();
                break;
            default:
                LOGGER.warning("Unknown command.");
        }
    }

    public void stop() {
        LOGGER.info("Shutting down Virtual Classroom Manager...");
        isRunning = false;
    }
}
