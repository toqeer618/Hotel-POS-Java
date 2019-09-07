package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ModelPkg.dealsModel;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class dealothers extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtDealId;
	private JTextField txtDiscriptio;
	private JTextField txtPrice;
	private JButton btnSubmit;
	private JButton btnOther;
	private DefaultTableModel model;
	private dealsModel dM=new dealsModel();
	String id;
	private JLabel label;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dealothers frame = new dealothers();
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
	public dealothers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Deals");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertData();
				table.setModel(model);
			}
		});
		btnNewButton.setBounds(197, 91, 238, 21);
		contentPane.add(btnNewButton);
		
		 btnOther = new JButton("Normal Order");
		btnOther.setBounds(197, 122, 238, 21);
		contentPane.add(btnOther);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 656, 225);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Deal ID", "Discription", "Price"
				}
			);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtDealId.setText((String) model.getValueAt(table.getSelectedRow(), 0));
				txtDiscriptio.setText((String) model.getValueAt(table.getSelectedRow(), 1));
				txtPrice.setText((String) model.getValueAt(table.getSelectedRow(), 2));
			}
		});
		
		scrollPane.setViewportView(table);
		
		txtDealId = new JTextField();
		txtDealId.setEditable(false);
		txtDealId.setText("Deal ID");
		txtDealId.setBounds(20, 417, 137, 19);
		contentPane.add(txtDealId);
		txtDealId.setColumns(10);
		
		txtDiscriptio = new JTextField();
		txtDiscriptio.setEditable(false);
		txtDiscriptio.setText("Discription");
		txtDiscriptio.setBounds(209, 417, 226, 19);
		contentPane.add(txtDiscriptio);
		txtDiscriptio.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setText("Price");
		txtPrice.setBounds(523, 417, 116, 19);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		 btnSubmit = new JButton("Submit");
		 btnSubmit.setBackground(Color.GREEN);
		 btnSubmit.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	dealViewTable dvt= new dealViewTable();
		 	dvt.setVisible(true);
		 	dvt.setTotal(txtPrice.getText());
		 	dvt.setID(id);
		 	dvt.insertData(txtDealId.getText());
		 	}
		 });
		btnSubmit.setBounds(554, 446, 85, 21);
		contentPane.add(btnSubmit);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(167, 0, 308, 81);
		contentPane.add(label);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 676, 477);
		contentPane.add(lblNewLabel);
	}
	
	
	public void otherActListen(ActionListener act)
	{
		btnOther.addActionListener(act);
		
	}
	
	public void insertData()
	{
		int j=1;
		int k=2;
		String[] pro=dM.getDeals();
		for(int i=0; i<pro.length; i=i+3)
		{
			if(pro[i]==null)
			{
				break;
			}
			else 
			{
			//System.out.println(pro[i]+"  "+pro[j]+"   "+ pro[k]+"   "+pro[l]);
				model.addRow(new Object[] {pro[i], pro[j], pro[k]});
			j=j+3;
			k=k+3;
		
			
			}
		}
	
	}
	
	
	public void getID(String i)
	{
		
		id=i;
	}
}
