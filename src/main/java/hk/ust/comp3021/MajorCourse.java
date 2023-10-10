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

        //if(s.getCompletedCourses().indexOf(courseCode) != -1) //Studies before -> also return false
        //    return false;

        for(String this_prerequisites : Prerequisites){ //[has pre && not find in completed course] -> false
            if((!this_prerequisites.equals("")) && (s.getCompletedCourses().indexOf(this_prerequisites) == -1) ){
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
