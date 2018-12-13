package View;

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

public class JudgeDetails {

	public JFrame frame;
	public int Aid;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   Connection conn = null;
	   Statement stmt = null;
	   PreparedStatement stmt1 = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public JudgeDetails(int val) {
		Aid = val;
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
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(29, 34, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(29, 78, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(29, 138, 70, 15);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(29, 176, 70, 51);
		frame.getContentPane().add(lblPassword);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(208, 23, 106, 21);
		frame.getContentPane().add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(208, 72, 106, 21);
		frame.getContentPane().add(editorPane_1);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(208, 123, 106, 21);
		frame.getContentPane().add(editorPane_2);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setBounds(208, 176, 106, 21);
		frame.getContentPane().add(editorPane_3);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String name = editorPane.getText().toString();
					String email = editorPane_1.getText().toString();
					String value = editorPane_2.getText().toString();
					String password = editorPane_3.getText().toString();
					if(name.length() == 0) {
						JOptionPane.showMessageDialog(frame,"Name Field s empty");
						return;
					}
					if(email.length() == 0) {
						JOptionPane.showMessageDialog(frame,"Email Field s emptyr");
						return;
					}
					if(value.length() != 10) {
						JOptionPane.showMessageDialog(frame,"Invalid Phone Number");
						return;
					}
					if(password.length() <= 8) {
						JOptionPane.showMessageDialog(frame,"Password Field is weak Enter strong one");
						return;
					}
					int contact;
					try {
						contact = Integer.parseInt(value);
					}catch(Exception ee) {
						JOptionPane.showMessageDialog(frame,"Invalid Phone Number");
						return;
					}
					
					try{
					      //STEP 2: Register JDBC driver
					      Class.forName("com.mysql.jdbc.Driver");

					      //STEP 3: Open a connection
					      System.out.println("Connecting to database...");
					      conn = DriverManager.getConnection(DB_URL,USER,PASS);
					      stmt = conn.createStatement();
					      Statement stmt1 = conn.createStatement();
					      Statement stmt2 = conn.createStatement();
					      //STEP 4: Execute a query
					      System.out.println("Creating statement...");
					      String q2 = "select * from Judge where Email = '" + email + "'";
					      ResultSet rs  =stmt2.executeQuery(q2);
					      String sql;
					      if(!rs.next()) {
						      sql = "insert into Judge values(' " + email + "' , '" + name + "' ," + contact + " ,'" + password + "')";
						      stmt.executeUpdate(sql);
					      }    
					      String query = "insert into Contains values('" + email + "' ,"+ Aid + ")";
					      stmt1.executeUpdate(query);
					      stmt.close();
					      stmt1.close();
					      stmt2.close();
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
					JOptionPane.showMessageDialog(frame,"Judge Added Successfully");
					editorPane.setText("");
					editorPane_1.setText("");
					editorPane_2.setText("");
					editorPane_3.setText("");
					
					
					
				
			}
		});
		btnNewButton.setBounds(52, 216, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(234, 216, 117, 25);
		frame.getContentPane().add(btnBack);
	}
}
