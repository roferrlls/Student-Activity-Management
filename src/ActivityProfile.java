import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActivityProfile {

	public JFrame frame;
	public int flag;
	public  int id;
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
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ActivityProfile(int id,int val) {
		this.id = id;
		flag = val;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("ActivityProfile");
		frame.setBounds(100, 100, 800, 800);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Serif", Font.PLAIN, 14));

		lblName.setBounds(47, 76, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblDate = new JLabel("DATE(yyyy - mm - dd)");
		lblDate.setFont(new Font("Serif", Font.PLAIN, 14));

		lblDate.setBounds(48, 122, 208, 28);
		frame.getContentPane().add(lblDate);
		
		JLabel lblDateyyyytimeDd = new JLabel("TIME(hh:mm::ss)");
		lblDateyyyytimeDd.setToolTipText("");
		lblDateyyyytimeDd.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDateyyyytimeDd.setBounds(48, 188, 208, 28);
		frame.getContentPane().add(lblDateyyyytimeDd);
		
		JLabel lblVenue = new JLabel("VENUE");
		lblVenue.setFont(new Font("Serif", Font.PLAIN, 14));
		lblVenue.setBounds(47, 248, 70, 15);
		frame.getContentPane().add(lblVenue);
		
		JLabel lblExpectedAudience = new JLabel("EXPECTED AUDIENCE");
		lblExpectedAudience.setFont(new Font("Serif", Font.PLAIN, 14));
		lblExpectedAudience.setBounds(47, 302, 173, 15);
		frame.getContentPane().add(lblExpectedAudience);
		
		JLabel lblContactDetails = new JLabel("CONTACT DETAILS");
		lblContactDetails.setFont(new Font("Serif", Font.PLAIN, 14));
		lblContactDetails.setBounds(47, 351, 173, 15);
		frame.getContentPane().add(lblContactDetails);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDescription.setBounds(47, 421, 173, 15);
		frame.getContentPane().add(lblDescription);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(443, 61, 265, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(443, 121, 265, 30);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(443, 176, 265, 30);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(443, 233, 265, 30);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(443, 287, 265, 30);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(443, 336, 265, 30);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(443, 122, 305, 592);
		frame.getContentPane().add(label_5);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(257, 710, 219, 25);
		frame.getContentPane().add(btnBack);
		
		JButton btnNewButton_1 = new JButton("Show Result");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Result window = new Result(id);
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setBounds(257, 567, 208, 25);
			if(flag != 0)
			frame.getContentPane().add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Show Participant");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton_2.setBounds(257, 628, 208, 25);
			frame.getContentPane().add(btnNewButton_2);
		
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EnterRoll window = new EnterRoll(id);
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setBounds(47, 601, 645, 66);
		if(flag  == 1) {
			frame.getContentPane().add(btnNewButton);
		}	
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String query = "select * from Activity where Aid = "  + "?";
		      stmt = conn.prepareStatement(query);
		      
		      stmt.setInt(1, id);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()){
			         //Retrieve by column name
		    	  	 
			         String name = rs.getString("Name");
			         String venue = rs.getString("Venue");
			         String date=rs.getString("Date");
			         String time=rs.getString("Time");
			         String ex_aud=rs.getString("Expected_Audience");
			         String contact=rs.getString("Contact_Details");
			         String desc=rs.getString("Description");
			         lblNewLabel.setText(name);
			         label.setText(date);
			         label_1.setText(time);
			         label_2.setText(venue);
			         label_3.setText(ex_aud);
			         label_4.setText(contact);
			         label_5.setText(desc);
			       
			  }
		      
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
}
