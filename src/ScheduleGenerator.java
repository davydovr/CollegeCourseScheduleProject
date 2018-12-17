import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ScheduleGenerator 
{
	private JFrame frame;
	private JPanel tablePanel;
	private JLabel enterCourse;
	private JButton go;
	private JTable coursesTable;
	private DefaultTableModel modelTable;
	private JTextField userInputCourse;
	private String [] tableHeadings = {"CRN", "Course Code", "Course Name", "Professor", "TimeSlot", "Credits"};

	/**Constructor**/
	public ScheduleGenerator()
	{
		initialize();//set up GUI
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

		tablePanel = new JPanel();
		coursesTable = new JTable();
		
		//Do not adjust column widths automatically; use a horizontal scrollbar instead.
		coursesTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );		
	}
	
	
}
