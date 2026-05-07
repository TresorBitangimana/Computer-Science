package Assignment6;

import java.util.ArrayList;

public class Course<C, S extends Student<?>> {

    private C courseCode;
    private ArrayList<S> students = new ArrayList<>();

    public Course(C courseCode) {
        this.courseCode = courseCode;
    }

    public void addStudent(S Student) {
        students.add(Student);
    }

    public C getCourseCode() {
        return courseCode;
    }

    public ArrayList<S> getStudents() {
        return students;
    }

    public void displayInfo() {
        System.out.println(
                "Couse Code: " + courseCode + "\nStudents" + students.toString());
    }

}