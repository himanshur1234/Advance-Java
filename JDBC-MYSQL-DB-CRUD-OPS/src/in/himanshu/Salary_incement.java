package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Salary_incement {

	public static void main(String[] args)throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb", "root","Himanshu@1023");
		 
		Statement st = con.createStatement();
		String s="SELECT * FROM emp ";
		ResultSet rs = st.executeQuery(s);
		
		StringBuilder sql=new StringBuilder("UPDATE emp SET Emp_Salary=? ");
		
		PreparedStatement stmt = con.prepareStatement(sql.toString());
		while(rs.next()) {
			int salary=rs.getInt(3);
			salary=salary+salary/10;
			stmt.setInt(1, salary);
			
		}
		int row = stmt.executeUpdate();
		
		System.out.println("Row effected :"+row);
		con.close();
		
		
		

	}

}
