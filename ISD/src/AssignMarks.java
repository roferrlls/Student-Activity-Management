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
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Color;

public class AssignMarks {

	public JFrame frame;
	public int Aid;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   public String jEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public AssignMarks(int id,String email) {
		Aid = id;
		jEmail = email;
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
		
		JLabel lblParticipant = new JLabel("Participant");
		lblParticipant.setBounds(62, 60, 100, 15);
		frame.getContentPane().add(lblParticipant);
		String str[] = new String[1000]; 
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String sql;
		      sql = "select Pid from Enrolls where Aid= " + "?";
		      stmt = conn.prepareStatement(sql);
		      stmt.setInt(1,Aid);
		      ResultSet rs = stmt.executeQuery();
		      int count = 0;
		      while(rs.next()){
			         //Retrieve by column name
			        str[count] = rs.getString("Pid");
			        count++;
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
		      }
		   }//end finally try
		      JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(235, 55, 111, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(64, 125, 70, 15);
		frame.getContentPane().add(lblScore);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(235, 119, 106, 21);
		frame.getContentPane().add(editorPane);
		
		JButton btnSubmitScore = new JButton("SUBMIT SCORE");
		btnSubmitScore.setBackground(new Color(135, 206, 235));
		btnSubmitScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      String pid = String.valueOf(comboBox.getItemAt(comboBox.getSelectedIndex()));  
				      System.out.println(pid);
				      String sql;
				      String score = editorPane.getText().toString();
				      int val = Integer.parseInt(score);
				      sql = "insert into Evaluation " + "values(?,?,?,?)";
				      stmt = conn.prepareStatement(sql);
				      stmt.setInt(1,Aid);
				      stmt.setString(2,pid);
				      stmt.setString(3,jEmail);
				      stmt.setInt(4,val);
				      
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
				      }
				   }
			}
		});	
		btnSubmitScore.setBounds(133, 230, 153, 25);
		frame.getContentPane().add(btnSubmitScore);
		
		JButton btnDone = new JButton("DONE");
		btnDone.setBackground(new Color(135, 206, 235));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnDone.setBounds(399, 230, 117, 25);
		frame.getContentPane().add(btnDone);
		System.out.println(Aid);
	}
}
