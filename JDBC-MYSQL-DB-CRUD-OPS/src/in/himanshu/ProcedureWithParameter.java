package in.himanshu;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProcedureWithParameter {

	private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb"; 
	private static final String DB_UNAME="root"; 
	private static final String DB_PASS="Himanshu@1023"; 
	private static final String PROCEDURE="CALL getBookById(?)"; 
	public static void main(String[] args) throws Exception{

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter book id");
		int id=sc.nextInt();
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PASS);
		CallableStatement cbsmt = con.prepareCall(PROCEDURE);
		cbsmt.setInt(1, id);
		
		ResultSet rs = cbsmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getDouble(3));
		}
		
		con.close();
	}

}
