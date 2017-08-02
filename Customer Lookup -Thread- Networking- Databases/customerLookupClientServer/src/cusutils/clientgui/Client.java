package cusutils.clientgui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import cusutils.cusData.Customer;

public class Client {
	
	public static void getConnection(Object obj) throws Exception {
		Socket addSocket = null;
		ObjectOutputStream strmToServer = null;
		ObjectInputStream strmFromServer = null;
		final String server = "localhost";

		InetAddress serverAddr = InetAddress.getLocalHost();
		System.out.println(serverAddr.getHostAddress());

		Object returnObject = null;

		try {
			addSocket = new Socket(serverAddr, 8000);
			strmToServer = new ObjectOutputStream(addSocket.getOutputStream());
			strmFromServer = new ObjectInputStream(addSocket.getInputStream());
			System.out.println("Connected to Server ...");

		} catch (UnknownHostException ex) {
			System.out.println("Unable to find server: " + server);
			System.exit(1);
		} catch (IOException ex) {
			System.out.println("Unable to open I/O stream to server clientside : " + server);
			System.out.println(ex.getStackTrace());
			System.exit(1);
		}

		try {
			
			strmToServer.writeObject(obj); // tell server the type of lookup to perform
			
			returnObject = strmFromServer.readObject();
			if(returnObject != null && returnObject instanceof Customer)
				System.out.println(returnObject.toString());
			else if(returnObject != null && returnObject instanceof ArrayList<?>){
				
				ArrayList<Customer> cusList = (ArrayList<Customer>) returnObject;
				if(!cusList.isEmpty())
					for(Customer customer: cusList)
						System.out.println(customer.toString());
				else
					System.out.println("No records found.");
			}else
				System.out.println("No records found.");
						
			strmFromServer.close();
			strmToServer.close();
			addSocket.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
