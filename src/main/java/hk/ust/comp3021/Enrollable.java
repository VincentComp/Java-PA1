package hk.ust.comp3021;

//Shall we define the CourseFullException ???
class CourseFullException extends Exception{ }

public interface Enrollable {
    void enrollWithCondition(Student student) throws CourseFullException;
}
