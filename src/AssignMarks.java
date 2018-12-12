import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Color;

import java.awt.Dimension;


public class AssignMarks {

	public JFrame frame;
	public int Aid;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
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

	//	frame.setBounds(100, 100, 800, 800);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		//frame.setBounds(100, 100, 800, 800);

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
		

	//	JButton btnSubmitScore = new JButton("SUBMIT SCORE");

		JLabel lblNewLabel = new JLabel("Review");
		lblNewLabel.setBounds(64, 175, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(235, 169, 106, 21);
		frame.getContentPane().add(editorPane_1);
		System.out.println(Aid);
		
		
		JButton btnSubmitScore = new JButton("SUBMIT");

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
				      String review =editorPane_1.getText().toString();
				      int val = Integer.parseInt(score);
				      if(score.length()==0 || review.length()==0)
				      {
				    	  JOptionPane.showMessageDialog(frame,"field is empty");
				    	  return;
				      }
				      else
				      {
				    	  sql = "insert into Evaluation " + "values(?,?,?,?,?)";
					      stmt = conn.prepareStatement(sql);
					      stmt.setInt(1,Aid);
					      stmt.setString(2,pid);
					      stmt.setString(3,jEmail);
					      stmt.setInt(4,val);
					      stmt.setString(5, review);
					      
					      stmt.execute();
					  
					      stmt.close();
					      conn.close();
					      JOptionPane.showMessageDialog(frame,"submitted successfully");
				    	  
				      }
				      
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
				
				editorPane.setText("");
				editorPane_1.setText("");
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
		
		final JMenuBar menuBar = new JMenuBar();
		//
//			      //create menus
			      JMenu ActivityMenu = new JMenu(" Activity");
//			      JMenu upcomingMenu = new JMenu("Upcoming Activity"); 
//			      final JMenu pastMenu = new JMenu("Past Activity");
			      final JMenu ParticipantMenu = new JMenu("My account");
			      final JMenu AddMenu = new JMenu("Add Activity");
			      final JMenu JudgeMenu = new JMenu("Judge Portal");
			      final JMenu UpdateMenu = new JMenu("Update Activity");
			     
			      menuBar.add(ActivityMenu);
//			      menuBar.add(upcomingMenu);
//			      menuBar.add(pastMenu);       
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
