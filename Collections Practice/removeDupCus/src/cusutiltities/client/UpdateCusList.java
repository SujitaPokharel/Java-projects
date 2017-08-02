package cusutiltities.client;

//USING ARRAYLIST

import java.util.*;

import cusutilities.cusdata.*;
import cusutilities.cusdb.*;

/* We have a list of Customers (origCusList).   We have a list of customers who
 have recently ordered (recentOrders).   Some of the customers in recentOrders are
 new customers, some are old.   We want to add the new customers to origCusList and 
 create a new Customer list (mergedList).   There should not be any duplicates in
 mergedList.   Thus if a Customer is in both the origCusList and the recentOrders list,
 then we should find the Customer only once in the merged list (not twice!).
 */
public class UpdateCusList {

	public static void main(String[] args) {
		ArrayList<Customer> origCusList;
		ArrayList<Customer> recentOrders;
		ArrayList<Customer> mergedList;

		origCusList = CustomerDb.readOrigList();
		recentOrders = CustomerDb.readRecentOrderList();

		mergedList = mergeCusLists(origCusList, recentOrders);
		printList(mergedList);
	}

	public static ArrayList<Customer> mergeCusLists(ArrayList<Customer> origCusList, ArrayList<Customer> recCusList) {
		ArrayList<Customer> mergedList;
		Iterator<Customer> cusIterator;
		Customer cus;

		mergedList = new ArrayList<Customer>();

		cusIterator = origCusList.iterator();
		while (cusIterator.hasNext()) {
			cus = cusIterator.next();
			mergedList.add(cus);
		}

		cusIterator = recCusList.iterator();
		while (cusIterator.hasNext()) {
			cus = cusIterator.next();
			if (!mergedList.contains(cus)) {
				mergedList.add(cus);

			}

		}

		return mergedList;
	}

	public static void printList(ArrayList<Customer> cusList) {
		Iterator<Customer> cusIterator;
		Customer cus;

		System.out.println("*** Merged Customer List ***");
		cusIterator = cusList.iterator();
		while (cusIterator.hasNext()) {
			cus = cusIterator.next();
			cus.print();
		}

		System.out.println("*** End List ***");
	}

}
