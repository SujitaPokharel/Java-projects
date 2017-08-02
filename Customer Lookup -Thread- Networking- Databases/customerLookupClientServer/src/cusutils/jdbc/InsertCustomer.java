package cusutils.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import cusutils.cusData.Customer;
import cusutils.cusData.PhoneNum;

public class InsertCustomer {

	public static void main(String[] args) {

		CustomerDb.initialize();
		ArrayList<Customer> cusList = CustomerDb.cusList;

		for (Customer customer : cusList) {
			String customerPhone = changePhone(customer.getPhone());
			try {
				CustomerInfo.insertCustomer(customer.getName().getLastName(), customer.getName().getFirstName(), customerPhone);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	private static String changePhone(PhoneNum phoneNum) {

		int areaCode = phoneNum.getAreaCode();
		String localNum = phoneNum.getLocalNum();
		if (areaCode != 0 && !localNum.isEmpty())
			return areaCode + localNum.replaceAll("-", "");

		return null;
	}
}
