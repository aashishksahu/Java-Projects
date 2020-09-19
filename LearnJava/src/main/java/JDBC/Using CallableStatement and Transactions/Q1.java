import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q1 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "root", "abc123")) {
			System.out.println("Connection Established successfully");

			int emp_no_input = Integer.parseInt(args[0]);

			PreparedStatement p_stmt = con.prepareStatement("select empno, ename from emp where empno=?");
			p_stmt.setInt(1, emp_no_input);
			ResultSet rs = p_stmt.executeQuery();

			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				CallableStatement stmt = con.prepareCall("{call calculateNetSal (?, ?)}");
				stmt.setInt(1, emp_no_input);
				stmt.registerOutParameter(2, java.sql.Types.INTEGER);
				stmt.executeQuery();

				int net_sal = stmt.getInt(2);

				System.out.println("empno: " + empno + ", ename: " + ename + ", net salary: " + net_sal);
				stmt.close();
			}

			p_stmt.close();

		} catch (SQLException e) {
			System.out.println("Connection could not be established");
		}
	}

}
