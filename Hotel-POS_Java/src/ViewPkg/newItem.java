package ViewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class newItem extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduct;
	private JTextField txtPrice;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnSave ;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public newItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterProductName = new JLabel("Enter Product Name");
		lblEnterProductName.setForeground(Color.WHITE);
		lblEnterProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterProductName.setBounds(60, 113, 130, 14);
		contentPane.add(lblEnterProductName);
		
		txtProduct = new JTextField();
		txtProduct.setBounds(200, 110, 143 ,20);
		contentPane.add(txtProduct);
		txtProduct.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(200, 135, 143, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblEnterPrice = new JLabel("Enter Price");
		lblEnterPrice.setForeground(Color.WHITE);
		lblEnterPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterPrice.setBounds(60, 138, 96, 14);
		contentPane.add(lblEnterPrice);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(324, 11, 100, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		label_1.setBounds(324, 57, 100, 14);
		contentPane.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(55, 168, 391, 114);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtProduct.setText((String) model.getValueAt(table.getSelectedRow(), 0));
				txtPrice.setText((String) model.getValueAt(table.getSelectedRow(), 1));
			}
		});
		
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Product", "Price"
				}
			);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
		btnSave.setForeground(new Color(0, 0, 0));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(374, 292, 72, 23);
		contentPane.add(btnSave);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtPrice.getText().equals("") || txtProduct.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter the Data");
				}
				else
				{
					setTableData();
					txtPrice.setText("");
					txtProduct.setText("");
				}
			}
		});
		btnAdd.setBounds(363, 134, 61, 23);
		contentPane.add(btnAdd);
		
		JLabel lblAddItems = new JLabel("Add Items");
		lblAddItems.setForeground(Color.BLUE);
		lblAddItems.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblAddItems.setBounds(185, 63, 106, 20);
		contentPane.add(lblAddItems);
		
		JLabel label_2 = new JLabel("THE CONQUERORS FAST FOOD");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label_2.setBounds(92, 11, 332, 41);
		contentPane.add(label_2);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(420, 325, 89, 23);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(10, 325, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 515, 357);
		contentPane.add(lblNewLabel);
		
	}
	public void setTableData()
	{
		String ar[]= {txtProduct.getText(), txtPrice.getText()};
		model.addRow(ar);
	}
	
	public String[][] getTableData()
	{
		
		int totalRow=model.getRowCount();
		//System.out.println(totalRow);
		String dataValue[][] = new String[totalRow][4];
		for(int i=0;i<totalRow; i++)
		{
			dataValue[i][0]=model.getValueAt(i, 0).toString();
			dataValue[i][1]=model.getValueAt(i, 1).toString();
		}
		return dataValue;
	}
	
	public void addSaveListener(ActionListener cal) {
       btnSave.addActionListener(cal);
    }
	
}
