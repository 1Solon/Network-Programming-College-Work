import java.io.*;
import java.net.*;

class Server {
	public static void main(String[] args) {
		ServerSocket server = null;

		try {
			server = new ServerSocket(3000);
			server.setReuseAddress(true);

			while (true) {
				Socket client = server.accept();

				System.out.println("Client Connected: "+ client.getInetAddress().getHostAddress());

				HandleClient clientSock= new HandleClient(client);

				new Thread(clientSock).start();
			}
		}
		catch (IOException e) {
			e.printStackTrace(); 
		}
		finally {
			if (server != null) {
				try {
					server.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static class HandleClient implements Runnable {
		private final Socket clientSocket;

		public HandleClient(Socket socket) {this.clientSocket = socket;}

		public void run() {
			PrintWriter out = null;
			BufferedReader in = null;

			try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);

				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				String line;
				while ((line = in.readLine()) != null) {
					System.out.printf(" Client sent: %s\n",line);
					out.println(line);
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (out != null) {
						out.close();
					}
					if (in != null) {
						in.close();
						clientSocket.close();
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

