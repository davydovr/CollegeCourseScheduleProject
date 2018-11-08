import java.util.ArrayList;

public class RuthCourseObjects {
	
	private ArrayList <Course> ruthCourses;
	
	public RuthCourseObjects() {
		ruthCourses = new ArrayList <Course> ();
	}
	
	public void instantiateArrayList() {
	
		//Course(int cRN, String code, String title, String professor, Integer timeSlot, Integer credits)
		ruthCourses = new ArrayList <Course>();
		ruthCourses.add( new Course(10617, "HISN220", "Survey Mod History I", "Singer Toba", 01, 3));
		ruthCourses.add( new Course(13394, "MATN261", "Statistics For Soc Sci", "Siegel Stephanie", 01, 3));
		ruthCourses.add( new Course(13138, "PSYN101", "Introduction To Psychology", "Steinman David", 01 , 3));
		ruthCourses.add( new Course(11111, "HISN220", "Survey Mod History I", "Appleseed Johnny", 03, 3));
	}
	
	public ArrayList <Course> getRuthCourses() {
		instantiateArrayList();
		return ruthCourses;
	}

}
