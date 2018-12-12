import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;


import javax.swing.JList;

public class EnterRoll {

	public JFrame frame;
	public int seat = -1;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   DefaultListModel<String> l1;

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   PreparedStatement stmt = null;
	Statement stmt1= null;
	Statement stmt2= null;
	Statement stmt3= null;

	   public int Aid;
	   private JPasswordField passwordField;
	   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public EnterRoll(int id) {
		Aid = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 205));
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEn = new JLabel("ROLL NUMBER");
		lblEn.setBounds(27, 54, 168, 15);
		frame.getContentPane().add(lblEn);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(394, 43, 282, 21);
		frame.getContentPane().add(editorPane);
		//String rollNum = editorPane.ge
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(27, 117, 122, 15);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(394, 113, 276, 24);
		frame.getContentPane().add(passwordField);
		

		l1 = new DefaultListModel<>();
		
		String val[] = new String[50];
		   String att[] = new String[50];
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt1 = conn.createStatement();
		      stmt2= conn.createStatement();
		      stmt3= conn.createStatement();
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String query = "select column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Activity' ORDER BY ORDINAL_POSITION";
		      ResultSet rs1=stmt1.executeQuery(query);
		      int i=1;
		      while(rs1.next())
		      {
		    	  att[i]=rs1.getString(1);
		    	  System.out.println(att[i]);
		    	  String que2  = "select data_type from information_schema.columns where table_name='Activity' and column_name = '" + att[i] +"'";    
		    	  ResultSet rs3 = stmt3.executeQuery(que2);
		    	  while(rs3.next()) {
		    		  val[i] = rs3.getString(1);
		    	  }
		    	  i++;
		      }
		      int j=13;
		      
		      query = "select * FROM Activity where Aid = "+Aid;
		      ResultSet rs2=stmt2.executeQuery(query);
		      int count = 1;
		      while(rs2.next())
		      {
		    	  
		    	while(j < i) {
		    		String str = "";
		    		if(val[j] == "int") {
		    			str = " (" + count + ")" + " " + att[j] + "    " + rs2.getInt(j);
		    		}
		    		else {
		    			str = " (" + count + ")" + " " + att[j] + "    " + rs2.getString(j);
		    		}
		    		j++;
		    		count++;
		    		System.out.println(str);
		    		l1.addElement(str);
		    	}
		      }
		      
		      
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt1!=null)
		            stmt1.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }
		
		JList list = new JList(l1);
		list.setBounds(394, 182, 282, 193);
		frame.getContentPane().add(list);
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(new Color(135, 206, 235));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);
				      Statement stmt4 = conn.createStatement();
				      String q2 = "select Seats from Activity where Aid = " + Aid;
				      ResultSet rs5 = stmt4.executeQuery(q2);
				      if(!rs5.next()) {
						      String roll = editorPane.getText().toString();
						      //STEP 4: Execute a query
						      System.out.println("Creating statement...");
						      String query = "select * from Participant where Pid = "  + "?";
						      stmt = conn.prepareStatement(query);
						      
						      stmt.setString(1, roll);
						      
						      ResultSet rs = stmt.executeQuery();
						      if(rs.next() == false) {
		//				    	  EventQueue.invokeLater(new Runnable() {
		//				  			public void run() {
		//				  				try {
		//				  					PartcipantForm window = new PartcipantForm(Aid,roll);
		//				  					window.frame.setVisible(true);
		//				  				} catch (Exception e) {
		//				  					e.printStackTrace();
		//				  				}
		//				  			}
		//				  		});
									JOptionPane.showMessageDialog(frame,"Not a valid user");  
						    	  
						      }
						      else
						      {
						    	  String check = rs.getString("Password");
						    	  String password = new String(passwordField.getPassword());
						    	  System.out.println(password);
						    	  
						    	  if(check == null || !check.equals(password)) {
						    		  JOptionPane.showMessageDialog(frame,"Invalid password");
						    	  }
						      
							      else {
							    	  String sq = "select * from Enrolls where Pid = ? and Aid = ?";
							    	  stmt = conn.prepareStatement(sq);
							    	  stmt.setString(1, roll);
							    	  stmt.setInt(2, Aid);
								      rs = stmt.executeQuery();
							    	  if(!rs.next()) {
							    		  
							    	  String sql = "insert into Enrolls(Aid,Pid) " + "values(?,?)";
							    	  stmt = conn.prepareStatement(sql);
								      
								      stmt.setInt(1, Aid);
								      stmt.setString(2, roll);
								      stmt.execute();
						    		  JOptionPane.showMessageDialog(frame,"Successfully Registered!");
							    	  }
							    	  else
							    		  JOptionPane.showMessageDialog(frame,"Already Registered!");
			
			
							      }
						      }
						}     
				      else {
				    	  seat = rs5.getInt(1);
				    	  if(seat > 0) {
				    		  seat--;
				    		  String roll = editorPane.getText().toString();
						      //STEP 4: Execute a query
						      System.out.println("Creating statement...");
						      String query = "select * from Participant where Pid = "  + "?";
						      stmt = conn.prepareStatement(query);
						      
						      stmt.setString(1, roll);
						      
						      ResultSet rs = stmt.executeQuery();
						      if(rs.next() == false) {
		//				    	  EventQueue.invokeLater(new Runnable() {
		//				  			public void run() {
		//				  				try {
		//				  					PartcipantForm window = new PartcipantForm(Aid,roll);
		//				  					window.frame.setVisible(true);
		//				  				} catch (Exception e) {
		//				  					e.printStackTrace();
		//				  				}
		//				  			}
		//				  		});
									JOptionPane.showMessageDialog(frame,"Not a valid user");  
						    	  
						      }
						      else
						      {
						    	  String check = rs.getString("Password");
						    	  String password = new String(passwordField.getPassword());
						    	  System.out.println(password);
						    	  
						    	  if(check == null || !check.equals(password)) {
						    		  JOptionPane.showMessageDialog(frame,"Invalid password");
						    	  }
						      
							      else {
							    	  String sq = "select * from Enrolls where Pid = ? and Aid = ?";
							    	  stmt = conn.prepareStatement(sq);
							    	  stmt.setString(1, roll);
							    	  stmt.setInt(2, Aid);
								      rs = stmt.executeQuery();
							    	  if(!rs.next()) {
							    		  
							    	  String sql = "insert into Enrolls(Aid,Pid) " + "values(?,?)";
							    	  stmt = conn.prepareStatement(sql);
								      
								      stmt.setInt(1, Aid);
								      stmt.setString(2, roll);
								      stmt.execute();
						    		  JOptionPane.showMessageDialog(frame,"Successfully Registered!");
						    		  Statement st = conn.createStatement();
						    		  String q = "update Activity set Seats = " + seat + " where Aid = " + Aid;
						    		  st.executeUpdate(q);
							    	  }
							    	  else
							    		  JOptionPane.showMessageDialog(frame,"Already Registered!");
			
			
							      }
						    	  
						      }
				    		  
				    		  
				    	  }
				    	  else {
				    		  JOptionPane.showMessageDialog(frame,"No Seats available!");
				    		  return;
				    	  }
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
		});	
		btnSubmit.setBounds(394, 425, 147, 25);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblRequirements = new JLabel("OTHER REQUIREMENTS");
		lblRequirements.setBounds(27, 195, 122, 15);
		frame.getContentPane().add(lblRequirements);
		
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(94, 425, 142, 25);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		
	}
}
