package ModelPkg;

import java.sql.*;

import javax.swing.JOptionPane;

public class itemModel {
	private String productName;
	private int pricer;
	private Connection cn;
	private Statement qn1;
	private int i=0;
	public itemModel()
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
	
	public void insertItem(String pName, String price) {
		int data1 = Integer.parseInt(price);

		String query="INSERT INTO items Values ('"+pName+"','"+data1+"')";
		try {
			qn1 = cn.createStatement();
			 qn1.execute(query);	  
			 if(i==0)
				 JOptionPane.showMessageDialog(null, "New Item Added");
			 i++;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error to catch it\n");
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
	public String[] getItemData()
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
	String[] arr = new String[result+result];
	
	result=0;
	String query1 = "SELECT * FROM items";
	try {
		qn1 = cn.createStatement();
		ResultSet res1 = qn1.executeQuery(query1);
		while (res1.next())
        {
			arr[result] = res1.getString(1);
			result++;
			arr[result] = Integer.toString(res1.getInt(2));	
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
			 if(i==0)
				 JOptionPane.showMessageDialog(null, "Item Updated Successfully");
			 i++;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error to catch it\n");
		}
		
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
			
        }
		//String result= res.getString(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int x=(int) (Integer.parseInt(result)*0.85);
	return Integer.toString(x);
		
	
		
	}
	
}