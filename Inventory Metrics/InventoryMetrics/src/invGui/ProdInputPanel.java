package invGui;
import invData.ProductCnt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Data Gatherer on Product shipments and deliveries -- part of the Controller
public class ProdInputPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel deliveryLbl = new JLabel("Delivery: ");
	private JLabel shipmentLbl = new JLabel("Shipment: ");
	private JTextField deliveryTxt = new JTextField(5);
	private JTextField shipmentTxt = new JTextField(5);
	private ProductCnt prodCnt;

	public ProdInputPanel(ProductCnt prodCnt) {
		this.prodCnt = prodCnt;
		add(deliveryLbl);
		add(deliveryTxt);
		deliveryTxt.addActionListener(this);
		add(shipmentLbl);
		add(shipmentTxt);
		shipmentTxt.addActionListener(this);
	}

	private void shipProduct() {
		String numItemsStr = shipmentTxt.getText();
		prodCnt.removeProducts(Integer.parseInt(numItemsStr));
	}

	private void deliverProduct() {
		String numItemsStr = deliveryTxt.getText();
		prodCnt.addProducts(Integer.parseInt(numItemsStr));
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == deliveryTxt) {
			deliverProduct();
			deliveryTxt.setText("");
		} else if (event.getSource() == shipmentTxt) {
			shipProduct();
			shipmentTxt.setText("");
		}
	}

}