import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q4 {
	private static boolean modify(Connection con, int Rollno, int newFees) {
		try {
			PreparedStatement stmt = con.prepareStatement("update student set Fees = ? where Rollno = ?");
			stmt.setInt(1, newFees);
			stmt.setInt(2, Rollno);

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "root", "abc123")) {
			System.out.println("Connection Established successfully");

			modify(con, Integer.parseInt(args[0]), Integer.parseInt(args[1]));

		} catch (SQLException e) {
			System.out.println("Connection could not be established");

		}

	}

}
