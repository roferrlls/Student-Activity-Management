package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

public class AuthorizedUser {

	public JFrame frame;
	public int flag;
	String uid;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
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
	
	
	public AuthorizedUser(int val) {
		flag = val;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 192, 203));
		//frame.setBounds(100, 100, 450, 300);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRollno = new JLabel("USER ID");
		lblRollno.setBounds(37, 30, 70, 15);
		frame.getContentPane().add(lblRollno);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(37, 96, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(201, 24, 106, 21);
		frame.getContentPane().add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(201, 90, 106, 21);
		frame.getContentPane().add(editorPane_1);
		
		JButton btnSubmit = new JButton("LOGIN");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roll = editorPane.getText().toString();
				uid = roll;
				String password = editorPane_1.getText().toString();
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
				      sql = "select password from AuthorizedUser where Uid = '" + roll+"'";
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
					if(flag == 1) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									addActivity window = new addActivity(uid);
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					else if(flag == 2) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									UpdateEventList window = new UpdateEventList(uid);
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				}
				else {
					JOptionPane.showMessageDialog(frame,"Invalid UserName or password");  
					return;
				}
				
			}
		});
		btnSubmit.setBounds(120, 173, 187, 25);
		frame.getContentPane().add(btnSubmit);
		

		JMenuBar menuBar = new JMenuBar();
		//menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.BLACK);
		menuBar.setPreferredSize(new Dimension(0, 50));
		//
//			      //create menus
			      JMenu ActivityMenu = new JMenu(" Activity");
			      ActivityMenu.setForeground(Color.WHITE);
//			      JMenu upcomingMenu = new JMenu("Upcoming Activity"); 
//			      final JMenu pastMenu = new JMenu("Past Activity");
			      final JMenu ParticipantMenu = new JMenu("My account");
			      ParticipantMenu.setForeground(Color.WHITE);
			      final JMenu AddMenu = new JMenu("Add Activity");
			      AddMenu.setForeground(Color.WHITE);
			      final JMenu JudgeMenu = new JMenu("Judge Portal");
			      JudgeMenu.setForeground(Color.WHITE);
			      final JMenu UpdateMenu = new JMenu("Update Activity");
			      UpdateMenu.setForeground(Color.WHITE);
				     
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
				      ActivityMenuItem3.setActionCommand("login");
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
		    	  
		    	  else if(e.getActionCommand().equals("login")){
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
