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
import java.awt.Color;
public class ParticipantDetails {

	JFrame frame;
	public String Pid;
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
	public ParticipantDetails(String Pid) {
		this.Pid=Pid;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 700, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblName.setBounds(77, 110, 95, 36);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER");
		lblPhoneNumber.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(77, 158, 139, 33);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblBatch = new JLabel("BATCH");
		lblBatch.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblBatch.setBounds(77, 255, 125, 51);
		frame.getContentPane().add(lblBatch);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEmail.setBounds(77, 203, 105, 40);
		frame.getContentPane().add(lblEmail);
		
		JLabel lbldisName = new JLabel("New label");
		lbldisName.setFont(new Font("Serif", Font.BOLD, 15));
		lbldisName.setBounds(384, 121, 174, 15);
		frame.getContentPane().add(lbldisName);
		
		JLabel lbldisPhone = new JLabel("New label");
		lbldisPhone.setFont(new Font("Serif", Font.BOLD, 15));
		lbldisPhone.setBounds(384, 167, 174, 15);
		frame.getContentPane().add(lbldisPhone);
		
		JLabel lbldisEmail = new JLabel("New label");
		lbldisEmail.setFont(new Font("Serif", Font.BOLD, 15));
		lbldisEmail.setBounds(384, 216, 174, 15);
		frame.getContentPane().add(lbldisEmail);
		
		JLabel lbldisBatch = new JLabel("New label");
		lbldisBatch.setFont(new Font("Serif", Font.BOLD, 15));
		lbldisBatch.setBounds(384, 273, 174, 15);
		frame.getContentPane().add(lbldisBatch);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnBack.setBounds(264, 423, 117, 25);
		frame.getContentPane().add(btnBack);
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String query = "select * from Participant where Pid = "  + "?";
		      stmt = conn.prepareStatement(query);
		      
		      stmt.setString(1, Pid);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()){
			         //Retrieve by column name
		    	  	 String email=rs.getString("Email");
			         String name = rs.getString("Name");
			         String contact=rs.getString("PhoneNumber");
			         String batch=rs.getString("Batch");
			         lbldisName.setText(name);
			         lbldisPhone.setText(contact);
			         lbldisBatch.setText(batch);
			         lbldisEmail.setText(email);
			         
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
