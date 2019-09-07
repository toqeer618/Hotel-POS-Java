package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class addDeals extends JFrame {
	private String[] arr=new String[10];

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtdealName;
	private JTextField txtDealPrice;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnAdd;
	private JButton btnSaveDeal;
	private JLabel label;
	private JTextField txtUnit;
	private JTextField txtPrice;
	private JComboBox cmbItems ;
	int total=0;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public addDeals() {
		JFrame jframe = new JFrame("My JFrame Title");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Deal ID:");
		lblNewLabel.setBounds(69, 64, 117, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(243, 64, 234, 32);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblDealName = new JLabel("Deal  Name:");
		lblDealName.setBounds(69, 132, 97, 19);
		lblDealName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblDealName);
		
		txtdealName = new JTextField();
		txtdealName.setBounds(243, 128, 234, 32);
		contentPane.add(txtdealName);
		txtdealName.setColumns(10);
		
		JLabel lblDealPrice = new JLabel("Deal Price");
		lblDealPrice.setBounds(467, 489, 78, 13);
		lblDealPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblDealPrice);
		
		txtDealPrice = new JTextField();
		txtDealPrice.setEditable(false);
		txtDealPrice.setBounds(579, 485, 103, 26);
		contentPane.add(txtDealPrice);
		txtDealPrice.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 265, 672, 190);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Item Name", "Units", "Price"
				}
			);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		  btnSaveDeal = new JButton("Save Deal");
		 
		  btnSaveDeal.setBounds(585, 530, 97, 32);
		contentPane.add(btnSaveDeal);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(546, 220, 85, 21);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableData();
				//txtPrice.setText("");
				int val1 = Integer.parseInt(txtUnit.getText());
				int val=Integer.parseInt(txtPrice.getText());
				total+=val*val1;
				txtDealPrice.setText(Integer.toString(total));
				txtUnit.setText("");

			}
		});
		contentPane.add(btnAdd);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setBounds(185, 10, 332, 41);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(label);
		
		 cmbItems = new JComboBox();
		cmbItems.setBounds(69, 220, 97, 21);
		contentPane.add(cmbItems);
		
		txtUnit = new JTextField();
		txtUnit.setBounds(243, 221, 96, 19);
		contentPane.add(txtUnit);
		txtUnit.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setBounds(381, 221, 96, 19);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel_1.setBounds(0, 0, 732, 463);
		contentPane.add(lblNewLabel_1);
	}
	public void tableData()
	{
		String pName = cmbItems.getSelectedItem().toString();
		String unit = txtUnit.getText();
		String Price = txtPrice.getText(); 
		int X= Integer.parseInt(Price)*Integer.parseInt(unit);
		
		String[] rowData= {pName, unit ,Integer.toString(X)};
		
			//String arr[][]= {};
			model.addRow(rowData);
	}
	public String[][] gettableData()
	{
		int totalRow=model.getRowCount();
		//System.out.println(totalRow);
		String dataValue[][] = new String[totalRow][3];
		for(int i=0; i<totalRow; i++)
		{	
			dataValue[i][0]=model.getValueAt(i, 0).toString();
			dataValue[i][1]=model.getValueAt(i, 1).toString();
			dataValue[i][2]=model.getValueAt(i, 2).toString();
			
			}
		return dataValue; 
	}
public void addSaveDealListener(ActionListener cal) {
		
        btnSaveDeal.addActionListener(cal);
    }
	public void setComboBox(String[] array)
	{
		arr=array;
		for(int i=0; i<arr.length; i++)
		cmbItems.insertItemAt(array[i], i);
				
	}
	public void setDealID(String id)
	{
		txtID.setText(id);
	}
	public void SetPrice(String price)
	{
		txtPrice.setText(price);
	}
	
	public String getProduct() {
		return cmbItems.getSelectedItem().toString();
	}
	
	public void addProductListener(ActionListener cal) {
		
        cmbItems.addActionListener(cal);
    }
	
	public String getDealId()
	{
		return txtID.getText();
	}
	
	public String getDealName()
	{
		return txtdealName.getText();
	}
	public String getDealPrice()
	{
		return txtDealPrice.getText();
	}
}
