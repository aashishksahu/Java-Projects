import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q2 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "root", "abc123")) {
			System.out.println("Connection Established successfully");

			Statement stmt = con.createStatement();

			String query = "select ename, job, sal, com from emp where sal > 1000 and sal < 2000;";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println("ename: " + rs.getString("ename") + "\t" + "job: " + rs.getString("job") + "\t"
						+ "sal: " + rs.getDouble("sal") + "\t" + "com: " + rs.getDouble("com"));
			}
			rs.close();

		} catch (SQLException e) {
			System.out.println("Connection could not be established");

		}

	}

}
