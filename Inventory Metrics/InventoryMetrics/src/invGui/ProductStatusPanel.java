package invGui;
import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import invData.*;

// Our View which is an Observer
public class ProductStatusPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private JLabel prodCntLabel, lastActionLabel;
	private ProductCnt prodCnt;
	private String cntTitle;

	public ProductStatusPanel(ProductCnt counter) {
		prodCnt = counter;
		prodCnt.addObserver(this);
		setLayout(new GridLayout(2, 1));

		cntTitle = prodCnt.getName() + " In Stock: ";
		prodCntLabel = new JLabel(cntTitle + prodCnt.getNumItems(),
				JLabel.CENTER);
		add(prodCntLabel);

		lastActionLabel = new JLabel(" ", JLabel.CENTER);
		add(lastActionLabel);
	}

	public void update(Observable obs, Object actionObj) {
		ProductCntAction action;
		if (obs == prodCnt) {
			// This is the observable guy we are interested in
			updateCnt();
			action = (ProductCntAction) actionObj;
			updateLastAction(action);
		}
	}

	private void updateCnt() {
		prodCntLabel.setText(cntTitle + prodCnt.getNumItems());
	}

	private void updateLastAction(ProductCntAction action) {
		if (action.isDelivery()) {
			lastActionLabel.setText(action.getNumItems()
					+ " products delivered");
		} else {
			lastActionLabel.setText(action.getNumItems() + " products shipped");
		}
	}
}