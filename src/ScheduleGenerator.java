import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


import javax.swing.JButton;


//Make use of the files 
//ScheduleUsingDB for the list panel
//ScheduleGUI for the chart panel

public class ScheduleGenerator {

	private JFrame frame;

	//WELCOME PANEL
	private JPanel welcomePanel;
	private JTextField textFieldUserInput;
	private JLabel lblEnterCourse;
	private JButton goButton;
	private JButton doneButton;
	private ArrayList<Course> courses;
	private InstantiateCourseObjects fillArray;
	private ArrayList<String> selectedCourseCodes;

	//LIST PANEL
	private JPanel listPanel;
	private JTable coursesTable;
	private DefaultTableModel modelTable;
	private String [] tableHeadings = {"CRN", "Course Code", "Course Name", "Professor", "TimeSlot", "Credits"};
	private JLabel lblSelectedCourses;
	private JButton showScheduleButton;
	private CourseSchedule schedule;
	String semester = "Fall 2018";

	//CHART PANEL
	private JPanel chartPanel;
	private JTable chartTable;
	private DefaultTableModel chartTableModel;
	private String [] chartTableHeadings = {"Time", "Tuesday", "Thursday"};




	public ScheduleGenerator() {
		
		//Connect to the database and get all the courses
		databaseConnection();
		stepOne();
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleGenerator window = new ScheduleGenerator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void stepOne() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//**GET SIZE FROM OLD GUI 
		//frame.setBounds(100, 100, 450, 300);
		frame.setBounds(600, 600, 550, 500);
		frame.setTitle("Course Scheduler");

		frame.getContentPane().setLayout(new CardLayout(0, 0));

		welcomePanel = new JPanel();
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null); 		//means absolute layout!


		listPanel = new JPanel();
		frame.getContentPane().add(listPanel);
		listPanel.setLayout(null);

		chartPanel = new JPanel();
		frame.getContentPane().add(chartPanel);

		welcomePanelSetup();
		listPanelSetup();
	

	}

	public void welcomePanelSetup() {

		//Initialize
		lblEnterCourse = new JLabel("Enter Course:");
		textFieldUserInput = new JTextField();
		goButton = new JButton("Go!");
		doneButton = new JButton("Done");


		//Location
		lblEnterCourse.setBounds(46, 77, 84, 16);
		textFieldUserInput.setBounds(142, 72, 130, 26);
		goButton.setBounds(284, 63, 75, 47);
		doneButton.setBounds(129, 151, 117, 29);

		//Add elements to panel
		welcomePanel.add(lblEnterCourse);
		welcomePanel.add(textFieldUserInput);
		welcomePanel.add(goButton);
		welcomePanel.add(doneButton);
		
		//these are the courses that the user wishes to take
		selectedCourseCodes= new ArrayList<String>(); 
		
		//Makes Go and Done buttons responsive
		setWelcomePanelActionListener();
		
	}

	//welcomePanel GO button 
	private void setWelcomePanelActionListener() {

		//Listens out for an enter key on the textfield. 
		//Calls to add the inputted course to the arraylist 

		textFieldUserInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					theWelcomePanelAction();
					textFieldUserInput.setText("");		//to clear field after input 
				}
			}
		});

		//listens out for a click
		goButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theWelcomePanelAction();
				textFieldUserInput.setText("");		//to clear field after input 
			}
		});

		//Switch panels
		doneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//move on to the next panel
				listPanelDisplay();
				listPanel.setVisible(true);
				welcomePanel.setVisible(false);
			}
		});


	}//end setActionListener


	private void databaseConnection() {
		try //create connection
		{
			//query
			ConnectDB connectDB = new ConnectDB("jdbc:sqlserver://localhost;databaseName=CourseSchedule;integratedSecurity=true");
			fillArray = new InstantiateCourseObjects(connectDB);
			courses = fillArray.getCourses();//courses in the database to compare to
		}

		//connection failed
		catch(SQLException e) {
			System.out.println(e);
		}

	}

	/**
	 * What happens once GO or the Enter key are pressed on Welcome Panel
	 * that course code is added to the arraylist 
	 */
	private void theWelcomePanelAction() {

		String selectedCode = textFieldUserInput.getText();
		if (selectedCourseCodes.size() <= 6) {
			//check that this course code is valid
			ArrayList <Course> returnedCourses= SearchCourses.search(courses, selectedCode);
			if (returnedCourses.size()>0) {
				selectedCourseCodes.add(textFieldUserInput.getText());
				JOptionPane.showMessageDialog(null, "Course added successfully.");
			}
			else {
				//could not find a match to the course code
				JOptionPane.showMessageDialog(null, "Invalid course code.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Exeeded credit limit. Press Done to see schedule.");
		}
	}//end theWelcomePanelAction



	public void listPanelSetup() {

		lblSelectedCourses = new JLabel("Selected Courses");
		lblSelectedCourses.setBounds(131, 6, 126, 27);

		showScheduleButton = new JButton("Show Schedule");
		showScheduleButton.setBounds(180, 313, 117, 29);
		
		
		modelTable = new DefaultTableModel(tableHeadings, 0);	//to show outline of table but no information inside yet
		listPanel.setLayout(null);
		
		coursesTable = new JTable(modelTable);
		coursesTable.setEnabled(false);	//not to let users tamper with the output

		JScrollPane scrollPane = new JScrollPane(coursesTable);
		scrollPane.setBounds(6, 45, 600, 190);

		listPanel.add(showScheduleButton);
		listPanel.add(lblSelectedCourses);
		listPanel.add(scrollPane);		//displays the top header
		
		listPanel.add(showScheduleButton);
		
		
		listPanelDisplay();
		listPanelActionListener();
		

		//GET THE RESULTS OF THE ARRAYLIST OF COURSES AND DISPLAY THAT HERE

	}

	private void listPanelDisplay() {
		//now get the CourseSchedule object schedule
		schedule =  ScheduleAlgorithm.createSchedule(selectedCourseCodes, courses, semester);
		
		for (int x = 0; x < schedule.getCourses().size(); x++) {
			Vector<Comparable> newRow = new Vector <Comparable>();
			newRow.add(schedule.getCourses().get(x).getCRN());
			newRow.add(schedule.getCourses().get(x).getCode());
			newRow.add(schedule.getCourses().get(x).getTitle());
			newRow.add(schedule.getCourses().get(x).getProfessor());
			newRow.add(schedule.getCourses().get(x).getTimeSlot());
			newRow.add(schedule.getCourses().get(x).getCredits());
			modelTable.addRow(newRow);	
		}		
		modelTable.fireTableDataChanged();

		//to resize the columns to fit the contents 
		for (int x = 0; x < tableHeadings.length; x++) 
			packColumn(coursesTable, x, 3);	
	}
	
	private void listPanelActionListener() {
		//Switch panels
		showScheduleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//move on to the next panel
				chartPanelSetup();
				chartPanel.setVisible(true);
				listPanel.setVisible(false);
			}
		});
	}
	
	
	public void chartPanelSetup() {
		chartTableModel = new DefaultTableModel(chartTableHeadings, 0);

		chartPanel.setLayout(null);		//necessary
		chartTable = new JTable(chartTableModel);
		chartTable.setEnabled(false); 	//user cannot edit the table

		JScrollPane scrollpane = new JScrollPane(chartTable);
		scrollpane.setBounds(54, 90, 442, 176);

		chartPanel.add(scrollpane);

		//to fill the table with info

		ArrayList <String> times = new ArrayList<String> ();
		times.add("3:10-4:15");
		times.add("4:25-5:30");
		times.add("6:00-8:15");
		times.add("8:20-10:30");

		//The rows of the table 
		Vector <Comparable> newRow1 = new Vector <Comparable> ();	//	3-4
		Vector <Comparable> newRow2 = new Vector <Comparable> ();	//	4-5
		Vector <Comparable> newRow3 = new Vector <Comparable> ();	// 6-8
		Vector <Comparable> newRow4 = new Vector <Comparable> ();	// 8-10
		
		//timeslot 5 (3 - 4) 
		for (Course c : schedule.getCourses()) {
			if (c.getTimeSlot() == 5) {
				newRow1.add("3:10-4:15");
				newRow1.add(c.getTitle());
				newRow1.add(c.getTitle());
				break;
			}
		}
		chartTableModel.addRow(newRow1);

		//timeslot 6 (4 - 5) 
		for (Course c : schedule.getCourses()) {
			if (c.getTimeSlot() == 6) {
				newRow2.add("4:25-5:30");
				newRow2.add(c.getTitle());
				newRow2.add(c.getTitle());
				break;
			}
		}
		chartTableModel.addRow(newRow2);

		//timeslot 10 and 14 (6 - 8) 
		for (Course c : schedule.getCourses()) {
			if (c.getTimeSlot() == 10) {
				newRow3.add("6:00-8:15");
				newRow3.add(c.getTitle());
				break;
			}
		}
		for (Course c : schedule.getCourses()) {
			if (c.getTimeSlot() == 14) {
				newRow3.add(c.getTitle());
				break;
			}
		}
		chartTableModel.addRow(newRow3);

		//timeslot 11 and 16 (8 - 10) 
		for (Course c : schedule.getCourses()) {
			if (c.getTimeSlot() == 11) {
				newRow4.add("8:20-10:30");
				newRow4.add(c.getTitle());
				break;
			}
		}
		for (Course c : schedule.getCourses()) {
			if (c.getTimeSlot() == 16) {
				newRow4.add(c.getTitle());
				break;
			}
		}
		chartTableModel.addRow(newRow4);


		//to resize the columns to fit the contents 
		for (int x = 0; x < chartTableHeadings.length; x++) {
			packColumn(chartTable, x, 3);	//3 is the margin
		}
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
	}
}