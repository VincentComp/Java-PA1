package hk.ust.comp3021;

import java.util.List;

public class Student {
    private String StudentID;
    private String Department;
    private int YearOfStudy;
    private double CGA;
    private List<String> Preferences;
    private List<String> CompletedCourses;

    //Self defined constructor
    public Student(String studentID, String department, int yearOfStudy, double CGA, List<String> preferences, List<String> completedCourses) {
        StudentID = studentID;
        Department = department;
        YearOfStudy = yearOfStudy;
        this.CGA = CGA;
        Preferences = preferences;
        CompletedCourses = completedCourses;
    }

    //Selft defined accessor
    public List<String> getPreferences() {
        return Preferences;
    }

    //Selft defined accessor

    public String getStudentID() {
        return StudentID;
    }
}