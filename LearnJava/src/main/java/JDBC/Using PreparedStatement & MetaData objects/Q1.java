import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DAOClass {
	public boolean insert(Connection con, int Rollno, String StudentName, String Standard, String Date_Of_Birth, int Fees) {

		try {
			PreparedStatement stmt = con
					.prepareStatement("insert into student (Rollno, StudentName, Standard, Date_Of_Birth, Fees) values(?,?,?,?,?)");
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

	public boolean delete(Connection con, int Rollno) {

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

	public boolean modify(Connection con, int Rollno, int newFees) {
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

	public void display(Connection con, Integer Rollno) {

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
				System.out.println("Rollno: " + rs.getInt("Rollno") + ", StudentName: " + rs.getString("StudentName") + ", Standard: "
						+ rs.getString("Standard") + ", Date_Of_Birth: " + rs.getString("Date_Of_Birth") + ", Fees: " + rs.getInt("Fees"));
			}
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}

public class Q1 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "root", "abc123")) {
			System.out.println("Connection Established successfully");

			DAOClass op = new DAOClass();

			if (Integer.parseInt(args[0]) == 1) {
				op.insert(con, Integer.parseInt(args[1]), args[2], args[3], args[4], Integer.parseInt(args[5]));

			} else if (Integer.parseInt(args[0]) == 2) {
				op.delete(con, Integer.parseInt(args[1]));

			} else if (Integer.parseInt(args[0]) == 3) {
				op.modify(con, Integer.parseInt(args[1]), Integer.parseInt(args[2]));

			} else if (Integer.parseInt(args[0]) == 3) {

				Integer Rollno;

				try {
					Rollno = Integer.parseInt(args[1]);
				} catch (NumberFormatException e) {
					Rollno = null;
				}

				op.display(con, Rollno);
			}

		} catch (SQLException e) {
			System.out.println("Connection could not be established");

		}

	}

}
