import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q2 {

	public static boolean insertRecords(Connection con, int Rollno, String StudentName, String Standard,
			String Date_Of_Birth, int Fees) {

		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into student (Rollno, StudentName, Standard, Date_Of_Birth, Fees) values(?,?,?,?,?)");
			stmt.setInt(1, Rollno);
			stmt.setString(2, StudentName);
			stmt.setString(3, Standard);
			stmt.setString(4, Date_Of_Birth);
			stmt.setInt(5, Fees);

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

			insertRecords(con, 1, "A", "I", "02-12-2000", 3450);
			insertRecords(con, 2, "B", "II", "03-11-1999", 4450);
			insertRecords(con, 3, "C", "III", "04-10-1998", 4550);
			insertRecords(con, 4, "D", "IV", "05-09-1997", 4600);
			insertRecords(con, 5, "E", "V", "06-08-1996", 5000);

		} catch (SQLException e) {
			System.out.println("Connection could not be established");

		}

	}

}
