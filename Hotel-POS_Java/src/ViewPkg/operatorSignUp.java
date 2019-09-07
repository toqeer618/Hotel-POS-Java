package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;






public class operatorSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtCNIC;
	private JLabel lblPassword;
	private JLabel lblPhoneNo;
	private JLabel lblCnic;
	private JLabel lblGender;
	private JLabel lblAddress;
	private JButton btnCreate;
	private JPasswordField password;
	private JComboBox cmbGender;
	private JTextArea txtAdress;
	private JLabel label;
	private JLabel lblOperatorSignup;
	private JButton btnBack;
	private JButton btnHome;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					operatorSignUp frame = new operatorSignUp();
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
	public operatorSignUp() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(234, 93, 159, 30);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblId = new JLabel("Operater ID :");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblId.setBounds(104, 90, 105, 30);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(104, 136, 58, 21);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setBounds(234, 134, 159, 30);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(234, 224, 159, 30);
		contentPane.add(txtPhone);
		
		txtCNIC = new JTextField();
		txtCNIC.setColumns(10);
		txtCNIC.setBounds(234, 265, 159, 30);
		contentPane.add(txtCNIC);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(104, 175, 90, 25);
		contentPane.add(lblPassword);
		
		lblPhoneNo = new JLabel("Phone No :");
		lblPhoneNo.setForeground(Color.WHITE);
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhoneNo.setBounds(104, 224, 90, 25);
		contentPane.add(lblPhoneNo);
		
		lblCnic = new JLabel("CNIC :");
		lblCnic.setForeground(Color.WHITE);
		lblCnic.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCnic.setBounds(104, 267, 58, 21);
		contentPane.add(lblCnic);
		
		lblGender = new JLabel("Gender :");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGender.setBounds(104, 303, 71, 30);
		contentPane.add(lblGender);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddress.setBounds(104, 347, 90, 25);
		contentPane.add(lblAddress);
		
		btnCreate = new JButton("Create");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBackground(Color.BLACK);
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreate.setBounds(234, 436, 159, 30);
		contentPane.add(btnCreate);
		
		password = new JPasswordField();
		password.setBounds(234, 175, 159, 30);
		contentPane.add(password);
		
		 txtAdress = new JTextArea();
		txtAdress.setBounds(234, 347, 159, 78);
		contentPane.add(txtAdress);
		
		 cmbGender = new JComboBox();
		 cmbGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		cmbGender.setBounds(234, 306, 159, 30);
		contentPane.add(cmbGender);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(119, 0, 332, 41);
		contentPane.add(label);
		
		lblOperatorSignup = new JLabel("Operator Signup");
		lblOperatorSignup.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblOperatorSignup.setForeground(Color.BLUE);
		lblOperatorSignup.setBounds(187, 52, 193, 30);
		contentPane.add(lblOperatorSignup);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(10, 443, 89, 23);
		contentPane.add(btnBack);
		
		btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(471, 443, 89, 23);
		contentPane.add(btnHome);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 566, 474);
		contentPane.add(lblNewLabel);
	}
	public String getID()
	{
		return txtID.getText();
	}
	public String getName()
	{
		return txtName.getText();
	}
	public String getCNIC()
	{
		return txtCNIC.getText();
	}
	public String getPassword()
	{
		return password.getText();
	}
	public String getPhone()
	{
		return txtPhone.getText();
	}
	
	public String getGender()
	{
		return cmbGender.getSelectedItem().toString();
	}
	public String getAddress()
	{
		return txtAdress.getText();
	}
	public void btnCreateActListner(ActionListener act)
	{
		btnCreate.addActionListener(act);
	}
	

	
}
