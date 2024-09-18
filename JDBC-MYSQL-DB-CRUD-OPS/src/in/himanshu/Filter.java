package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Filter {

	public static void main(String[] args) throws Exception{
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb", "root","Himanshu@1023");
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Location");
		String loc=sc.next();
		
		System.out.println("Enter Gender");
		String gen=sc.next();
		
		StringBuilder sql=new StringBuilder("SELECT * FROM emp WHERE 1=1 ");
		
		if(loc!=null&&!loc.equals("null")) {
			sql.append("AND Work_Loc=?");
		}
		if(gen!=null&&!gen.equals("null")) {
			sql.append("AND Emp_Gender=?");
		}
		
		PreparedStatement stmt = con.prepareStatement(sql.toString());
		
		int index=1;
		if(loc!=null&&!loc.equals("null")) {
			stmt.setString(index, loc);
			index++;
		}
		if(gen!=null&&!gen.equals("null")) {
			stmt.setString(index,gen);
			index++;
		}
		
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getDouble(3)+"----"+rs.getString(4)+"---"+rs.getString(5));
		}
		con.close();
	}

}
