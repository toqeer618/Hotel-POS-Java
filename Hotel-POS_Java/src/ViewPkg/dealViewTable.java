package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ModelPkg.OrderModel;
import ModelPkg.dealsModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class dealViewTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private dealsModel dM=new dealsModel();
	private JLabel lblCustomerId;
	private JTextField txtCid;
	private OrderModel oM= new OrderModel();
	private JTextField txtTotal;
	private JLabel label;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					dealViewTable frame = new dealViewTable();
					
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
	public dealViewTable() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 688, 222);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Product", "Unit", "Price"
				}
			);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   
			   try {
				oM.insertSalesInfo(oM.orderNumber()+1, txtCid.getText(), txtTotal.getText(), dtf.format(now));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   //createPdf.genBill(arr, abc.getId(), alpha.orderNumber()+1);
				for(int i=0; i<model.getRowCount(); i++)
				try {
					oM.insertData(oM.orderNumber(), model.getValueAt(i, 0).toString(), Integer.parseInt(model.getValueAt(i, 1).toString()),Integer.parseInt(model.getValueAt(i, 2).toString()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSave.setBounds(613, 428, 85, 21);
		contentPane.add(btnSave);
		
		lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerId.setBounds(76, 114, 90, 13);
		contentPane.add(lblCustomerId);
		
		txtCid = new JTextField();
		txtCid.setEditable(false);
		txtCid.setBounds(187, 111, 203, 19);
		contentPane.add(txtCid);
		txtCid.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(602, 398, 96, 19);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(196, 10, 308, 76);
		contentPane.add(label);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 708, 457);
		contentPane.add(lblNewLabel);
	}
	
	public void insertData(String str)
	{
		int j=1;
		int k=2;
		String[] pro=dM.getDealsDetail(str);
		for(int i=0; i<pro.length; i=i+3)
		{
			if(pro[i]==null)
			{
				break;
			}
			else 
			{
				model.addRow(new Object[] {pro[i], pro[j], pro[k]});
			j=j+3;
			k=k+3;
		
			
			}
		}
	
	}
	public void setID(String id)
	{
		
		txtCid.setText("03475878167");
	}
	public void setTotal(String id)
	{
		
		txtTotal.setText(id);
	}
}
