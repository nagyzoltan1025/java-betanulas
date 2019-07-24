package jdbcdemo.preparedstatement;

import java.sql.*;

public class DriverPreparedStatement {

	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String url="jdbc:mysql://localhost:3306/demo";
		String user = "user";
		String password = "pass";
		url=url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		try {
			// 1. Get a connection to the database
			myConn = DriverManager.getConnection(url, user, password);
			
			// 2. Prepare statement
			myStmt = myConn.prepareStatement("select * from employees where salary > ? and department=?");
			
			// 3. Set the parameters
			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");
			
			// 4. Execute SQL query
			myRs = myStmt.executeQuery();
			
			// 5. Display the result set
			display(myRs);
			
			//
			// Reuse the prepared statement: salary > 25000, department = HR
			//
			System.out.println("\nREUSE PREPARED STATEMENT");
			
			// 6. Set parameters
			myStmt.setDouble(1, 25000);
			myStmt.setString(2, "HR");
			
			// 7. Execute prepared statement and display
			display(myStmt.executeQuery());
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (myStmt != null) { 
				myStmt.close();
			}
		}

	}

	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}

}
