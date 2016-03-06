import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InventoryPage extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	public static final String name = "InventoryPage";
	
	Model model;
	int vehicleID;
	
	ActionListener pageLoadDelegate;
	
	JLabel vin_label;
	JLabel vehicleType_label;
	JLabel make_label;
	JLabel model_label;
	JLabel year_label;
	JLabel trim_label;
	JLabel color_label;
	JLabel mileage_label;
	JLabel price_label;
	
	JTextField vin_text;
	JTextField vehicleType_text;
	JTextField make_text;
	JTextField model_text;
	JTextField year_text;
	JTextField trim_text;
	JTextField color_text;
	JTextField mileage_text;
	JTextField price_text;
	
	JButton save_button;
	JButton delete_button;
	
	
	InventoryPage(Model model, ActionListener pageLoadDelegate)
	{
		this.setName(name);
		this.model = model;
		this.pageLoadDelegate = pageLoadDelegate;
		
		buildContentPane();
		buildNavPane();
	}
	
	void buildContentPane()
	{
		vin_label = new JLabel("Vin");
		vehicleType_label = new JLabel("Vehicle Type");
		make_label = new JLabel("Make");
		model_label = new JLabel("Model");
		year_label = new JLabel("Year");
		trim_label = new JLabel("Trim");
		color_label = new JLabel("Color");
		mileage_label = new JLabel("Mileage");
		price_label = new JLabel("Price");
		
		
		vin_text = new JTextField();
		vehicleType_text = new JTextField();
		make_text = new JTextField();
		model_text = new JTextField();
		year_text = new JTextField();
		trim_text = new JTextField();
		color_text = new JTextField();
		mileage_text = new JTextField();
		price_text = new JTextField();
		
		
		Dimension textFieldSize = new Dimension(100, 25);
		
		vin_text.setPreferredSize(textFieldSize);
		vehicleType_text.setPreferredSize(textFieldSize);
		make_text.setPreferredSize(textFieldSize);
		model_text.setPreferredSize(textFieldSize);
		year_text.setPreferredSize(textFieldSize);
		trim_text.setPreferredSize(textFieldSize);
		color_text.setPreferredSize(textFieldSize);
		mileage_text.setPreferredSize(textFieldSize);
		price_text.setPreferredSize(textFieldSize);
		
		
		this.add(vin_label);
		this.add(vin_text);
		this.add(vehicleType_label);
		this.add(vehicleType_text);
		this.add(make_label);
		this.add(make_text);
		this.add(model_label);
		this.add(model_text);
		this.add(year_label);
		this.add(year_text);
		this.add(trim_label);
		this.add(trim_text);
		this.add(color_label);
		this.add(color_text);
		this.add(mileage_label);
		this.add(mileage_text);
		this.add(price_label);
		this.add(price_text);
	}
	
	void buildNavPane()
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
	
	void resetPage()
	{
		vin_text.setText("");
		vehicleType_text.setText("");
		make_text.setText("");
		model_text.setText("");
		year_text.setText("");
		trim_text.setText("");
		color_text.setText("");
		mileage_text.setText( String.valueOf("") );
		price_text.setText( String.valueOf("") );
	}
	
	public void loadVehicleInformation(int id)
	{
		resetPage();
		Vehicle vehicle = model.getVehicle(id);
		vehicleID = vehicle.id;
		
		if(vehicle.id != -1)
		{
			vin_text.setText(vehicle.vin);
			vehicleType_text.setText(vehicle.vehicleType);
			make_text.setText(vehicle.make);
			model_text.setText(vehicle.model);
			year_text.setText(String.valueOf(vehicle.year));
			trim_text.setText(vehicle.trim);
			color_text.setText(vehicle.color);
			mileage_text.setText( String.valueOf(vehicle.mileage) );
			price_text.setText( String.valueOf(vehicle.price) );
		}else
		{
			vin_text.setText("");
			vehicleType_text.setText("");
			make_text.setText("");
			model_text.setText("");
			year_text.setText("");
			trim_text.setText("");
			color_text.setText("");
			mileage_text.setText("");
			price_text.setText("");
		}
		
		
		
	}
	
	void saveVehicle()
	{
		model.saveVehicle(new Vehicle( vehicleID, vin_text.getText(), vehicleType_text.getText(), make_text.getText(), model_text.getText(), Integer.valueOf(year_text.getText()),
				trim_text.getText(), color_text.getText(), Integer.valueOf(mileage_text.getText()), Integer.valueOf(price_text.getText())));
	}
	
	void deleteVehicle()
	{
		model.deleteVehicle(vehicleID);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals("save"))
		{
			saveVehicle();
			ActionEvent ae = new ActionEvent(this, 1, "goTo_" + InventoryListPage.name);
			pageLoadDelegate.actionPerformed(ae);
		}else if(command.equals("delete"))
		{
			deleteVehicle();
			ActionEvent ae = new ActionEvent(this, 1, "goTo_" + InventoryListPage.name);
			pageLoadDelegate.actionPerformed(ae);
		}
		
	}


}










