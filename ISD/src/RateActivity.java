import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RateActivity {
	public int Aid;
	public int rating;
	public String check;
	public String rollNum;
	String check1;
	JFrame frame = new JFrame("RateActivity");
	private JPasswordField passwordField;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   Statement stmt = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RateActivity window = new RateActivity();
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
	public RateActivity() {
		initialize();
	}

	public RateActivity(int id) {
		Aid = id;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Rate Activity");
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
		frame.getContentPane().setBackground(new Color(255, 250, 205));
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//roll number
		JEditorPane editorPaneRollNum = new JEditorPane();
		editorPaneRollNum.setFont(new Font("Dialog", Font.PLAIN, 14));
		editorPaneRollNum.setForeground(new Color(0, 0, 0));
		editorPaneRollNum.setBackground(Color.WHITE);
		editorPaneRollNum.setBounds(393, 62, 349, 28);
		frame.getContentPane().add(editorPaneRollNum);
		
		JLabel lblRollNum = new JLabel("Roll Number");
		lblRollNum.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRollNum.setBounds(52, 62, 142, 15);
		frame.getContentPane().add(lblRollNum);
		
		
		//password
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Serif", Font.PLAIN, 14));
		lblPass.setBounds(52, 123, 142, 15);
		frame.getContentPane().add(lblPass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(393, 117, 345, 28);
		frame.getContentPane().add(passwordField);
		//passwordField.setEchoChar('*');

		
		JButton btnNewButton = new JButton("Rate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollNum = editorPaneRollNum.getText().toString();
				
				
				//checking if user has participated in activity
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      stmt = conn.createStatement();
				      String sql;
				      sql = "SELECT Aid from Enrolls where Pid = '" + rollNum + "'";
				      //System.out.println(sql);
				      ResultSet rs = stmt.executeQuery(sql);
				      if(!rs.next()) {
				    	  EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										ErrorMessage window = new ErrorMessage();
										window.frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
				      }
				      else 
				    	  check1 = rs.getString("Aid");
				      rs.close();
				      stmt.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e2){
				      //Handle errors for Class.forName
				      e2.printStackTrace();
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

				if(Aid != Integer.parseInt(check1)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ErrorMessage window = new ErrorMessage();
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
				
				
				
				
				
				
				//String rating = editorPaneRating.getText().toString();
				String pass = new String(passwordField.getPassword());
				//System.out.println(rollNum);
				//System.out.println(pass);
				// checking for password in database
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      stmt = conn.createStatement();
				      String sql;
				      sql = "SELECT Password from Participant where Pid = '" + rollNum + "'";
				      //System.out.println(sql);
				      ResultSet rs = stmt.executeQuery(sql);
				      rs.next();
				      check = rs.getString("Password");
				      rs.close();
				      stmt.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e2){
				      //Handle errors for Class.forName
				      e2.printStackTrace();
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

				if(!check.equals(pass)) {
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ErrorMessage window = new ErrorMessage();
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
				}
				else {
					JFrame frame = new JFrame();
			        JPanel panel = new JPanel();
			        StarRater starRater = new StarRater(5, 2, 1);
			        starRater.addStarListener(
			            new StarRater.StarListener()   {

			                public void handleSelection(int selection) {
			                    
			                	rating = selection;
			                	try{
								      //STEP 2: Register JDBC driver
								      Class.forName("com.mysql.jdbc.Driver");

								      //STEP 3: Open a connection
								      System.out.println("Connecting to database...");
								      conn = DriverManager.getConnection(DB_URL,USER,PASS);

								      //STEP 4: Execute a query
								      System.out.println("Creating statement...");
								      stmt = conn.createStatement();
								      String sql;
								      PreparedStatement st=null;
								      System.out.println(Integer.toString(rating));
								      sql = "Update Enrolls set Rating = ? where Aid = ? and Pid = ?";
								      st=conn.prepareStatement(sql);
								      st.setInt(1, rating);
								      st.setInt(2, Aid);
								      st.setString(3, rollNum);
								      System.out.println(sql);
								      st.executeUpdate();
								      //rs.next();
								      //check = rs.getString("Password");
								      //rs.close();
								      stmt.close();
								      conn.close();
								   }catch(SQLException se){
								      //Handle errors for JDBC
								      se.printStackTrace();
								   }catch(Exception e2){
								      //Handle errors for Class.forName
								      e2.printStackTrace();
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
			        panel.add(starRater);
			        frame.getContentPane().add(panel);
			        frame.pack();
			        frame.setVisible(true);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        
			        
			        
			        
					//storing the rating now in database
			        
			        
			        
			        			     
			        
				}
				
				
				
				

				
				
								
			}
		});
		btnNewButton.setBounds(321, 264, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		
		

	}
}
