package invGui;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import invData.*;

/**
 * Display important inventory metrics. Keep track of: 1. The average
 * transaction size. This value is zero when the application starts up. After
 * every shipment or delivery, the average should be updated. 2. Baseline
 * indicator -- either red (inventory is out of expected range) or green
 * (inventory is within expected range).
 */
public class InvMetricsPanel extends JPanel implements Observer {// implements
																	// Observer
																	// Change
	private static final long serialVersionUID = 1L;
	private JTextField avgTransTxtField = new JTextField(5);
	private JLabel avgTransLbl = new JLabel("Average Transaction Size: ");

	private JTextField baseLineTxtField = new JTextField(5);
	private JLabel baseLineDiffLbl = new JLabel("Distance From Baseline: ");
	private JTextField baseLineColorIndicator = new JTextField(3);

	private JPanel avgTransPanel = new JPanel();
	private JPanel baseLinePanel = new JPanel();
	private JPanel topPanel = new JPanel();
	private GridLayout topLayoutMgr = new GridLayout(2, 1);
	private static final int VERTICAL_SPACING = 20;

	private final double RED_BASELINE = .25;
	int sum;
	private ProductCnt prodCnt;

	public InvMetricsPanel(ProductCnt prodData) {
		prodCnt = prodData;
		sum = prodCnt.getNumItems();// initially it is 5
		prodCnt.getName();
		/* Configure our top level panel */
		// Change
		prodCnt.addObserver(this);// adding observer to inform all the object
									// about action
		topLayoutMgr.setVgap(VERTICAL_SPACING);
		topPanel.setLayout(topLayoutMgr);
		add(topPanel);

		avgTransTxtField.setEditable(false);
		avgTransTxtField.setHorizontalAlignment(JTextField.RIGHT);
		avgTransTxtField.setText("0");
		avgTransPanel.add(avgTransLbl);
		avgTransPanel.add(avgTransTxtField);
		topPanel.add(avgTransPanel);

		baseLineTxtField.setEditable(false);
		baseLinePanel.add(baseLineDiffLbl);
		baseLinePanel.add(baseLineTxtField);
		baseLineColorIndicator.setEditable(false);
		baseLineColorIndicator.setBackground(Color.GREEN);
		baseLinePanel.add(baseLineColorIndicator);
		topPanel.add(baseLinePanel);
	}

	int numberOfTransaction = 0;
	int oldNumItems = 5;
	int newNumItems = 0;
	double average = 0.0;

	// Change in the code to update InvMetricsPanel functionality

	@Override
	public void update(Observable obs, Object actionObj) {

		/*
		 * Configure the "Average Transaction Size" panel and then add it to the
		 * top panel
		 */
		newNumItems = Math.abs(prodCnt.getNumItems() - oldNumItems);
		oldNumItems = prodCnt.getNumItems();
		double runningAverage = ((average * numberOfTransaction) + newNumItems) / (numberOfTransaction + 1);
		average = runningAverage;

		numberOfTransaction++;
		avgTransTxtField.setText(String.valueOf(runningAverage));

		/*
		 * Configure the "Baseline Information" panel and then add it to the top
		 * panel
		 */
		int distanceFromBaseLine = Math.abs(prodCnt.getBaseLine() - prodCnt.getNumItems());
		baseLineTxtField.setText(String.valueOf(distanceFromBaseLine));

		/*
		 * Baseline is green if inventory is within 25% of the product's
		 * baseline. If the current inventory is off by more than 25% from the
		 * baseline, the indicator should change to red.
		 */
		double baseLineRange = (prodCnt.getNumItems() * 1.0 / prodCnt.getBaseLine());
		System.out.println("baseLineRange" + baseLineRange);
		baseLineRange = Math.abs(1 - baseLineRange);

		if (obs == prodCnt) {
			if (baseLineRange > RED_BASELINE)
				baseLineColorIndicator.setBackground(Color.RED);
			else
				baseLineColorIndicator.setBackground(Color.GREEN);
		}
	}

}
