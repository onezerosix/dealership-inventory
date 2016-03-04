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
	Vehicle v;
	
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
		v = model.getVehicle(id);
		
		if(v.id != -1)
		{
			vin_text.setText(v.vin);
			vehicleType_text.setText(v.vehicleType);
			make_text.setText(v.make);
			model_text.setText(v.model);
			year_text.setText(String.valueOf(v.year));
			trim_text.setText(v.trim);
			color_text.setText(v.color);
			mileage_text.setText( String.valueOf(v.mileage) );
			price_text.setText( String.valueOf(v.price) );
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
		v.vin = vin_text.getText();
		v.vehicleType = vehicleType_text.getText();
		v.make = make_text.getText();
		v.model = model_text.getText();
		v.year = Integer.valueOf(year_text.getText());
		v.trim = trim_text.getText();
		v.color = color_text.getText();
		v.mileage = Integer.valueOf( mileage_text.getText() );
		v.price = Integer.valueOf( price_text.getText() );
		
		model.saveVehicle(v);
	}
	
	void deleteVehicle()
	{
		model.deleteVehicle(v.id);
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










