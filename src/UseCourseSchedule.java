import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UseCourseSchedule 
{
	public static void main(String [] args)
	{
		CourseSchedule schedule;
		String semester = "Fall-2019"; 
		Scanner keyboard = new Scanner(System.in);
		Boolean flag= false;
		
			try //create connection
			{
				
				ConnectDB connectDB = new ConnectDB("jdbc:sqlserver://localhost;databaseName=CourseSchedule;integratedSecurity=true");
				//query	
				
				InstantiateCourseObjects fillArray = new InstantiateCourseObjects(connectDB);
				ArrayList<Course> courses =fillArray.getCourses();//courses in the database to compare to
				ArrayList<String> selectedCourseCodes= new ArrayList<String>(); //these are the courses that the user wishes to take
				//int crn=0;
				String courseCode= null;
				String choice =null;
				do
				{
					//while(selectedCourseCodes==null)
					//{
					do {	
						do
						{
							try
							{
								System.out.println("Enter Course Code:");
								courseCode = keyboard.nextLine();
								//keyboard.nextLine();//clear buffer
								flag=true;
							}
							catch(InputMismatchException e)
							{
								System.out.println(e);
								keyboard.nextLine();//clear buffer
							}
						}
						while (flag==false);
						flag=false;//Reinitialize flag so we can reuse later
						if(SearchCourses.search(courses, courseCode).size()>0) //check that this course code is valid
						{
							selectedCourseCodes.add(courseCode);
							flag = true;
						}
						else
						{
							System.out.println("Invalid course code.");//could not find a match to the course code
							
						}
				}while(flag==false);
				//	}
				/*	try 
					{
						schedule.addCourse(course);//add course to the schedule
						System.out.println(course);//print or gui print
						
					}
					catch(TimeslotConflictException | CreditOverflowException e)
					{
						System.out.println(e);
					}
				*/
					System.out.println("Press any key to continue adding courses or press 'f' to finish.");
					choice = keyboard.nextLine();
				}
				while(choice.toLowerCase().charAt(0)!='f');
				
				
				//now get the schedule
				schedule =  ScheduleAlgorithm.createSchedule(selectedCourseCodes, courses, semester);
				System.out.println(schedule);
				
				
				keyboard.close();
			}
			//connection failed
			catch(SQLException e)
			{
				System.out.println(e);
			}
		
	}
	/*
	public static Course searchCourses(ArrayList<Course> courses, Integer crn)
	{	
		for(Course c : courses)
		{
			if(c.getCRN().equals(crn))
			{
				return c;
			}
		}
		return null;
	}*/
	
	/*//commenting this out and extracting to a class with a static method so all the classes can use the algorithm
	public static ArrayList<Course> searchCourses(ArrayList<Course> courses, String courseCode)
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
	}*/
}
