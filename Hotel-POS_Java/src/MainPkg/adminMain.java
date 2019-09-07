package MainPkg;

import ControllerPkg.adminController;
import ModelPkg.adminModel;
import ViewPkg.adminLogin;

public class adminMain {

	public static void main(String string) {
		adminModel aModel=new adminModel();
		adminLogin aLogin = new adminLogin();
		adminController ac=new adminController(aModel, aLogin); 
		
		// aLogin.setVisible(true);

	}

}
