import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class lab5Client {

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 6666);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter call = new PrintWriter(clientSocket.getOutputStream(), true);

        while (true){
            call.println();
            System.out.println(response.readLine());
        }
    }
}
