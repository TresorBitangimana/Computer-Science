package Assignment8;

public class InstructorTest {
    public static void main(String[] args) {

        // creates instances of instructors
        Instructor instructor1 = new Instructor("josh", "A1231");
        Instructor instructor2 = new Instructor("joy", "A1232");
        Instructor instructor3 = new Instructor("jody", "A1233");
        Instructor instructor4 = new Instructor("joz", "A1234");
        Instructor instructor5 = new Instructor("joe", "A1235");

        instructor1.equals(instructor2); // conpares instructor1 with isntructor2
        instructor1.getHashCode(); // gets instructor1's hashcode

        InstructorSet instructorSet = new InstructorSet(); // creates an instance of the instructorSet

        // adds the previously made instructors into the instructorsSet
        instructorSet.addInstructor(instructor1);
        instructorSet.addInstructor(instructor2);
        instructorSet.addInstructor(instructor3);
        instructorSet.addInstructor(instructor4);
        instructorSet.addInstructor(instructor5);

        instructorSet.display(); // displays all the instructors

        Instructor instructor6 = new Instructor("josh", "A1231"); // creates a new instructor

        instructorSet.search(instructor1); // searches instructor1 from the instuctorSet
        instructorSet.search(instructor6); // searches instructor6 from the instuctorSet
    }
}
