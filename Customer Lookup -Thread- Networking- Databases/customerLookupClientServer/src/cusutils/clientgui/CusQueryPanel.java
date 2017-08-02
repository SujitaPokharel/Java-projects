package cusutils.clientgui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cusutils.cusData.Name;
import cusutils.cusData.PhoneNum;

public class CusQueryPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
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

	public CusQueryPanel() {
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

	public void actionPerformed(ActionEvent evt) {
		JButton sourceBtn;
		String lastName, firstName;
		lastName = lastNameTxtField.getText();
		firstName = firstNameTxtField.getText();
		Name cusName = new Name(lastName, firstName);
		
		sourceBtn = (JButton) evt.getSource();
		// Request a connection initiation
		try {

			if (sourceBtn == phoneSearchBtn){
				String areaCodeStr = areaCodeTxtField.getText();
				int areaCode = Integer.parseInt(areaCodeStr);
				String localNum = localNumTxtField.getText();
				PhoneNum phone = new PhoneNum(areaCode, localNum);
				Client.getConnection(phone);
			}

			if (sourceBtn == nameSearchBtn)
				Client.getConnection(cusName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
