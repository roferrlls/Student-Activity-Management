import java.awt.EventQueue;
import java.util.Date;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

public class SubmitUpdate {

	public JFrame frame;
	public int Aid;
	 Statement st = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   String name = "";
	   String date = "";
	   String time = "";
	   String venue="";
	   String expectedAud="";
	   int Contact;
	   String Des="";
	   
	   
	   

	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   Connection conn = null;
	   PreparedStatement stmt = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					SubmitUpdate window = new SubmitUpdate(18);
					
					window.frame.setVisible(true);
			}
		});
	
	}
	public static boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    if (str.isEmpty()) {
	        return false;
	    }
	    int i = 0;
	    int length = str.length();
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public SubmitUpdate(int id) {
		Aid = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("ActivityProfile");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		frame.getContentPane().setBackground(new Color(255, 250, 205));
		//frame.setBounds(100, 100, 800, 800);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Serif", Font.PLAIN, 14));

		lblName.setBounds(47, 76, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblDate = new JLabel("DATE(yyyy - mm - dd)");
		lblDate.setFont(new Font("Serif", Font.PLAIN, 14));

		lblDate.setBounds(48, 122, 208, 28);
		frame.getContentPane().add(lblDate);
		
		JLabel lblDateyyyytimeDd = new JLabel("TIME(hh:mm::ss)");
		lblDateyyyytimeDd.setToolTipText("");
		lblDateyyyytimeDd.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDateyyyytimeDd.setBounds(48, 188, 208, 28);
		frame.getContentPane().add(lblDateyyyytimeDd);
		
		JLabel lblVenue = new JLabel("VENUE");
		lblVenue.setFont(new Font("Serif", Font.PLAIN, 14));
		lblVenue.setBounds(47, 248, 70, 15);
		frame.getContentPane().add(lblVenue);
		
		JLabel lblExpectedAudience = new JLabel("EXPECTED AUDIENCE");
		lblExpectedAudience.setFont(new Font("Serif", Font.PLAIN, 14));
		lblExpectedAudience.setBounds(47, 302, 173, 15);
		frame.getContentPane().add(lblExpectedAudience);
		
		JLabel lblContactDetails = new JLabel("CONTACT DETAILS");
		lblContactDetails.setFont(new Font("Serif", Font.PLAIN, 14));
		lblContactDetails.setBounds(47, 351, 173, 15);
		frame.getContentPane().add(lblContactDetails);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDescription.setBounds(47, 421, 173, 15);
		frame.getContentPane().add(lblDescription);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JEditorPane lblNewLabel = new JEditorPane();
		lblNewLabel.setBounds(443, 61, 265, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JEditorPane label = new JEditorPane();
		label.setBounds(443, 121, 265, 30);
		frame.getContentPane().add(label);
		
		JEditorPane label_1 = new JEditorPane();
		label_1.setBounds(443, 176, 265, 30);
		frame.getContentPane().add(label_1);
		
		JEditorPane label_2 = new JEditorPane();
		label_2.setBounds(443, 233, 265, 30);
		frame.getContentPane().add(label_2);
		
		JEditorPane label_3 = new JEditorPane();
		label_3.setBounds(443, 287, 265, 30);
		frame.getContentPane().add(label_3);
		
		JEditorPane label_4 = new JEditorPane();
		label_4.setBounds(443, 336, 265, 30);
		frame.getContentPane().add(label_4);
		
		JEditorPane label_5 = new JEditorPane();
		label_5.setBounds(443, 409, 265, 157);
		frame.getContentPane().add(label_5);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(257, 710, 219, 25);
		frame.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      name = lblNewLabel.getText().toString();
				      System.out.println(name);
				      date = label.getText().toString();
				      time = label_1.getText().toString();
				      venue = label_2.getText().toString();
				      expectedAud = label_3.getText().toString();
				      try {
				    	  Contact = Integer.parseInt(label_4.getText().toString());
				      }catch(NumberFormatException ee) {
				    	  JOptionPane.showMessageDialog(frame,"Contact Field Is Invalid");  
							return;
				      }
				      String val = label_4.getText().toString();
				      Des = label_5.getText().toString();
				      if(name.length() == 0) {
							JOptionPane.showMessageDialog(frame,"Name field is empty");  
							return;
						}
						if(date.length() == 0) {
							JOptionPane.showMessageDialog(frame,"date field is empty");  
							return;
						}
						if(time.length() == 0) {
							JOptionPane.showMessageDialog(frame,"time field is empty");  
							return;
						}
						if(venue.length() == 0) {
							JOptionPane.showMessageDialog(frame,"venue field is empty");  
							return;
						}
						if(expectedAud.length() == 0) {
							JOptionPane.showMessageDialog(frame,"expected Audience field is empty");  
							return;
						}
						if(val.length() != 10) {
							JOptionPane.showMessageDialog(frame,"Contact field is empty");  
							return;
						}
						
						if(Des.length() == 0) {
							JOptionPane.showMessageDialog(frame,"description field is empty");  
							return;
						}
						
				      String query = "update Activity set Name = '" + name +"' , Time='" +time+ "' , Date='" +date+ "' , Venue='" +venue+ "' , Description='" + Des + "' ,Expected_Audience = '" + expectedAud + "' ,Contact_Details = '" + Contact + "' where Aid="+Aid;
				      st = conn.createStatement();
				      st.executeUpdate(query);
				      
				      
				      st.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception w){
				      //Handle errors for Class.forName
				      w.printStackTrace();
				   }finally{
				      //finally block used to close resources
				      try{
				         if(st!=null)
				            st.close();
				      }catch(SQLException se2){
				      }// nothing we can do
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }
				 JOptionPane.showMessageDialog(frame,"Submitted Successfully");  
				 lblNewLabel.setText("");
				 label.setText("");
				 label_1.setText("");
				 label_2.setText("");
				 label_3.setText("");
				 label_4.setText("");
				 label_5.setText("");
				
			}
			
		});
		btnNewButton.setBounds(275, 593, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String query = "select * from Activity where Aid = "  + "?";
		      stmt = conn.prepareStatement(query);
		      
		      stmt.setInt(1, Aid);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()){
			         //Retrieve by column name
		    	  	 
			         name = rs.getString("Name");
			         String venue = rs.getString("Venue");
			         String date=rs.getString("Date");
			         String time=rs.getString("Time");
			         String ex_aud=rs.getString("Expected_Audience");
			         String contact=rs.getString("Contact_Details");
			         String desc=rs.getString("Description");
			         lblNewLabel.setText(name);
			         label.setText(date);
			         label_1.setText(time);
			         label_2.setText(venue);
			         label_3.setText(ex_aud);
			         label_4.setText(contact);
			         label_5.setText(desc);
			       
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
		

		JMenuBar menuBar = new JMenuBar();
		//
//				      //create menus
				      JMenu ActivityMenu = new JMenu(" Activity");
//				      JMenu upcomingMenu = new JMenu("Upcoming Activity"); 
//				      final JMenu pastMenu = new JMenu("Past Activity");
				       JMenu ParticipantMenu = new JMenu("My account");
				       JMenu AddMenu = new JMenu("Add Activity");
				       JMenu JudgeMenu = new JMenu("Judge Portal");
				       JMenu UpdateMenu = new JMenu("Update Activity");
				     
				      menuBar.add(ActivityMenu);
//				      menuBar.add(upcomingMenu);
//				      menuBar.add(pastMenu);       
				      menuBar.add(AddMenu);
				      menuBar.add(JudgeMenu);       
				      menuBar.add(UpdateMenu);
				      menuBar.add(ParticipantMenu);
				      //add menubar to the frame
				      frame.setJMenuBar(menuBar);
				      frame.setVisible(true);  
				    
				     // JMenuItem newMenuItem = new JMenuItem("New");
				      JMenuItem ActivityMenuItem = new JMenuItem("Current Activity");
				      MenuItemListener menuItemListener = new MenuItemListener();
				      ActivityMenuItem.setActionCommand("Current Activity");
				      ActivityMenuItem.addActionListener(menuItemListener);
				      ActivityMenu.add(ActivityMenuItem);
				      
				      JMenuItem ActivityMenuItem1 = new JMenuItem("Upcoming Activity");
				      
				      ActivityMenuItem1.setActionCommand("upcoming Activity");
				      ActivityMenuItem1.addActionListener(menuItemListener);
				      ActivityMenu.add(ActivityMenuItem1);
				      
				      JMenuItem ActivityMenuItem2 = new JMenuItem("Past Activity");
				      ActivityMenuItem2.setActionCommand("Past Activity");
				      ActivityMenuItem2.addActionListener(menuItemListener);
				      ActivityMenu.add(ActivityMenuItem2);
				      
				      JMenuItem AddMenuItem = new JMenuItem("open");
				      AddMenuItem.setActionCommand("Add Activity");
				      AddMenuItem.addActionListener(menuItemListener);
				      AddMenu.add(AddMenuItem);
				      
				      JMenuItem JudgeMenuItem = new JMenuItem("open");
				      JudgeMenuItem.setActionCommand("Judge");
				      JudgeMenuItem.addActionListener(menuItemListener);
				      JudgeMenu.add(JudgeMenuItem);
				      
				      JMenuItem UpdateMenuItem = new JMenuItem("open");
				      UpdateMenuItem.setActionCommand("Update Activity");
				      UpdateMenuItem.addActionListener(menuItemListener);
				      UpdateMenu.add(UpdateMenuItem);
				      
				      JMenuItem ActivityMenuItem3 = new JMenuItem("Login");
				      ActivityMenuItem3.setActionCommand("Login");
				      ActivityMenuItem3.addActionListener(menuItemListener);
				      ParticipantMenu.add(ActivityMenuItem3);
	}
	
	   
	   class MenuItemListener implements ActionListener {
		      public void actionPerformed(ActionEvent e) {    
		    	  if(e.getActionCommand().equals("Current Activity")){
			    	  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									EventList window = new EventList();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  else if(e.getActionCommand().equals("upcoming Activity")){
			    	  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									UpcomingEvent window = new UpcomingEvent();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  else if(e.getActionCommand().equals("Past Activity")){
			    	  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									PastEvent window = new PastEvent();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  
		    	  
		    	  else if(e.getActionCommand().equals("Add Activity")){
			    	  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									AuthorizedUser window = new AuthorizedUser(1);
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  
		    	  else if(e.getActionCommand().equals("Judge")){
		    		  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									JudgePortal window = new JudgePortal();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  
		    	  else if(e.getActionCommand().equals("Update Activity")){
		    		  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									AuthorizedUser window = new AuthorizedUser(2);
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  
		    	  else if(e.getActionCommand().equals("Login")){
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
		      
		      }        
		   }
	

}
