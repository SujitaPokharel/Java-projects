package cusutils.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import cusutils.cusData.Customer;
import cusutils.cusData.Name;
import cusutils.cusData.PhoneNum;
import cusutils.jdbc.CustomerInfo;

public class AdditionThread extends Thread {

	private Socket socket = null;

	public AdditionThread(Socket socketToClient) {

		socket = socketToClient;
	}

	@Override
	public void run() {
		ObjectOutputStream strmToClient = null;
		ObjectInputStream strmFromClient = null;

		Object clientObject = null;
		Customer clientToObj = null;
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		try {
			System.out.println("Serving client " + socket.getInetAddress());
			strmToClient = new ObjectOutputStream(socket.getOutputStream());
			strmFromClient = new ObjectInputStream(socket.getInputStream());

			try {
				clientObject = strmFromClient.readObject();

			} catch (ClassNotFoundException e) {
				System.out.println("Class not found.........");
			}

			try {
				if (clientObject instanceof PhoneNum){
					clientToObj = CustomerInfo.cusPhoneSearch((PhoneNum) clientObject);
					strmToClient.writeObject(clientToObj);
				}
				if (clientObject instanceof Name){
					cusList = CustomerInfo.cusNameSearch((Name)clientObject);
					strmToClient.writeObject(cusList);
				}
			} catch (SQLException e) {
				System.out.println("Error running SQL for Phone.");
			}

			
			socket.close();
		} catch (IOException ex) {
			System.out.println("Problem getting I/O Streams to client");
		}
	}
}
