
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
			
			
			//test the CourseSchedule object and its methods
			System.out.println("Adding course to your schedule...");
			CourseSchedule courseSchedule = new CourseSchedule(18, "Fall 2018");
			try {
				courseSchedule.addCourse(returnedCourses.get(0));//add the first course that was found with to match the code
				System.out.println("your schedule: "+courseSchedule);
				System.out.println("Trying to add the same course again...");
				courseSchedule.addCourse(returnedCourses.get(0));
				
			}catch(TimeslotConflictException | CreditOverflowException e)
			{
				System.out.println(e);
			}
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
