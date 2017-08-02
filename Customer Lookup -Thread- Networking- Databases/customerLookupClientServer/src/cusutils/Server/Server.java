package cusutils.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]){
		Socket socket = null;
		ServerSocket serverSocket = null;
		
		AdditionThread addThread = null;

		try {
			serverSocket = new ServerSocket(8000);
			System.out.println("Server is starting ...");
		} catch (Exception ex) {

			System.out.println("Unable to start server");
			System.out.println(ex.getMessage());
			System.exit(1);
		}

		try {
			while (true) {
				
				socket = serverSocket.accept();
				addThread = new AdditionThread(socket);
				addThread.start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Unable to open I/O stream to client");
			System.exit(1);
		}
	}

}
