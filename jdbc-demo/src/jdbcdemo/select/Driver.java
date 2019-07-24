package jdbcdemo.select;

import java.sql.*;

public class Driver {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/demo";
		String user = "user";
		String password = "pass";
		Statement myStmt = null;
		
		url=url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
		try {
			// 1. Get a connecion to database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from employees");
			
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " 
									+ myRs.getString("first_name") + ", " 
									+ myRs.getString("email"));
			}		
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myStmt != null) { 
				myStmt.close();
			}
		}
	}
}
