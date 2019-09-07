	package ViewPkg;
	
	import java.awt.BorderLayout;
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.border.Border;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JComboBox;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;
	
	import ControllerPkg.adminController;
	import ModelPkg.searchModel;
	
	import javax.swing.BorderFactory;
	import javax.swing.DefaultComboBoxModel;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JLabel;
	import java.awt.Font;
	import java.awt.Color;
	import javax.swing.ImageIcon;
	
	public class SearchBar extends JFrame {
	
		private JPanel contentPane;
		private JTextField textField;
		private JTable table;
		private DefaultTableModel model;
		private String[] arr;
		private searchModel sModel= new searchModel();
		private JComboBox cmbagainst;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SearchBar frame = new SearchBar();
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
		public SearchBar() {
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 740, 503);
			contentPane = new JPanel();
	
			String title = "A titled border";
			Border border = BorderFactory.createTitledBorder(title);
			contentPane.setBorder(border);
			
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			 cmbagainst = new JComboBox();
			cmbagainst.setBounds(174, 112, 99, 21);
			contentPane.add(cmbagainst);
			JComboBox comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(comboBox.getSelectedItem().toString().equals("Items"))
					{	
						cmbagainst.setModel(new DefaultComboBoxModel(new String[] {"Price", "Product Name"}));
						model=new DefaultTableModel(
								new Object[][] {
								},
								new String[] {"Iteme Name", "Price"
										
								}
							);
	
						table.setModel(model);
					}
					else if(comboBox.getSelectedItem().toString().equals("Sales"))
					{ 	
						cmbagainst.setModel(new DefaultComboBoxModel(new String[] {"Oerder ID", "Date","Total" }));
						model=new DefaultTableModel(
								new Object[][] {
								},
									new String[] {"Order Id","Customer ID","Date", "Total"
										
								}
							);
						table.setModel(model);
					}
					else if(comboBox.getSelectedItem().toString().equals("Customer"))
						{	
						cmbagainst.setModel(new DefaultComboBoxModel(new String[] {"Customer ID", "Customer Name","Total" }));
							model=new DefaultTableModel(
									new Object[][] {
									},
										new String[] {"Customer ID", "Customer Name", "Customer Phone", 
											"Address"
											
									}
								);
							table.setModel(model);
						}
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Items", "Sales", "Customer"}));
			comboBox.setBounds(44, 109, 93, 26);
			contentPane.add(comboBox);
			
			textField = new JTextField();
			textField.setBounds(307, 110, 170, 26);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem().toString().equals("Customer"))
						{
							insertCustomerInfo();
						}
					else if(comboBox.getSelectedItem().toString().equals("Sales"))
					{
						insertSalesData();
					}
					else
					{
						insertItemsData();
					}
				}
			});
			btnSearch.setBounds(500, 111, 89, 23);
			contentPane.add(btnSearch);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(44, 146, 474, 212);
			contentPane.add(scrollPane);
			
			table = new JTable();
					
			scrollPane.setViewportView(table);
			
			JLabel lblSearchPlane = new JLabel("Search Plane");
			lblSearchPlane.setForeground(Color.BLUE);
			lblSearchPlane.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
			lblSearchPlane.setBounds(189, 58, 130, 26);
			contentPane.add(lblSearchPlane);
			
			JLabel label = new JLabel("THE CONQUERORS FAST FOOD");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
			label.setBounds(92, 6, 332, 41);
			contentPane.add(label);
			
			JButton btnHome = new JButton("Home");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					adminOptions aOp= new adminOptions();
					dispose();
					adminController ad;
					aOp.setVisible(true);
				}
			});
			btnHome.setBackground(Color.BLACK);
			btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnHome.setForeground(Color.WHITE);
			btnHome.setBounds(412, 383, 89, 23);
			contentPane.add(btnHome);
			
			JButton btnBack = new JButton("Back");
			btnBack.setForeground(Color.WHITE);
			btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBack.setBackground(Color.BLACK);
			btnBack.setBounds(10, 383, 89, 23);
			contentPane.add(btnBack);
			
			
			
			JLabel lblSearchType = new JLabel("Search Type             Against value");
			lblSearchType.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSearchType.setBounds(44, 85, 308, 13);
			contentPane.add(lblSearchType);
			
		}
		public void insertItemsData()
		{	int j=1;
			String[] pro=sModel.getItemsInfo(textField.getText(), cmbagainst.getSelectedItem().toString() );
			for(int i=0; i<pro.length; i=i+2)
			{
				if(pro[i]==null)
				{
					break;
				}
				else
					model.addRow(new Object[] {pro[i], pro[j]});
				j=j+2;
			}
		}
		///
		public void insertSalesData()
		{	int j=1;
			int k=2;
			int l=3;
			String[] pro=sModel.getSalesInfo(textField.getText(), cmbagainst.getSelectedItem().toString() );
			for(int i=0; i<pro.length; i=i+4)
			{
				if(pro[i]==null)
				{
					break;
				}
				else 
				{
				//System.out.println(pro[i]+"  "+pro[j]+"   "+ pro[k]+"   "+pro[l]);
					model.addRow(new Object[] {pro[i], pro[j], pro[l], pro[k]});
				j=j+4;
				k=k+4;
				l=l+4;
				
				}
			}
		}
		
		public void insertCustomerInfo()
		{	int j=1;
			int k=2;
			String[] pro=sModel.getCustInfo(textField.getText(),cmbagainst.getSelectedItem().toString());
			for(int i=0; i<pro.length; i=i+3)
			{
				if(pro[i]==null)
				{
					break;
				}
				else 
				{
				//System.out.println(pro[i]+"  "+pro[j]+"   "+ pro[k]+"   "+pro[l]);
					model.addRow(new Object[] {pro[i], pro[j], pro[i], pro[k]});
				j=j+3;
				k=k+3;
			
				
				}
			}
		}
	}
