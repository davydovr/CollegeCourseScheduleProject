import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BoxLayout;

public class ScheduleUsingDB extends JFrame {

	private JFrame frame;
	private JPanel panel;
	private JPanel tablePanel;
	private JLabel enterCourse;
	private JButton go;
	private JTable coursesTable;
	private DefaultTableModel modelTable;
	private RuthCourseObjects ruthCourses;
	private JTextField userInputCourse;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleUsingDB window = new ScheduleUsingDB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScheduleUsingDB() {
		initialize();
		setupPanel();
	}


	/**
	 * Initialize the contents of the frame.
	 * Initialization does not ADD it.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Course Scheduler");

		panel = new JPanel();
		tablePanel = new JPanel();
		coursesTable = new JTable();

	}
	/**
	 * Adds the elements to the frame, makes them visible
	 */
	private void setupPanel() {

		go = new JButton("Go!");
		enterCourse = new JLabel("Enter course:");
		userInputCourse = new JTextField();

		setupTable();
		setGoButtonAction();

		setPanelLayout();

		frame.getContentPane().add(panel);
		frame.getContentPane().add(tablePanel);		

		tablePanel.add(go);
		tablePanel.add(enterCourse);

		tablePanel.add(userInputCourse);
		userInputCourse.setColumns(10);
	}//end setupPanel

	/**
	 * Sets location of all elements
	 */
	private void setPanelLayout() {
		frame.setBounds(200, 200, 650, 400);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		go.setBounds(257, 66, 75, 29);
		enterCourse.setBounds(41, 65, 82, 29);
		userInputCourse.setBounds(130, 66, 130, 26);

	}
	private void setGoButtonAction() {
		go.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//all that happens inside:!
				ArrayList <Course> courses = new ArrayList <Course> ();
				ArrayList <Course> returnedCourses = new ArrayList <Course> ();
				
				//create connection
				try {
					
					ConnectDB connectDB = new ConnectDB("jdbc:sqlserver://localhost;databaseName=CourseSchedule;integratedSecurity=true");
					//query	
					
					InstantiateCourseObjects fillArray = new InstantiateCourseObjects(connectDB);
					
					//the course user is looking for
					String inputCourse = userInputCourse.getText();

					//get the arraylist of all courses
					courses = fillArray.getCourses();
					
					//the arraylist that will hold the desired courses
					
					
					//find all matching courses
					returnedCourses = searchCourses(courses, inputCourse);
					
				}
				catch(SQLException f)
				{
					System.out.println(f);
				}
				
			
				//if there are matching courses: 
				if (courses.size() > 0) {

					//Convert the containsCourse arraylist into an array. 
					//This enables us to add the course info to the table
					Course [] arrayOfCourses = new Course[returnedCourses.size()];

					//populate the array 
					for (int x = 0; x < returnedCourses.size(); x++) {
						arrayOfCourses[x] = returnedCourses.get(x);
					}

					for (int x = 0; x < returnedCourses.size(); x++) {
						Vector<Comparable> newRow = new Vector <Comparable>();
						newRow.add(returnedCourses.get(x).getCRN());
						newRow.add(returnedCourses.get(x).getCode());
						newRow.add(returnedCourses.get(x).getTitle());
						newRow.add(returnedCourses.get(x).getProfessor());
						newRow.add(returnedCourses.get(x).getTimeSlot());
						newRow.add(returnedCourses.get(x).getCredits());
						modelTable.addRow(newRow); 
					}
					modelTable.fireTableDataChanged();

				}


			}
		});
	}
	
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
	}


	/**
	 * This method creates the outline of the table as it appears before any input is given.
	 * Just the headings, no information inside
	 */
	private void setupTable() {
		String [] tableHeadings = {"CRN", "Course Code", "Course Name", "Professor", "TimeSlot", "Credits"};
		modelTable = new DefaultTableModel(tableHeadings, 0);	//to show outline of table but no information inside yet
		tablePanel.setLayout(null);
		coursesTable = new JTable(modelTable);
		coursesTable.setEnabled(false);	//not to let users tamper with the output
		JScrollPane scrollPane = new JScrollPane(coursesTable);
		scrollPane.setBounds(19, 156, 600, 190);
		tablePanel.add(scrollPane);		//displays the top header

		
	}

}//end program
