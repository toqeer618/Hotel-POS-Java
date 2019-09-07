package ControllerPkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import ModelPkg.OrderModel;
import ModelPkg.customerModel;
import ModelPkg.itemModel;
import ViewPkg.orderView;
import ViewPkg.udateOrder;
import ViewPkg.Verification;
import ViewPkg.createPdf;
import ViewPkg.dealothers;
import ViewPkg.optionFrame;


public class orderController {
	private dealothers deal= new dealothers();
	udateOrder uO=new udateOrder();
	private OrderModel alpha;
	private orderView abc;
	private customerModel custM= new customerModel();
	private itemModel itM=new itemModel();
	private createPdf cPdf= new createPdf();
	private optionFrame opF= new optionFrame();
	Verification vf;
	public String id;
	public orderController(OrderModel alpha, orderView beta)
	{
		
		this.alpha=alpha;
		this.abc=beta;
		Action act=new Action();
		Action1 act1=new Action1();
		Action2 act2=new Action2();
	
	abc.addProductListener(act);
	abc.addSaveListener(act1);
	uO.addSaveListener(act2);
	uO.addCancelListener(new ActionCancel());
	abc.HomeActListen(new ActionHome());
	uO.HomeActListen(new ActionHome());
	deal.otherActListen(new ActionOther());
	SelectOPtion();
	Home();
	}
	public void updateCombo() {
		abc.setComboBox(itM.getProductList());
		
	}
	public void SelectOPtion()
	{	
		deal.setVisible(true);
		
	}
	
	public void setTopBar(String Id)
	{
	
			abc.setCustomerID(Id);
			updateCombo();
			abc.setVisible(true);
			try {
				abc.setOrderID(Integer.toString(alpha.orderNumber()+1));
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void Home()
	{	
		
	}
	

	
		
	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
				
			
			try {
			abc.SetPrice(alpha.returnPrice(abc.getProduct()));
			} 
			catch (SQLException e1) {
				System.out.println("Failure!!!!!");
			}

		}
		
		
		
	}
	
	class Action1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String arr[][]=abc.getTableData();
			
			abc.setVisible(false);
			uO.setVisible(true);
			uO.insertData(arr);
			
		}
			
	}
	
	class Action2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String arr1[][]=abc.getTableData();
			
			try {
				boolean ax=alpha.insertSalesInfo(alpha.orderNumber()+1, abc.getId(),uO.getTotal(), abc.getDate());
				if(ax==true)
					{
					String arr[][]=abc.getTableData();
					createPdf.genBill(arr, abc.getId(), alpha.orderNumber()+1);
					for(int i=0; i<arr.length; i++)
					{
						int data1 = Integer.parseInt(arr[i][1]);
						int data2 = Integer.parseInt(arr[i][3]);
						try {
							alpha.insertData((alpha.orderNumber()), arr[i][0], data1, data2);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							
						}
					}
			}
					
				
			} catch ( SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
	}
	
	}
	
	class ActionCancel implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
		uO.dispose();
		opF.setVisible(true);
			
		}
		
	}
	class ActionHome implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
		abc.dispose();
		uO.dispose();
		opF.setVisible(true);
			
		}
		
	}
	class ActionOther implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setTopBar(id);
			
		}
		
	}

}
