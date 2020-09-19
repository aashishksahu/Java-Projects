import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q1 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "root", "abc123")) {
			System.out.println("Connection Established successfully");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select empno, ename from emp;");
			
			while(rs.next()) {
				System.out.println("empno: " + rs.getInt("empno") + "\tename: "+rs.getString("ename"));
			}
			rs.close();

		} catch (SQLException e) {
			System.out.println("Connection could not be established");

		}

	}

}
