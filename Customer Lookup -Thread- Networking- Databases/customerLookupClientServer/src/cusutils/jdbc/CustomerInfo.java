package cusutils.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cusutils.cusData.Customer;
import cusutils.cusData.Name;
import cusutils.cusData.PhoneNum;

public class CustomerInfo {
	private static String dbSourceUrl = "jdbc:mysql://localhost/customer_lookup";
	static private Connection cuslookupDbConn;
	static private String userId = "cuslookup_user";
	static private String dbPassword = "coursedb_pswd";

	public static Connection getConnection() throws SQLException {
		if (cuslookupDbConn == null) {
			System.out.println("Starting........");
			cuslookupDbConn = DriverManager.getConnection(dbSourceUrl, userId, dbPassword);
			System.out.println("Connection success.");
		}

		return cuslookupDbConn;
	}

	public static void shutdown() throws SQLException {
		if (cuslookupDbConn != null) {
			cuslookupDbConn.close();
		}
	}

	public static Customer cusPhoneSearch(PhoneNum phoneNumObj) throws SQLException {
		Connection dbConn;
		String queryStr = "SELECT lastName, firstName, phoneNum " + "FROM customer " + "WHERE phoneNum = '" + changePhoneToString(phoneNumObj) + "'";

		dbConn = getConnection();
		Statement queryStmt = dbConn.createStatement();
		ResultSet results;
		Customer customer = null;
		
		results = queryStmt.executeQuery(queryStr);
		while (results.next()) { // process results
			String lastName = results.getString("lastName");
			String firstName = results.getString("firstName");
			String phoneNum = results.getString("phoneNum");
			Name name = new Name(lastName, firstName);
			customer = new Customer(name, changePhoneFromString(phoneNum));
		}

		// Free resources
		results.close();
		queryStmt.close();
		return customer;
	}

	public static ArrayList<Customer> cusNameSearch(Name cusName) throws SQLException {
		Connection dbConn;
		String queryStr = "SELECT lastName, firstName, phoneNum " + "FROM customer " + "WHERE lastName = '" + cusName.getLastName() + "'" + " And firstName = '"
				+ cusName.getFirstName() + "'";

		dbConn = getConnection();
		Statement queryStmt = dbConn.createStatement();
		ResultSet results;
	
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		results = queryStmt.executeQuery(queryStr);
		
		while (results.next()) { // process results
			String resultLastName = results.getString("lastName");
			String resultFirstName = results.getString("firstName");
			String phoneNum = results.getString("phoneNum");
			Name name = new Name(resultLastName, resultFirstName);
			Customer customer = new Customer(name, changePhoneFromString(phoneNum));
			cusList.add(customer);
		}

		// Free resources
		results.close();
		queryStmt.close();
		return cusList;
	}

	public static void insertCustomer(String lastName, String firstName, String phoneNum) throws SQLException {

		Connection dbConn;
		String queryStr = "INSERT INTO Customer (lastName, firstName, phoneNum) values ('" + lastName + "','" + firstName + "','" + phoneNum + "');";

		dbConn = getConnection();
		Statement queryStmt = dbConn.createStatement();

		queryStmt.executeUpdate(queryStr);

		/*
		 * queryStmt.close(); dbConn.close();
		 */

	}

	private static String changePhoneToString(PhoneNum phoneNum) {

		int areaCode = phoneNum.getAreaCode();
		String localNum = phoneNum.getLocalNum();
		if (areaCode != 0 && !localNum.isEmpty())
			return areaCode + localNum.replaceAll("-", "");

		return null;
	}

	private static PhoneNum changePhoneFromString(String phoneNum) {

		PhoneNum phoneNumber = null;
		if (phoneNum != null) {
			StringBuffer phoneNumLocalNum = new StringBuffer();
			String areaCode = phoneNum.substring(0, 3);
			phoneNumLocalNum.append(phoneNum.substring(3, 6));
			phoneNumLocalNum.append("-");
			phoneNumLocalNum.append(phoneNum.substring(6, 10));
			try {
				int areaCodeInt = Integer.parseInt(areaCode);
				String localNum = phoneNumLocalNum.toString();
				phoneNumber = new PhoneNum(areaCodeInt, localNum);
			} catch (NumberFormatException ex) {
				System.out.println("Exception in areaCode");
			}
		}

		return phoneNumber;
	}

}
