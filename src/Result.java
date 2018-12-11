import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Result {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   PreparedStatement stmt1=null;
	   public int Aid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Result(int id) {
		Aid = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Results");
		DefaultListModel<String> l1 = new DefaultListModel<>();   
        try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		 
		      String query;
		      query = "SELECT * from Evaluation where Aid = " + "?";
		      stmt = conn.prepareStatement(query);
		      stmt.setInt(1, Aid);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()){
			         //Retrieve by column name
			        String score = rs.getString("Score");
			        String pid = rs.getString("Pid");
			        
			        
			         
			        try{
					     
					      String sql;
					      sql = "select * from Participant where Pid = " + "?";
					      stmt1 = conn.prepareStatement(sql);
					      stmt1.setString(1,pid);
					      ResultSet rs1 = stmt1.executeQuery();
					      
					      while(rs1.next()){
						         //Retrieve by column name
						        String name = rs1.getString("Name");
						        String finals = "";
						        finals += name + "->" + score;
						        System.out.println(finals);
						        l1.addElement(finals);
						        
						       
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
        list.setBounds(12,34, 721,510);  
        frame.getContentPane().add(list);  
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnBack.setBounds(283, 637, 117, 25);
		frame.getContentPane().add(btnBack);
	}

}
