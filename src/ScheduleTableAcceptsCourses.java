
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ScheduleTableAcceptsCourses extends JFrame {

	private JFrame frame;
	private JPanel tablePanel;
	private JTable scheduleTable;
	private DefaultTableModel scheduleTableModel;
	private String [] scheduleTableHeadings = {"Time", "Tuesday", "Thursday"};
	private static CourseSchedule theSchedule;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleTableAcceptsCourses window = new ScheduleTableAcceptsCourses(theSchedule);
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
	public ScheduleTableAcceptsCourses(CourseSchedule schedule) {
		ScheduleTableAcceptsCourses.theSchedule = schedule;
		initialize();
		setup();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();		
		tablePanel = new JPanel();
		//evenly spaces the headers across the table
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setup() {
		//call to setup the table
		//setupTimeTable();
		setupScheduleTable(); 

		//add panel to frame 
//		tablePanel.add(generate);

		setLayout();
		frame.getContentPane().add(tablePanel);
		frame.setTitle("Schedule Generator");		//title for the window

	}

	private void setLayout() {
		frame.setBounds(600, 600, 550, 500);
	}

	private void setupScheduleTable() {
		//to set the heading of the table. the zero means that the table holds no information
		scheduleTableModel = new DefaultTableModel(scheduleTableHeadings, 0);

		tablePanel.setLayout(null);		//necessary
		scheduleTable = new JTable(scheduleTableModel);
		scheduleTable.setEnabled(false); 	//user cannot edit the table

		JScrollPane scrollpane = new JScrollPane(scheduleTable);
		scrollpane.setBounds(54, 90, 442, 176);

		tablePanel.add(scrollpane);

		populateTable();
	}//end setupTable

	private void populateTable() {
		ArrayList <Course> courses = new ArrayList <Course> ();
		courses = theSchedule.getCourses();

		//The rows of the table 
		Vector <Comparable> newRow1 = new Vector <Comparable> ();//	3-4
		Vector <Comparable> newRow2 = new Vector <Comparable> ();//	4-5
		Vector <Comparable> newRow3 = new Vector <Comparable> ();// 6-8
		Vector <Comparable> newRow4 = new Vector <Comparable> ();// 8-10

		//timeslot 5 (3 - 4) 
		for (Course c : courses) {
			if (c.getTimeSlot() == 5) {
				newRow1.add("3:10-4:15");
				newRow1.add(c.getTitle());
				newRow1.add(c.getTitle());
				break;
			}
		}
		scheduleTableModel.addRow(newRow1);

		//timeslot 6 (4 - 5) 
		for (Course c : courses) {
			if (c.getTimeSlot() == 6) {
				newRow2.add("4:25-5:30");
				newRow2.add(c.getTitle());
				newRow2.add(c.getTitle());
				break;
			}
		}
		scheduleTableModel.addRow(newRow2);

		//timeslot 10 and 14 (6 - 8) 
		for (Course c : courses) {
			if (c.getTimeSlot() == 10) {
				newRow3.add("6:00-8:15");
				newRow3.add(c.getTitle());
				break;
			}
		}
		for (Course c : courses) {
			if (c.getTimeSlot() == 14) {
				newRow3.add(c.getTitle());
				break;
			}
		}
		scheduleTableModel.addRow(newRow3);

		//timeslot 11 and 16 (8 - 10) 
		for (Course c : courses) {
			if (c.getTimeSlot() == 11) {
				newRow4.add("8:20-10:30");
				newRow4.add(c.getTitle());
				break;
			}
		}
		for (Course c : courses) {
			if (c.getTimeSlot() == 16) {
				newRow4.add(c.getTitle());
				break;
			}
		}
		scheduleTableModel.addRow(newRow4);


		//to resize the columns to fit the contents 
		for (int x = 0; x < scheduleTableHeadings.length; x++) {
			packColumn(scheduleTable, x, 3);	//3 is the margin
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





}
