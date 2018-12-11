import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MyAccount {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   Connection conn = null;
	   Statement stmt = null;
	   PreparedStatement stmt1 = null;
	   String roll_no;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MyAccount(String val) {
		roll_no = val;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(800, 800, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(42, 36, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(42, 79, 70, 15);
		frame.getContentPane().add(lblContact);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(42, 114, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setBounds(42, 158, 70, 15);
		frame.getContentPane().add(lblBatch);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(31, 201, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(226, 30, 106, 21);
		frame.getContentPane().add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(226, 73, 106, 21);
		frame.getContentPane().add(editorPane_1);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(226, 108, 106, 21);
		frame.getContentPane().add(editorPane_2);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setBounds(226, 152, 106, 21);
		frame.getContentPane().add(editorPane_3);
		
		JEditorPane editorPane_4 = new JEditorPane();
		editorPane_4.setBounds(226, 185, 106, 21);
		frame.getContentPane().add(editorPane_4);
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String sql;
		      sql = "select * from Participant where Pid = '" + roll_no+"'";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()) {
		    	  editorPane.setText(rs.getString(3));
		    	  editorPane_1.setText(rs.getString(4));
		    	  editorPane_2.setText(rs.getString(2));
		    	  editorPane_3.setText(rs.getString(5));
		    	  editorPane_4.setText(rs.getString(6));
		    		  
		      }
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception ee){
		      //Handle errors for Class.forName
		      ee.printStackTrace();
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
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = editorPane.getText().toString();
				String contact = editorPane_1.getText().toString();
				String email = editorPane_2.getText().toString();
				String batch = editorPane_3.getText().toString();
				String password = editorPane_4.getText().toString();
				if(name.length() == 0) {
					JOptionPane.showMessageDialog(frame,"Name field is empty");  
					return;
				}
				if(contact.length() == 0) {
					JOptionPane.showMessageDialog(frame,"contact field is empty");  
					return;
				}
				if(email.length() == 0) {
					JOptionPane.showMessageDialog(frame,"email field is empty");  
					return;
				}
				if(batch.length() == 0) {
					JOptionPane.showMessageDialog(frame,"batch field is empty");  
					return;
				}
				if(password.length() == 0) {
					JOptionPane.showMessageDialog(frame,"password Audience field is empty");  
					return;
				}
				
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      
				      String query = "update Participant set Name ='" + name + "' , Email='" + email + "' ,Batch= '" + batch + "' ,PhoneNumber= '" + contact + "' ,Password ='" + password + "' where Pid ='" +roll_no+ "'";
				      stmt = conn.createStatement();	      
				      stmt.executeUpdate(query);
				      
				      stmt.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception ee){
				      //Handle errors for Class.forName
				      ee.printStackTrace();
				   }finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null) {
				         
				            stmt.close();
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
				JOptionPane.showMessageDialog(frame,"Updates Have been registered");  
				
			}
		});
		btnSubmit.setBounds(119, 261, 117, 25);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnNewButton = new JButton("My Registered Activity");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MyActivity window = new MyActivity(roll_no);
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setBounds(101, 330, 211, 25);
		frame.getContentPane().add(btnNewButton);
	}

}
