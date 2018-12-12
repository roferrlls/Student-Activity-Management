import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class DateGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateGUI window = new DateGUI();
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
	public DateGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDateChooser dateChooser = new JDateChooser();
		frame.getContentPane().add(dateChooser, BorderLayout.NORTH);
		
		JButton Submit = new JButton("Submit");
		frame.getContentPane().add(Submit, BorderLayout.CENTER);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String whole = dateChooser.getDate().toString();				
				String date = whole.substring(24,28);
				String m = null;
				date = date + "-";
				String month = whole.substring(4,7);
				String[] tp = new String[12];
				tp[0] = "Jan";
				tp[1] = "Feb";
				tp[2] = "Mar";
				tp[3] = "Aprr";
				tp[4] = "May";
				tp[5] = "Jun";
				tp[6] = "Jul";
				tp[7] = "Aug";
				tp[8] = "Sep";
				tp[9] = "Oct";
				tp[10] = "Nov";
				tp[11] = "Dec";
				for(int i=0;i<12;i++) {
					if(tp[i].equals(month)) {
						m = Integer.toString(i+1);
					}
				}
				if(m.length() == 1) {
					m = "0" + m;
				}
				date = date + m;
				String day = whole.substring(8,10);
				date = date + "-" + day;
				System.out.println(date);
				
				
			}
		});

		
		
	}

}
