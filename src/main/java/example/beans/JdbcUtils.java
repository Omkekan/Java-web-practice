package example.beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
	public static Connection obtainConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    String url = "jdbc:mysql://localhost:3306/cdac?useSSL=false";
	    String userName = "root";
	    String password = "Omkekan";
	    return DriverManager.getConnection(url, userName, password);
	}
}
