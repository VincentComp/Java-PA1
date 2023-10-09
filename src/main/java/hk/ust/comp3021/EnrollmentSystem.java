package hk.ust.comp3021;

import java.io.*;
import java.util.*;

public class EnrollmentSystem {
    public List<Student> students;
    public Map<String, Course> courses;

    public EnrollmentSystem() {
        this.students = new ArrayList<>();
        this.courses = new HashMap<>();
    }

    /**
     * TODO: Part 1
     * The first two choices in students' preferences must be enrolled,
     * regardless of course capacity or prerequisites.
     * The course capacity, initially sets at 10, expands if necessary
     * to accommodate these guaranteed choices.
     */
    public void enrollFirstRound() {
    }

    /**
     * TODO: Part 2
     * Task 3: All third choices from preferences will be processed first,
     * followed by fourth choices, and so on until the last preference.
     * The task 3 has higher priority than task 4. 
     * Task 4: MajorCourses prioritize students with the same major. 
     * Other than that, the courses will be filled in the ascending order 
     * of StudentID, which you can assume is the default order in the input. 
     * HINT: Make two lists of students to screen out those who both are 
     * enrolling major courses and belong to the same department.
     */
    public void enrollSecondRound() {
    }

    /**
     * TODO: Task 7
     * Find the number of Teaching Assistants (TAs) required, given that
     * 1 TA is needed for every 5 students in a course.
     *
     * @return the number of TAs required
     */
    public int findNumTA() {
    }

    /**
     * TODO: Task 8
     * Find the number of students who successfully enrolled in
     * all their course preferences.
     *
     * @return the number of students
     */
    public int findNumAllSuccess() {
    }

    /**
     * TODO: Task 9
     * Identify the students who have not enrolled in any
     * common core courses.
     *
     * @return the list of StudentID
     */
    public List<String> findListNoCommonCore() {
    }

    public void parseStudents(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // TODO: Task 1
                String studentID = ;
                String department = ;
                int yearOfStudy = ;
                double CGA = ;
                List<String> preferences = ;
                List<String> completedCourses = ;
            }
        }
    }

    public void parseCourses(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // TODO: Task 1
            }
        }
    }

    public void writeCourseEnrollment(String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Course course : courses.values()) {
                bw.write(course.courseCode + ", " + course.capacity + ", [" +
                        String.join(" ", course.enrolledStudents) + "], [" +
                        String.join(" ", course.waitlist) + "]"
                );
                bw.newLine();
            }
        }
    }

    public void writeCourseAnalysis(String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(findNumTA() + ", " + findNumAllSuccess() + ", [" + String.join(" ", findListNoCommonCore()) + "]");
            bw.newLine();
        }
    }

    public static void main(String[] args) {
        EnrollmentSystem system = new EnrollmentSystem();

        try {
            system.parseStudents("student.txt");
            system.parseCourses("course.txt");
            system.enrollFirstRound();
            system.writeCourseEnrollment("firstRoundEnrollment.txt");
            system.enrollSecondRound();
            system.writeCourseEnrollment("secondRoundEnrollment.txt");
            system.writeCourseAnalysis("dataAnalytics.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
