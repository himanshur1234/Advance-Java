package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class HikeBasedOnPerformence {

	public static void main(String[] args)throws Exception {
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb", "root","Himanshu@1023");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Department");
		String dep=sc.next();
		System.out.println("Enter hike Percentage");
		int hike=sc.nextInt();
		
		
		String sql="Update emp SET Emp_Salary=Emp_Salary+(Emp_Salary*?)/100 WHERE Emp_Department=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, hike);
		stmt.setString(2, dep);
		
		int row = stmt.executeUpdate();
		
		System.out.println("Row effected: "+row);
		con.close();
	}

}
