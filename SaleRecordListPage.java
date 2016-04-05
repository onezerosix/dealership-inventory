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


public class SaleRecordListPage extends JPanel implements ActionListener {


	private static final long serialVersionUID = 1L;
	public static final String name = "SaleRecordListPage";

	Model model;
	
	DefaultTableModel tableModel;
	JTable table;
	JButton newSaleRecord_button;
	
	ActionListener pageLoadDelegate;

	SaleRecordListPage(ActionListener pageLoadDelegate)
	{
		this.setName(name);
		
		this.model = Model.sharedInstance;
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
		String[] columnNames = SaleRecord.saleRecordNames; // change to ?
		tableModel.setColumnIdentifiers(columnNames);
//		table.getColumnModel().getColumn(1).setPreferredWidth(150);
//		table.getColumnModel().getColumn(3).setPreferredWidth(20);
//		table.getColumnModel().getColumn(5).setPreferredWidth(100);
//		table.removeColumn(table.getColumnModel().getColumn(0));

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
					loadSaleRecordPage(id);
				}
			}
		});

		newSaleRecord_button = new JButton("New");
		newSaleRecord_button.setName("newSaleRecord"); //newEmployee
		newSaleRecord_button.setActionCommand(newSaleRecord_button.getName()); // updated button for 
		newSaleRecord_button.addActionListener(this);
		this.add(newSaleRecord_button); // newEmployee_button updated
		
		populateSaleRecordList(); //populateEmployeeList
		
	}
	
	void resetPage()
	{
		tableModel.setRowCount(0);
	}
	
	void populateSaleRecordList() 
	{
		resetPage();
		
		Vector<SaleRecord> SaleRecords = model.getSaleRecords();
		for(SaleRecord s : SaleRecords)
		{
			addRecord(s);
		}
	}
	
	void addRecord(SaleRecord s)
	{
		Object[] rowData = { s.saleRecordID, s.employeeID, s.customerID, s.vehicleID, s.firstName, s.middleInitial, s.lastName, s.phone, 
				s.address, s.salePrice, s.year, s.month, s.day};
		tableModel.addRow(rowData);
	}

	void loadSaleRecordPage(int id)
	{
//		ActionEvent ae = new ActionEvent(this, 1, "goTo_" + SaleRecordPage.name + "_"+id); 
//		pageLoadDelegate.actionPerformed(ae);
	}

	void createBlankRow()
	{
		Object[] rowData = {"-1","--", "--", "--", "--", "--", "--", "--", "--", "--", "--"};
		tableModel.addRow(rowData);
		tableModel.fireTableDataChanged();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getActionCommand().equals(newSaleRecord_button.getName()))
		{
			loadSaleRecordPage(-1);
		}
	}
	
	
	
	
	
	
}