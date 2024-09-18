package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertBook {
public static void main(String[] args) throws Exception{
	//Step-1 :Load Driver
	//class.forName-ussed to load any class
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//Step-2:Get Connection
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb", "root","Himanshu@1023"); 
	System.out.println(con);
	
	//Step-3: Create Statement
	Statement stmt = con.createStatement();
	
	String Insert_Sql="INSERT INTO Book VALUES(105,'C',2000)";
	
	//Step-4:Execute Query
	int rowEffected = stmt.executeUpdate(Insert_Sql);// executeUpdate-for DML......executeQuery for DQL
	
	//Step-5:Process the result
	System.out.println("Record Inserted count::"+rowEffected);
	
	//step6:close connection
	con.close();
}
}



