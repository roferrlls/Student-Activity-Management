import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JButton;

public class JudgePortal {

	public JFrame frame;
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
	public JudgePortal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEntrEmailId = new JLabel("Entr Email ID");
		lblEntrEmailId.setBounds(27, 45, 114, 15);
		frame.getContentPane().add(lblEntrEmailId);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(199, 39, 201, 21);
		frame.getContentPane().add(editorPane);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);
				      String email = editorPane.getText().toString();
				      //STEP 4: Execute a query
				      String query = "select * from Judge where Email = "  + "?";
				      stmt = conn.prepareStatement(query);
				      
				      stmt.setString(1, email);
				      ResultSet rs = stmt.executeQuery();
				      if(rs.next() == false) {
				    	  System.out.println("HI");
				      }
				      else {
				    	  EventQueue.invokeLater(new Runnable() {
				  			public void run() {
				  				try {
				  					JudgeProfile window = new JudgeProfile(email);
				  					window.frame.setVisible(true);
				  				} catch (Exception e) {
				  					e.printStackTrace();
				  				}
				  			}
				  		});
				    	  
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
		btnSubmit.setBounds(112, 137, 117, 25);
		frame.getContentPane().add(btnSubmit);
	}

}
