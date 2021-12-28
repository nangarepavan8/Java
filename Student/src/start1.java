
//import java.io.*;                            // we add the specific import packages thats why no need to add
// bufferd reader and input stream reader

import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
//import java.com.mysql.jdbc.driver;

public class start1 {
	

	public static void main(String args[]) throws IOException{ 
		
		//			int c = Integer.parseInt(br.readLine());   ya line mule IO Exception ale ahe
		
		System.out.println("Wel come to om sai ram world \n");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.println(" PRESS 1 to ADD students");
			System.out.println(" PRESS 2 to DELETE students");
			System.out.println(" PRESS 3 to DISPLAY students");
			System.out.println(" PRESS 4 to EXIT app");

			int c = Integer.parseInt(br.readLine());
			
			if(c == 1)
			{
//				//  ADD student
//				System.out.println("Enter the user ID: ");
//				String id = br.readLine();
//				
				System.out.println("Enter the user name: ");
				String name = br.readLine();
				
				System.out.println("Enter the user phone: ");
				String phone = br.readLine();
				
				System.out.println("Enter the user city: ");
				String city = br.readLine();
				
				
				// create student object  to store the student
				
//				Student st=new Student(name, phone, city);      // object create kelya vr error jate 
				//options select karav lagate.. Students nntr paused gheun.
				
//				Student st = new Student(id, name, phone, city);
		        Student st = new Student( name, phone, city);
		        
				boolean ans	= StudentDao.insertStudentDB(st);     // object create krun nantr tyacha tya specific code mde transfer kaara.
				boolean add= true;
				if(ans == add)
				{ 
					System.out.println("student added succesfully..");
				}
				else
				{
					
					System.out.println("Something went wrong (add)");
				}
				
				System.out.println(st);
				
			}
			else if(c == 2)
			{
				// DELETE
				System.out.println("Enter user ID to deleet");
				
				int userId =Integer.parseInt(br.readLine());
				
				boolean deletecheck =StudentDao.deleteStudent(userId);
				
				if(deletecheck) {
					System.out.println("Delted the item...");
				}
				else {
					System.out.println("something went wrong  in delet");
				}
				
				
			}
			else if(c == 3)
			{
				// Display
				
			StudentDao.showAllStudent();
				
				
				
			}
			else if(c == 4)
			{
				//Exit
				
				break; // exit the loop
				
			}
			else
			{
				System.out.println("Please enter the invalid Input");
			}
			
			System.out.println("  Thank you for using my application ");
			System.out.println(" See you soon....");


			
		}
	}
}
