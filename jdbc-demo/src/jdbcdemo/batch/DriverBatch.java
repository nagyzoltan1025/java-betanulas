package jdbcdemo.batch;
import java.sql.*;
public class DriverBatch {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/demo";
		String user = "user";
		String password = "pass";
		url=url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		Connection myConn = DriverManager.getConnection(url, user, password);
		
		// Create statement object
		Statement stmt = myConn.createStatement();

		// Set auto-commit to false
		myConn.setAutoCommit(false);

		// Create SQL statement
		String SQL = "INSERT INTO Employees "
				+ "VALUES(200,'Zia', 'Ali', 'z.a@foo.com', 'HR', 40000)";
		// Add above SQL statement in the batch.
		stmt.addBatch(SQL);

		// Create one more SQL statement
		SQL = "INSERT INTO Employees "
				+ "VALUES(201,'Raj', 'Kumar', 'raj.kumar@foo.com', 'Legal', 100000)";
		
		// Add above SQL statement in the batch.
		stmt.addBatch(SQL);

		// Create one more SQL statement
		SQL = "UPDATE Employees SET salary = 35000 " +
		             "WHERE id > 100";
		// Add above SQL statement in the batch.
		stmt.addBatch(SQL);

		// Create an int[] to hold returned values
		int[] count = stmt.executeBatch();

		//Explicitly commit statements to apply changes
		myConn.commit();

		stmt.close();
		myConn.close();
	}
}
