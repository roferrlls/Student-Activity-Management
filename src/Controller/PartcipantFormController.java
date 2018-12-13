package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Participant;

public class PartcipantFormController {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   static Connection conn = null;
	   static PreparedStatement stmt = null;
	   
	public static void insertParticipant(Participant pt,int Aid) {
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");

		      String query = "insert into Participant values (?,?,?,?,?,?)";
		      stmt = conn.prepareStatement(query);
		      
		      stmt.setString(1, pt.getPid());
		      stmt.setString(2, pt.getEmail());
		      stmt.setString(3, pt.getName());
		      stmt.setString(4, pt.getContact());
		      stmt.setString(5, pt.getBatch());
		      stmt.setString(6, pt.getPass());
		      stmt.execute();
		      
		      String sql = "insert into Enrolls (Aid,Pid) values(?,?)";
	    	  stmt = conn.prepareStatement(sql);
		      
		      stmt.setInt(1, Aid);
		      stmt.setString(2, pt.getPid());
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
		
	}
	
	public static Participant getDetails(String Pid) {
		Participant pt = null;
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String query = "select * from Participant where Pid = "  + "?";
		      stmt = conn.prepareStatement(query);
		      
		      stmt.setString(1, Pid);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()){
			         //Retrieve by column name
		    	  	 String email=rs.getString("Email");
			         String name = rs.getString("Name");
			         String contact=rs.getString("PhoneNumber");
			         String batch=rs.getString("Batch");
			         pt = new Participant(Pid, email, name, contact, batch, "");
			         
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
		return pt;
		
	}

}
