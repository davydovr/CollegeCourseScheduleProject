//This algorithm is used across our whole program
//searches through the given course list and returns an arraylist 
//with a subset of the course which match a given course code
import java.util.ArrayList;

public class SearchCourses {
	
	public static ArrayList<Course> search(ArrayList<Course> courses, String courseCode)
	{
		ArrayList<Course> selectedCourses = new ArrayList<Course>();
		
		for(Course course : courses)
		{
			if(course.getCode().equalsIgnoreCase(courseCode))
			{
				//valid course are only ones that fit into our schedule GUI - the standard timeslots for the schedule
				if(course.getTimeSlot()==5||course.getTimeSlot()==6 || course.getTimeSlot()==10 ||
						course.getTimeSlot()==11 || course.getTimeSlot()==16 || course.getTimeSlot()== 14)
				{
					selectedCourses.add(course);
				}
			}
		}
		
		return selectedCourses;
	}

}
