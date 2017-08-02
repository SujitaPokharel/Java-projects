package cusutils.clientgui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import cusutils.cusData.*;

public class CusQueryPanel extends JPanel implements ActionListener {
	private JLabel lastNameLbl = new JLabel("Last Name: ");
	private JTextField lastNameTxtField = new JTextField(20);

	private JLabel firstNameLbl = new JLabel("First Name: ");
	private JTextField firstNameTxtField = new JTextField(10);

	private JLabel phoneNumLbl = new JLabel("Phone:  (");
	private JTextField areaCodeTxtField = new JTextField(4);
	private JLabel endAreaCodeLbl = new JLabel(")");
	private JTextField localNumTxtField = new JTextField(10);

	private JButton nameSearchBtn = new JButton("Name Search");
	private JButton phoneSearchBtn = new JButton("Phone Search");

	private JPanel namePanel = new JPanel();
	private JPanel phonePanel = new JPanel();
	private JPanel btnPanel = new JPanel();

	private ArrayList<Customer> cusList;

	public CusQueryPanel(ArrayList<Customer> cusList) {
		this.cusList = cusList;

		setLayout(new GridLayout(3, 1));

		namePanel.add(lastNameLbl);
		namePanel.add(lastNameTxtField);
		namePanel.add(firstNameLbl);
		namePanel.add(firstNameTxtField);
		add(namePanel);

		phonePanel.add(phoneNumLbl);
		phonePanel.add(areaCodeTxtField);
		phonePanel.add(endAreaCodeLbl);
		phonePanel.add(localNumTxtField);
		add(phonePanel);

		phoneSearchBtn.addActionListener(this);
		nameSearchBtn.addActionListener(this);
		btnPanel.add(nameSearchBtn);
		btnPanel.add(phoneSearchBtn);
		add(btnPanel);
	}

	private void printNameMatch() {
		Name cusName;
		Customer cus;
		String lastName, firstName;
		int i, numCus;
		boolean matchFound = false;

		lastName = lastNameTxtField.getText();
		firstName = firstNameTxtField.getText();
		cusName = new Name(lastName, firstName);

		numCus = cusList.size();
		for (i = 0; i < numCus; i++) {
			cus = cusList.get(i);
			/* Does "cus" have the name "cusName"? */
			if (((cusName.getFirstName()).equalsIgnoreCase(cus.getName().getFirstName()))
					&& ((cusName.getFirstName()).equalsIgnoreCase(cus.getName().getFirstName()))) {
				if (!matchFound) {
					System.out.println("\n***** Matches Found For: " + cusName + " *****");
					matchFound = true;
				}
				cus.print();
			}
		}

		if (matchFound) {
			System.out.println("***** End of Match Query *****\n");
		} else {
			System.out.println("No match found for: " + cusName);
		}

		lastNameTxtField.setText("");
		firstNameTxtField.setText("");
	}

	private void printPhoneMatch() {
		Customer cus;
		PhoneNum phone;
		String areaCodeStr, localNum;
		int i, numCus, areaCode, localNumber;
		boolean matchFound = false;

		areaCodeStr = areaCodeTxtField.getText();
		areaCode = Integer.parseInt(areaCodeStr);
		System.out.println("area code is " + areaCode);
		localNum = localNumTxtField.getText();
		System.out.println("Local Num is " + localNum);
		phone = new PhoneNum(areaCode, localNum);

		/* Lookup phone number */
		numCus = cusList.size();
		for (i = 0; i < numCus; i++) {
			cus = cusList.get(i);
			if (((phone.getLocalNum()).equals(cus.getPhone().getLocalNum())) && ((phone.getLocalNum()).equals((cus.getPhone().getLocalNum())))) {
				System.out.println("Match Found: " + cus);
				matchFound = true;
				break;

			}
		}

		if (!matchFound) {
			System.out.println("No customer found with phone number: " + phone);
		} else {
			areaCodeTxtField.setText("");
			localNumTxtField.setText("");
		}
	}

	public void actionPerformed(ActionEvent evt) {
		JButton sourceBtn;

		sourceBtn = (JButton) evt.getSource();
		if (sourceBtn == phoneSearchBtn) {
			printPhoneMatch();
		} else if (sourceBtn == nameSearchBtn) {
			printNameMatch();
		}

	}
}
