import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Q2 {

	public static void main(String[] args) {

		Connection con = null;

		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "root", "abc123");
			System.out.println("Connection Established successfully");

		} catch (SQLException e) {
			System.out.println("Connection could not be established");

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

}
