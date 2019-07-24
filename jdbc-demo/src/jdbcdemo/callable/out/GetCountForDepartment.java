package jdbcdemo.callable.out;

import java.sql.*;

public class GetCountForDepartment {

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
			
			// Prepare the stored procedure
			myStmt = myConn.prepareCall("{call "
					+ "get_count_for_department(?, ?)}");
			
			// Set the parameters
			myStmt.setString(1,  theDepartment);
			myStmt.registerOutParameter(2, Types.INTEGER);
			
			// Call stored procedure
			System.out.println("Calling stored procedure. get_count_for_department('" + theDepartment + "', ?)");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			
			// Get the value of the OUT parameter
			int theCount = myStmt.getInt(2);
			
			System.out.println("\nThe count = " + theCount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt);
		}
	}

	private static void close(Connection myConn, CallableStatement myStmt) throws SQLException {
		if (myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
		
	}
}
