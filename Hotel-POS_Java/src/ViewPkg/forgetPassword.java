package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class forgetPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSave ;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgetPassword frame = new forgetPassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public forgetPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterId = new JLabel("Enter ID:");
		lblEnterId.setBounds(24, 47, 46, 13);
		contentPane.add(lblEnterId);
		
		textField = new JTextField();
		textField.setBounds(156, 44, 154, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setBounds(24, 106, 97, 13);
		contentPane.add(lblEnterPassword);
		
		JLabel lblConfirmPasword = new JLabel("Confirm Pasword");
		lblConfirmPasword.setBounds(24, 159, 84, 13);
		contentPane.add(lblConfirmPasword);
		
		 btnSave = new JButton("Save");
		btnSave.setBounds(225, 236, 85, 21);
		contentPane.add(btnSave);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(320, 159, 158, 13);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 103, 154, 19);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(156, 159, 154, 19);
		contentPane.add(passwordField_1);
	}
	
	public void btnSaveActionListner(ActionListener act)
	{
		btnSave.addActionListener(act);
	}
	public String getID()
	{
		return textField.getText();
	}
	public String getfPassword()
	{
		return passwordField.getText();
	}
	public String getSPassword()
	{
		return passwordField_1.getText();
	}
}
