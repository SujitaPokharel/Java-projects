package cusutils.clientgui;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import cusutils.cusData.Customer;
import cusutils.cusData.PhoneNum;
  // for testing purposes only


public class CustomerQueryGui {
    static Map<PhoneNum, Customer> cusList;

    public static void main(String[] args) {
	/*public CustomerQueryGui(){*/
         JFrame topFrame;
         CusQueryPanel queryPanel;

         /*  Instantiate the Collections */
         cusList = new HashMap<PhoneNum, Customer>();

         queryPanel = new CusQueryPanel(/*cusList*/);

         /* Set up the JFrame */
         topFrame = new JFrame();
         topFrame.setSize(600,200);
         topFrame.setTitle("Customer Lookup");
         topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         topFrame.add(queryPanel);
         topFrame.setVisible(true);
    }

}

