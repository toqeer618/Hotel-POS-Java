 package ViewPkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainPkg.Main;
import MainPkg.adminMain;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class FrontPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPage frame = new FrontPage();
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
	public FrontPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdminLogin = new JButton("Admin");
		btnAdminLogin.setForeground(new Color(255, 255, 255));
		btnAdminLogin.setBackground(new Color(0, 0, 0));
		btnAdminLogin.setIcon(null);
		btnAdminLogin.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminMain frame = new adminMain();
				frame.main("");
				setVisible(false);
			}
		});
		btnAdminLogin.setBounds(38, 303, 168, 38);
		contentPane.add(btnAdminLogin);
		
		JButton btnNewButton_1 = new JButton("Operator Login");
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main ma=new Main();
				try {
						ma.main("Hello");
						setVisible(false);
				} catch (SQLException e1) {
					JOptionPane.showConfirmDialog(null,"Hello");
				}
				
			}
		}); 
		btnNewButton_1.setBounds(425, 303, 141, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTheC = new JLabel("THE CONQUERORS FAST FOOD");
		lblTheC.setForeground(Color.WHITE);
		lblTheC.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 20));
		lblTheC.setBounds(162, 29, 308, 105);
		contentPane.add(lblTheC);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 618, 372);
		contentPane.add(lblNewLabel);
	}
}
