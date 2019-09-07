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

public class reMoveCustomer extends JFrame {

	private JButton btnRemove;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JButton btnSave;
	private final JTextField txtCustid = new JTextField();
	private JTextField txtCUstname;
	private DefaultTableModel model;
	private JTextField txtTotal;
	private JLabel lblTotal;
	private JPanel contentPane;
	private JLabel lblRemoveCustomer;
	private JLabel label;
	private JButton btnHome;
	private JButton btnBack;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reMoveCustomer frame = new reMoveCustomer();
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
	public reMoveCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.RED);
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setValueAt(txtCustid.getText(), table.getSelectedRow(), 0);
				model.setValueAt(txtCUstname.getText(), table.getSelectedRow(), 1);
				txtCUstname.setText("");
				txtCustid.setText("");
			}
		});
		btnRemove.setBounds(422, 125, 89, 23);
		contentPane.add(btnRemove);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(37, 158, 474, 106);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCustid.setText((String) model.getValueAt(table.getSelectedRow(), 0));
				txtCUstname.setText((String) model.getValueAt(table.getSelectedRow(), 1));
			}
		});
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					" Customer Id", " Name"
				}
			);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(213);
		table.getColumnModel().getColumn(1).setPreferredWidth(225);

		scrollPane_1.setViewportView(table);
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBackground(Color.GREEN);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(422, 274, 89, 23);
		contentPane.add(btnSave);
		txtCustid.setBounds(37, 127, 220, 23);
		contentPane.add(txtCustid);
		txtCustid.setColumns(10);
		
		txtCUstname = new JTextField();
		txtCUstname.setBounds(267, 129, 146, 20);
		contentPane.add(txtCUstname);
		txtCUstname.setColumns(10);
		
		JLabel lblProduct = new JLabel("Customer ID");
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProduct.setBounds(37, 103, 97, 14);
		contentPane.add(lblProduct);
		
		JLabel lblPrice = new JLabel("Name");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setBounds(267, 103, 46, 14);
		contentPane.add(lblPrice);
		
		lblRemoveCustomer = new JLabel("Remove Customer");
		lblRemoveCustomer.setForeground(Color.BLUE);
		lblRemoveCustomer.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblRemoveCustomer.setBounds(186, 67, 154, 23);
		contentPane.add(lblRemoveCustomer);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(116, 11, 332, 41);
		contentPane.add(label);
		
		btnHome = new JButton("Home");
		btnHome.setBackground(Color.BLACK);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setForeground(Color.WHITE);
		btnHome.setBounds(445, 315, 89, 23);
		contentPane.add(btnHome);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(10, 315, 89, 23);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 552, 358);
		contentPane.add(lblNewLabel);
	}
	
	public void insertData(String[] pro)
	{	
		int j=1;
			for(int i=0; i<pro.length; i=i+2)
		{
			model.addRow(new Object[] {pro[i], pro[j]});
			j=j+2;
		}
	}
	///
	
	public String getId()
	{
		return txtCustid.getText();
	}
	public void btnRemoveActListen(ActionListener act)
	{
		btnRemove.addActionListener(act);
	}
	public void btnSaveActListen(ActionListener act)
	{
		btnSave.addActionListener(act);
	}
	

}
