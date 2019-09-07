package MainPkg;

import java.sql.SQLException;

import ControllerPkg.operatorController;
import ControllerPkg.orderController;
import ModelPkg.customerModel;
import ModelPkg.OrderModel;
import ModelPkg.operatorModel;
import ViewPkg.CreateCustomer;
import ViewPkg.OperatorLogin;
import ViewPkg.Verification;
import ViewPkg.orderView;

public class mainOrder {
	static String CustId;
	public void get(String arg)
	{
		
	}
public static void main(String string) throws SQLException{
	CustId=string;
//		customerModel custM= new customerModel();
//		CreateCustomer creCust= new CreateCustomer();
		//custCTRL cCtrl= new custCTRL(custM, creCust);
		//creCust.setVisible(true);
	OrderModel model = ModelOrder();		
	orderView view=new orderView();
		orderController oC=new orderController(model, view);
		oC.id=string;	
//		Verification vf=new Verification();
//		
//		operatorModel oM = new operatorModel();
//		OperatorLogin oV=new OperatorLogin();
//		
//		operatorController oC = new operatorController(oM, oV, vf, custM, creCust );
//		oV.setVisible(true);
		
		
			
			
		
		
		
	//oc.getViewProduct();
		
	}
private static OrderModel ModelOrder(){
	OrderModel student = new OrderModel();
	
	return student;
	}


	

}
