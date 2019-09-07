package ViewPkg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class udateOrder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUnit;
	private JButton btnupdate;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JButton btnSave;
	private final JTextField txtProduct = new JTextField();
	private JTextField txtPrice;
	private DefaultTableModel model;
	private JTextField txtTotal;
	private JLabel lblTotal;
	
	private JButton btnCancelOrder;
	private JButton btnHome;
	private JButton btnBack;
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public udateOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUnit = new JTextField();
		txtUnit.setBounds(251, 127, 101, 23);
		contentPane.add(txtUnit);
		txtUnit.setColumns(10);
		
		btnupdate = new JButton("Update");
		btnupdate.setBackground(Color.GREEN);
		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtProduct.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Text Field must be Filled");
				}
				else {
				model.setValueAt(txtProduct.getText(), table.getSelectedRow(), 0);
				model.setValueAt(txtUnit.getText(), table.getSelectedRow(), 1);
				String unit=txtUnit.getText();
				int res1 = Integer.parseInt(unit);
				int rest= Integer.parseInt(txtPrice.getText());
				int resut=res1*rest;
				String price=Integer.toString(resut);
						
				model.setValueAt(price, table.getSelectedRow(), 3);
				int Total=0;
				for (int i=0; i<model.getRowCount(); i++)
				{
				int res = Integer.parseInt(model.getValueAt(i, 3).toString());
				Total = Total + res;
				
				}
				String p = Integer.toString(Total);
				txtTotal.setText(p);
		
				txtPrice.setText("");
				txtProduct.setText("");
				txtUnit.setText("");
				}
			}
		});
		btnupdate.setBounds(477, 125, 89, 23);
		contentPane.add(btnupdate);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 160, 542, 110);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtProduct.setText((String) model.getValueAt(table.getSelectedRow(), 0));
				txtPrice.setText((String) model.getValueAt(table.getSelectedRow(), 2));
				txtUnit.setText((String) model.getValueAt(table.getSelectedRow(), 1));
			}
		});
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						" Product", "Qty", "Unit Price", "Price"
				}
			);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(213);
		scrollPane_1.setViewportView(table);
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(477, 310, 89, 23);
		contentPane.add(btnSave);
		txtProduct.setBounds(24, 127, 217, 23);
		contentPane.add(txtProduct);
		txtProduct.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBackground(Color.WHITE);
		txtPrice.setEditable(false);
		txtPrice.setBounds(362, 129, 100, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProduct.setBounds(24, 101, 101, 14);
		contentPane.add(lblProduct);
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setForeground(Color.WHITE);
		lblUnit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnit.setBounds(251, 101, 46, 14);
		contentPane.add(lblUnit);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(367, 101, 46, 14);
		contentPane.add(lblPrice);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(480, 280, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		lblTotal = new JLabel("Total");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(424, 280, 46, 14);
		contentPane.add(lblTotal);
		
		btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.setBackground(Color.RED);
		btnCancelOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Order Cancelled  ");
				setVisible(false);
				optionFrame oF= new optionFrame();
				oF.setVisible(true);
			}
		});
		btnCancelOrder.setBounds(24, 310, 129, 23);
		contentPane.add(btnCancelOrder);
		
		JLabel lblUpdateOrder = new JLabel("Update Order");
		lblUpdateOrder.setForeground(Color.BLUE);
		lblUpdateOrder.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblUpdateOrder.setBounds(227, 61, 144, 28);
		contentPane.add(lblUpdateOrder);
		
		JLabel label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(128, 10, 332, 41);
		contentPane.add(label);
		
		btnHome = new JButton("Home");
		btnHome.setBackground(Color.BLACK);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setForeground(Color.WHITE);
		btnHome.setBounds(481, 369, 89, 23);
		contentPane.add(btnHome);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(10, 369, 89, 23);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 576, 400);
		contentPane.add(lblNewLabel);
	}
	public void insertData(String[][] pro)
	{	int intTotal=0;
		for(int i=0; i<pro.length; i++)
		{
		String[] arr= {pro[i][0],pro[i][1],pro[i][2], pro[i][3]};
		int res = Integer.parseInt(pro[i][3]);
		intTotal = intTotal + res;
		model.addRow(arr);
		}
		txtTotal.setText(Integer.toString(intTotal));
	}
	public String[][] getUpdatedTableData()
	{
		int totalRow=model.getRowCount();
		//System.out.println(totalRow);
		String dataValue[][] = new String[totalRow][4];
		for(int i=0; i<totalRow; i++)
		{	
			dataValue[i][0]=model.getValueAt(i, 0).toString();
			dataValue[i][1]=model.getValueAt(i, 1).toString();
			dataValue[i][2]=model.getValueAt(i, 3).toString();
			
//			int data1 = Integer.parseInt(dataValue[i][1]);
//			int data2 = Integer.parseInt(dataValue[i][2]);
		//obj.InsertData(dataValue[i][0], data1, data2); 
		}
		return dataValue;  
	}
	public void addSaveListener(ActionListener cal) {
	
        btnSave.addActionListener(cal);
    }
	
	public void addCancelListener(ActionListener cal) {
		
        btnCancelOrder.addActionListener(cal);
    }
	public String getTotal()
	{
		return txtTotal.getText();
	}
	public void HomeActListen(ActionListener act)
	{
		btnHome.addActionListener(act);		
	}
}
