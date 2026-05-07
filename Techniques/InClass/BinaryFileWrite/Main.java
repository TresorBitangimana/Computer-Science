package InClass.BinaryFileWrite;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try (FileOutputStream outPutStream = new FileOutputStream("InClass/Test.txt")) {
            DataOutputStream dataOutput = new DataOutputStream(outPutStream);

            int randNum = 0;

            for (int i = 0; i < 100; i++) {
                randNum = (int) (Math.random() * 2);
                dataOutput.write(randNum);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        // try (FileInputStream inpuStream = new FileInputStream("InClass/Test.txt")) {
        // DataInputStream dataInputStream = new DataInputStream(inpuStream);

        // while (dataInputStream.available() > 0) {
        // System.out.println(dataInputStream.readInt());
        // dataInputStream.read();
        // }

        // } catch (FileNotFoundException e) {
        // System.out.println(e);
        // } catch (IOException e) {
        // System.out.println(e);
        // }

        // try {
        // RandomAccessFile randomFile = new RandomAccessFile("InClass/Test.txt", "rw");
        // for (int i = 0; i < 100; i++) {
        // randomFile.write((int) (Math.random() * 101));
        // }
        // randomFile.close();
        // } catch (FileNotFoundException e) {
        // System.out.println(e);
        // } catch (IOException e) {
        // System.out.println(e);
        // }

        // try (Scanner scanner = new Scanner(new Readable("InClass/Test.txt"))) {

        // while (scanner.hasNext()) {
        // System.out.println(scanner.next());
        // }

        // } catch (FileNotFoundException e) {
        // System.out.println(e);
        // }

    }
}
