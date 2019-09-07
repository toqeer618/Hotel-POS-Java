package MainPkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MonthlyGraph extends JFrame {

	private JPanel contentPane;
	private Connection cn;
	private Statement qn1;	
	

	/**
	 * Launch the application.
	 */
	public void Calling() {
		setVisible(true);
		connect();
	}
	private  void connect()
	{
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost/fastfood","root", "");
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Not Connected");
		}
	}

	/**
	 * Create the frame.
	 */
	public MonthlyGraph() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShowGraph = new JButton("Show Graph");
		btnShowGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultCategoryDataset dataset =new DefaultCategoryDataset();
				int result=0;
				String query="Select COUNT(OrderID) from sales_per_item";
				try {
					qn1 = cn.createStatement();
					ResultSet res1 = qn1.executeQuery(query);
					while (res1.next())
			        {
						result=res1.getInt(1);			
			        }
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error to catch it\n");
				}
			String[] arr = new String[result];
			int[] arr1 = new int[result];
			result-=1;
			String query1 = "SELECT * FROM sales_per_item";
			try {
				qn1 = cn.createStatement();
				ResultSet res1 = qn1.executeQuery(query1);
				
				while (res1.next())
		        {
					arr[result] = res1.getString(4);
					arr1[result] = res1.getInt(3);
					result--;
		        }
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "No Data Or Lots of Noise\n");
				
			}	
				for(int i=0; i<arr.length; i++)
				{
					int x=arr1[i];
					for (int j=1; j<arr.length; j++)
						{
							if(arr[i].equals(arr[j]))
							{	
								x+=arr1[j];
							}
						}
						dataset.setValue(x, "1", arr[i]);
				}
						
				JFreeChart chart = ChartFactory.createLineChart("Monthly Sales", "Month", "Sales", dataset, PlotOrientation.VERTICAL, false, true, false);
				
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.BLUE);
				
				//renderer  = new BarRenderer(); 
				ChartFrame frame1 =new ChartFrame("Monthly Sales graph", chart);
				frame1.setVisible(true);
				frame1.setSize(400, 650);
			
			}
		});
		
		btnShowGraph.setBounds(22, 213, 104, 23);
		contentPane.add(btnShowGraph);
	}

}