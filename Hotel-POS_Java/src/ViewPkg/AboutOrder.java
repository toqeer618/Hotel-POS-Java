package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class AboutOrder extends JFrame {
	private JPanel contentPane;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutOrder frame = new AboutOrder();
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
	public AboutOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 393);
		getContentPane().setLayout(null);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnCancelOrder.setBackground(Color.red);
			}
		});
	
		
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelOrder.setBounds(246, 169, 129, 47);
		btnCancelOrder.setForeground(Color.BLACK);
		btnCancelOrder.setBackground(Color.CYAN);
		contentPane.add(btnCancelOrder);
		
		 btnNewButton = new JButton("Update Order");
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(246, 238, 129, 47);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnNewButton.setBackground(Color.orange);
			}
		});
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confirm Order");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(246, 307, 129, 47);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnNewButton_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(140, 23, 332, 41);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Operator Menu");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(246, 103, 137, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(498, 435, 89, 23);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(10, 438, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel_1.setBounds(0, 0, 593, 466);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
