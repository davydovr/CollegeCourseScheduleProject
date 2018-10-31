

import java.sql.SQLException;
import java.util.ArrayList;

public class useCourses {

	
	public static void main(String [] args)
	{
		//create connection
		try {
			
			ConnectDB connectDB = new ConnectDB("jdbc:sqlserver://localhost;databaseName=CourseSchedule;integratedSecurity=true");
			//query	
			
			InstantiateCourseObjects fillArray = new InstantiateCourseObjects(connectDB);
			
			ArrayList<Course> courses =fillArray.getCourses();
			for(Course course: courses)
			{
				System.out.println(course);
				System.out.println();
			}
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		
		
		}
}
