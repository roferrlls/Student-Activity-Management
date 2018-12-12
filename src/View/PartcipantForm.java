package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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

import javax.swing.JList;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPasswordField;

import Controller.PartcipantFormController;
import Model.Participant;

import javax.swing.JComboBox;

public class PartcipantForm {

	public JFrame frame;
	   public int Aid;
	   public String Pid;
	   public String pass=null;
	   private JPasswordField passwordField;

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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		//frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Serif", Font.PLAIN, 14));

		lblEmail.setBounds(48, 58, 208, 28);
		frame.getContentPane().add(lblEmail);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(310, 58, 181, 21);
		frame.getContentPane().add(editorPane_1);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setToolTipText("");
		lblName.setFont(new Font("Serif", Font.PLAIN, 14));
		lblName.setBounds(48, 97, 208, 28);
		frame.getContentPane().add(lblName);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(310, 97, 181, 21);
		frame.getContentPane().add(editorPane_2);
		
		JLabel lblNewLabel = new JLabel("PHONE NUMBER");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNewLabel.setBounds(48, 136, 154, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BATCH");
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(48, 191, 90, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Serif", Font.PLAIN, 14));
		lblPassword.setBounds(48, 244, 90, 14);
		frame.getContentPane().add(lblPassword);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(310, 145, 183, 20);
		frame.getContentPane().add(editorPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(310, 239, 109, 21);
		frame.getContentPane().add(passwordField);
		
		String batch[]= {"Y15","Y16","Y17","Y18","PG"};
		JComboBox comboBox = new JComboBox(batch);
		comboBox.setBounds(310, 190, 57, 20);
		frame.getContentPane().add(comboBox);
		
		
		JButton btnSubmit = new JButton("REGISTER");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      String email = editorPane_1.getText().toString();
				      String name =  editorPane_2.getText().toString();
				      String phno = editorPane.getText().toString();
					  String batch= String.valueOf(comboBox.getItemAt(comboBox.getSelectedIndex()));
					  pass = new String(passwordField.getPassword());
					  Participant par = new Participant(Pid,email, name, phno, batch, pass);
					  PartcipantFormController.insertParticipant(par, Aid);
					  frame.dispose();

			}
		});	
		btnSubmit.setBounds(147, 313, 163, 25);
		frame.getContentPane().add(btnSubmit);
		


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