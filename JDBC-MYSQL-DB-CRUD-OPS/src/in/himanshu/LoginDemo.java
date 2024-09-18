package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDemo {

	public static void main(String[] args)throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb", "root","Himanshu@1023");
		
		Statement stmt = con.createStatement();
		
		System.out.println("Enter 1 for Login and 2 for Register");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		
		String id;
		String pass;
		
		switch (a){
		
		case 1:
			System.out.println("Enter email id");
			id=sc.next();
			System.out.println("Enter Password");
			pass=sc.next();
			
			String query="SELECT *FROM data where id="+id+",Pass="+pass;
			
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				System.out.println("Succesfully login");
			}else {
				System.out.println("Wrong id and password");
			}
			
			
		case 2:
			System.out.println("Enter email id");
			id=sc.next();
			System.out.println("Enter Password");
			pass=sc.next();
			String queryinsert="INSERT INTO data VALUES("+id+","+pass+")";
			int roweffected = stmt.executeUpdate(queryinsert);
			System.out.println("Sinup succesfully");
		}
		
		con.close();
	}

}
