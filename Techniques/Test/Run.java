package Test;

public class Run {
    public static void main(String[] args) throws InterruptedException {

        // creates a class that runs in the background.
        Thread loop = new Loop();

        loop.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Interuption");
            Thread.sleep(500);
        }

    }
}
