package hk.ust.comp3021;

import java.util.ArrayList;

public class CommonCoreCourse extends Course {
    private boolean isHonorsCourse;

    //self defined constructor
    public CommonCoreCourse(String courseCode,String department, boolean isHonorsCourse){
        super.courseCode = courseCode;
        super.department = department;
        super.capacity = INITIAL_CAPACITY;
        super.enrolledStudents = new ArrayList<>();
        super.waitlist = new ArrayList<>();
        this.isHonorsCourse = isHonorsCourse;


    }

    @Override
    public boolean enrollmentCriteria(Student s){
        return true; //implemented later
    }

    @Override
    public void enrollWithCondition(Student student) throws CourseFullException {
        //later defined
    }
}
