package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class optionFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnTakeOrder;
	private JLabel label;
	private JLabel lblOperatorManu;
	private JButton btnBack;
	private JButton btnHome;
	private JLabel lblNewLabel;
	private JButton btnAddCustomer;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public optionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnTakeOrder = new JButton("Take Order");
		 btnTakeOrder.setBackground(Color.CYAN);
		 btnTakeOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTakeOrder.setBounds(266, 158, 125, 23);
		contentPane.add(btnTakeOrder);
		
		btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setBackground(Color.CYAN);
		btnAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		btnAddCustomer.setBounds(266, 215, 125, 23);
		contentPane.add(btnAddCustomer);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(176, 10, 332, 41);
		contentPane.add(label);
		
		lblOperatorManu = new JLabel("Operator Manu");
		lblOperatorManu.setForeground(Color.BLUE);
		lblOperatorManu.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblOperatorManu.setBounds(243, 76, 167, 23);
		contentPane.add(lblOperatorManu);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(10, 446, 89, 23);
		contentPane.add(btnBack);
		
		btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(571, 446, 89, 23);
		contentPane.add(btnHome);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 670, 487);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("New button");
		button.setBounds(278, 432, 85, 21);
		contentPane.add(button);
		
	
		
	}

	public void addTakeButtonListner(ActionListener act)
	{
		btnTakeOrder.addActionListener(act);
	}
	
	public void btnAddCust(ActionListener act)
	{
		btnAddCustomer.addActionListener(act);
	}
}
