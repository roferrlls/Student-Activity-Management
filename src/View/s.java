package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;

public class s {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					s window = new s();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public s() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
//		internalFrame.setBounds(144, 52, 224, 147);
//		frame.getContentPane().add(internalFrame);
//		internalFrame.setVisible(true);
//		JImageComponent ic = new JImageComponent("/home/tirth/root-2017-1.jpg");
		
		
		JFrame frame = new JFrame();
		frame.add(new JLabel(new ImageIcon("/home/tirth/root-2017-1.jpg")));
		
	}
}
