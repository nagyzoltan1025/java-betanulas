package jdbcdemo.update;

import java.sql.*;

public class DriverUpdate {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/demo";
		String user = "user";
		String password = "pass";
		Statement myStmt = null ;
		
		url=url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
		try {
			// 1. Connect the database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			String sql = "update employees "
					   + "set email='demo@foo1234.com'"
					   + "where id=6";
			myStmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (myStmt != null) { 
				myStmt.close();
			}			
		}
	}

}
