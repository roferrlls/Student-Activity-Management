package dbAccess;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Evaluation;

public class EvaluationController {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   static Connection conn = null;
	   static Statement stmt1 = null;
	   static PreparedStatement stmt = null;

	public static void insertDetails(JComboBox comboBox, JFrame frame,Evaluation el) {
		
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
		      int val = Integer.parseInt(el.getScore());
		      if(el.getScore().length()==0 || el.getRemarks().length()==0)
		      {
		    	  JOptionPane.showMessageDialog(frame,"field is empty");
		    	  return;
		      }
		      else
		      {
		    	  sql = "insert into Evaluation " + "values(?,?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			      stmt.setInt(1,el.getAid());
			      stmt.setString(2,el.getPid());
			      stmt.setString(3,el.getEmail());
			      stmt.setInt(4,Integer.parseInt(el.getScore()));
			      stmt.setString(5, el.getRemarks());
			      
			      stmt.execute();
			  
			      stmt.close();
			      conn.close();
			      JOptionPane.showMessageDialog(frame,"submitted successfully");
		    	  
		      }
		      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		     
		      JOptionPane.showMessageDialog(frame,"Already Evaluated!");
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      
		      JOptionPane.showMessageDialog(frame,"Already Evaluated!");
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
}
