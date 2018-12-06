

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Font;

public class ScheduleUsingCrnsDBVersion extends JFrame {

	private JFrame frame;
	private JPanel panel;
	private JLabel enterCourse;
	private JButton go;
	private JTable coursesTable;
	private DefaultTableModel modelTable;
	private JTextField userInputCourse;
	private String [] tableHeadings = {"CRN", "Course Code", "Course Name", "Professor", "TimeSlot", "Credits"};
	private RuthCourseObjects ruthCourses;
	private CourseSchedule schedule = new CourseSchedule(18, "Fall-2019"); //instantiate course schedule
	
	private JButton showSchedule;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleUsingCrnsDBVersion window = new ScheduleUsingCrnsDBVersion();
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
	public ScheduleUsingCrnsDBVersion() {
		initialize();
		setupPanel();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Schedule Creator");

		panel = new JPanel();
		coursesTable = new JTable();

		//this line sizes the headers to fill up the top of the screen
		coursesTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );

	}

	private void setupPanel() {
		enterCourse = new JLabel("Enter Course CRN:");
		enterCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		go = new JButton("Go!");
		go.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		userInputCourse = new JTextField();
		
		showSchedule = new JButton("Show Schedule");

		setupTable();
		setPanelLayout();
		setActionListener();

		frame.getContentPane().add(panel);


		panel.add(enterCourse);
		panel.add(go);
		panel.add(userInputCourse);
		panel.add(showSchedule);


	}//end setupPanel

	private void setupTable() {

		modelTable = new DefaultTableModel(tableHeadings, 0);	//to show outline of table but no information inside yet
		panel.setLayout(null);
		coursesTable = new JTable(modelTable);
		coursesTable.setEnabled(false);	//not to let users tamper with the output

		JScrollPane scrollPane = new JScrollPane(coursesTable);
		scrollPane.setBounds(41, 78, 568, 243);
		panel.add(scrollPane);		//displays the top header

		

	}//end setupTable

	private void setPanelLayout() {
		frame.setBounds(200, 200, 650, 400);
		go.setBounds(352, 37, 75, 29);
		enterCourse.setBounds(52, 39, 158, 27);
		userInputCourse.setBounds(205, 36, 135, 30);
		showSchedule.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		showSchedule.setBounds(41, 333, 135, 39);

	}

	/**
	 * Makes the button listen out for a click and the textfield listen out for an enter 
	 */
	private void setActionListener() {
		//listens out for an enter key
		userInputCourse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					theAction();
				}
			}
		});

		//listens out for a click
		go.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//all that happens inside:!
				theAction();
			}
		});
		
		showSchedule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//all that happens inside:!
			//	showTheSchedule();
				new ScheduleTableAcceptsCourses(schedule).setVisible(true);
			}
		});
		
	}//end setActionListener
	

	public void theAction() {
		//the course user is looking for
		String inputCourse = userInputCourse.getText();
		Integer crn = Integer.valueOf(inputCourse);

		//We are not clearing the results of the previous search because it is getting added on cumulatively
		
		//find course by CRN
		Course foundCourse = searchCourses(crn);

		if (foundCourse != null) {
			
			try {
				schedule.addCourse(foundCourse);
				//if such a course exists, add it to the table
				Vector<Comparable> newRow = new Vector <Comparable>();
				newRow.add(foundCourse.getCRN());
				newRow.add(foundCourse.getCode());
				newRow.add(foundCourse.getTitle());
				newRow.add(foundCourse.getProfessor());
				newRow.add(foundCourse.getTimeSlot());
				newRow.add(foundCourse.getCredits());
				modelTable.addRow(newRow);
			}
			catch(TimeslotConflictException | CreditOverflowException e) {
				//make popup box to display error message
				JOptionPane.showMessageDialog(null, "Course could not be added.");
			}
			
			 
		}
		else {
			//if foundCourse IS null..
		}
			//to resize the columns to fit the contents 
			for (int x = 0; x < tableHeadings.length; x++) {
				packColumn(coursesTable, x, 3);	
			}
		

	}//end theAction
	
	
	private void showTheSchedule() {
		this.setVisible(false);
		new ScheduleGUI().setVisible(true);
	}
	
	//Credits to this method to Spot35 https://stackoverflow.com/questions/5820238/how-to-resize-jtable-column-to-string-length
	/**
	 * Sets the preferred width of the visible column specified by vColIndex. The column
	 * will be just wide enough to show the column head and the widest cell in the column.
	 * margin pixels are added to the left and right
	 * (resulting in an additional width of 2*margin pixels).
	 */ 
	private void packColumn(JTable table, int vColIndex, int margin) {
		DefaultTableColumnModel colModel = (DefaultTableColumnModel)table.getColumnModel();
		TableColumn col = colModel.getColumn(vColIndex);
		int width = 0;

		// Get width of column header
		TableCellRenderer renderer = col.getHeaderRenderer();
		if (renderer == null) {
			renderer = table.getTableHeader().getDefaultRenderer();
		}
		java.awt.Component comp = renderer.getTableCellRendererComponent(
				table, col.getHeaderValue(), false, false, 0, 0);
		width = comp.getPreferredSize().width;

		// Get maximum width of column data
		for (int r=0; r<table.getRowCount(); r++) {
			renderer = table.getCellRenderer(r, vColIndex);
			comp = renderer.getTableCellRendererComponent(
					table, table.getValueAt(r, vColIndex), false, false, r, vColIndex);
			width = Math.max(width, comp.getPreferredSize().width);
		}
		// Add margin
		width += 2 * margin;

		// Set the width
		col.setPreferredWidth(width);

		//Center the text
		//Credits to Articuno L at https://stackoverflow.com/questions/48667656/center-text-in-jtable
		//			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		//			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		//			int columnNum = table.getColumnCount();
		//			
		//			for (int y = 0; y < columnNum; y++) {
		//				table.getColumnModel().getColumn(y).setCellRenderer(centerRenderer);	
		//			}
	}//end packColumn

	
	public Course searchCourses(Integer crn) {	
		
		ruthCourses = new RuthCourseObjects();
		ArrayList <Course> allCourses = new ArrayList <Course> ();
		allCourses = ruthCourses.getRuthCourses();
		
		for(Course c : allCourses) {
			if(c.getCRN().equals(crn))
				return c;
		}
		return null;
	}//end searchCourses

}
