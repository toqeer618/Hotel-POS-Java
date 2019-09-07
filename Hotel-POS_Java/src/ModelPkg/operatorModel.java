package ModelPkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import MainPkg.Connector;

public class operatorModel  {
	private Connection cn;
	private  Statement qn, qn1;


	public operatorModel()
	{
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
	public boolean verify(String S, String X ) throws SQLException
	{
		boolean result = false;
		qn1 = cn.createStatement();
		try {
			String query="Select * from operator where ID = '"+S+"' and Password ='"+X+"'";
			
			ResultSet res1 = qn1.executeQuery(query);
			//String query="Select * from items where Item_Name = '"+pName+"'";
			if (res1.next()==true)
	        {
				result=true;
				System.out.println(query);
				
	        }
			else 
				result=false;
			//String result= res.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	public String[] getItemData()
	{
		
		int result=0;
		String query="Select COUNT(ID) from operator";
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
	System.out.println(result);
	result=0;
	String query1 = "SELECT * FROM operator";
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
	//
	public void deleteOperator(String id)
	{
		
		String query="Delete from operator where ID ='"+id+"'";
		try {
			qn1 = cn.createStatement();
			 qn1.execute(query);	  
			 JOptionPane.showMessageDialog(null, "Operator deleted Successfully");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error to catch it\n");
		}
	}
	public void UpdatePassword(String ID, String Password)
	{
		String query1="Update admin Set  Password= '"+Password+"' where ID = '"+ID+"'";
		try {
			qn1=cn.createStatement();
			qn1.execute(query1);
			JOptionPane.showMessageDialog(null, "Password Updated Successfully");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " Wrong ID");
		}
	}
}
