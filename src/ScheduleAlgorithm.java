//The actual algorithm to generate a working schedule of requested courses

import java.util.ArrayList;
import java.util.Collections;

public class ScheduleAlgorithm {
	
		
	public  static CourseSchedule createSchedule(ArrayList<String> requestedCourses, ArrayList<Course> courses, String semester )
	{
		ArrayList<String> reqCourses = requestedCourses;
			
		//An ArrayLists to hold all the arraylists of the available courses that match the user's requested course codes
		ArrayList<ArrayList<Course>> allCourses = new ArrayList<ArrayList<Course>>();
		
		//get an individual array of all the options available for each requested course code
		for(int i=0; i< reqCourses.size(); i++)
		{	
			ArrayList<Course> courseOptions = SearchCourses.search(courses, reqCourses.get(i));
			allCourses.add(courseOptions);
		}
		
		//sort the array ordered by the number of options offered for each course
		//although sorting is not recommended... due to efficiency - it seems like the only way to accomplish what we need 
		//and this is a very small scale, a user doesn't put in an infinite amount of course as there is a credit limit per semester
		Collections.sort(allCourses, new ArrayListSizeComparator());
		
		//actual schedule for the user
		CourseSchedule courseSchedule = new CourseSchedule(18, semester);
		
		ArrayList<Course> coursesToAdd;
		
		//we will go through the courses and keep trying to add the courses until the arrayList is empty
		for(int i =0; i< allCourses.size();i++) 
		{	
			coursesToAdd = allCourses.get(i); //get the first arraylist of the courses that were selected for this user to choose from
						
			//loop through the individual array to try to add the course to the schedule.
			//once its been added successfully, break out of loop
			for(int j = 0; j< coursesToAdd.size();j++)
			{	
				try {
					courseSchedule.addCourse(coursesToAdd.get(j));
					
					//remove the course code from the String list so the user will know which courses couldn't be added
					//since this is a shallow copy it works that in the program which calls this method, 
					//once the schedule is generated, they can check to see if the list is empty
					reqCourses.remove(coursesToAdd.get(j).getCode());
					break;
				}catch(TimeslotConflictException e)
				{
					//now we will do nothing, as the loop will continue
				}catch(CreditOverflowException e )
				{
					//same as above
				}
				
			}
	
		}
		return courseSchedule;
		
		
	}
	
}
