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

public class EnterRoll {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   PreparedStatement stmt2 = null;
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
	public EnterRoll(int id) {
		Aid = id;
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
		
		JLabel lblEn = new JLabel("ENTER ROLL NUMBER");
		lblEn.setBounds(27, 54, 168, 15);
		frame.getContentPane().add(lblEn);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(394, 43, 282, 21);
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
				      String roll = editorPane.getText().toString();
				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      String query = "select * from Participant where Pid = "  + "?";
				      stmt = conn.prepareStatement(query);
				      
				      stmt.setString(1, roll);
				      ResultSet rs = stmt.executeQuery();
				      if(rs.next() == false) {
				    	  EventQueue.invokeLater(new Runnable() {
				  			public void run() {
				  				try {
				  					PartcipantForm window = new PartcipantForm(Aid,roll);
				  					window.frame.setVisible(true);
				  				} catch (Exception e) {
				  					e.printStackTrace();
				  				}
				  			}
				  		});
				      }
				      else {
				    	  String sql = "insert into Enrolls " + "values(?,?)";
				    	  stmt = conn.prepareStatement(sql);
					      
					      stmt.setInt(1, Aid);
					      stmt.setString(2, roll);
					      stmt.execute();
				    	  
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
		btnSubmit.setBounds(258, 139, 147, 25);
		frame.getContentPane().add(btnSubmit);
	}
}
