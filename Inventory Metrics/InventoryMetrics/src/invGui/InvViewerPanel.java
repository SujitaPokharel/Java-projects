package invGui;
import java.awt.*;
import javax.swing.*;
import invData.*
;

// Top-Level Controller
public class InvViewerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ProdInputPanel prodInput;
	private ProductStatusPanel prodStatus;

	public InvViewerPanel(ProductCnt prodCnt) {
		setLayout(new BorderLayout());
		prodInput = new ProdInputPanel(prodCnt);
		add(prodInput, "North");
		prodStatus = new ProductStatusPanel(prodCnt);
		add(prodStatus, "Center");
	}

}