package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainPkg.MonthlyGraph;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

public class adminOptions extends JFrame {

	private JPanel contentPane;
	private JButton btnItemsFeature;
	private JButton btnAddOperatotor;
	private JButton btnremOp;
	private JButton btnRemoveCustomer;
	private JButton btnDeals ;
	private JButton btnMonthlySalesGraph;
	private JButton btnLogOut ;
	private JButton btnNewButton;
	private JLabel label;
	private JButton btnHome;
	private JLabel lblName;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public adminOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnItemsFeature = new JButton("Items Feature");
		btnItemsFeature.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnItemsFeature.setBackground(Color.CYAN);
		btnItemsFeature.setBounds(72, 190, 175, 36);
		contentPane.add(btnItemsFeature);
		
	    btnAddOperatotor = new JButton("Add Operatotor");
	    btnAddOperatotor.setBackground(Color.CYAN);
	    btnAddOperatotor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddOperatotor.setBounds(357, 141, 175, 36);
		contentPane.add(btnAddOperatotor);
		
	    btnremOp = new JButton("Remove Operator");
	    btnremOp.setBackground(Color.CYAN);
	    btnremOp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnremOp.setBounds(72, 237, 175, 36);
		contentPane.add(btnremOp);
		
	    btnRemoveCustomer = new JButton("Remove Customer");
	    btnRemoveCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnRemoveCustomer.setBackground(Color.CYAN);
		btnRemoveCustomer.setBounds(357, 190, 175, 36);
		contentPane.add(btnRemoveCustomer);
		
		btnDeals = new JButton("Add Deals");
		btnDeals.setBackground(Color.CYAN);
		btnDeals.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeals.setBounds(72, 284, 175, 36);
		contentPane.add(btnDeals);
		
		btnMonthlySalesGraph = new JButton("Monthly Sales Graph");
		btnMonthlySalesGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MonthlyGraph mG= new MonthlyGraph();
				mG.Calling();
			}
		});
		btnMonthlySalesGraph.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMonthlySalesGraph.setBackground(Color.CYAN);
		btnMonthlySalesGraph.setBounds(357, 237, 175, 36);
		contentPane.add(btnMonthlySalesGraph);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(Color.RED);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBounds(257, 439, 127, 36);
		contentPane.add(btnLogOut);
		
		JLabel lblAdminBlock = new JLabel("Admin Block");
		lblAdminBlock.setForeground(Color.BLUE);
		lblAdminBlock.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblAdminBlock.setBounds(243, 80, 122, 36);
		contentPane.add(lblAdminBlock);
		
		btnNewButton = new JButton("SEARCH");
		
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(72, 141, 175, 36);
		contentPane.add(btnNewButton);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(147, 11, 332, 41);
		contentPane.add(label);
		
		btnHome = new JButton("Home");
		btnHome.setBackground(Color.BLACK);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setForeground(Color.WHITE);
		btnHome.setBounds(483, 446, 89, 23);
		contentPane.add(btnHome);
		
		lblName = new JLabel("");
		lblName.setBounds(30, 23, 46, 13);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 688, 547);
		contentPane.add(lblNewLabel);
	}
	
	public void btnItemactionListener(ActionListener act) 
	{
		
		btnItemsFeature.addActionListener(act);
}
	public void btnOpsign(ActionListener act) 
	{
		
		btnAddOperatotor.addActionListener(act);
}
	public void btnRemOp(ActionListener act) 
	{
		
		btnremOp.addActionListener(act);
}
	public void btnRemCust(ActionListener act) 
	{
		
		btnRemoveCustomer.addActionListener(act);
	}
	public void btnLogouT(ActionListener act) 
	{
		btnLogOut.addActionListener(act);
	}
	//
	public void btnAddDeal(ActionListener act) 
	{
		btnDeals.addActionListener(act);
	}
	public void btnSearch(ActionListener act) 
	{
		btnNewButton.addActionListener(act);
	}
	public void setAdminName(String str)
	{
		lblName.setText(str);
	}
}