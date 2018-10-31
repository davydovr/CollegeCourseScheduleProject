

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CourseSchedule 
{
	public static ArrayList fillObjects() throws IOException
	{
		ArrayList <Course> courses = new ArrayList <Course>();
		Integer time =0;
		Integer crn=0;
		Integer credits=0;
		String professor = null;
		String description =null;
		String courseCode =null;
		File file = new File("testFile.txt");//open file
		Scanner inputFile = new Scanner(file);//create a scanner to read file
		while(inputFile.hasNext())
		{
			time = inputFile.nextInt();
			crn = inputFile.nextInt();
			courseCode = inputFile.next();
			inputFile.nextLine();
			description = inputFile.nextLine();
			professor = inputFile.nextLine();
			credits = inputFile.nextInt();
					
			courses.add(new Course(crn, courseCode, description, professor, time, credits));
		}
		
		inputFile.close();
		return courses;
		
	}
	public static void main(String [] args)throws IOException
	{
		
		System.out.println(fillObjects());
	}
		
}
