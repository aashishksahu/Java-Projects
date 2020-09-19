import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q3 {
	private static boolean fetchRecord(Connection con, Integer Rollno, String Leaving_Date) {
		try {
			PreparedStatement stmt = con.prepareStatement("select * from student where Rollno = ?");
			stmt.setInt(1, Rollno);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				insertRecord(con, rs.getInt("Rollno"), rs.getString("StudentName"), rs.getString("Standard"), Leaving_Date);
			}
			rs.close();

			return true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	private static boolean deleteRecord(Connection con, int Rollno) {

		try {
			PreparedStatement stmt = con.prepareStatement("delete from student where Rollno = ?");
			stmt.setInt(1, Rollno);

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	private static boolean insertRecord(Connection con, int Rollno, String StudentName, String Standard, String Leaving_Date) {

		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into StudentLog (Rollno, StudentName, Standard, Leaving_Date, Fees) values(?,?,?,?,?)");
			stmt.setInt(1, Rollno);
			stmt.setString(2, StudentName);
			stmt.setString(3, Standard);
			stmt.setString(4, Leaving_Date);

			stmt.executeUpdate();

			deleteRecord(con, Rollno);
			
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "root", "abc123")) {
			System.out.println("Connection Established successfully");

			fetchRecord(con, Integer.parseInt(args[0]), args[1]);

		} catch (SQLException e) {
			System.out.println("Connection could not be established");

		}

	}

}
