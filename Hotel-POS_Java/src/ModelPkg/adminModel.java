package ModelPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import MainPkg.Connector;

public class adminModel extends Connector {
	private Connection cn;
	private  Statement qn, qn1;

	private String adminName;
	private String adminPassword;
	
	
	public adminModel()
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
	public boolean verify(String S, String X ) 
	{
		boolean result = false;
		try {
			qn1 = cn.createStatement();
			
			String query="Select * from admin where ID = '"+S+"' and Password ='"+X+"'";
			
			ResultSet res1 = qn1.executeQuery(query);
			if (res1.next()==true)
	        {
				result=true;
				JOptionPane.showMessageDialog(null, "Logged In");
	        }
			else 
				result=false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed");
		}
		return result;
		
	}
	//
	public String retName(String S, String X ) 
	{
		String result = null;
		try {
			qn1 = cn.createStatement();
			
			String query="Select * from admin where ID = '"+S+"' and Password ='"+X+"'";
			
			ResultSet res1 = qn1.executeQuery(query);
			if (res1.next()==true)
	        {
				result=res1.getString("Name");
				JOptionPane.showMessageDialog(null, "Logged In");
	        }
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed");
		}
		return result;
		
	}
	//
	public void setOperator(String ID, String Name, String Password, String Gender, String Address, String cnic, String phone)
	{
		String query1="INSERT INTO operator VALUES ('"+ID+"','"+Name+"','"+phone+"','"+Gender+"','"+cnic+"','"+Password+"', '"+Address+"')";
		try {
			qn1=cn.createStatement();
			qn1.execute(query1);
			JOptionPane.showMessageDialog(null, " Operator Created '"+ Name+"'");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " Error");
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
