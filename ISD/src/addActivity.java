import java.awt.EventQueue;
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
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class addActivity {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   public int id =0;

	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   Statement stmt1 = null;

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
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(310, 63, 349, 28);
		frame.getContentPane().add(editorPane);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Serif", Font.PLAIN, 14));

		lblName.setBounds(47, 76, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblDate = new JLabel("DATE(yyyy - mm - dd)");
		lblDate.setFont(new Font("Serif", Font.PLAIN, 14));

		lblDate.setBounds(48, 122, 208, 28);
		frame.getContentPane().add(lblDate);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(310, 129, 181, 21);
		frame.getContentPane().add(editorPane_1);
		
		JLabel lblDateyyyytimeDd = new JLabel("TIME(hh:mm::ss)");
		lblDateyyyytimeDd.setToolTipText("");
		lblDateyyyytimeDd.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDateyyyytimeDd.setBounds(48, 188, 208, 28);
		frame.getContentPane().add(lblDateyyyytimeDd);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(310, 184, 181, 21);
		frame.getContentPane().add(editorPane_2);
		
		JLabel lblVenue = new JLabel("VENUE");
		lblVenue.setFont(new Font("Serif", Font.PLAIN, 14));
		lblVenue.setBounds(47, 248, 70, 15);
		frame.getContentPane().add(lblVenue);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setBounds(310, 235, 349, 28);
		frame.getContentPane().add(editorPane_3);
		
		JLabel lblExpectedAudience = new JLabel("EXPECTED AUDIENCE");
		lblExpectedAudience.setFont(new Font("Serif", Font.PLAIN, 14));
		lblExpectedAudience.setBounds(47, 302, 173, 15);
		frame.getContentPane().add(lblExpectedAudience);
		
		JEditorPane editorPane_4 = new JEditorPane();
		editorPane_4.setBounds(310, 296, 181, 21);
		frame.getContentPane().add(editorPane_4);
		
		JLabel lblContactDetails = new JLabel("CONTACT DETAILS");
		lblContactDetails.setFont(new Font("Serif", Font.PLAIN, 14));
		lblContactDetails.setBounds(47, 351, 173, 15);
		frame.getContentPane().add(lblContactDetails);
		
		JEditorPane editorPane_5 = new JEditorPane();
		editorPane_5.setBounds(310, 345, 181, 21);
		frame.getContentPane().add(editorPane_5);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDescription.setBounds(47, 421, 173, 15);
		frame.getContentPane().add(lblDescription);
		
		JEditorPane editorPane_6 = new JEditorPane();
		editorPane_6.setBounds(310, 407, 459, 43);
		frame.getContentPane().add(editorPane_6);
		
		JButton btnAddJudge = new JButton("ADD judge");
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
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = editorPane.getText().toString();
				String date =  editorPane_1.getText().toString();
				String time = editorPane_2.getText().toString();
				String venue = editorPane_3.getText().toString();
				String exaud = editorPane_4.getText().toString();
				String contact = editorPane_5.getText().toString();
				String description = editorPane_6.getText().toString();
				String club = String.valueOf(comboBox.getItemAt(comboBox.getSelectedIndex()));
				String dept = String.valueOf(comboBox_1.getItemAt(comboBox_1.getSelectedIndex()));
				if(name.length() == 0) {
					JOptionPane.showMessageDialog(frame,"Name field is empty");  
					return;
				}
				if(date.length() == 0) {
					JOptionPane.showMessageDialog(frame,"date field is empty");  
					return;
				}
				if(time.length() == 0) {
					JOptionPane.showMessageDialog(frame,"time field is empty");  
					return;
				}
				if(venue.length() == 0) {
					JOptionPane.showMessageDialog(frame,"venue field is empty");  
					return;
				}
				if(exaud.length() == 0) {
					JOptionPane.showMessageDialog(frame,"expected Audience field is empty");  
					return;
				}
				if(contact.length() == 0) {
					JOptionPane.showMessageDialog(frame,"contact field is empty");  
					return;
				}
				if(description.length() == 0) {
					JOptionPane.showMessageDialog(frame,"description field is empty");  
					return;
				}
				if(club.length() == 0) {
					club = "";
				}
				if(dept.length() == 0) {
					dept="";  
				}
				//System.out.print(club + " "+ dept + " " + time + " " + venue + " " + exaud + " " + contact);
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      String s= "select Aid from Activity";
				      stmt1 = conn.createStatement();
				      ResultSet rs = stmt1.executeQuery(s);
				      while(rs.next()) {
				    	  id++;
				      }
				      
				      System.out.println(id);
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
				         if(stmt!=null) {
				            stmt.close();
				            stmt1.close();
				         }   
				         	
				      }catch(SQLException se2){
				      }// nothing we can do
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }
				
				EventQueue.invokeLater(new Runnable() {
						public void run() {
						try {
							Features window = new Features(id);
							window.frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		Submit.setBounds(269, 677, 145, 43);
		frame.getContentPane().add(Submit);
		
		
		
		
	}
}
