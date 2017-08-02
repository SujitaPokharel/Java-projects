package cusutils.clientgui;
import java.awt.*;
import javax.swing.*;
import java.util.*;

import cusutils.cusData.*;
import cusutils.cusDb.*;  // for testing purposes only


public class CustomerQueryGui {
    static ArrayList<Customer> cusList;

    public static void main(String[] args){
         JFrame topFrame;
         CusQueryPanel queryPanel;

         /*  Instantiate the Collections */
         cusList = new ArrayList<Customer>();

         /* Read in and build the data structure */
         buildDataStructure();
         queryPanel = new CusQueryPanel(cusList);

         /* Set up the JFrame */
         topFrame = new JFrame();
         topFrame.setSize(600,200);
         topFrame.setTitle("Customer Lookup");
         topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         topFrame.add(queryPanel);
         topFrame.setVisible(true);
    }


    private static void buildDataStructure() {
         int numCus, i;
         Customer cus;

         CustomerDb.initialize();

         numCus = CustomerDb.customerCnt();
         for (i=0; i<numCus; i++) {
             cus = CustomerDb.readCus(i);
             cusList.add(cus);
         }
         
    }

}

