import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8565;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String resp = in.readLine();
            System.out.println(resp);
            out.println("Aleksandr");
            String resp1 = in.readLine();
            System.out.println(resp1);
            out.println("no");
            final String resp2 = in.readLine();
            System.out.println(resp2);
            out.println("Bye!");
            final String resp3 = in.readLine();
            System.out.println(resp3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
