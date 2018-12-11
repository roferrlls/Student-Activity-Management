import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateEventList {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   DefaultListModel<String> l1;
	   JList<String> list;
	   PreparedStatement stmt1 = null;

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   Statement stmt = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public UpdateEventList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("EventList");
		frame.setBounds(100, 100, 800, 800);
		l1 = new DefaultListModel<>();   
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
		      sql = "SELECT * from Activity where Date > CURDATE()";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
			         //Retrieve by column name
			        String name = rs.getString("Name");
			        int id = rs.getInt("Aid");
			         System.out.println( id);
			         String str = "(" + id + ")" + " " + name;
			         l1.addElement(str);
			       
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
        list = new JList<>(l1);  
        list.setBounds(12,34, 721,510);  
        frame.getContentPane().add(list);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnViewDetails = new JButton("UPDATE DETAILS");
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String dest= list.getSelectedValue();
							String id = "";
							int i =1;
							while(dest.charAt(i) != ')') {
								id += dest.charAt(i);
								i++;
							}
							int val = Integer.parseInt(id);
							SubmitUpdate window = new SubmitUpdate(val);
							
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});	
		btnViewDetails.setBounds(39, 635, 275, 51);
		frame.getContentPane().add(btnViewDetails);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(443, 643, 275, 43);
		frame.getContentPane().add(btnNewButton);
		
		
	}

}
