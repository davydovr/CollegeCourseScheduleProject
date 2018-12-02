//package ScheduleCompMethProject.src;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JButton;

public class ScheduleGUI {

	private JFrame frame;
	private JPanel tablePanel;
	private JButton generate;
	private JTable scheduleTable;
	private JTable timeTable;
	private DefaultTableModel scheduleTableModel;
	private DefaultTableModel timeTableModel;
	private String [] scheduleTableHeadings = {"Tuesday", "Thursday"};
	private String [] timeTableHeading = {"Time"};
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleGUI window = new ScheduleGUI();
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
	public ScheduleGUI() {
		initialize();
		setup();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		tablePanel = new JPanel();
		generate = new JButton("Generate Schedule");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setup() {
		
		//call to setup the tables
		setupTimeTable();
		setupScheduleTable(); 
	
		//add panel to frame 
		tablePanel.add(generate);
		
		setLayout();
		frame.getContentPane().add(tablePanel);
		frame.setTitle("Schedule Generator");		//title for the window
	
		
		
	}

	private void setLayout() {
		frame.setBounds(500, 500, 450, 400);
		generate.setBounds(124, 65, 170, 29);
	}

	/**
	 * This makes the 
	 */
	private void setActionListener() {
		//listens out for a click on the button
		generate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theAction();
			}
		});
	}
	
	/**
	 * The action that happens once the button is clicked
	 */
	private void theAction() {
		
	}
	
	private void setupTimeTable() {
		timeTableModel = new DefaultTableModel(timeTableHeading, 5);
		tablePanel.setLayout(null);
		timeTable = new JTable(timeTableModel);
		timeTable.setEnabled(false);		//to not allow tampering with the text
		String [] times = {"3:10-4:15", "4:25-5:30", "6:00-8:15", "8:20-10:30"};
		
		
		for (int x = 0; x< times.length; x++) {			
			Vector<Comparable> setText = new Vector <Comparable>();
			setText.add(times[x]);
			timeTableModel.addRow(setText);
		}
		
		JScrollPane timeScroll = new JScrollPane(timeTable);
		timeScroll.setBounds(6, 143, 118, 200);
		
		tablePanel.add(timeScroll);

	}//end setupTimeTable
	
	private void setupScheduleTable() {
		//to set the heading of the table. the zero means that the table holds no information
		scheduleTableModel = new DefaultTableModel(scheduleTableHeadings, 5);
		
		
		tablePanel.setLayout(null);//QUESTIONABLE!!
		scheduleTable = new JTable(scheduleTableModel);
		scheduleTable.setEnabled(false); 	//user cannot edit the table
		
	//	scheduleTableModel.setRowCount(5);		//5 rows needed, 1 for title, 4 for courses
		scheduleTable.setShowHorizontalLines(true);		//to draw horizontal lines between rows
		
		
		JScrollPane scrollpane = new JScrollPane(scheduleTable);
		scrollpane.setBounds(124, 143, 183, 200);
		
		
		tablePanel.add(scrollpane);
		
		//Do not adjust column widths automatically; use a horizontal scrollbar instead.
		scheduleTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF );
		
		
		
		
	}//end setupTable

	 
	
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
		}//end packColumn
}//end ScheduleGUI
