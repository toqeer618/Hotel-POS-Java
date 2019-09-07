package MainPkg;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class genPrint extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtPrint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					genPrint frame = new genPrint();
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
	public genPrint() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPrint = new JTextArea();
		txtPrint.setBounds(236, 10, 400, 354);
		contentPane.add(txtPrint);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(540, 406, 85, 21);
		contentPane.add(btnPrint);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(338, 406, 85, 21);
		contentPane.add(btnCancel);
	}
	public void printAndSave(String[][] arr, String orderID, String Time, String CustomerID){
		txtPrint.append("\t\t Bill of Student \n\n"
				+ " arr"
				+ "arr"
				+ " arr"
				+ "arr ");
		
	}
	
}
