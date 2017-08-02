package cusutils.jdbc;
import cusutils.cusData.*;
import java.util.*;


public class CustomerDb {
    static ArrayList<Customer> cusList;

    public static int customerCnt() {
         return cusList.size();
    }

    public static Customer readCus(int idx) {
        return cusList.get(idx);
    }


    public static void initialize() {
         Customer cus;
         PhoneNum phone;
         Name name;

         cusList = new ArrayList<Customer>();

         phone = new PhoneNum(437, "225-6590");
         name = new Name("Jackson", "Sean");
         cus = new Customer(name, phone);
         cusList.add(cus);

         phone = new PhoneNum(408, "123-4567");
         name = new Name("Watson", "John");
         cus = new Customer(name, phone);
         cusList.add(cus);

         /* duplicate of John Watson name */
         phone = new PhoneNum(215, "678-4567");
         name = new Name("Watson", "John");
         cus = new Customer(name, phone);
         cusList.add(cus);

         /* duplicate of John Watson name */
         phone = new PhoneNum(621, "299-4353");
         cus = new Customer(name, phone);
         cusList.add(cus);

         /* duplicate of John Watson name */
         phone = new PhoneNum(436, "875-1892");
         name = new Name("Watson", "John");
         cus = new Customer(name, phone);
         cusList.add(cus);

         phone = new PhoneNum(615, "234-7961");
         name = new Name("Walters", "Susan");
         cus = new Customer(name, phone);
         cusList.add(cus);

         phone = new PhoneNum(423, "873-2479");
         name = new Name("Wu", "Willam");
         cus = new Customer(name, phone);
         cusList.add(cus);

         phone = new PhoneNum(158, "809-1682");
         name = new Name("Alders", "Julia");
         cus = new Customer(name, phone);
         cusList.add(cus);

         /* Duplicate of Julia Alders  */
         phone = new PhoneNum(569, "109-9925");
         name = new Name("Alders", "Julia");
         cus = new Customer(name, phone);
         cusList.add(cus);
    }

}

