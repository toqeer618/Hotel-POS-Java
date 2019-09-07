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

public class RemoveOp extends JFrame {
	private JButton btnRemove;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JButton btnSave;
	private final JTextField txtOPid = new JTextField();
	private JTextField txtOPname;
	private DefaultTableModel model;
	private JTextField txtTotal;
	private JLabel lblTotal;
	private JPanel contentPane;
	private JLabel lblRemoveOperator;
	private JLabel label;
	private JButton btnHome;
	private JButton btnBack;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public RemoveOp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setValueAt(txtOPid.getText(), table.getSelectedRow(), 0);
				model.setValueAt(txtOPname.getText(), table.getSelectedRow(), 1);
				txtOPname.setText("");
				txtOPid.setText("");
			}
		});
		btnRemove.setBounds(431, 148, 89, 23);
		contentPane.add(btnRemove);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 181, 511, 104);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtOPid.setText((String) model.getValueAt(table.getSelectedRow(), 0));
				txtOPname.setText((String) model.getValueAt(table.getSelectedRow(), 1));
			}
		});
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					" Operator Id", " Name"
				}
			);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(213);
		table.getColumnModel().getColumn(1).setPreferredWidth(225);

		scrollPane_1.setViewportView(table);
		btnSave = new JButton("Save");
		btnSave.setBounds(451, 295, 89, 23);
		contentPane.add(btnSave);
		txtOPid.setBounds(29, 150, 227, 20);
		contentPane.add(txtOPid);
		txtOPid.setColumns(10);
		
		txtOPname = new JTextField();
		txtOPname.setBounds(281, 150, 140, 20);
		contentPane.add(txtOPname);
		txtOPname.setColumns(10);
		
		JLabel lblProduct = new JLabel("Operator ID");
		lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setBounds(29, 126, 94, 14);
		contentPane.add(lblProduct);
		
		JLabel lblPrice = new JLabel("Name");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(281, 126, 46, 14);
		contentPane.add(lblPrice);
		
		lblRemoveOperator = new JLabel("Remove Operator");
		lblRemoveOperator.setForeground(Color.BLUE);
		lblRemoveOperator.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 18));
		lblRemoveOperator.setBounds(201, 76, 154, 23);
		contentPane.add(lblRemoveOperator);
		
		label = new JLabel("THE CONQUERORS FAST FOOD");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(114, 11, 332, 41);
		contentPane.add(label);
		
		btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(455, 328, 89, 23);
		contentPane.add(btnHome);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(10, 331, 89, 23);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hamza\\eclipse-workspace\\OADProject\\Theme\\mcdonalds_by_daylight___flickr_-_photo_sharing_.jpg"));
		lblNewLabel.setBounds(0, 0, 552, 358);
		contentPane.add(lblNewLabel);
	}
	public void insertData(String[] pro)
	{	int j=1;
	System.out.println(j);
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
			
		}
		return dataValue;
	}
	public String getId()
	{
		return txtOPid.getText();
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

