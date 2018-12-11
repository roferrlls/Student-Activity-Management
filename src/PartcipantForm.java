import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class PartcipantForm {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   public int Aid;
	   public String Pid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public PartcipantForm(int Aid,String Pid) {
		this.Aid = Aid;
		this.Pid = Pid;
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
		
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Serif", Font.PLAIN, 14));

		lblEmail.setBounds(48, 122, 208, 28);
		frame.getContentPane().add(lblEmail);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(310, 129, 181, 21);
		frame.getContentPane().add(editorPane_1);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setToolTipText("");
		lblName.setFont(new Font("Serif", Font.PLAIN, 14));
		lblName.setBounds(48, 188, 208, 28);
		frame.getContentPane().add(lblName);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(310, 184, 181, 21);
		frame.getContentPane().add(editorPane_2);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);
				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      String email = editorPane_1.getText().toString();
				      String name =  editorPane_2.getText().toString();
				      String query = "insert into Participant " + "values(?,?,?)";
				      stmt = conn.prepareStatement(query);
				      
				      stmt.setString(1, Pid);
				      stmt.setString(2, email);
				      stmt.setString(3, name);
				      stmt.execute();
				      
				      String sql = "insert into Enrolls " + "values(?,?)";
			    	  stmt = conn.prepareStatement(sql);
				      
				      stmt.setInt(1, Aid);
				      stmt.setString(2, Pid);
				      stmt.execute();	  
				    	  
				     
				      
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
				frame.dispose();

			}
		});	
		btnSubmit.setBounds(147, 285, 163, 25);
		frame.getContentPane().add(btnSubmit);
		
	}
}
