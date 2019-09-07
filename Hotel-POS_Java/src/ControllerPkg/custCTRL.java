package ControllerPkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ModelPkg.customerModel;
import ViewPkg.CreateCustomer;
import ViewPkg.Verification;
import ViewPkg.orderView;

public class custCTRL {
	private customerModel custM;
	private CreateCustomer creCust;
	private Verification vf;
	private orderView abc;
	public custCTRL(customerModel cM, CreateCustomer cC)
	{
		this.custM=cM;
		this.creCust=cC;
//		ActionCreateCustomer act= new ActionCreateCustomer();
//		creCust.btnSaveActListner(act);
	}
	
	
	

//	class ActionVerify implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {			
//			if( custM.verifyCustomer(vf.getID())==true)
//			{	
//				abc.setVisible(true);
//				 
//				abc.setOrderID(Integer.toString(alpha.orderNumber()+1));
//				abc.setCustomerID(vf.getID());
//			}
//		}	
//}
}
