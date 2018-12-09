import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SubmitUpdate {

	public JFrame frame;
	public int Aid;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   String name = "";

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
	public SubmitUpdate(int id) {
		Aid = id;
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
		
		JEditorPane lblNewLabel = new JEditorPane();
		lblNewLabel.setBounds(443, 61, 265, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JEditorPane label = new JEditorPane();
		label.setBounds(443, 121, 265, 30);
		frame.getContentPane().add(label);
		
		JEditorPane label_1 = new JEditorPane();
		label_1.setBounds(443, 176, 265, 30);
		frame.getContentPane().add(label_1);
		
		JEditorPane label_2 = new JEditorPane();
		label_2.setBounds(443, 233, 265, 30);
		frame.getContentPane().add(label_2);
		
		JEditorPane label_3 = new JEditorPane();
		label_3.setBounds(443, 287, 265, 30);
		frame.getContentPane().add(label_3);
		
		JEditorPane label_4 = new JEditorPane();
		label_4.setBounds(443, 336, 265, 30);
		frame.getContentPane().add(label_4);
		
		JEditorPane label_5 = new JEditorPane();
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
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      String query = "update Activity set name = " + "?" + " where Aid = " + "?";
				      stmt = conn.prepareStatement(query);
				      
				      stmt.setString(1,name);
				      stmt.setInt(2,Aid);
				      stmt.executeUpdate();
				      
				      
				      stmt.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception w){
				      //Handle errors for Class.forName
				      w.printStackTrace();
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
		btnNewButton.setBounds(275, 593, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		
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
		      
		      stmt.setInt(1, Aid);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()){
			         //Retrieve by column name
		    	  	 
			         name = rs.getString("Name");
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
