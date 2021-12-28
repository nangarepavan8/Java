package com.student.manage;

import java.sql.Connection;                    // for connetion
import java.sql.DriverManager;                     // driver manager must to import
//import java.com.mysql.jdbc.driver;

//import java.sql.SQLException;          // no need

public class CP {

	static Connection con;      // he java.sql.connection pakage mdale ahe.           // static

	public static Connection createC() {                    // static
		
		
		
		try {
			// 1). load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			// create connecetions..
			
			String user ="root";
			String password ="12345678";
			String url ="jdbc:mysql://localhost:3306/student_manage";
			
		/*static Connection*/	con = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
			//  to handel the exception
			e.printStackTrace();       // konti exeption ali tr he sdentence handel karte  // how i dont know..
		}
		
		return con;
		
	}
}
