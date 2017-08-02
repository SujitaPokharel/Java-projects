package invData;
import java.util.Observable;

public class ProductCnt extends Observable { 
   private String name;
   private int numItems;
   private int baseLine;

   public ProductCnt(String name, int numItems) {
      this.name = name;
      this.numItems = numItems;
   }

   public String getName() { return name; }
   public int getNumItems() { return numItems; }

   public int getBaseLine() { return baseLine; }
   public void setBaseLine(int newBaseLine) { 
       baseLine = newBaseLine;
   }

   public void addProducts(int numProds) { 
      ProductCntAction action;

      numItems = numItems + numProds;
      action = new ProductCntAction(ProductCntAction.DELIVERY, numProds);
      setChanged();
      notifyObservers(action);
   }

   public void removeProducts(int numProds) { 
      ProductCntAction action;

      numItems = numItems - numProds;
      action = new ProductCntAction(ProductCntAction.SHIPMENT, numProds);
      setChanged();
      notifyObservers(action);
   }
}