package manager;

import models.Classroom;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassroomManager {
    private Map<String, Classroom> classrooms;
    private static final Logger LOGGER = Logger.getLogger(ClassroomManager.class.getName());

    public ClassroomManager() {
        this.classrooms = new HashMap<>();
    }

    public void addClassroom(String className) {
        if (className != null && !className.isEmpty()) {
            if (!classrooms.containsKey(className)) {
                classrooms.put(className, new Classroom(className));
                LOGGER.info("Classroom " + className + " has been created.");
            } else {
                LOGGER.warning("Classroom " + className + " already exists.");
            }
        } else {
            throw new IllegalArgumentException("Class name cannot be null or empty.");
        }
    }

    public Classroom getClassroom(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            LOGGER.warning("Classroom " + className + " does not exist.");
            throw new IllegalArgumentException("Classroom not found.");
        }
        return classroom;
    }

    public void listClassrooms() {
        LOGGER.info("Listing all classrooms: " + classrooms.keySet());
    }
}
