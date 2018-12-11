import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import com.sun.prism.paint.Color;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class testgui {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   Connection conn = null;
	   Statement stmt = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testgui window = new testgui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testgui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuItem menuItem = new JMenuItem("");
		menuItem.setBounds(37, 12, 129, 19);
		frame.getContentPane().add(menuItem);
		
		Button current = new Button("Current");
		current.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		current.setBounds(80, 37, 86, 23);
		frame.getContentPane().add(current);
		
		Button past = new Button("Past");
		past.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		past.setBounds(172, 37, 86, 23);
		frame.getContentPane().add(past);
		
		Button Upcoming = new Button("Upcoming");
		
		
		Upcoming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		Upcoming.setBounds(264, 37, 86, 23);
		frame.getContentPane().add(Upcoming);
		
		JButton btnAddActivity = new JButton("ADD ACTIVITY");
		btnAddActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							addActivity window = new addActivity();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnAddActivity.setBounds(609, 722, 148, 25);
		frame.getContentPane().add(btnAddActivity);
		
		JButton btnJudgePortal = new JButton("JUDGE PORTAl");
		btnJudgePortal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnJudgePortal.setBounds(233, 334, 198, 25);
		frame.getContentPane().add(btnJudgePortal);
		
		JButton btnUpdateActivity = new JButton("UPDATE Activity");
		btnUpdateActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Verification window = new Verification();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			
			}
		});
		btnUpdateActivity.setBounds(233, 477, 198, 25);
		frame.getContentPane().add(btnUpdateActivity);

		
		
		
		 
		
	}
}
