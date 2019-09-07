package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class itemView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNewProduct;
	private JTextField txtNewPrcice;
	private JLabel lblNewProduct;
	private JLabel lblNewPrice;
	private JComboBox cmbProduct;
	private DefaultComboBoxModel model;
	private String arr[]=new String[1];
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnUpdateItem;
	private JLabel label;
	private JButton btnHome;
	private JButton btnBack;
	private JLabel lblNewLabel;
	public itemView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddItems = new JLabel("Add Items");
		lblAddItems.setForeground(Color.BLUE);
		lblAddItems.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		lblAddItems.setBounds(198, 84, 91, 23);
		contentPane.add(lblAddItems);
		
		 btnAdd = new JButton("Add Item");
		 btnAdd.setForeground(Color.WHITE);
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnAdd.setBackground(Color.BLACK);
		
		btnAdd.setBounds(89, 252, 103, 23);
		contentPane.add(btnAdd);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(Color.WHITE);
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName.setBounds(89, 159, 90, 14);
		contentPane.add(lblProductName);
		
		 cmbProduct = new JComboBox();
		 System.out.println(arr[0]);
		model= new DefaultComboBoxModel(arr);
		 cmbProduct.setModel(model);
		cmbProduct.setBounds(248, 158, 123, 20);
		contentPane.add(cmbProduct);
		
		 btnUpdateItem = new JButton("Update Item");
		 btnUpdateItem.setBackground(Color.GREEN);
		 btnUpdateItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnUpdateItem.setBounds(260, 250, 111, 23);
		contentPane.add(btnUpdateItem);
		
		 btnDelete = new JButton("Delete");
		 btnDelete.setForeground(new Color(0, 0, 0));
		 btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnDelete.setBackground(Color.RED);
	
		btnDelete.setBounds(282, 206, 89, 23);
		contentPane.add(btnDelete);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(74, 11, 332, 41);
		contentPane.add(label);
		
		btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(382, 286, 89, 23);
		contentPane.add(btnHome);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(10, 285, 89, 23);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 477, 317);
		contentPane.add(lblNewLabel);
	}
	public void setComboBox(String[] array)
	{
		arr=array;
		for(int i=0; i<arr.length; i++)
		model.insertElementAt(array[i], i);
		setVisible(true);
		 
		
	}
	public String getItemName()
	{
		return model.getSelectedItem().toString();
	}
	public void btnDelActLis(ActionListener act)
	{
		
		btnDelete.addActionListener(act);
		
	}
		public void btnAddButton(ActionListener act)
		{
			
			btnAdd.addActionListener(act);
			
		}
		public void btnUpdateButton(ActionListener act)
		{
			
			btnUpdateItem.addActionListener(act);
			
		}
}
