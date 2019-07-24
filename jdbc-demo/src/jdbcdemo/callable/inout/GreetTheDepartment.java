package jdbcdemo.callable.inout;

import java.sql.*;

public class GreetTheDepartment {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/demo";
		String user = "user";
		String password = "pass";
		url=url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		String theDepartment = "Engineering";
		
		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(url, user, password);
			
			// Prepare the stored procedure call
			myStmt = myConn.prepareCall("{call greet_the_department(?)}");
			
			// Set the parameters
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setString(1, theDepartment);
			
			// Call stored procedure
			System.out.println("Calling stored procedure. greet_the_department('" + theDepartment + "')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			
			// Get the value of the INOUT parameter
			String theResult = myStmt.getString(1);
			
			System.out.println("\nThe result = " + theResult);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt);
		}

	}

	private static void close(Connection myConn, CallableStatement myStmt) throws SQLException {
		if(myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
		
	}

}


