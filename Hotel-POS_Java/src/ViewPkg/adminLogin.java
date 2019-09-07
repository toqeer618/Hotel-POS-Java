package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class adminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JPasswordField pasAdmin;
	private JButton btnLogIn ;
	private JLabel lblNewLabel_1;
	private JButton btnForgetPassword ;
	
	/**
	 * Create the frame.
	 */
	public adminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textId = new JTextField();
		textId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textId.setBounds(212, 114, 156, 23);
		contentPane.add(textId);
		textId.setColumns(10);
		
		 btnLogIn = new JButton("Log In");
		 btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogIn.setForeground(Color.BLACK);
		btnLogIn.setBackground(Color.GREEN);
		btnLogIn.setBounds(251, 231, 89, 23);
		contentPane.add(btnLogIn);
		
		pasAdmin = new JPasswordField();
		pasAdmin.setBounds(212, 173, 156, 23);
		contentPane.add(pasAdmin);
		
		JLabel lblAdminId = new JLabel("Admin Id");
		lblAdminId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdminId.setForeground(Color.WHITE);
		lblAdminId.setBounds(212, 88, 68, 14);
		contentPane.add(lblAdminId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(212, 148, 102, 14);
		contentPane.add(lblPassword);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setBackground(new Color(0, 100, 0));
		lblAdminLogin.setForeground(Color.BLUE);
		lblAdminLogin.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblAdminLogin.setBounds(230, 63, 116, 14);
		contentPane.add(lblAdminLogin);
		
		lblNewLabel_1 = new JLabel("THE CONQUERORS FAST FOOD");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(129, 11, 332, 41);
		contentPane.add(lblNewLabel_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(467, 315, 89, 23);
		contentPane.add(btnHome);
		
		 btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.setBounds(132, 318, 236, 21);
		contentPane.add(btnForgetPassword);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Hamza\\Downloads\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		label.setBounds(0, 0, 574, 370);
		contentPane.add(label);
	}
	public void setEmpty()
	{
		textId.setText("");
		pasAdmin.setText("");
	}
	public void btnLoginActListner(ActionListener act)
	{	
		btnLogIn.addActionListener(act);
	}
	public String getID()
	{
		
		return textId.getText();
		
	}
	public String getPassword()
	{	
		return pasAdmin.getText();
		
	}
	
	public void btnForgetPasActListner(ActionListener act)
	{	
		btnForgetPassword.addActionListener(act);
	}
}
