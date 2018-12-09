import java.awt.EventQueue;
import java.util.Date;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import java.awt.Color;

public class addActivity {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   PreparedStatement stmt = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addActivity window = new addActivity();
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
	public addActivity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Activity");
		frame.getContentPane().setBackground(new Color(255, 250, 205));
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(Color.LIGHT_GRAY);
		editorPane.setBounds(310, 64, 349, 28);
		frame.getContentPane().add(editorPane);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Serif", Font.PLAIN, 14));

		lblName.setBounds(47, 76, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Serif", Font.PLAIN, 14));

		lblDate.setBounds(48, 122, 208, 28);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(Color.LIGHT_GRAY);
		dateChooser.setBounds(314, 131, 100, 19);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblDateyyyytimeDd = new JLabel("TIME(hh:mm::ss)");
		lblDateyyyytimeDd.setToolTipText("");
		lblDateyyyytimeDd.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDateyyyytimeDd.setBounds(48, 188, 208, 28);
		frame.getContentPane().add(lblDateyyyytimeDd);
		
		
		
		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		timeSpinner.setBackground(Color.LIGHT_GRAY);
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		timeSpinner.setBounds(310, 188, 128, 20);
		frame.getContentPane().add(timeSpinner);
		
		
		JLabel lblVenue = new JLabel("VENUE");
		lblVenue.setFont(new Font("Serif", Font.PLAIN, 14));
		lblVenue.setBounds(47, 248, 70, 15);
		frame.getContentPane().add(lblVenue);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setBackground(Color.LIGHT_GRAY);
		editorPane_3.setBounds(310, 235, 349, 28);
		frame.getContentPane().add(editorPane_3);
		
		JLabel lblExpectedAudience = new JLabel("EXPECTED AUDIENCE");
		lblExpectedAudience.setFont(new Font("Serif", Font.PLAIN, 14));
		lblExpectedAudience.setBounds(47, 302, 173, 15);
		frame.getContentPane().add(lblExpectedAudience);
		
		JEditorPane editorPane_4 = new JEditorPane();
		editorPane_4.setBackground(Color.LIGHT_GRAY);
		editorPane_4.setBounds(310, 296, 181, 21);
		frame.getContentPane().add(editorPane_4);
		
		JLabel lblContactDetails = new JLabel("CONTACT DETAILS");
		lblContactDetails.setFont(new Font("Serif", Font.PLAIN, 14));
		lblContactDetails.setBounds(47, 351, 173, 15);
		frame.getContentPane().add(lblContactDetails);
		
		JEditorPane editorPane_5 = new JEditorPane();
		editorPane_5.setBackground(Color.LIGHT_GRAY);
		editorPane_5.setBounds(310, 345, 181, 21);
		frame.getContentPane().add(editorPane_5);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDescription.setBounds(47, 421, 173, 15);
		frame.getContentPane().add(lblDescription);
		
		JEditorPane editorPane_6 = new JEditorPane();
		editorPane_6.setBackground(Color.LIGHT_GRAY);
		editorPane_6.setBounds(310, 407, 459, 43);
		frame.getContentPane().add(editorPane_6);
		
		JButton btnAddJudge = new JButton("ADD judge");
		btnAddJudge.setBackground(new Color(255, 165, 0));
		btnAddJudge.setBounds(284, 732, 117, 25);
		frame.getContentPane().add(btnAddJudge);
		
		String[] club = {"Quizzinga","LC"};
		JComboBox comboBox = new JComboBox(club);
		comboBox.setBounds(418, 495, 132, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("CLUB");
		lblNewLabel.setBounds(61, 500, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setBounds(61, 570, 117, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		String[] dept = {"CSE","ECE","CCE"};
		JComboBox comboBox_1 = new JComboBox(dept);
		comboBox_1.setBounds(418, 565, 132, 24);
		frame.getContentPane().add(comboBox_1);
		
		JButton Submit = new JButton("SUBMIT");
		Submit.setBackground(new Color(255, 165, 0));
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = editorPane.getText().toString();
				
				// getting date
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
				//System.out.println(date);
				
				
				//getting time
				
				String val=timeSpinner.getValue().toString();
				String time=val.substring(11,19);
				
				
				
				
				//String date =  editorPane_1.getText().toString();
				//String time = editorPane_2.getText().toString();
				String venue = editorPane_3.getText().toString();
				String exaud = editorPane_4.getText().toString();
				String contact = editorPane_5.getText().toString();
				String description = editorPane_6.getText().toString();
				String club = String.valueOf(comboBox.getItemAt(comboBox.getSelectedIndex()));
				String dept = String.valueOf(comboBox_1.getItemAt(comboBox_1.getSelectedIndex()));
				//System.out.print(club + " "+ dept + " " + time + " " + venue + " " + exaud + " " + contact);
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      String query = "insert into Activity (name,time,date,venue,description,Expected_Audience,Contact_Details,Club,Department)" + " values(?,?,?,?,?,?,?,?,?)";
				      stmt = conn.prepareStatement(query);
				      stmt.setString(1, name);
				      stmt.setString(2, time);
				      stmt.setString(3, date);
				      stmt.setString(4, venue);
				      stmt.setString(5, description);
				      stmt.setString(6, exaud);
				      stmt.setString(7,contact);
				      stmt.setString(8, club);
				      stmt.setString(9, dept);
				      stmt.execute();
				      
				      stmt.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
				   }finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            stmt.close();
				      }catch(SQLException se2){
				      }// nothing we can do
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }
				
			}
		});
		Submit.setBounds(269, 677, 145, 43);
		frame.getContentPane().add(Submit);
		
		
		
		
		
		
		
			
		
	}
}
