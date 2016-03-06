import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeListPage extends JPanel implements ActionListener
{

	private static final long serialVersionUID = 1L;
	public static final String name = "EmployeeListPage";

	Model model;
	
	DefaultTableModel tableModel;
	JTable table;
	JButton newEmployee_button;
	
	ActionListener pageLoadDelegate;

	EmployeeListPage(Model model, ActionListener pageLoadDelegate)
	{
		this.setName(name);
		
		this.model = model;
		this.pageLoadDelegate = pageLoadDelegate;
		
		tableModel = new DefaultTableModel()
		{
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(790, 400));
		this.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		String[] columnNames = Employee.employeeAttributeNames;
		tableModel.setColumnIdentifiers(columnNames);
//		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.removeColumn(table.getColumnModel().getColumn(0));

		//mouse listener
		table.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me)
			{
				JTable table = (JTable) me.getSource();
				if(me.getClickCount() == 2)
				{
					Point p = me.getPoint();
					int row = table.rowAtPoint(p);
					int id =  Integer.valueOf( String.valueOf( tableModel.getValueAt(row, 0) ) );
					loadEmployeePage(id);
				}
			}
		});

		newEmployee_button = new JButton("New");
		newEmployee_button.setName("newEmployee");
		newEmployee_button.setActionCommand(newEmployee_button.getName());
		newEmployee_button.addActionListener(this);
		this.add(newEmployee_button);
		
		populateEmployeeList();
		
	}
	
	void resetPage()
	{
		tableModel.setRowCount(0);
	}
	
	void populateEmployeeList()
	{
		resetPage();
		
		Vector<Employee> employees = model.getEmployees();
		for(Employee e : employees)
		{
			addEmployee(e);
		}
	}
	
	void addEmployee(Employee e)
	{
		Object[] rowData = {e.id, e.ssn, e.firstName, e.MI, e.lastName, e.title, e.workPhone, e.personalPhone, e.salary};
		tableModel.addRow(rowData);
	}
	
	void loadEmployeePage(int id)
	{
		ActionEvent ae = new ActionEvent(this, 1, "goTo_" + EmployeePage.name + "_"+id);
		pageLoadDelegate.actionPerformed(ae);
	}

	void createBlankRow()
	{
		Object[] rowData = {"-1","--", "--", "--", "--", "--", "--", "--", "--"};
		tableModel.addRow(rowData);
		tableModel.fireTableDataChanged();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getActionCommand().equals(newEmployee_button.getName()))
		{
			createBlankRow();
		}
	}
	
	
	
	
	
	
}