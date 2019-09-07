package ViewPkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CreateCustomer extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel label = new JLabel("Customer Sign Up");
	private JTextField txtID;
	private JTextField txtName;
	private JButton btnSave;
	private JTextArea textArea;
	private JComboBox comboBox;
	private JLabel label_1;
	private JLabel lblAddress;
	private JButton btnHome;
	private JButton btnBack;
	private JLabel lblNewLabel;
	public static void main(String[] args) {
			
					CreateCustomer frame = new CreateCustomer();
					frame.setVisible(true);
	}

	
	public CreateCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(178, 63, 169, 31);
		contentPane.add(label);
		
		txtID = new JTextField();
		txtID.setBounds(118, 130, 122, 31);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(279, 130, 122, 31);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		 textArea = new JTextArea();
		textArea.setBounds(118, 232, 283, 94);
		contentPane.add(textArea);
		
		JLabel lblEnterCustomerId = new JLabel("Enter Customer ID");
		lblEnterCustomerId.setForeground(Color.WHITE);
		lblEnterCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterCustomerId.setBounds(118, 105, 131, 14);
		contentPane.add(lblEnterCustomerId);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setForeground(Color.WHITE);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerName.setBounds(279, 109, 131, 14);
		contentPane.add(lblCustomerName);
		
		 btnSave = new JButton("Create Customer");
		 btnSave.setBackground(Color.BLACK);
		 btnSave.setForeground(Color.WHITE);
		 btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(208, 337, 122, 23);
		contentPane.add(btnSave);
		
		 comboBox = new JComboBox();
		 comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		comboBox.setBounds(208, 172, 122, 20);
		contentPane.add(comboBox);
		
		label_1 = new JLabel("THE CONQUERORS FAST FOOD");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label_1.setBounds(99, 11, 332, 41);
		contentPane.add(label_1);
		
		lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(118, 202, 122, 18);
		contentPane.add(lblAddress);
		
		btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(405, 340, 89, 23);
		contentPane.add(btnHome);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(10, 340, 89, 23);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 500, 373);
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
	public String getGender()
	{
		return comboBox.getSelectedItem().toString();
	}
	public String getAddress()
	{
		return textArea.getText();
	}
	public void btnSaveCustomerActListner(ActionListener act)
	{
		btnSave.addActionListener(act);
	}
	
public void btnHomeAct(ActionListener cal) {
		
        btnHome.addActionListener(cal);
        
    }
	public void btnBackAct(ActionListener cal) {
		
        btnBack.addActionListener(cal);
        
    }
}
