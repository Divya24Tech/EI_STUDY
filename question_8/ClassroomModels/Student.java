package models;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Student {
    private String studentID;
    private List<Assignment> assignments;
    private static final Logger LOGGER = Logger.getLogger(Student.class.getName());

    public Student(String studentID) {
        if (studentID == null || studentID.isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        }
        this.studentID = studentID;
        this.assignments = new ArrayList<>();
        LOGGER.info("Student " + studentID + " created.");
    }

    public String getStudentID() {
        return studentID;
    }

    public List<Assignment> getAssignments() {
        return new ArrayList<>(assignments);
    }

    public void addAssignment(Assignment assignment) {
        if (assignment != null) {
            assignments.add(assignment);
            LOGGER.info("Assignment added for Student " + studentID);
        } else {
            throw new IllegalArgumentException("Cannot add null assignment.");
        }
    }

    public void submitAssignment(String assignmentDetails) {
        for (Assignment assignment : assignments) {
            if (assignment.getDetails().equals(assignmentDetails) && !assignment.isSubmitted()) {
                assignment.submit();
                LOGGER.info("Assignment with details \"" + assignmentDetails + "\" submitted by Student " + studentID);
                return;
            }
        }
        LOGGER.warning("Assignment not found or already submitted by Student " + studentID);
    }
}
