import java.util.ArrayList;

public class SearchCourses {
	
	public static ArrayList<Course> search(ArrayList<Course> courses, String courseCode)
	{
		ArrayList<Course> selectedCourses = new ArrayList<Course>();
		
		for(Course course : courses)
		{
			if(course.getCode().equalsIgnoreCase(courseCode))
			{
				selectedCourses.add(course);
			}
		}
		
		return selectedCourses;
	}

}
