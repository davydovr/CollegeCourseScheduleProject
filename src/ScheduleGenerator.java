import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScheduleGenerator 
{
	private JFrame frame;
	private	JPanel container;


	// User Input Panel
	private JPanel userInputPanel;
	private JLabel enterCourse;
	private JButton go;
	private JTextField userInputCourse;
	
	// Display Courses in a List Panel
	private JPanel displayCoursesListPanel;
	private JTable tableDisplayCoursesList;
	private DefaultTableModel modelTableDisplayCoursesList;
	private String [] displayCourseListTableHeadings = {"CRN", "Course Code", "Course Name", "Professor", "TimeSlot", "Credits"};
	
	//Schedule Format Panel
	private JPanel scheduleFormatPanel;
	private JTable tableScheduleFormat;
	private DefaultTableModel modelTableScheduleFormat;
	private String [] scheduleFormatHeadings = {"Time", "Tuesday", "Thursday"};
	
	/**Constructor**/
	public ScheduleGenerator()
	{
		initialize();//set up GUI
		
		setupDisplayCourseListPanel();
		setupUserPanel();
		
		userInputPanelSetActionListener();
	
		setupScheduleFormatPanel();
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
		
		container = new JPanel();


		//Do not adjust column widths automatically; use a horizontal scrollbar instead.
		tableDisplayCoursesList.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );		
	}

	private void setupUserPanel() {
		//initialize
		userInputPanel = new JPanel();
		enterCourse = new JLabel("Enter course:");
		go = new JButton("Go!");
		userInputCourse = new JTextField();

		//set location
		enterCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		enterCourse.setBounds(34, 58, 115, 16);
		go.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		go.setBounds(284, 54, 75, 29);
		userInputCourse.setBounds(155, 54, 128, 26);
		userInputPanel.setLayout(null);

		//add to panel
		userInputPanel.add(enterCourse);
		userInputPanel.add(go);
		userInputPanel.add(userInputCourse);
		
		container.add(userInputPanel);
	}
	
	private void setupDisplayCourseListPanel() {
		
		displayCoursesListPanel = new JPanel();
	//	displayCoursesListPanel.setBounds(0, 216, 150, 0);
	//	displayCoursesListPanel.setBounds(-7, 5, 464, 430);
		
		modelTableDisplayCoursesList = new DefaultTableModel(displayCourseListTableHeadings, 0);
		//displayCoursesListPanel.setLayout(null);
		tableDisplayCoursesList = new JTable(modelTableDisplayCoursesList);
		tableDisplayCoursesList.setEnabled(false);		//not to allow user to edit the table
		
		JScrollPane scrollPane = new JScrollPane(tableDisplayCoursesList);
		//scrollPane.setBounds(19, 156, 200, 190);
		
		displayCoursesListPanel.add(scrollPane);		//add the table to the panel
		
		container.add(displayCoursesListPanel);
	}
	
	private void setupScheduleFormatPanel() {
		scheduleFormatPanel = new JPanel();

		modelTableScheduleFormat = new DefaultTableModel(scheduleFormatHeadings, 0);
		
		tableScheduleFormat = new JTable (modelTableScheduleFormat);
		tableScheduleFormat.setEnabled(false);
		
		JScrollPane scrollpane = new JScrollPane(tableScheduleFormat);
		scrollpane.setBounds(54, 90, 442, 176);
		
		scheduleFormatPanel.add(scrollpane);
		
		container.add(scheduleFormatPanel);
		
	}

	private void userInputPanelSetActionListener() {
		//listens out for an enter key
		userInputCourse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					userInputAction();
				}
			}
		});
		//listens out for a click
		go.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//all that happens inside:!
				userInputAction();
			}
		});
	}//end setActionListener
	
	private void userInputAction() {
		// when the user presses GO to add a course to the arraylist 
	}


}
