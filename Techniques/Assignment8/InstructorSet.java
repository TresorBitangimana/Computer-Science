package Assignment8;

import java.util.HashSet;

public class InstructorSet {

    private HashSet<Instructor> set = new HashSet<>();

    public void addInstructor(Instructor i) {
        set.add(i);
    }

    public void display() {
        for (Instructor i : set) {
            System.out.println(i);
        }
    }

    public void search(Instructor i) {
        if (set.contains(i)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
