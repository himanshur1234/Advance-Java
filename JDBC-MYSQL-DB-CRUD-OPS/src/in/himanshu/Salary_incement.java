package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Salary_incement {

	public static void main(String[] args)throws Exception {
		
		//This logic will work but it will cause performance issue bcz if there are so many entities thenn it will update that many time ..
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb", "root","Himanshu@1023");
		 Scanner sc= new Scanner(System.in);
		 int hike=sc.nextInt();
//		Statement st = con.createStatement();
//		String s="SELECT * FROM emp ";
//		ResultSet rs = st.executeQuery(s);
		
//		StringBuilder sql=new StringBuilder("UPDATE emp SET Emp_Salary=? WHERE EMP_ID=?");
//		
//		PreparedStatement stmt = con.prepareStatement(sql.toString());
//		while(rs.next()) {
//			int salary=rs.getInt(3);
//			int id=rs.getInt(1); 
//			salary=salary+(salary*hike)/100;
//			stmt.setInt(1, salary);
//			stmt.setInt(2, id);
//			stmt.executeUpdate();
//		}
//		
//		System.out.println("Row updated");
//		con.close();
		
		
		 
		 
		//to resolve this problem wee have to execute the buisness logic in database not in java programm
			
		
		//2nd approch
		String sql="UPDATE emp SET emp_Salary=emp_Salary+(emp_Salary * ?)/100";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setDouble(1, hike);
		int row = stmt.executeUpdate();
		
		System.out.println("Row effected: "+row);
		con.close();
		
				
		

	}

}
