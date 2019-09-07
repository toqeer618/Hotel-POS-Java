package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Verification extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustID;
	private JButton btnSubmit;
	private JLabel label;
	private JButton btnHome;
	private JButton btnBack;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Verification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCustID = new JTextField();
		txtCustID.setBounds(175, 157, 149, 23);
		contentPane.add(txtCustID);
		txtCustID.setColumns(10);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerId.setBounds(62, 148, 80, 37);
		contentPane.add(lblCustomerId);
		
		 btnSubmit = new JButton("Submit");
		 btnSubmit.setBackground(Color.GREEN);
		 btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBounds(197, 190, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblCoustomVrification = new JLabel("Coustomer Vrification");
		lblCoustomVrification.setForeground(Color.BLUE);
		lblCoustomVrification.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblCoustomVrification.setBounds(123, 84, 201, 37);
		contentPane.add(lblCoustomVrification);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(174, 10, 332, 41);
		contentPane.add(label);
		
		btnHome = new JButton("Home");
		btnHome.setBackground(Color.BLACK);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setForeground(Color.WHITE);
		btnHome.setBounds(341, 232, 89, 23);
		contentPane.add(btnHome);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(10, 232, 89, 23);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 729, 502);
		contentPane.add(lblNewLabel);
	}
	public String getID()
	{
		return txtCustID.getText();
	}
	
	public void addSubmitListener(ActionListener cal) {
		txtCustID.setText("");
        btnSubmit.addActionListener(cal);
        
    }
	public void btnHomeAct(ActionListener cal) {
		
        btnHome.addActionListener(cal);
        
    }
	public void btnBackAct(ActionListener cal) {
		
        btnBack.addActionListener(cal);
        
    }
}
