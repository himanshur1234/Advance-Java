package in.himanshu;

import java.lang.classfile.TypeAnnotation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class ProcedureWith_IN_OUT {
	private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb"; 
	private static final String DB_UNAME="root"; 
	private static final String DB_PASS="Himanshu@1023"; 
	private static final String PROCEDURE="CALL getBookNameByPrice(?,?)"; 
	public static void main(String[] args)throws Exception {

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter book Price");
		Double price=sc.nextDouble();
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PASS);
		CallableStatement cbsmt = con.prepareCall(PROCEDURE);
		cbsmt.setDouble(1, price);
		
		
		cbsmt.registerOutParameter(2, Types.VARCHAR); // important
		
		ResultSet rs = cbsmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		
		con.close();
	}

}
