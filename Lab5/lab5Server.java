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


        String clientOutput = in.readLine();

        String[] clientCommands = clientOutput.split(":");
        
        switch (clientCommands[0]) {
            case "1":
            int a = a.parseInt(clientCommands[2]));
            out.println(a+b);
                break;
    
            case "2":
                break;
    
            case "3":
                break;
    
            case "0":
                break;
    
            }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        lab5Server server=new lab5Server();
        server.start(6666);
    }
}