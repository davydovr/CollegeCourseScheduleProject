
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
			System.out.println("Available Courses:");
			for(Course course: courses)
			{
				System.out.println(course);
				System.out.println();
			}
			
			String courseCode = "MATN-261";
			
			ArrayList<Course> returnedCourses = searchCourses(courses, courseCode);
			System.out.println("All courses with course code "+courseCode);
			System.out.println(returnedCourses.toString()); // remove once connected to GUI
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}
	
	public static ArrayList<Course> searchCourses(ArrayList<Course> courses, String courseCode)
	{
		ArrayList<Course> selectedCourses = new ArrayList<Course>();
		
		for(Course course : courses)
		{
			if(course.getCode().equals(courseCode))
			{
				selectedCourses.add(course);
			}
		}
		
		return selectedCourses;
	}
}
