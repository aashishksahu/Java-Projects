import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q5 {
	private static void display(Connection con, Integer Rollno) {

		try {
			PreparedStatement stmt;

			if (Rollno != null) {
				stmt = con.prepareStatement("select * from student where Rollno = ?");
				stmt.setInt(1, Rollno);
			} else {
				stmt = con.prepareStatement("select * from student");
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("Rollno: " + rs.getInt("Rollno") + ", StudentName: " + rs.getString("StudentName")
						+ ", Standard: " + rs.getString("Standard") + ", Date_Of_Birth: "
						+ rs.getString("Date_Of_Birth") + ", Fees: " + rs.getInt("Fees"));
			}
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "root", "abc123")) {
			System.out.println("Connection Established successfully");

			Integer Rollno;

			try {
				Rollno = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				Rollno = null;
			}

			display(con, Rollno);

		} catch (SQLException e) {
			System.out.println("Connection could not be established");

		}

	}

}
