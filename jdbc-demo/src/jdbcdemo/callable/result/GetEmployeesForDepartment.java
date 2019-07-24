package jdbcdemo.callable.result;

import java.sql.*;


public class GetEmployeesForDepartment {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/demo";
		String user = "user";
		String password = "pass";
		url=url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		
		String theDepartment = "Engineering";
		
		
		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(url, user, password);
			
			// Prepare the stored procedure call
			myStmt = myConn.prepareCall("{call get_employees_for_department(?)}");
			
			// Set the parameter
			myStmt.setString(1, theDepartment);
			
			// Call stored procedure
			System.out.println("Calling stored procedure. get_employees_for_department('" + theDepartment + "')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure.\n");
			
			// Get the result set
			myRs = myStmt.getResultSet();
			
			// Display the result set
			display(myRs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, myRs);
		}
	}
	private static void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}


	private static void display(ResultSet myRs) throws SQLException {
		// Process result set
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");

			System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
		}

	}
}
