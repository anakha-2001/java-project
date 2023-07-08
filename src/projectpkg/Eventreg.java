package projectpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Eventreg extends JFrame{

	private JFrame frame;
	
	private JTextField textField_2;
	private JTextField textField_venue;
	private JTextField textField_date;
	private JTextField textField_time;
	JTextField textField_name;
	static int uid2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eventreg window = new Eventreg(uid2);
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
	
	public Eventreg(int id) {
		uid2=id;
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
			Statement stmt=con.createStatement();
			String query="Select * from register where userid = '"+uid2+"'";
			System.out.println(query);
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			System.out.print(rs.getString(2));
			//textField_name.setText(rs.getString(2));
				//textArea.getString(4);
				//textField_2.getInt(5);
				
			
			
		}
		catch(Exception e8)
		{
			System.out.println(e8);
		}
		frame.setBounds(425, 250, 490, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
			textField_name = new JTextField();
			textField_name.setBounds(104, 28, 131, 20);
			frame.getContentPane().add(textField_name);
		
		JLabel lblNewLabel = new JLabel("Event ");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 25));
		lblNewLabel.setBounds(245, 67, 191, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Event Date");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(24, 194, 70, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Event Time");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(24, 222, 70, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Event");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(24, 162, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(24, 31, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(24, 67, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(24, 112, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Venue");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(24, 137, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Registration");
		lblNewLabel_8.setForeground(new Color(255, 250, 250));
		lblNewLabel_8.setFont(new Font("Segoe Script", Font.BOLD, 25));
		lblNewLabel_8.setBounds(257, 109, 179, 26);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 106, 131, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_venue = new JTextField();
		textField_venue.setBounds(104, 134, 131, 20);
		frame.getContentPane().add(textField_venue);
		textField_venue.setColumns(10);
		
		textField_date = new JTextField();
		textField_date.setBounds(104, 191, 131, 20);
		frame.getContentPane().add(textField_date);
		textField_date.setColumns(10);
		
		textField_time = new JTextField();
		textField_time.setBounds(104, 219, 131, 20);
		frame.getContentPane().add(textField_time);
		textField_time.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(104, 59, 131, 36);
		frame.getContentPane().add(textArea);
		
		String str[]= {"Select","Wedding","Birthday","Anniversary","Business Party","Success Party","Others"};
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(104, 158, 131, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
					Statement stmt=con.createStatement();
					String query1="Select max(userid) from register";
					System.out.println(query1);
					ResultSet rs=stmt.executeQuery(query1);
					rs.next();
					int qwe=rs.getInt(1)+1;
					String query2="insert into event values('"+qwe+"','"+uid2+"','"+textField_venue .getText()+"','"+comboBox.getSelectedItem().toString()+"','"+textField_date.getText()+"','"+textField_time.getText()+"')";
					int rseult=stmt.executeUpdate(query2);
					
					if(rseult==0)
					{
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null,"Registered Successfully!!");
						//new Submit().setVisible(false);
						setVisible(false);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Registration Failed!!");
						
					}
						
				}
				catch(Exception e5)
				{
					System.out.println(e5);
				}

	
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(367, 218, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("Further details DM:msccs2206@rajagiri.edu");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_9.setBounds(245, 174, 234, 28);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\images.png"));
		lblNewLabel_10.setBounds(0, 0, 489, 262);
		getContentPane().add(lblNewLabel_10);
		frame.setVisible(true);	
	}
}
