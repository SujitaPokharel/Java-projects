package invData;

public class ProductCntAction { 
   final static public char SHIPMENT = 's';
   final static public char DELIVERY = 'd';
   private char action;
   private int numItems;

   ProductCntAction(char action, int numItems) {
      this.action = action;
	  this.numItems = numItems;
   }

   public boolean isShipment() { return action == SHIPMENT; }
   public boolean isDelivery() { return action == DELIVERY; }
   public int getNumItems() { return numItems; }
}