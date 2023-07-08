package projectpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class register extends JFrame{

	private JFrame frame;
	private JTextField name;
	private JTextField username;
	private JTextField address;
	private JTextField phone;
	private JPasswordField passwordField;
	private JPasswordField confirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
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
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().setBackground(UIManager.getColor("Button.shadow"));
		frame.setBounds(425, 200, 563, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel register = new JLabel(" REGISTER NOW");
		register.setFont(new Font("Rockwell", Font.PLAIN, 25));
		register.setBounds(128, 11, 200, 35);
		frame.getContentPane().add(register);
		
		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Name.setBounds(118, 75, 46, 14);
		frame.getContentPane().add(Name);
		
		name = new JTextField();
		name.setBounds(234, 72, 140, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(234, 103, 140, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Username.setBounds(118, 100, 66, 27);
		frame.getContentPane().add(Username);
		
		JLabel Address = new JLabel("Address");
		Address.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Address.setBounds(118, 147, 46, 14);
		frame.getContentPane().add(Address);
		
		address = new JTextField();
		address.setBounds(234, 134, 140, 35);
		frame.getContentPane().add(address);
		address.setColumns(10);
		
		JLabel Phone = new JLabel("Phone");
		Phone.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Phone.setBounds(118, 183, 46, 14);
		frame.getContentPane().add(Phone);
		
		phone = new JTextField();
		phone.setBounds(234, 180, 140, 20);
		frame.getContentPane().add(phone);
		phone.setColumns(10);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Password.setBounds(118, 208, 66, 14);
		frame.getContentPane().add(Password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(234, 205, 140, 20);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JLabel Confirmpassword = new JLabel("confirm password");
		Confirmpassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Confirmpassword.setBounds(118, 233, 101, 14);
		frame.getContentPane().add(Confirmpassword);
		
		confirm = new JPasswordField();
		confirm.setBounds(234, 230, 140, 20);
		frame.getContentPane().add(confirm);
		confirm.setColumns(10);
		
		JButton submit = new JButton("Register");
		submit.setBackground(new Color(255, 250, 250));
		submit.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		submit.setBounds(365, 261, 89, 23);
		frame.getContentPane().add(submit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(186, 85, 211));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\photo-1617957689233-207e3cd3c610.jpeg"));
		lblNewLabel.setBounds(0, 0, 547, 297);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String passwd=passwordField.getText();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
					Statement stmt=con.createStatement();
					String query="Select count(userid)from register";
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int uid=rs.getInt(1);
					int newuid=uid+1;
					String sql="insert into register values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, newuid);
					ps.setString(2, name.getText());
					ps.setString(3, username.getText());
					ps.setString(4, address.getText());
					ps.setInt(5, Integer.parseInt(phone.getText()));
					ps.setString(6,passwd);
					
					try
					{
					int i=ps.executeUpdate();
					String q1="select  max(userid) from register";
					ResultSet rs1=stmt.executeQuery(q1);
					new Eventreg(newuid).setVisible(true);
					frame.setVisible(false);
					System.out.println(i);
					}
					catch(Exception e2) 
					{
					System.out.println(e2); 
					}
				}
				catch(Exception e3) 
				{
				System.out.println(e3); 
				}
				
			}
		});
		}
	 

	}
