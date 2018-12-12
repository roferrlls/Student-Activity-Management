import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Color;

public class JudgeProfile {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   PreparedStatement stmt1=null;
	   public String email;
	   
	   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public JudgeProfile(String email) {
		this.email=email;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("JudgeProfile");
		frame.setBounds(100, 100, 800, 800);
		DefaultListModel<String> l1 = new DefaultListModel<>();   
        try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String sql;
		      sql = "select Aid from Contains where Judge_Email= " + "?";
		      stmt = conn.prepareStatement(sql);
		      stmt.setString(1,email);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()){
			         //Retrieve by column name
			        
			        int id = rs.getInt("Aid");
			         System.out.println( id);
			         try{
					     
					      String query;
					      query = "select * from Activity where Aid = " + "?";
					      stmt1 = conn.prepareStatement(query);
					      stmt1.setInt(1,id);
					      ResultSet rs1 = stmt1.executeQuery();
					      
					      while(rs1.next()){
						         //Retrieve by column name
						        String name = rs1.getString("Name");
						        String str = "(" + id + ")" ;
						        str += " "  +name;
						         l1.addElement(str);
						        
						       
						      }
					      
					      
					   }catch(SQLException se){
					      //Handle errors for JDBC
					      se.printStackTrace();
					   }catch(Exception e){
					      //Handle errors for Class.forName
					      e.printStackTrace();
					   }
			         
			       
			      }
		      rs.close();
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
        JList<String> list = new JList<>(l1);  
        list.setBackground(new Color(255, 250, 205));
        list.setBounds(12,34, 721,510);  
        frame.getContentPane().add(list);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmitMarks = new JButton("VIEW PARTICIPANTS");
		btnSubmitMarks.setBackground(new Color(135, 206, 235));
		btnSubmitMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String dest = list.getSelectedValue();
							int i =1;
							String temp = "";
							temp += dest.charAt(i);
							while(dest.charAt(i+1) != ')') {
								temp += dest.charAt(i+1);
								i++;
							}
							int val = Integer.parseInt(temp);
							AssignMarks window = new AssignMarks(val,email);
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});	
		btnSubmitMarks.setBounds(209, 591, 395, 25);
		frame.getContentPane().add(btnSubmitMarks);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});	
		btnNewButton.setBounds(209, 685, 395, 25);
		frame.getContentPane().add(btnNewButton);
		
		
		
	}

}
