package models;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String className;
    private List<String> students;
    private List<String> assignments;

    public Classroom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public void addStudent(String studentID) {
        if (studentID != null && !studentID.isEmpty()) {
            students.add(studentID);
        } else {
            throw new IllegalArgumentException("Invalid student ID.");
        }
    }

    public List<String> getStudents() {
        return new ArrayList<>(students);
    }

    public void addAssignment(String assignment) {
        if (assignment != null && !assignment.isEmpty()) {
            assignments.add(assignment);
        } else {
            throw new IllegalArgumentException("Assignment details cannot be empty.");
        }
    }

    public List<String> getAssignments() {
        return new ArrayList<>(assignments);
    }
}
