package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JDesktopPane;

public class OperatorLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JButton btnLogin;
	private JPasswordField passwordField;
	private JLabel lblOperatorLogIn;
	private JLabel label;
	private JButton btnHome;
	private JButton btnForgetPassword;
	private JLabel label_1;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public OperatorLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(134, 194, 46, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(296, 194, 154, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(124, 259, 62, 14);
		contentPane.add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setBounds(280, 313, 89, 23);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(296, 259, 154, 20);
		contentPane.add(passwordField);
		
		lblOperatorLogIn = new JLabel("Operator Log In");
		lblOperatorLogIn.setForeground(Color.BLUE);
		lblOperatorLogIn.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblOperatorLogIn.setBounds(162, 78, 207, 20);
		contentPane.add(lblOperatorLogIn);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(82, 11, 332, 41);
		contentPane.add(label);
		
		btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(560, 439, 89, 23);
		contentPane.add(btnHome);
		
		btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.setBounds(230, 442, 220, 21);
		contentPane.add(btnForgetPassword);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Hamza\\Downloads\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		label_1.setBounds(0, 0, 669, 472);
		contentPane.add(label_1);
	}
	public void addLoginListener(ActionListener cal) {
		
		
			btnLogin.addActionListener(cal);
		
    }
	public String getID()
	{
		return txtId.getText();
	}
	public String getPassword()
	{
		return passwordField.getText();
	}
	public void btnForgetPasActListner(ActionListener act)
	{	
		btnForgetPassword.addActionListener(act);
	}
}
