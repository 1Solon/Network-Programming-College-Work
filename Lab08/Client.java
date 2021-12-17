import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class Client extends JFrame {
	public Client() throws UnknownHostException, SocketException {
		super("Client");
		JLabel label = new JLabel("Server Data will print here");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(label);
		setSize(400, 300);
		setVisible(true);

		try {
			InetAddress address = InetAddress.getByName("test.net");
            DatagramSocket socket = new DatagramSocket();

			while (true) {
				DatagramPacket request = new DatagramPacket(new byte[1], 1, address, 17);
                socket.send(request);
 
                byte[] buffer = new byte[512];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);
 
                String quote = new String(buffer, 0, response.getLength());



				String message = (String) in.readObject();
				label.setText("Message from Server: " + message);

			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static void main(String args[]) {
		Client application = new Client();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
