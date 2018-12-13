package dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Activity;

public class addActivityController {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   static Connection conn = null;
	   static Statement stmt1 = null;
	   static PreparedStatement stmt = null;
	   public static int id = 0;
	   
	   public static int insertDetails(Activity a,String uid) {
		   
		   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      String s= "select Aid from Activity";
			      stmt1 = conn.createStatement();
			      ResultSet rs = stmt1.executeQuery(s);
			      while(rs.next()) {
			    	  id++;
			      }
			      
			      System.out.println(id);
			      String query = "insert into Activity (name,time,date,venue,description,Expected_Audience,Contact_Details,Club,Department,Deadline)" + " values(?,?,?,?,?,?,?,?,?,?)";
			      stmt = conn.prepareStatement(query);
			      
			      stmt.setString(1, a.getName());
			      stmt.setString(2, a.getTime());
			      stmt.setString(3, a.getDate());
			      stmt.setString(4, a.getVenue());
			      stmt.setString(5, a.getDescription());
			      stmt.setString(6, a.getEx_aud());
			      int val = Integer.parseInt(a.getContact());
			      stmt.setInt(7,val);
			      stmt.setString(8, a.getClub());
			      stmt.setString(9, a.getDept());
			      stmt.setString(10, a.getDeadline());
			      stmt.execute();
			      int casee = id + 1;
			      query = "insert into AddAct values(" + casee + ", '" + uid +"' " + ")";
			      stmt1.executeUpdate(query);
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
			         if(stmt!=null) {
			            stmt.close();
			            stmt1.close();
			         }   
			         	
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }
		   return id;
	   }

}
