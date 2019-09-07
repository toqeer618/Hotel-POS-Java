package ControllerPkg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ControllerPkg.adminController.ActionFoegetPassword;
import ControllerPkg.adminController.ActionUpdatePassword;
import MainPkg.mainOrder;
import ModelPkg.customerModel;
import ModelPkg.operatorModel;
import ViewPkg.CreateCustomer;
import ViewPkg.OperatorLogin;
import ViewPkg.Verification;
import ViewPkg.forgetPassword;
import ViewPkg.optionFrame;

public class operatorController {
	private customerModel custM;
	private CreateCustomer creCust;
	private  operatorModel alpha;
	private OperatorLogin abc;
	private boolean res;
	private Verification vf;
	private optionFrame obj = new optionFrame();
	private forgetPassword forG= new forgetPassword();

	public operatorController(operatorModel alpha, OperatorLogin beta, Verification vf, customerModel cM,CreateCustomer cC )
	{
		this.alpha=alpha;
		this.abc=beta;
		this.vf=vf;
		this.custM=cM;
		this.creCust=cC;
		Action act=new Action();
		abc.addLoginListener(act);
		vf.addSubmitListener(new ActionSubmit());
		creCust.btnSaveCustomerActListner(new ActionCreateCustomer());
		obj.addTakeButtonListner(new ActionOptionFrame());
		obj.btnAddCust(new ActionOptionFrame1());
		creCust.btnHomeAct(new ActionHome());
		vf.btnHomeAct(new ActionHome());
		abc.btnForgetPasActListner(new ActionFoegetPassword());
		forG.btnSaveActionListner(new ActionUpdatePassword());
		
		
	}
	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				res=alpha.verify(abc.getID(), abc.getPassword());
				if(res==true)
				{
					abc.setVisible(false);
					
					obj.setVisible(true);
				}
				
			} catch (SQLException e1) {
				
				JOptionPane.showMessageDialog(null, "!!!!");
			}
			
			
		}
		
		
		
	}
	class ActionSubmit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String id=vf.getID();
				if( custM.verifyCustomer(id)==true)
				{	
					mainOrder mO=new mainOrder();
					mainOrder.main(id);
					
				}
			} catch (SQLException e2) {

			    JOptionPane.showMessageDialog(null,"Invalid Customer !!!"); 
			}
			
//			try {
//			abc.SetPrice(alpha.returnPrice(abc.getProduct()));
//			} 
//			catch (SQLException e1) {
//				System.out.println("Failure!!!!!");
//			}

	}
	}
	
	class ActionCreateCustomer implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {		
			custM.insertCustomerInfo(creCust.getID(),creCust.getName(), creCust.getAddress(), creCust.getGender());
			creCust.dispose();
								
			
		
	}
		

	}
	
	class ActionOptionFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			vf.setVisible(true);
			
	}
	}
		
		class ActionOptionFrame1 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				obj.dispose();
				creCust.setVisible(true);
				
		}
		

	}
	class ActionHome implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			vf.dispose();
			creCust.dispose();
			obj.setVisible(true);
	}
		

	}
	class ActionFoegetPassword implements ActionListener{
		public void actionPerformed(ActionEvent e) {
					abc.setVisible(false);
					forG.setVisible(true);
				}
			 

			}
		class ActionUpdatePassword implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				
				if(forG.getfPassword().equals(forG.getSPassword()))
				{
					alpha.UpdatePassword(forG.getID(), forG.getSPassword());
					forG.setVisible(false);
					abc.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Password typed in second fiels is incorret");
				}
					
					
				}
			 

			}
	

}