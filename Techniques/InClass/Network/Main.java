package InClass.Network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {

        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

        // System.out.println(Arrays.toString(args));

        System.out.println(serverName);
        System.out.println(port);

        try (Socket client = new Socket(serverName, port)) {

            System.out.println(client.getLocalPort());

        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
