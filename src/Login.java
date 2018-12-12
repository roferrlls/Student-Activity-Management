import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class Login {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   Statement stmt = null;
	   PreparedStatement stmt1 = null;
	   private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRollno = new JLabel("Roll_No");
		lblRollno.setBounds(37, 30, 70, 15);
		frame.getContentPane().add(lblRollno);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(37, 96, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(201, 24, 106, 21);
		frame.getContentPane().add(editorPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 93, 106, 21);
		frame.getContentPane().add(passwordField);
		
		JButton btnSubmit = new JButton("LOGIN");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roll = editorPane.getText().toString();
				//String password = passwordField.getText().toString();
				String password = new String(passwordField.getPassword());
				String rpassword = "";
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
				      sql = "select Password from Participant where Pid = '" + roll+"'";
				      ResultSet rs = stmt.executeQuery(sql);
				      while(rs.next()) {
				    	 rpassword = rs.getString(1);
				    		  
				      }
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
				if(password.equals(rpassword)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MyAccount window = new MyAccount(roll);
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else {
					JOptionPane.showMessageDialog(frame,"Invalid UserName or password");  
					return;
				}
				
			}
		});
		btnSubmit.setBounds(120, 173, 117, 25);
		frame.getContentPane().add(btnSubmit);
		
		
	}
}
