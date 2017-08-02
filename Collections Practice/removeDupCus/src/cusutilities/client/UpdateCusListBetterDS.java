package cusutilities.client;

import java.util.*;
import java.util.Map.Entry;

import cusutilities.cusdata.*;
import cusutilities.cusdb.*; // For testing purposes only

/* We have a list of Customers (origCusList).   We have a list of customers who
 have recently ordered (recentOrders).   Some of the customers in recentOrders are
 new customers, some are old.   We want to add the new customers to origCusList and 
 create a new Customer list (mergedList).   There should not be any duplicates in
 mergedList.   Thus if a Customer is in both the origCusList and the recentOrders list,
 then we should find the Customer only once in the merged list (not twice!).
 */

public class UpdateCusListBetterDS {

	public static void main(String[] args) {
		ArrayList<Customer> origCusList;
		ArrayList<Customer> recentOrders;

		origCusList = CustomerDb.readOrigList();
		recentOrders = CustomerDb.readRecentOrderList();

		HashMap<PhoneNum, Customer> mergedList = new HashMap<PhoneNum, Customer>();
		for (Customer customer : origCusList)
			mergedList.put(customer.getPhone(), customer);
		for (Customer customer : recentOrders)
			mergedList.put(customer.getPhone(), customer);

		printList(mergedList);
	}

	public static void printList(HashMap<PhoneNum, Customer> cusList) {
		Iterator cusIterator = cusList.entrySet().iterator();

		System.out.println("*** Merged Customer List ***");
		while (cusIterator.hasNext()) {
			Map.Entry<PhoneNum, Customer> cus = (Entry<PhoneNum, Customer>) cusIterator.next();
			System.out.println(cus.getValue().toString());
		}

		System.out.println("*** End List ***");
	}

}
