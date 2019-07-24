package jdbcdemo.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DriverInsert {

	public static void main(String[] args) {
		
		
		String url="jdbc:mysql://localhost:3306/demo";
		String user = "user";
		String password = "pass";
		
		url=url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";		
		
		try {
			// 1. Get a connection to database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			// 2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			String sql = "insert into employees "
						+" (last_name, first_name, email)"
						+" values ('Brown', 'David', 'david.brown@foo.com')";
			myStmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
