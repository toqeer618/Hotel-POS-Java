package ModelPkg;

import java.sql.*;

import javax.swing.JOptionPane;

public class searchModel {
	private Connection cn;
	private Statement qn1, qn;
	public searchModel()
	{
		connect();
	}
	private void connect()
	{
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost/fastfood","root", "");
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Not Connected");
		}
	}
  
	public String[] getItemsInfo(String data, String cond)
	{
		int result=0;
		String query1=null ;
		String[] arr = new String[100];
//		Full texts	
//		OrderId
//		CustomerId
//		TotalPrice
//		Date
		if(cond.equals("Product Name"))
			 query1 = "SELECT * FROM items WHERE Item_Name like '%"+data+"%'";
		else if(cond.equals("Price"))
			query1 = "SELECT * FROM items WHERE Per_Unit_Price like '%"+data+"%'";
		
		System.out.println(query1);
		try {
			qn1 = cn.createStatement();
			ResultSet res1 = qn1.executeQuery(query1);
			while (res1.next())
	        {
				arr[result] = res1.getString("Item_Name");
				result++;
				
				arr[result] = Integer.toString(res1.getInt("Per_Unit_Price"));
				result++;
				
				
	        }
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error");
			
		}
			return arr;	
	}
	
	
	public String[] getSalesInfo(String data, String cond)
	{
		int result=0;
		String query1=null ;
		String[] arr = new String[100];
//		Full texts	
//		OrderId
//		CustomerId
//		TotalPrice
//		Date
		if(cond.equals("Order ID"))
			 query1 = "SELECT * FROM sales_per_item WHERE OrderId like '%"+data+"%'";
		else if(cond.equals("Date"))
			query1 = "SELECT * FROM sales_per_item WHERE Date like '%"+data+"%'";
		else
			query1 = "SELECT * FROM sales_per_item WHERE TotalPrice like '%"+data+"%'";
		System.out.println(query1);
		try {
			qn1 = cn.createStatement();
			ResultSet res1 = qn1.executeQuery(query1);
			while (res1.next())
	        {
				arr[result] = res1.getString("OrderId");
				result++;
				arr[result] = res1.getString("CustomerId");
				result++;
				arr[result] = Integer.toString(res1.getInt("TotalPrice"));
				result++;
				arr[result] = res1.getString("Date");
					
				result++;

				
	        }
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No Data Or Lots of Noise\n");
			
		}
			return arr;	
	}

	public String[] getCustInfo(String data,String cond)
	{
		int result=0;
		String query1 =null;
		String[] arr = new String[100];
//		Full texts	
//		OrderId
//		CustomerId
//		TotalPrice
//		Date
		if(cond.equals("Customer ID"))
			query1 = "SELECT * FROM customer WHERE CustomerId like '%"+data+"%'";
		else if(cond.equals("Customer Name"))
			query1 = "SELECT * FROM customer WHERE CustomerName like '%"+data+"%'";		else
		
		System.out.println(query1);
		try {
			qn1 = cn.createStatement();
			ResultSet res1 = qn1.executeQuery(query1);
			while (res1.next())
	        {
				arr[result] = res1.getString("CustomerId");
				result++;
				arr[result] = res1.getString("CustomerName");
				result++;
				arr[result] = res1.getString("Address");
				result++;
				

				
	        }
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No Data Or Lots of Noise\n");
			
		}
			return arr;	
	}

}
