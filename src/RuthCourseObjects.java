
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
		ruthCourses.add( new Course(11261, "BION101", "Principles Of Biology I", "Borger Rivka", 02 ,4));
		ruthCourses.add( new Course(13585, "BION400", "Neuroscience", "Levine Alan", 02 ,3));
		ruthCourses.add( new Course(11262, "BION101L", "Principles Of Biology I Lab", "Borger Rivka", 04 ,0));
		ruthCourses.add( new Course(12671, "EBMN101", "Principles Of Management", "Felder Simcha", 04 ,3));
		ruthCourses.add( new Course(10618, "HISN221", "Survey Mod History II", "TBA", 04 ,3));
		ruthCourses.add( new Course(12756, "LLEN102", "English Composition II", "Epstein Janey", 04 ,3));
		ruthCourses.add( new Course(13139, "PSYN205", "Psyc Of Motivation", "Litwin Elissa", 04 ,3));
		ruthCourses.add( new Course(13141, "PSYN325", "Drugs And Behavior", "Steinman David", 04 ,3));
		ruthCourses.add( new Course(13381, "SASN103", "Introduction To Sociology", "Ratti Deborah", 04 ,3));
		ruthCourses.add( new Course(11656, "SPLN101", "Fund Of Speech I", "TBA", 04 ,3));
		ruthCourses.add( new Course(11338, "BION111", "Human Biology Non-Majors", "Dadivinyan Ara", 05 ,4));
		ruthCourses.add( new Course(11952, "COAN331", "Costume&Fashion in Art W Civ", "Terry-Seidenberg Rhoda", 05 ,3));
		ruthCourses.add( new Course(12672, "EBAN102", "Prin Of Accounting II", "Halberstam Breindy", 05 ,3));
		ruthCourses.add( new Course(12673, "EBAN314", "Fed Income Taxation Of Individ", "Bienenstock Shammai", 05 ,3));
		ruthCourses.add( new Course(12676, "EBEN102", "Principles Of Microeconomics", "Szenberg Michael", 05 ,3));
		ruthCourses.add( new Course(12678, "EBFN101", "Principles Of Finance", "Fischbein William", 05 ,3));
		ruthCourses.add( new Course(12680, "EBKN101", "Principles Of Marketing", "Felder Simcha", 05 ,3));
		ruthCourses.add( new Course(12681, "EBKN202", "Marketing Research", "Popkoff Eric", 05 ,3));
		ruthCourses.add( new Course(10625, "EDUN201", "Psy/Soc Found Grwth-Dev&Lrn Bir-G6", "Dickstein Joel", 05 ,3));
		ruthCourses.add( new Course(10619, "HISN220", "Survey Mod History I", "Singer Toba", 05 ,3));
		ruthCourses.add( new Course(13578, "LLEN100", "Introduction to Eng Comp", "Maltzman Rachelle", 05 ,3));
		ruthCourses.add( new Course(12757, "LLEN221", "Survey Of Modern Literature II", "Epstein Janey", 05 ,3));
		ruthCourses.add( new Course(13391, "MATN111", "College Mathematics", "Siegel Stephanie", 05 ,3));
		ruthCourses.add( new Course(11257, "MCON140", "Computer Concepts/Business Applctn", "Morgulis Debra", 05 ,3));
		ruthCourses.add( new Course(11110, "POLN101", "American Politics", "Mond Alan", 05 ,3));
		ruthCourses.add( new Course(13184, "PSYN201", "Developmental Psych", "Pretter Sheindy", 05 ,3));
		ruthCourses.add( new Course(13181, "PSYN332", "History And System Of Psychology", "Steinman David", 05 ,3));
		ruthCourses.add( new Course(13146, "PSYN345", "Psychology Of Health & Illness", "Litwin Elissa", 05 ,3));
		ruthCourses.add( new Course(13150, "PSYN492", "Honors Seminar In Psychology", "Soffer Rebecca", 05 ,3));
		ruthCourses.add( new Course(13579, "SASN493", "Topics: Technology and Society", "Ratti Deborah", 05 ,3));
		ruthCourses.add( new Course(11657, "SPLN101", "Fund of Speech I", "TBA", 05 ,3));
		ruthCourses.add( new Course(11947, "COAN101", "Art Of Western Civilization", "Terry-Seidenberg Rhoda", 06 ,3));
		ruthCourses.add( new Course(12682, "EBAN101", "Prin Of Accounting I", "Halberstam Breindy", 06 ,3));
		ruthCourses.add( new Course(12685, "EBAN201", "Intermediate Accounting I", "Saltz Simon", 06 ,3));
		ruthCourses.add( new Course(12686, "EBAN302", "Government &Not-For-Profit Accoutng", "Newman Yosef", 06 ,3));
		ruthCourses.add( new Course(12687, "EBAN316", "Corporation & Partnership Tax", "Bienenstock Shammai", 06 ,3));
		ruthCourses.add( new Course(12689, "EBEN101", "Principles Of Macroeconomics", "Yarmish Morris", 06 ,3));
		ruthCourses.add( new Course(12690, "EBKN101", "Principles Of Marketing", "Diamantstein Michael", 06 ,3));
		ruthCourses.add( new Course(12691, "EBKN204", "Marketing Management", "Popkoff Eric", 06 ,3));
		ruthCourses.add( new Course(10628, "EDUN311", "Principles Of Early Childhood Ed", "Vigilance Devika", 06 ,3));
		ruthCourses.add( new Course(10621, "HISN220", "Survey Mod History I", "Singer Toba", 06 ,3));
		ruthCourses.add( new Course(10622, "HISN251", "Jews And Arabs", "Nierman Jay Harris", 06 ,3));
		ruthCourses.add( new Course(12758, "LLEN101", "English Composition I", "Maltzman Rachelle", 06 ,3));
		ruthCourses.add( new Course(12760, "LLEN102", "English Composition II", "Epstein Janey", 06 ,3));
		ruthCourses.add( new Course(12762, "LLEN219", "Lit of Ancient & Medieval Worlds", "Buchman Hedy", 06 ,3));
		ruthCourses.add( new Course(13393, "MATN261", "Statistics For Soc Sci", "Siegel Stephanie", 06 ,3));
		ruthCourses.add( new Course(11258, "MCON140", "Computer Concepts/Business Applctn", "Zlotnikov Aleksandr",06,3));
		ruthCourses.add( new Course(11259, "MCON141", "Introduction To Programming", "Morgulis Debra", 06 ,3));
//		ruthCourses.add( new Course(11256, "MCON343", "Data Base Concepts & Design", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));
//		ruthCourses.add( new Course(, "", "", "", ,));

	
	}
	
	public ArrayList <Course> getRuthCourses() {
		instantiateArrayList();
		return ruthCourses;
	}

}
