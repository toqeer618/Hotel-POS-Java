package ModelPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class customerModel {
	
	private Connection cn;
	private Statement qn1;
	public customerModel () {
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
	public void insertCustomerInfo(String Id, String CustName,  String Add,String Gender )
	{
			
			String query1="INSERT INTO customer VALUES ('"+Id+"','"+CustName+"','"+Add+"','"+Gender+"')";
			try {
				//System.out.println(query);
				qn1 = cn.createStatement();
				qn1.execute(query1);
				JOptionPane.showMessageDialog(null, "Successfully Added Customer");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Failure in Database");
			}
			
		
	}
	public boolean verifyCustomer(String S ) throws SQLException
	{
		boolean result = false;
		qn1 = cn.createStatement();
		try {
			String query="Select CustomerId from customer where CustomerId = '"+S+"'";

			
			ResultSet res1 = qn1.executeQuery(query);
			//String query="Select * from items where Item_Name = '"+pName+"'";
			if (res1.next()==true)
	        {
				
				result=true;
				JOptionPane.showMessageDialog(null,"Customer Found!!!");				
	        }
			else 
				result=false;
			//String result= res.getString(1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Invalid Customer !!!");
		}
		return result;
		
	}
	public String[] getCustomerData()
	{
		
		int result=0;
		String query="Select COUNT(CustomerId) from customer";
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
	String query1 = "SELECT * FROM customer";
	try {
		qn1 = cn.createStatement();
		ResultSet res1 = qn1.executeQuery(query1);
		while (res1.next())
        {
			arr[result] = res1.getString(1);
			result++;
			arr[result] = res1.getString(2);	
			result++;

			
        }
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "No Data Or Lots of Noise\n");
		
	}
		return arr;	
		}
	public void deleteCustomer(String id)
	{
		
		String query="Delete from Customer where CustomerId ='"+id+"'";
		try {
			qn1 = cn.createStatement();
			 qn1.execute(query);	  
			 JOptionPane.showMessageDialog(null, "Customer deleted Successfully");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error to catch it\n");
		}
	}

}
