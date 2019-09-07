package ControllerPkg;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ModelPkg.OrderModel;
import ModelPkg.adminModel;
import ModelPkg.customerModel;
import ModelPkg.dealsModel;
import ModelPkg.itemModel;
import ModelPkg.operatorModel;
import ViewPkg.FrontPage;
import ViewPkg.RemoveOp;
import ViewPkg.SearchBar;
import ViewPkg.addDeals;
import ViewPkg.adminLogin;
import ViewPkg.adminOptions;
import ViewPkg.createPdf;
import ViewPkg.forgetPassword;
import ViewPkg.itemView;
import ViewPkg.newItem;
import ViewPkg.operatorSignUp;
import ViewPkg.reMoveCustomer;
import ViewPkg.updateItems;
public class adminController {
	private adminModel aM;
	private adminLogin aL;
	private operatorSignUp oSU=new operatorSignUp();
	private itemView it=new itemView();
	private OrderModel orderM= new OrderModel();
	private itemModel itM=new itemModel();
	private newItem newIt = new newItem();
	private updateItems uI=new updateItems();
	private adminOptions Aop = new adminOptions();
	private operatorModel opModel= new operatorModel();
	private RemoveOp reOp= new RemoveOp();
	private reMoveCustomer remCust = new reMoveCustomer();
	private customerModel custModel = new customerModel();
	private FrontPage FP= new FrontPage();
	private addDeals aDeal= new addDeals();
	private SearchBar aSearch= new SearchBar();
	private forgetPassword forG= new forgetPassword();
	private dealsModel dModel= new dealsModel();
	public adminController(adminModel alpha, adminLogin beta)
	{
		this.aM=alpha;
		this.aL=beta;
		aL.setVisible(true);
		//Admin Login Action Listner
		aL.btnLoginActListner(new Action());
		Aop.btnItemactionListener(new itemf());
		oSU.btnCreateActListner(new Action1());
		Aop.btnOpsign(new Opsignup());
		Aop.btnRemOp(new ActionRemOp());
		//Aop.btnRemCust(act);
		reOp.btnRemoveActListen(new ActionRemOpDel());
		Aop.btnRemCust(new ActionRemCust());
		remCust.btnRemoveActListen(new ActionRemCustDel());
		reOp.btnSaveActListen(new ActionSaveRemOp());
		remCust.btnSaveActListen(new ActionSaveRemOp());
		Aop.btnLogouT(new ActionLogout());
		Aop.btnAddDeal(new ActionAddDeals());
		aDeal.addSaveDealListener(new ActionSaveDeals());
		Aop.btnSearch(new ActionSearch());
		aL.btnForgetPasActListner(new ActionFoegetPassword());
		forG.btnSaveActionListner(new ActionUpdatePassword());
		aDeal.addProductListener(new ActionPrice());
	}
	public void getData()
	{
		reOp.insertData(opModel.getItemData());
	}
	
	public void getCustData()
	{
		remCust.insertData(custModel.getCustomerData());
	}
	
	public void getItemSData()
	{
		uI.insertData(itM.getItemData());
	}
	public void itemview()
	{
		Action act=new Action();
		Action1 act1=new Action1();
		updateCombo();
		
		it.btnDelActLis(new Action11());
		aL.btnLoginActListner(act);
		it.btnAddButton(new ActionSave());
		newIt.addSaveListener(new ActionSave1());
		ActionUpdate AU=new  ActionUpdate();
		it.btnUpdateButton(AU);
		uI.btnSaveUpdate(new ActionUpdate1());
		
		
	}
	//Combo Box updation 
	public void updateCombo() {
			aDeal.setComboBox(itM.getProductList());
			
		}
	
	public void setTopBar()
	{
	
			
			updateCombo();
			aDeal.setVisible(true);
			try {
				aDeal.setDealID(Integer.toString(dModel.DealID()+1));
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	///
	public void ForActioOpSignUp() {
		Aop.btnOpsign(new Opsignup());
		
	}
	//Action Listner
	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
							
			try {
				if(aM.verify(aL.getID(),aL.getPassword())==true)
				{
					aL.setVisible(false);
					Aop.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "AdminID or Password is incorrect.");	
			} catch (HeadlessException e1) {
				aL.setEmpty();
				JOptionPane.showMessageDialog(null, "  AdminID or Password is incorrect.");
			} 
			
		
	}
		

	}
	class Action1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(oSU.getID().equals("") || oSU.getName().equals("") || oSU.getPassword().equals("") || oSU.getGender().equals("")  )
			{
				JOptionPane.showMessageDialog(null, "Please Fill All Boxes");
			}
			else
				aM.setOperator(oSU.getID(), oSU.getName(), oSU.getPassword(), oSU.getGender(), oSU.getAddress(), oSU.getCNIC()
				, oSU.getPhone());
	}

	}
	
	class Action11 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			itM.deleteItem(it.getItemName());
			it.dispose();
					
	}

	}
	class ActionSave implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			it.dispose();
			newIt.setVisible(true);
		
	}

	}
class ActionSave1 implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			String arr[][]=newIt.getTableData();
			for(int i=0; i<arr.length; i++)
			{
				itM.insertItem(arr[i][0], arr[i][1]);
			}
		
	}

	}
class ActionUpdate implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
			it.dispose();
			uI.setVisible(true);
			getItemSData();
			itM.UpdateDelete();
		}

	}
class ActionUpdate1 implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		
		String arr[][]=uI.getTableData();
		for(int i=0; i<arr.length; i++)
		{
			itM.insertItem(arr[i][0], arr[i][1]);
		}
	
}
}
	class itemf implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			//Aop.dispose();

			itemview();
			it.setComboBox(itM.getProductList());
			it.setVisible(true);
			
		}
			 
		
	}

	class Opsignup implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			//Aop.dispose();

			 ForActioOpSignUp();
			oSU.setVisible(true);
			
		}
			 
		
	}
	
class ActionRemOp implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
		//	Aop.dispose();
			reOp.setVisible(true);
			getData();
			
		}
			 
		
	}

class ActionRemOpDel implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		opModel.deleteOperator(reOp.getId());

		
		}
		 
	
	}

class ActionRemCust implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		
		remCust.setVisible(true);
		getCustData();
		
	}
		 
	
}

class ActionSearch implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		//Aop.dispose();
		aSearch.setVisible(true);
		
	}
		 
	
}

class ActionRemCustDel implements ActionListener{


public void actionPerformed(ActionEvent e) {
		custModel.deleteCustomer(remCust.getId());	
		}
	 

	}
class ActionSaveRemOp implements ActionListener{


public void actionPerformed(ActionEvent e) {
		remCust.setVisible(false);
		reOp.setVisible(false);
		Aop.setVisible(true);	
		}
	 

	}
class ActionLogout implements ActionListener{
public void actionPerformed(ActionEvent e) {
			//Aop.setVisible(false);
			FP.setVisible(true);
		}
	 

	}
class ActionAddDeals implements ActionListener{
public void actionPerformed(ActionEvent e) {
		setTopBar();
			aDeal.setVisible(true);
		}
	 

	}
class ActionSaveDeals implements ActionListener{
public void actionPerformed(ActionEvent e) {
//			Aop.setVisible(false);
			aDeal.setVisible(false);
	dModel.insertDeals(aDeal.getDealId(),aDeal.getDealName(), aDeal.getDealPrice());
	String arr[][]=aDeal.gettableData();
	for(int i=0; i<arr.length; i++)
	{
		dModel.insertDealInfo(aDeal.getDealId(), arr[i][0], arr[i][1], arr[i][2]);
	
	}
		}
	 

	}
class ActionFoegetPassword implements ActionListener{
public void actionPerformed(ActionEvent e) {
			aL.setVisible(false);
			forG.setVisible(true);
		}
	 

	}
class ActionUpdatePassword implements ActionListener{
public void actionPerformed(ActionEvent e) {
		
		if(forG.getfPassword().equals(forG.getSPassword()))
		{
			aM.UpdatePassword(forG.getID(), forG.getSPassword());
			forG.setVisible(false);
			aL.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Password typed in second fiels is incorret");
		}
			
			
		}
	 

	}
class ActionPrice implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
			
		
		try {
		aDeal.SetPrice(itM.returnPrice(aDeal.getProduct()));
		} 
		catch (SQLException e1) {
			System.out.println("Failure!!!!!");
		}

	}
	
	
	
}
	
}
