package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class updateItems extends JFrame {

	private JPanel contentPane;
	private JButton btnupdate;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JButton btnSave;
	private final JTextField txtProduct = new JTextField();
	private JTextField txtPrice;
	private DefaultTableModel model;
	private JTextField txtTotal;
	private JLabel lblTotal;
	private JLabel lblUpdateItems;
	private JLabel label;
	private JButton btnHome;
	private JButton btnBack;
	private JLabel lblNewLabel;

	public updateItems() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnupdate = new JButton("Update");
		btnupdate.setBackground(Color.GREEN);
		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setValueAt(txtProduct.getText(), table.getSelectedRow(), 0);
				model.setValueAt(txtPrice.getText(), table.getSelectedRow(), 1);
				txtPrice.setText("");
				txtProduct.setText("");
			}
		});
		btnupdate.setBounds(453, 127, 89, 23);
		contentPane.add(btnupdate);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 160, 520, 116);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtProduct.setText((String) model.getValueAt(table.getSelectedRow(), 0));
				txtPrice.setText((String) model.getValueAt(table.getSelectedRow(), 1));
			}
		});
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					" Product", " Price"
				}
			);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(213);
		table.getColumnModel().getColumn(1).setPreferredWidth(225);

		scrollPane_1.setViewportView(table);
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(453, 286, 89, 23);
		contentPane.add(btnSave);
		txtProduct.setBounds(22, 125, 245, 23);
		contentPane.add(txtProduct);
		txtProduct.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(277, 127, 166, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setBounds(22, 101, 81, 14);
		contentPane.add(lblProduct);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(277, 101, 46, 14);
		contentPane.add(lblPrice);
		
		lblUpdateItems = new JLabel("Update Items");
		lblUpdateItems.setForeground(Color.BLUE);
		lblUpdateItems.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblUpdateItems.setBounds(219, 61, 119, 23);
		contentPane.add(lblUpdateItems);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(101, 10, 332, 41);
		contentPane.add(label);
		
		btnHome = new JButton("Home");
		btnHome.setBackground(Color.BLACK);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setForeground(Color.WHITE);
		btnHome.setBounds(457, 327, 89, 23);
		contentPane.add(btnHome);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(10, 327, 89, 23);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 552, 358);
		contentPane.add(lblNewLabel);
	}
	public void insertData(String[] pro)
	{	int j=1;
		for(int i=0; i<pro.length; i=i+2)
		{
			model.addRow(new Object[] {pro[i], pro[j]});
			j=j+2;
		}
	}
	///
	public String[][] getTableData()
	{
		
		int totalRow=model.getRowCount();
		System.out.println(totalRow);
		String dataValue[][] = new String[totalRow][4];
		for(int i=0;i<totalRow; i++)
		{
			dataValue[i][0]=model.getValueAt(i, 0).toString();
			dataValue[i][1]=model.getValueAt(i, 1).toString();
			System.out.println("::::");
		}
		return dataValue;
	}
	///
	public void btnSaveUpdate(ActionListener act)
	{
		btnSave.addActionListener(act);
	}
}
