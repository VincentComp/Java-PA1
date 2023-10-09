package hk.ust.comp3021;

import java.util.ArrayList;
import java.util.List;

public class MajorCourse extends Course{
    private List<String> Prerequisites;

    //self define constructor
    public MajorCourse(String courseCode,String department, List<String> Prerequisites ){
        super.courseCode = courseCode;
        super.department = department;
        super.capacity = INITIAL_CAPACITY;
        super.enrolledStudents = new ArrayList<>();
        super.waitlist = new ArrayList<>();
        this.Prerequisites = Prerequisites;

    }

    //Self-define accessor


    @Override
    public boolean enrollmentCriteria(Student s){
        return true; //to be implemented
    }

    @Override
    public void enrollWithCondition(Student student) throws CourseFullException {
        //later defined
    }


}
