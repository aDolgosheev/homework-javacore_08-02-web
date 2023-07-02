import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) throws IOException {
        int port = 8565;

        try (ServerSocket serverSocket = new ServerSocket(port)) { // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            System.out.println("server started");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();  // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.printf("New connection accepted. Port: %d.%n", clientSocket.getPort());
                    out.println("What's your name?");
                    final String name = in.readLine();
                    System.out.println(name);

                    out.println(String.format("Hi, %s, your port is %d. Are you child? (yes / no)", name, clientSocket.getPort()));
                    final String answer = in.readLine();
                    System.out.println(answer);
                    if (answer.equals("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                    } else if (answer.equals("no")) {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                    } else {
                        out.println(String.format("%s! Your answer ir wrong!", name));
                    }
                    final String bye = in.readLine();
                    System.out.println(bye);
                    out.println(bye);
                }
            }
        }
    }
}
