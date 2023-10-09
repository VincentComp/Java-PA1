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
        for (Student this_student : students ){
            List<String> Preference = this_student.getPreferences();
            int Num_Preference = Preference.size();


            if(Num_Preference == 0) //Note that some students may have no preference
                continue;

            if (Num_Preference == 1){
                String preference_course1  = this_student.getPreferences().get(0); //get & enrolled course
                courses.get(preference_course1).enroll(this_student);

                //if(courses.get(preference_course1).enrolledStudents.size() > courses.get(preference_course1).capacity) //modify capacity
                //    courses.get(preference_course1).capacity++;
            }
            /*
            if (Num_Preference >= 2){
                String preference_course2  = this_student.getPreferences().get(1);
                courses.get(preference_course2).enrolledStudents.add(studentID);

                if(courses.get(preference_course2).enrolledStudents.size() > courses.get(preference_course2).capacity)
                    courses.get(preference_course2).capacity++;
            }*/


        }
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
        return 0;//later defined
    }

    /**
     * TODO: Task 8
     * Find the number of students who successfully enrolled in
     * all their course preferences.
     *
     * @return the number of students
     */
    public int findNumAllSuccess() {
        return 0;//later defined
    }

    /**
     * TODO: Task 9
     * Identify the students who have not enrolled in any
     * common core courses.
     *
     * @return the list of StudentID
     */
    public List<String> findListNoCommonCore() {
        return new ArrayList<String>(); //later defiend
    }

    public void parseStudents(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // TODO: Task 1
                String[] line_split = line.split(", ");

                String studentID = line_split[0];
                String department = line_split[1];
                int yearOfStudy = Integer.parseInt(line_split[2]); //Note that String cannot directly convert to int
                double CGA = Double.parseDouble(line_split[3]);
                List<String> preferences = Arrays.asList(line_split[4].replaceAll("[\\[\\]]", "").split(", ")); //By ChatGPT : how to cast string with [] into list<string>
                List<String> completedCourses = Arrays.asList(line_split[5].replaceAll("[\\[\\]]", "").split(", ")); //By ChatGPT : how to cast string with [] into list<string>

                students.add(new Student(studentID,department,yearOfStudy,CGA,preferences,completedCourses)); //append the created students to the list
            }
        }
    }

    public void parseCourses(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // TODO: Task 1
                String line_split[] = line.split(", ");

                String keys = line_split[0]; //Map<keys,values>
                String courseCode = line_split[0];
                String department = line_split[1];

                boolean isHonorsCourse;
                List<String> Prerequisites;

                if(line_split[2].equals("CommonCore")){
                    isHonorsCourse = Boolean.parseBoolean(line_split[3]);
                    courses.put(keys,new CommonCoreCourse(courseCode,department,isHonorsCourse));

                }
                else if(line_split[2].equals("Major")){
                    Prerequisites = Arrays.asList(line_split[4].replaceAll("[\\[\\]]", "").split(", ")); //By ChatGPT : how to cast string with [] into list<
                    courses.put(keys,new MajorCourse(courseCode,department,Prerequisites));
                }
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
            //system.writeCourseEnrollment("firstRoundEnrollment.txt");
            //system.enrollSecondRound();
            //system.writeCourseEnrollment("secondRoundEnrollment.txt");
            //system.writeCourseAnalysis("dataAnalytics.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
