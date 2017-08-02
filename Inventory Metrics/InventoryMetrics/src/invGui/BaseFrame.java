package invGui;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaseFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public BaseFrame(JPanel topPanel, String title) {
		Container topContainer = getContentPane();

		WindowListener exitListener = new FrameTerminator();
		addWindowListener(exitListener);
		setTitle(title);
		setSize(500, 200);
		topContainer.add(topPanel);
	}

	class FrameTerminator extends WindowAdapter {
		public void windowClosing(WindowEvent event) {
			System.exit(0);
		}
	}

}