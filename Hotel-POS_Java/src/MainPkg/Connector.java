package MainPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private Connection cn;
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

}
