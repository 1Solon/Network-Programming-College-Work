import java.io.*;
import java.net.*;
import java.util.*;

class Client {
    
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 3000)) {
            
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            Scanner scanner = new Scanner(System.in);
            String line = null;
  
            while (!"close".equalsIgnoreCase(line)) {
                line = scanner.nextLine();

                output.println(line);
                output.flush();
  
                System.out.println("Server has replied: " + input.readLine());
            }
            scanner.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}