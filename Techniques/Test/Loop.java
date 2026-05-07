package Test;

public class Loop extends Thread {

    public Loop() {
    }

    public void run() {

        int count = 0;
        while (true) {
            System.out.println("count: " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }

    }
}
