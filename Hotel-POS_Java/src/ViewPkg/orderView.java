package ViewPkg;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;  
import java.util.Calendar;  
import ControllerPkg.orderController; 
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.border.Border;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import ControllerPkg.orderController;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
//import invoice.InvoModel;

public class orderView extends JFrame {
	//private InvoModel mm;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtcustId;
	private JTextField txtDate;
	private JLabel lblProduct;
	private JLabel lblUnit;
	private JLabel lblPrice;
	private JTextField txtUnit;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JButton btnSave;
	private JComboBox cmbProduct;
	String Array[]= new String[5];
	String Array1[]= new String[5];
	private int Total=0;
	private int Iter=0;
	private String uP;
	orderController oC;
	private orderController obj;
	private DefaultTableModel model;

	private JPanel contentPane1;
	String[] arr=new String[10];
	private JTextField txtPrice;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblTakeOrder;
	private JButton btnHome;
	private JButton btnBack;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] arg)
	{
		orderView frame= new orderView();
		frame.setVisible(true);
	}

	

	
		
	public  orderView() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLable = new JLabel("Order No.");
		idLable.setForeground(Color.WHITE);
		idLable.setBounds(46, 68, 72, 28);
		idLable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(idLable);
		
		txtId = new JTextField();
		txtId.setBounds(216, 70, 264, 28);
		txtId.setEditable(false);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblCname = new JLabel(" Customer ID");
		lblCname.setForeground(Color.WHITE);
		lblCname.setBounds(45, 109, 129, 25);
		lblCname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblCname);
		
		txtcustId = new JTextField();
		txtcustId.setBounds(216, 109, 264, 28);
		txtcustId.setEditable(false);
		contentPane.add(txtcustId);
		txtcustId.setColumns(10);
		
		JLabel lblDate = new JLabel(" Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(46, 145, 59, 25);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setBackground(Color.WHITE);
		txtDate.setBounds(319, 145, 161, 28);
		txtDate.setEditable(false);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		 Border border = BorderFactory.createLineBorder(Color.WHITE, 5);
		 txtDate.setBorder(border);

		lblProduct = new JLabel("Product");
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProduct.setBounds(24, 187, 82, 14);
		contentPane.add(lblProduct);
		
		
		lblUnit = new JLabel("Unit");
		lblUnit.setForeground(Color.WHITE);
		lblUnit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnit.setBounds(221, 187, 90, 14);
		contentPane.add(lblUnit);
		
		lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(360, 184, 90, 20);
		contentPane.add(lblPrice);
		
		txtUnit = new JTextField();
		txtUnit.setBounds(221, 215, 86, 20);
		contentPane.add(txtUnit);
		txtUnit.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(477, 214, 89, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=1;
				for(int i=0; i<Iter; i++)
				if(Array1[i].equals(cmbProduct.getSelectedItem().toString()))
				{
					flag=0;
					break;
				}
					if(flag==1)
						{
							addData();
							Array[Iter]=model.getValueAt(Iter, 3).toString();
							int res = Integer.parseInt(Array[Iter]);
							Total = Total + res;
							String p = Integer.toString(Total);
							txtTotal.setText(p);
							Iter++;
						}
					else
						JOptionPane.showMessageDialog(null, "Duplicate ENtry");
				txtUnit.setText("");
				
				
		
				
			}
		});
		contentPane.add(btnAdd);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 246, 617, 139);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		 model= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Product Name", "Qty", "Unit Price", "Total Price"
				}
			);
		
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(123);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);

		scrollPane.setViewportView(table);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\toqee\\Downloads\\fast_food_logo.jpg"));
		scrollPane.setColumnHeaderView(label);
		
		lblTotal = new JLabel("Total");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(434, 356, 46, 14);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(538, 404, 86, 20);
		txtTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtTotal.setEditable(false);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		btnSave = new JButton("Submit");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBackground(Color.GREEN);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(538, 458, 89, 23);
		contentPane.add(btnSave);
		String[] Dishes = {""};
		 cmbProduct = new JComboBox(Dishes);
		 cmbProduct.setBounds(24, 214, 173, 20);
		contentPane.add(cmbProduct);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(360, 215, 86, 20);
		txtPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		contentPane.add(txtPrice);
		
		label_1 = new JLabel("THE CONQUERORS FAST FOOD");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label_1.setBounds(148, 11, 332, 41);
		contentPane.add(label_1);
		
		lblTakeOrder = new JLabel("Take Order");
		lblTakeOrder.setForeground(Color.BLUE);
		lblTakeOrder.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblTakeOrder.setBounds(233, 42, 129, 25);
		contentPane.add(lblTakeOrder);
		
		btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(391, 458, 89, 23);
		contentPane.add(btnHome);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(16, 458, 89, 23);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 669, 502);
		contentPane.add(lblNewLabel);
		
		
	}
	
	public void addData()
	{
		String price=txtPrice.getText();
		String unit= txtUnit.getText();
		String pName= cmbProduct.getSelectedItem().toString();
		String Unit_Price=txtPrice.getText();
		int res = Integer.parseInt(price);
		int res1 = Integer.parseInt(unit);
		int total = res*res1;
		String p = Integer.toString(total);
		Array1[Iter]=cmbProduct.getSelectedItem().toString();
		String[] rowData= {pName, unit,Unit_Price, p};
		try {
			//String arr[][]= {};
			model.addRow(rowData);
			
		}
		catch(java.lang.NullPointerException e )
		{
			//e.printStackTrace();
			System.out.println("An error occured");
			}	
	}
	
	public void GetData()
	{
		String Id= txtId.getText();
		String Cname= txtcustId.getText();
		//From system
		String Date= txtDate.getText();
		
		
		}
	 
	public String[][] getTableData()
	{
		int totalRow=model.getRowCount();
		//System.out.println(totalRow);
		String dataValue[][] = new String[totalRow][4];
		for(int i=0; i<totalRow; i++)
		{	
			dataValue[i][0]=model.getValueAt(i, 0).toString();
			dataValue[i][1]=model.getValueAt(i, 1).toString();
			dataValue[i][2]=model.getValueAt(i, 2).toString();
			dataValue[i][3]=model.getValueAt(i, 3).toString();
			
//			int data1 = Integer.parseInt(dataValue[i][1]);
//			int data2 = Integer.parseInt(dataValue[i][2]);
		//obj.InsertData(dataValue[i][0], data1, data2); 
		}
		return dataValue;  
	}
	
		

	public void addProductListener(ActionListener cal) {
			
	        cmbProduct.addActionListener(cal);
	    }
	
	public String getProduct() {
		//.out.println(cmbProduct.getSelectedItem().toString());
		return cmbProduct.getSelectedItem().toString();
	}
	
	public void SetPrice(String price)
	{
		txtPrice.setText(price);
	}
	
	public void addSaveListener(ActionListener cal) {
		
        btnSave.addActionListener(cal);
    }
	public void setCustomerID(String Cid)
	{
		txtcustId.setText(Cid);
	}
	public void setOrderID(String Cid)
	{
		txtId.setText(Cid);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		  
		 
		txtDate.setText(dtf.format(now)); 
	}
	public String getId() {
		
	return txtcustId.getText();
	}
	
	public void setComboBox(String[] array)
	{
		arr=array;
		for(int i=0; i<arr.length; i++)
		cmbProduct.insertItemAt(array[i], i);
		setVisible(true);
		
	}
	public String getDate() {
		
		return txtDate.getText();
		}
	
	public void HomeActListen(ActionListener act)
	{
		btnHome.addActionListener(act);		
	}
}
