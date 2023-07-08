package projectpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Login extends JFrame {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login window = new Login();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		Login window = new Login();
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setBounds(425, 200, 519, 335);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBackground(new Color(255, 250, 250));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 32));
		lblNewLabel.setBounds(168, 45, 113, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(192, 99, 131, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel login = new JLabel("PASSWORD");
		login.setForeground(UIManager.getColor("ColorChooser.background"));
		login.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		login.setBounds(192, 159, 89, 28);
		frame.getContentPane().add(login);
		
		username = new JTextField();
		username.setBounds(221, 128, 128, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(221, 186, 128, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");`
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			
			 	
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
					Statement stmt=con.createStatement();
					String query1="Select * from register where USERNAME='"+username.getText()+"' and PASSWORD='"+password.getText()+"'";
					System.out.println(query1);
					ResultSet rs=stmt.executeQuery(query1);
					if(rs.next())
					{
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null,"Login Successfully!!");
 						Eventreg ereg= new Eventreg(rs.getInt("userid"));
						ereg.setVisible(true);
						setVisible(false);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Login Failed!!");
						
					}
						
				}
				catch(Exception e5)
				{
					System.out.println(e5);
				}

				
			}

	
		});
		btnNewButton.setBounds(328, 232, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setBounds(148, 232, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\purple-big-bubbles-wallpaper-preview.jpg"));
		lblNewLabel_2.setBounds(0, 0, 503, 296);
		frame.getContentPane().add(lblNewLabel_2);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new register().setVisible(true);
				frame.setVisible(false);
				
			}
		});
		frame.setVisible(true);
		
	}
}
