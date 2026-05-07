package Assignment8;

/**
 * This class stores data about an instructor.
 */

public class Instructor {
   private String name; // Name
   private String officeNumber; // Office number

   /**
    * This constructor initializes the fields.
    * 
    * @param n      The instructor's name.
    * @param office The office number.
    */

   public Instructor(String n, String office) {
      name = n;
      officeNumber = office;
   }

   /**
    * The copy constructor initializes the object
    * as a copy of another Instructor object.
    * 
    * @param object2 The object to copy.
    */

   public Instructor(Instructor object2) {
      name = object2.name;
      officeNumber = object2.officeNumber;
   }

   /**
    * getName method returns the instructor's name.
    * 
    * @return The name field.
    */

   public String getName() {
      return name;
   }

   /**
    * getOfficeNumber returns the instructor's office number.
    * 
    * @return The instructor's office number.
    */

   public String getOfficeNumber() {
      return officeNumber;
   }

   /**
    * toString method
    * 
    * @return A string with the instructor
    *         information.
    */

   public String toString() {
      // Create a string representing the object.
      String str = "Name: " + name + "\nOffice Number: " +
            officeNumber;

      // Return the string.
      return str;
   }

   public boolean equals(Instructor instructor) {
      return name.equals(instructor.getName()) && officeNumber.equals(instructor.getOfficeNumber());
   }

   public int getHashCode() {
      return name.hashCode() + officeNumber.hashCode();
   }

}