package MainPkg;

import java.sql.SQLException;

import ControllerPkg.custCTRL;
import ControllerPkg.operatorController;
import ControllerPkg.orderController;
import ViewPkg.CreateCustomer;
import ViewPkg.OperatorLogin;
import ViewPkg.Verification;
import ViewPkg.optionFrame;
import ViewPkg.orderView;
import ModelPkg.OrderModel;
import ModelPkg.customerModel;
import ModelPkg.operatorModel;

public class Main {
	public static void main(String string) throws SQLException{
		
		customerModel custM= new customerModel();
		CreateCustomer creCust= new CreateCustomer();
		//custCTRL cCtrl= new custCTRL(custM, creCust);
		//creCust.setVisible(true);
//		OrderModel model = ModelOrder();
//		orderView view=new orderView();
		Verification vf=new Verification();
		
		operatorModel oM = new operatorModel();
		OperatorLogin oV=new OperatorLogin();
		
		operatorController oC = new operatorController(oM, oV, vf, custM, creCust );
		oV.setVisible(true);
		
		
			
			
		
		
		
	//oc.getViewProduct();
		
	}
	
	
}