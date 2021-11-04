import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class lab5Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        int a;
        int b;

        while (true) {
            out.println("What do you want to do?");

            String opt = "";
            while ((opt = in.readLine()) != null){}

            switch (opt) {
            case "1":
                out.println("What is the first number?");
                a = Integer.parseInt(in.readLine());
                out.println("What is the second number?");
                b = Integer.parseInt(in.readLine());
                out.println(a + " + " + b + " = " + (a + b));
                break;

            case "2":
                out.println("What number would you like to squareroot?");
                out.println(Math.sqrt(Integer.parseInt(in.readLine())));
                break;

            case "3":
                out.println("What is the base?:");
                a = Integer.parseInt(in.readLine());
                out.println("What is the exponent?:");
                b = Integer.parseInt(in.readLine());
                out.println(a + "^" + b + " is " + Math.pow(a, b));
                break;

            case "0":
                out.println("Goodbye!");
                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
                System.exit(0);

            default:
                out.println("Something wrong has happened here!");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        lab5Server server = new lab5Server();
        server.start(6666);
    }
}