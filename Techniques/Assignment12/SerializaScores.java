package Assignment12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializaScores {
    public static void main(String[] args) {

        TestScore[] testScores = {
                new TestScore(new double[] { 85.0, 90.5, 78.0, 92.0, 88.5 }),
                new TestScore(new double[] { 70.0, 65.5, 80.0, 75.0, 69.5 }),
                new TestScore(new double[] { 100.0, 98.0, 95.5, 97.0, 99.0 }),
                new TestScore(new double[] { 55.0, 60.0, 58.5, 62.0, 57.0 }),
                new TestScore(new double[] { 40.0, 45.5, 50.0, 48.0, 42.5 })
        };

        // Serialize the array to a file
        try (ObjectOutputStream outPutStream = new ObjectOutputStream(
                new FileOutputStream("testscores.ser"))) {

            outPutStream.writeObject(testScores);
            System.out.println("Serialization successful! " + testScores.length
                    + " TestScore objects written to testscores.ser");

        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        // Deserialize the array
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("testscores.ser"))) {

            // Cast the deserialized object back to a TestScore array
            TestScore[] DeserializedTestScores = (TestScore[]) inputStream.readObject();

            System.out.println("Deserialization successful! "
                    + DeserializedTestScores.length + " TestScore objects read from testscores.ser");

            System.out.println("\nDeserialized objects:");
            for (int i = 0; i < DeserializedTestScores.length; i++) {
                System.out.println("  [" + i + "] " + DeserializedTestScores[i]);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("TestScore class not found: " + e.getMessage());
        }

    }
}
