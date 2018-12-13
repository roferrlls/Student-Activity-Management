package View;

import java.util.Date;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;

import com.toedter.calendar.JDateChooser;

import dbAccess.addActivityController;
import Model.Activity;

import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class addActivity {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   public int id =0;
	   public String uid;

	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   Statement stmt1 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public addActivity() {
		
		initialize();
	}
	public addActivity(String val) {
		uid = val;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Activity");
		frame.getContentPane().setBackground(new Color(255, 192, 203));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		//frame.setBounds(700, 700,700, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(310, 63, 349, 28);
		frame.getContentPane().add(editorPane);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Serif", Font.PLAIN, 14));

		lblName.setBounds(47, 76, 70, 15);
		frame.getContentPane().add(lblName);
		
//		JLabel lblDate = new JLabel("DATE(yyyy - mm - dd)");
//		lblDate.setFont(new Font("Serif", Font.PLAIN, 14));
//
//		lblDate.setBounds(48, 122, 208, 28);
//		frame.getContentPane().add(lblDate);
//		
//		JEditorPane editorPane_1 = new JEditorPane();
//		editorPane_1.setBounds(310, 129, 181, 21);
//		frame.getContentPane().add(editorPane_1);
//		
//		JLabel lblDateyyyytimeDd = new JLabel("TIME(hh:mm::ss)");
//		lblDateyyyytimeDd.setToolTipText("");
//		lblDateyyyytimeDd.setFont(new Font("Serif", Font.PLAIN, 14));
//		lblDateyyyytimeDd.setBounds(48, 188, 208, 28);
//		frame.getContentPane().add(lblDateyyyytimeDd);
//		
//		JEditorPane editorPane_2 = new JEditorPane();
//		editorPane_2.setBounds(310, 184, 181, 21);
//		frame.getContentPane().add(editorPane_2);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Serif", Font.PLAIN, 14));

		lblDate.setBounds(48, 122, 208, 28);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(0, 128, 0));
		dateChooser.setBounds(314, 122, 192, 28);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblDateyyyytimeDd = new JLabel("TIME(hh:mm::ss)");
		lblDateyyyytimeDd.setToolTipText("");
		lblDateyyyytimeDd.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDateyyyytimeDd.setBounds(48, 188, 208, 28);
		frame.getContentPane().add(lblDateyyyytimeDd);
		
		
		
		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		timeSpinner.setBackground(Color.LIGHT_GRAY);
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		timeSpinner.setBounds(310, 180, 196, 28);
		frame.getContentPane().add(timeSpinner);

		
		
		
		
		JLabel lblVenue = new JLabel("VENUE");
		lblVenue.setFont(new Font("Serif", Font.PLAIN, 14));
		lblVenue.setBounds(47, 248, 70, 15);
		frame.getContentPane().add(lblVenue);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setBounds(310, 235, 349, 28);
		frame.getContentPane().add(editorPane_3);
		
		JLabel lblExpectedAudience = new JLabel("EXPECTED AUDIENCE");
		lblExpectedAudience.setFont(new Font("Serif", Font.PLAIN, 14));
		lblExpectedAudience.setBounds(47, 302, 173, 15);
		frame.getContentPane().add(lblExpectedAudience);
		
		JEditorPane editorPane_4 = new JEditorPane();
		editorPane_4.setBounds(310, 296, 181, 21);
		frame.getContentPane().add(editorPane_4);
		
		JLabel lblContactDetails = new JLabel("CONTACT DETAILS");
		lblContactDetails.setFont(new Font("Serif", Font.PLAIN, 14));
		lblContactDetails.setBounds(47, 351, 173, 15);
		frame.getContentPane().add(lblContactDetails);
		
		JEditorPane editorPane_5 = new JEditorPane();
		editorPane_5.setBounds(310, 345, 181, 21);
		frame.getContentPane().add(editorPane_5);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDescription.setBounds(47, 421, 173, 15);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblDeadlineDate = new JLabel("DEADLINE DATE");
		lblDeadlineDate.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDeadlineDate.setBounds(47, 488, 158, 15);
		frame.getContentPane().add(lblDeadlineDate);
		

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBackground(new Color(0, 128, 0));
		dateChooser_1.setBounds(314, 475, 192, 28);
		frame.getContentPane().add(dateChooser_1);
		
		

		
		JEditorPane editorPane_6 = new JEditorPane();
		editorPane_6.setBounds(310, 407, 459, 43);
		frame.getContentPane().add(editorPane_6);
		
		JButton btnAddJudge = new JButton("ADD judge");
		btnAddJudge.setBounds(284, 732, 117, 25);
		frame.getContentPane().add(btnAddJudge);
		
		String[] club = {"Quizzinga","LC"};
		JComboBox comboBox = new JComboBox(club);
		comboBox.setBounds(418, 558, 132, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("CLUB");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNewLabel.setBounds(63, 563, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(61, 590, 117, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		String[] dept = {"CSE","ECE","CCE"};
		JComboBox comboBox_1 = new JComboBox(dept);
		comboBox_1.setBounds(418, 590, 132, 24);
		frame.getContentPane().add(comboBox_1);
		
		JButton Submit = new JButton("SUBMIT");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = editorPane.getText().toString();
//				String date =  editorPane_1.getText().toString();
//				String time = editorPane_2.getText().toString();
				// getting date

				String whole = dateChooser.getDate().toString();
			
			//	String whole = dateChooser.getDate().toString();				

				String date = whole.substring(24,28);
				String m = null;
				date = date + "-";
				String month = whole.substring(4,7);
				String[] tp = new String[12];
				tp[0] = "Jan";
				tp[1] = "Feb";
				tp[2] = "Mar";
				tp[3] = "Aprr";
				tp[4] = "May";
				tp[5] = "Jun";
				tp[6] = "Jul";
				tp[7] = "Aug";
				tp[8] = "Sep";
				tp[9] = "Oct";
				tp[10] = "Nov";
				tp[11] = "Dec";
				for(int i=0;i<12;i++) {
					if(tp[i].equals(month)) {
						m = Integer.toString(i+1);
					}
				}
				if(m.length() == 1) {
					m = "0" + m;
				}
				date = date + m;
				String day = whole.substring(8,10);
				date = date + "-" + day;
				//System.out.println(date);
				
	
				
				
				//getting deadline
				whole = dateChooser_1.getDate().toString();
				String ddate = whole.substring(24,28);
				m = null;
				ddate = ddate + "-";
				String dmonth = whole.substring(4,7);
				
				for(int i=0;i<12;i++) {
					if(tp[i].equals(dmonth)) {
						m = Integer.toString(i+1);
					}
				}
				if(m.length() == 1) {
					m = "0" + m;
				}
				ddate = ddate + m;
				String dday = whole.substring(8,10);
				ddate = ddate + "-" + dday;
				
				

				//getting time
				
				String val=timeSpinner.getValue().toString();
				String time=val.substring(11,19);
				
				String venue = editorPane_3.getText().toString();
				String exaud = editorPane_4.getText().toString();
				int contact;
				String value = editorPane_5.getText().toString();
				try {
			    	  contact = Integer.parseInt(editorPane_5.getText().toString());
			      }catch(NumberFormatException ee) {
			    	  JOptionPane.showMessageDialog(frame,"Contact Field Is Invalid");  
						return;
			      }
				String description = editorPane_6.getText().toString();
				String club = String.valueOf(comboBox.getItemAt(comboBox.getSelectedIndex()));
				String dept = String.valueOf(comboBox_1.getItemAt(comboBox_1.getSelectedIndex()));
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
				if(exaud.length() == 0) {
					JOptionPane.showMessageDialog(frame,"expected Audience field is empty");  
					return;
				}
				if(value.length() != 10) {
					JOptionPane.showMessageDialog(frame,"contact field is Invalid");  
					return;
				}
				if(description.length() == 0) {
					JOptionPane.showMessageDialog(frame,"description field is empty");  
					return;
				}
				if(club.length() == 0) {
					club = "";
				}
				if(dept.length() == 0) {
					dept="";  
				}
				if(ddate.length() == 0) {
					JOptionPane.showMessageDialog(frame,"Deadline field is empty");  
					return;
				}
				Activity activity =new Activity(name,time, date, venue, description, exaud, club,
		     			dept, value, ddate);
				addActivityController.insertDetails(activity, uid);
				
				
				EventQueue.invokeLater(new Runnable() {
						public void run() {
						try {
							Features window = new Features(id);
							window.frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		Submit.setBounds(224, 609, 145, 43);
		frame.getContentPane().add(Submit);
		
		
//		JDateChooser dateChooser_1 = new JDateChooser();
//		dateChooser_1.setBackground(new Color(0, 128, 0));
//		dateChooser_1.setBounds(314, 475, 192, 28);
//		frame.getContentPane().add(dateChooser_1);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
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
