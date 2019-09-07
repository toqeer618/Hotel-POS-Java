package ModelPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class dealsModel {
	private Connection cn;
	private Statement qn1;	
	
	public dealsModel(){
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
	public void deleteItem(String ItName)
	{
		
		String query="Delete from items where Item_Name ='"+ItName+"'";
		try {
			qn1 = cn.createStatement();
			 qn1.execute(query);	  
			 JOptionPane.showMessageDialog(null, "Item deleted Successfully");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error to catch it\n");
		}
	}
	
	public String[] getDealsDetail(String dID)
	{
		int result;
		String[] arr= new String[100];
		
		result=0;
		String query1 = "SELECT * FROM deal where Deal_Id ='"+dID+"'";
		try {
			qn1 = cn.createStatement();
			ResultSet res1 = qn1.executeQuery(query1);
			while (res1.next())
	        {
				arr[result] = res1.getString(2);
			result++;
			arr[result] = Integer.toString(res1.getInt(3));	
			result++;
			arr[result] = Integer.toString(res1.getInt(4));	
			result++;


			
        }
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "No Data Or Lots of Noise\n");
		
	}
		return arr;	
		}
	
	
	public String[] getDeals()
	{
		int result;
		String[] arr= new String[100];
		
		result=0;
		String query1 = "SELECT * FROM deals";
		try {
			qn1 = cn.createStatement();
			ResultSet res1 = qn1.executeQuery(query1);
			while (res1.next())
	        {
				arr[result] = res1.getString(1);
			result++;
			arr[result] = res1.getString(2);	
			result++;
			arr[result] = Integer.toString(res1.getInt(3));	
			result++;


			
        }
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "No Data Or Lots of Noise\n");
		
	}
		return arr;	
		}
	
	///Update Fuction
	public void UpdateDelete()
	{
		
		String query="Delete from items";
		try {
			qn1 = cn.createStatement();
			 qn1.execute(query);	  
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error to catch it\n");
		}
	}
	public void insertUpdatedItems(String pName, String price) {
		int data1 = Integer.parseInt(price);

		String query="INSERT INTO items Values ('"+pName+"','"+data1+"')";
		try {
			qn1 = cn.createStatement();
			 qn1.execute(query);	  
				 JOptionPane.showMessageDialog(null, "Item Updated Successfully");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error to catch it\n");
		}
		
	}
	
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
	

	
	//deal ID
	public int DealID() throws SQLException
	{
		int result=0;
		qn1 = cn.createStatement();
		try {
			String query="Select MAX(Deal_Id) from deals";
			
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
	
	public void insertDeals(String dealID, String DealName , String price)
	{ 
		
		String query1="INSERT INTO deals VALUES ('"+Integer.parseInt(dealID)+"','"+DealName+"','"+Integer.parseInt(price)+"')";
		try {
			
			qn1=cn.createStatement();
			qn1.execute(query1);

		    JOptionPane.showMessageDialog(null,"Deal Added Successefully "); 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void insertDealInfo(String dealID, String iName , String price, String unit)
	{ 
		
		String query1="INSERT INTO deal VALUES ('"+Integer.parseInt(dealID)+"','"+iName+"','"+Integer.parseInt(price)+"','"+Integer.parseInt(unit)+"')";
		try {
			
			qn1=cn.createStatement();
			qn1.execute(query1);

		   // JOptionPane.showMessageDialog(null,"Deal Added Successefully "); 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
