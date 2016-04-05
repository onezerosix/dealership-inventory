import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaleRecordPage extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	public static final String name = "SaleRecordPage";

	ActionListener pageLoadDelegate;
	
	Model model;
	int saleRecordID;
	int vehicleID;
	
	//e.salesRecordID, e.employeeID, e.customerID, e.vehicleID, e.firstName, e.middleInitial, e.lastName, e.phone, 
	//e.address, e.salePrice, e.year, e.month, e.day
	
	JLabel firstName_label;
	JLabel middleInitial_label;
	JLabel lastName_label;
	JLabel phone_label;
	JLabel address_label;
	JLabel salePrice_label;
	JLabel year_label;
	JLabel month_label;
	JLabel day_label;

	JTextField firstName_text;
	JTextField middleInitial_text;
	JTextField lastName_text;
	JTextField phone_text;
	JTextField address_text;
	JTextField salePrice_text;
	JTextField year_text;
	JTextField month_text;
	JTextField day_text;
	
	JButton save_button;
	JButton delete_button;

	
	SaleRecordPage(ActionListener pageLoadDelegate)
	{
		this.setName(name);
		this.model = Model.sharedInstance;
		this.pageLoadDelegate = pageLoadDelegate;

		buildContentPane();
		buildNavPane();
	}
	
	void createNewSaleRecord(int vehicleID)
	{
		Vehicle v = model.getVehicle(vehicleID);
		this.vehicleID = vehicleID;
		loadSaleRecordInformation(-1);
		salePrice_text.setText(String.valueOf(v.price));
	}
	
	void loadSaleRecordInformation(int srID)
	{
		resetPage();
		SaleRecord sr = model.getSaleRecord(srID); //getSales
		saleRecordID = sr.saleRecordID;

		if(saleRecordID >= 0)
		{
			firstName_text.setText(sr.firstName);
			middleInitial_text.setText(sr.middleInitial);
			lastName_text.setText(sr.lastName);
			phone_text.setText(sr.phone);
			address_text.setText(sr.address);
			salePrice_text.setText( String.valueOf(sr.salePrice ));
			year_text.setText(String.valueOf(sr.year));
			month_text.setText(String.valueOf(sr.month));
			day_text.setText(String.valueOf(sr.day));
		}else
		{
			firstName_text.setText("");
			middleInitial_text.setText("");
			lastName_text.setText("");
			phone_text.setText("");
			address_text.setText("");
			salePrice_text.setText("");
			year_text.setText("");
			month_text.setText("");
			day_text.setText("");
		}
	}
	
	private void resetPage()
	{
		firstName_text.setText("");
		middleInitial_text.setText("");
		lastName_text.setText("");
		phone_text.setText("");
		address_text.setText("");
		salePrice_text.setText("");
		year_text.setText("");
		month_text.setText("");
		day_text.setText("");
	}
	
	private void buildContentPane()
	{
		firstName_label = new JLabel("First");
		middleInitial_label = new JLabel("M");
		lastName_label = new JLabel("Last");
		phone_label = new JLabel("Phone");
		address_label= new JLabel("Address");
		salePrice_label = new JLabel("Sale Price");
		year_label = new JLabel("Year");
		month_label = new JLabel("Month");
		day_label = new JLabel("Day");

		
		firstName_text = new JTextField();
		middleInitial_text = new JTextField();
		lastName_text = new JTextField();
		phone_text = new JTextField();
		address_text = new JTextField();
		salePrice_text = new JTextField();
		year_text = new JTextField();
		month_text = new JTextField();
		day_text= new JTextField();
		
		
		Dimension textFieldSize = new Dimension(100, 25);
		
		firstName_text.setPreferredSize(textFieldSize);
		middleInitial_text.setPreferredSize(textFieldSize);
		lastName_text.setPreferredSize(textFieldSize);
		phone_text.setPreferredSize(textFieldSize);
		address_text.setPreferredSize(textFieldSize);
		salePrice_text.setPreferredSize(textFieldSize);
		year_text.setPreferredSize(textFieldSize);
		month_text.setPreferredSize(textFieldSize);
		day_text.setPreferredSize(textFieldSize);
		

		this.add(firstName_label);
		this.add(firstName_text);
		this.add(middleInitial_label);
		this.add(middleInitial_text);
		this.add(lastName_label);
		this.add(lastName_text);
		this.add(phone_label);
		this.add(phone_text);
		this.add(address_label);
		this.add(address_text);
		this.add(salePrice_label);
		this.add(salePrice_text);
		this.add(year_label);
		this.add(year_text);
		this.add(month_label);
		this.add(month_text);
		this.add(day_label);
		this.add(day_text);
	}
	
	private void buildNavPane()
	{
		save_button = new JButton("Save");
		save_button.setActionCommand("save");
		save_button.addActionListener(this);
		this.add(save_button);
		
		delete_button = new JButton("Delete");
		delete_button.setActionCommand("delete");
		delete_button.addActionListener(this);
		this.add(delete_button);
	}
	
	private boolean saveSaleRecord()
	{
		InputValidator iv = InputValidator.sharedInstance;
		boolean valid = true;
		firstName_text.setBackground(Color.white);
		middleInitial_text.setBackground(Color.white);
		lastName_text.setBackground(Color.white);
		phone_text.setBackground(Color.white);
		address_text.setBackground(Color.white);
		salePrice_text.setBackground(Color.white);
		year_text.setBackground(Color.white);
		month_text.setBackground(Color.white);
		day_text.setBackground(Color.white);

		if(!iv.validateName(firstName_text.getText()))
		{
			firstName_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateMinit(middleInitial_text.getText()))
		{
			middleInitial_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateName(lastName_text.getText()))
		{
			lastName_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validatePhoneNumber(phone_text.getText()))
		{
			phone_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateAddress(address_text.getText()))
		{
			address_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateVehiclePrice(salePrice_text.getText()))
		{
			salePrice_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateVehicleYear(year_text.getText()))
		{
			year_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateMonth(month_text.getText()))
		{
			month_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateDay(day_text.getText()))
		{
			day_text.setBackground(Color.red);
			valid = false;
		}



		if(valid)
		{
			model.saveSaleRecord(new SaleRecord(-1, model.getCurrentUser().id, -1, vehicleID, firstName_text.getText(), middleInitial_text.getText(), 
					lastName_text.getText(), phone_text.getText(), address_text.getText(), Integer.valueOf(salePrice_text.getText()),
					Integer.valueOf(year_text.getText()), Integer.valueOf(month_text.getText()), Integer.valueOf(day_text.getText())   ));
		}

		return valid; 
	
	}
	
	private void deleteSaleRecord()
	{/*
		model.deleteEmployee(saleRecordID);
	*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals("save"))
		{
			if(saveSaleRecord())
			{	/*
				ActionEvent ae = new ActionEvent(this, 1, "goTo_" + SaleRecordPage.name);
				pageLoadDelegate.actionPerformed(ae);
				*/
			}
		}else if(command.equals("delete"))
		{
			deleteSaleRecord();
			ActionEvent ae = new ActionEvent(this, 1, "goTo_" + SaleRecordPage.name);
			pageLoadDelegate.actionPerformed(ae);
		}
		
	}
	
	
}
/*

	

	

	
	
	
	
	
	

	
	
}
*/