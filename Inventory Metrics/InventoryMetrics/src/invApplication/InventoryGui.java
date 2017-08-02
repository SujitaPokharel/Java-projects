package invApplication;
import invData.ProductCnt;
import invGui.BaseFrame;
import invGui.InvMetricsPanel;
import invGui.InvViewerPanel;

public class InventoryGui {

    public static void main(String args[]) {
       ProductCnt prodCnt;
       InvViewerPanel invPanel;
       InvMetricsPanel metricsPanel;
       BaseFrame invFrame, metricsFrame;
      
       //  Instantiate our data structure
       //  Normally we would read it in from a file or database.  For testing, just hardcode it.
       prodCnt = new ProductCnt("Toasters", 5);
       prodCnt.setBaseLine(20);

       /*  Our first window shows the current inventory  */
       invPanel = new InvViewerPanel(prodCnt);
       invFrame = new BaseFrame(invPanel, "Product In Stock");
       invFrame.setVisible(true);
       
       /*  Our second window shows some interesting metrics about our inventory  */
       metricsPanel = new InvMetricsPanel(prodCnt);
       metricsFrame = new BaseFrame(metricsPanel, "Inventory Metrics");
       metricsFrame.setVisible(true);
   }

}
