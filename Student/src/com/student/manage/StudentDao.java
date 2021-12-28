// om sai ram..
package com.student.manage;

// import java.sql.*;
// import java.com.mysql.jdbc.driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

//	Connection con;            // con is null so it gives error..
	
	public static boolean insertStudentDB(Student st) {  // object banvaycha nasel tr static kara..
		
		// jdbc code to insert into database..
		
		boolean  f= false;
		try {
			
			Connection con= CP.createC();
			
			String q = "insert into student(studentName, studentPhone, studentCity) values(?,?,?);";
			
			// prepared statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			// execute
			pstmt.executeUpdate();               // transfer to database..
			
			
			f= true;         // update jhala tr TRUE kr... nhi tr false kr..1 return kr
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
//    Delete 
	
	public static boolean deleteStudent(int userId) {
		
		// copy pasted cabove method  to save the time
		
		
		boolean  f= false;
		try {
			
			Connection con= CP.createC();
			
			String q = "delete from student where studentId=?";
			
			// prepared statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value of parameter
			
			pstmt.setInt(1, userId);
			
			// execute
			pstmt.executeUpdate();               // transfer to database..
			
			
			f= true;         // update jhala tr TRUE kr... nhi tr false kr..1 return kr
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
		
		
	}

	public static void showAllStudent() {
		// display all the students   queery -->> select * from student;
		
		
		 
		try {
			
			Connection con= CP.createC();
			
			String q = "select * from student";
			// display karnya stahi query execute karayala       ( create statemnt karav lagat).....
		
			Statement stmt =con.createStatement();
			
			ResultSet set= stmt.executeQuery(q);

			while(set.next())
			{
				int  studentId= set.getInt(1);
				String studentName = set.getString(2);
				String studentPhone = set.getString(3);
				String studentCity = set.getString(4);
				
				System.out.println("ID  :"+ studentId);
				System.out.println("Name  :"+ studentName);
				System.out.println("Phone  :"+ studentPhone);
				System.out.println("City  :"+ studentCity);
				System.out.println("+++++++++++++++++++++++++++++++");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		
	}
}
