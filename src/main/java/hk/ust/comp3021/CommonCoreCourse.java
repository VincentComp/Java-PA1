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
        //if(s.getCompletedCourses().indexOf(courseCode) != -1) //Studies before -> also return false
        //    return false;


        if(isHonorsCourse == true){
            if(s.getCGA() < 3.5){
                return false;
            }
        }
        return true;
    }

    @Override
    public void enrollWithCondition(Student student) throws CourseFullException {
        if(capacity == enrolledStudents.size())
            throw new CourseFullException();
    }
}
