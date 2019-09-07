package ModelPkg;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainPkg.Connector;
import ViewPkg.orderView;
import ViewPkg.udateOrder;
public class OrderModel {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  Connection cn;
	private  Statement qn, qn1;
	private String Cname, Id, date, pName;
	int unit,price;	
	public boolean succes;
	
	static int size=0;
	String[] I_Name= new String[5]; 
	String[] U_price= new String[5]; 
	
	public OrderModel(){
		connect();
		
	
}
	
	public  void connect() {
		try {
			 cn = DriverManager.getConnection("jdbc:mysql://localhost/fastfood", "root","");
			System.out.println("connectd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Not connectd");
			e.printStackTrace();
		}
	}

	public String[] getProductList()
	{
		int result=0;
		String query="Select COUNT(Item_Name) from items";
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
	result-=1;
	String query1 = "SELECT * FROM items";
	try {
		qn1 = cn.createStatement();
		ResultSet res1 = qn1.executeQuery(query1);
		
		while (res1.next())
        {
			arr[result] = res1.getString(1);	
			result--;
        }
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "No Data Or Lots of Noise\n");
		
	}
		return arr;
	}
	
	public String returnPrice(String pName) throws SQLException
	{	String result="Not found";
		//System.out.println("Model"+pName);
		qn1 = cn.createStatement();
	try {
		String query="Select * from items where Item_Name = '"+pName+"'";
		
		ResultSet res1 = qn1.executeQuery(query);
		//System.out.println(res1.getString("Per_Unit_Price"));
		//SELECT * FROM people WHERE lname = 'Bloggs'")
	//System.out.println(res.getString("Per_Unit_Price"));
		while (res1.next())
        {
			result=res1.getString("Per_Unit_Price");
			//System.out.println(p);
			
        }
		//String result= res.getString(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
		
	
		
	}
	public void insertData(int orderId, String product, int result, int result2)
	{ 
		
		String query1="INSERT INTO saleperitem VALUES ('"+orderId+"','"+product+"','"+result+"','"+result2+"')";
		try {
			
			qn1=cn.createStatement();
			qn1.execute(query1);

		    JOptionPane.showMessageDialog(null," Successefully Order Submited"); 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
//	public boolean verifyCustomer(String S ) throws SQLException
//	{
//		boolean result = false;
//		qn1 = cn.createStatement();
//		try {
//			String query="Select CustomerId from customer where CustomerId = '"+S+"'";
//
//			
//			ResultSet res1 = qn1.executeQuery(query);
//			//String query="Select * from items where Item_Name = '"+pName+"'";
//			if (res1.next()==true)
//	        {
//				
//				result=true;
//				//System.out.println(p);
//				
//	        }
//			else 
//				result=false;
//			//String result= res.getString(1);
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null,"Invalid Customer !!!");
//		}
//		return result;
//		
//	}
	public int orderNumber() throws SQLException
	{
		int result=0;
		qn1 = cn.createStatement();
		try {
			String query="Select MAX(OrderId) from sales_per_item";
			
			ResultSet res1 = qn1.executeQuery(query);
			while (res1.next())
	        {
				result=res1.getInt(1);
				
				
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public boolean insertSalesInfo(int Id, String CustID,  String total,String d )
	{
			boolean ax=true;
			int t= Integer.parseInt(total);
			
			String query1="INSERT INTO sales_per_item VALUES ('"+Id+"','"+CustID+"','"+t+"','"+d+"')";
			try {
				//System.out.println(query);
				qn1=cn.createStatement();
				ax=qn1.execute(query1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ax=true;
			return ax;
		
		
	}
	
	
	

}
