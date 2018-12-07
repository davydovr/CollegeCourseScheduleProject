
import java.util.ArrayList;

import ScheduleCompMethProject.src.Course;

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
		ruthCourses.add( new Course(11256, "MCON343", "Data Base Concepts & Design", "Plonczak Miriam", 06 ,3));
		ruthCourses.add( new Course(11111, "POLN304", "Politics Of Mid East", "Mond Alan", 06 ,3));
		ruthCourses.add( new Course(11953, "PSYN209", "Introduction To Art Therapy I", "Grenadir Atara", 06 ,3));
		ruthCourses.add( new Course(13201, "PSYN326", "Advanced Topics In Psychology", "Soffer Rebecca", 06 ,3));
		ruthCourses.add( new Course(11658, "SPLN208", "Phonetics", "Roitman Rita", 06 ,3));
		ruthCourses.add( new Course(11659, "SPLN361", "Psycholinguistics", "Bottino Patti", 06 ,3));
		ruthCourses.add( new Course(11221, "BION101", "Principles Of Biology I", "Schiffenbauer Milton", 07 ,3));
		ruthCourses.add( new Course(11331, "BION102L", "Principles Of Biology II Lab", "Borger Rivka", 07 ,0));
		ruthCourses.add( new Course(11380, "BION222L", "Anatomy & Physiology I Lab", "Strickman Jeffrey", 07 ,0));
		ruthCourses.add( new Course(11452, "BIO223", "Anatomy & Physiology II", "Wells Jean", 07 ,4));
		ruthCourses.add( new Course(12303, "CPCN201", "Organic Chemistry I", "Mintzer Evan", 07 ,4));
		//ruthCourses.add( new Course(11222, "BION101L", "Principles Of Biology I Lab", "Schiffenbauer Milton", 08 ,0));
		ruthCourses.add( new Course(11224, "BION101", "Principles Of Biology I", "Zheng Zihwa", 10 ,4));
		ruthCourses.add( new Course(11339, "BION111", "Human Biology Non-Majors", "Merdian William", 10 ,4));
		ruthCourses.add( new Course(11483, "BION228L", "Microbiology Lab", "Leifer Zev", 10 ,0));
		ruthCourses.add( new Course(12105, "CPPNL", "General Physics I Lab", "TBA", 10 ,0));
		ruthCourses.add( new Course(12289, "CPCN201", "Organic Chemistry I", "Mintzer Evan", 10 ,4));
		ruthCourses.add( new Course(12693, "EBAN102", "Prin Of Accounting II", "Edelstein Jacob", 10 ,3));
		ruthCourses.add( new Course(12697, "EBAN202", "Intermediate Accounting II", "Ehrlich Devorah", 10 ,3));
		ruthCourses.add( new Course(12701, "EBAN209", "Financial Statement Analysis", "Berger Chaim", 10 ,3));
		ruthCourses.add( new Course(12702, "EBAN213", "Cost Accounting", "Saltz Simon", 10 ,3));
		ruthCourses.add( new Course(12703, "EBAN301", "Adv Accounting", "Rosenbaum Shulem", 10 ,3));
		ruthCourses.add( new Course(12705, "EBEN102", "Principles Of Microeconomics", "Yarmish Morris", 10 ,3));
		ruthCourses.add( new Course(12708, "EBFN410", "Seminar In Options Trading", "Fischbein William", 10 ,3));
		ruthCourses.add( new Course(12717, "EBKN207", "Social Media & Marketing", "Diamantstein Michael", 10 ,3));
		ruthCourses.add( new Course(12710, "EBKN315", "Advertising & Promotion Management", "Rovt Steven", 10 ,3));
		ruthCourses.add( new Course(12719, "EBMN204", "Human Resource Management", "Felder Simcha", 10 ,3));
		ruthCourses.add( new Course(10631, "EDUN302", "Diag & Corr Read Disab", "Sonnenschein Devorah", 10 ,3));
		ruthCourses.add( new Course(10624, "HISN221", "Survey Mod History II", "Nierman Jay Harris", 10 ,3));
		ruthCourses.add( new Course(10658, "JSBN262", "The Latter Prophets: Isaiah", "Layosh Itzhac", 10 ,3));
		ruthCourses.add( new Course(10623, "HISN342", "Topics In Us Socl Intellectual Hist", "Hertzberg David", 10 ,3));
		ruthCourses.add( new Course(13584, "BION101L", "Principles of Biology Lab", "Levine Alan", 11 ,3));
		ruthCourses.add( new Course(11390, "BION222", "Anatomy & Physiology I", "Merdian William", 11 ,4));
		ruthCourses.add( new Course(11950, "COAN222", "Workshop: Studio Art/Painting I", "Grenadir Atara", 11 ,4));
		ruthCourses.add( new Course(12265, "CPCN102L", "General Chemistry II Lab", "Abbasi Najmunisa", 11 ,0));
		ruthCourses.add( new Course(11260, "BION101L", "Principles Of Biology I Lab", "Zheng Zihwa", 14 ,0));
		ruthCourses.add( new Course(11516, "BION246", "Nutrition And Human Development", "Weinberger Rachael", 14 ,3));
		ruthCourses.add( new Course(12263, "CPCN101", "General Chemistry I", "Mintzer Evan", 14 ,3));
		ruthCourses.add( new Course(12290, "CPCN201L", "Organic Chemistry I Lab", "TBA", 14 ,0));
		ruthCourses.add( new Course(13580, "BION101", "Principles of Biology", "TBA", 16 ,4));
		ruthCourses.add( new Course(13001, "EBEN101", "Principles Of Macroeconomics", "TBA", 16 ,3));
//		ruthCourses.add( new Course(, "", "", "", ,));

	
	}
	
	public ArrayList <Course> getRuthCourses() {
		instantiateArrayList();
		return ruthCourses;
	}

}
