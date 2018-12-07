import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UseCourseSchedule 
{
	public static void main(String [] args)
	{
		CourseSchedule schedule = new CourseSchedule(18, "Fall-2019"); //instantiate course schedule
		Scanner keyboard = new Scanner(System.in);
		Boolean flag= false;
		
			try //create connection
			{
				
				ConnectDB connectDB = new ConnectDB("jdbc:sqlserver://localhost;databaseName=CourseSchedule;integratedSecurity=true");
				//query	
				
				InstantiateCourseObjects fillArray = new InstantiateCourseObjects(connectDB);
				ArrayList<Course> courses =fillArray.getCourses();//courses in the database to compare to
				Course course=null;
				int crn=0;
				String choice =null;
				do
				{
					while(course==null)
					{
						do
						{
							try
							{
								System.out.println("Enter CRN:");
								crn = keyboard.nextInt();
								keyboard.nextLine();//clear buffer
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
						course = searchCourses(courses, crn);
						if(course==null)
						{
							System.out.println("Invalid crn.");//could not find a match to the crn
						}
					}
					try 
					{
						schedule.addCourse(course);//add course to the schedule
						System.out.println(course);//print or gui print
						
					}
					catch(TimeslotConflictException | CreditOverflowException e)
					{
						System.out.println(e);
					}
					System.out.println("Press any key to continue adding courses or press 'e' to exit.");
					choice = keyboard.nextLine();
				}
				while(choice.toLowerCase().charAt(0)!='e');
			}
			//connection failed
			catch(SQLException e)
			{
				System.out.println(e);
			}
		
	}
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
	}
}
