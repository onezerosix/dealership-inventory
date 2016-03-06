import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Model model;
	
	//nav bar
	JPanel navBarPane;
	TreeMap<String, JButton> navButtons;
	TreeMap<String, String> navButton_titles;
	
	//content pane
	JPanel contentPane;
	CardLayout contentPaneCardLayout;
	
	
	View(Model model)
	{
		super("In-house Algorithm Applicaiton");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.model = model;
		
		buildNavBar();
		buildContentPane();

		this.setLayout(new BorderLayout());
		add(navBarPane, BorderLayout.NORTH);
		add(contentPane, BorderLayout.CENTER);
		this.setSize(800, 525);
		this.setVisible(true);
		
		loadPage("LoginPage");
	}
	
	void buildNavBar()
	{
		navButtons = new TreeMap<String, JButton>();
		navButton_titles = new TreeMap<String, String>(); //<name on button, name of page>
		navButton_titles.put("Inventory List", InventoryListPage.name);
		navButton_titles.put("Employee Managment", EmployeeListPage.name);

		
		navBarPane = new JPanel();
		navBarPane.setLayout(new BoxLayout(navBarPane, BoxLayout.X_AXIS));
		navBarPane.setBackground(Color.LIGHT_GRAY);
//		Dimension navButtonSize = new Dimension(100, 100);
		for(Map.Entry<String, String> entry : navButton_titles.entrySet())
		{
			JButton newButton = new JButton(entry.getKey());
//			newButton.setPreferredSize(navButtonSize);
			newButton.setName(entry.getKey());
			newButton.addActionListener(this);
			newButton.setActionCommand("goTo_" + entry.getValue());
			navButtons.put(entry.getKey(), newButton);
			navBarPane.add(newButton);
		}
	}
	
	void buildContentPane()
	{
		contentPane = new JPanel(new CardLayout());
		contentPane.add(new LoginPage(model, this), LoginPage.name);
		contentPane.add(new InventoryListPage(model, this), InventoryListPage.name);
		contentPane.add(new InventoryPage(model, this), InventoryPage.name);
		contentPane.add(new EmployeeListPage(model, this), EmployeeListPage.name);
		contentPane.add(new EmployeePage(model, this), EmployeePage.name);
		
	}
	
	void loadPage(String named)
	{
		//check for privileges
		if(model.loggedIn)
		{
			CardLayout cl = (CardLayout) contentPane.getLayout();
			cl.show(contentPane, named);
		}
	}

	private Object getInstanceOfClass(String name)
	{
		Object pageInstance = null;
		for(Component c : contentPane.getComponents())
		{
			if(c.getName() == name)
			{
				pageInstance = c;
			}
		}
		return pageInstance;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().matches("goTo_" + InventoryPage.name + "_.+"))
		{//loading a vehicle to the inventory page    command format: "goTo_InventoryPage_VIN"
			String[] command = e.getActionCommand().split("_", 3);
			int id = Integer.valueOf(command[2]);
			loadPage(command[1]);
			
			InventoryPage pageInstance = (InventoryPage) getInstanceOfClass(InventoryPage.name);
			if(pageInstance != null)
			{
				pageInstance.loadVehicleInformation(id);
			}else
			{
				System.out.println("View::ActionPerformed - Could not load vehicle to inventory page");
			}
		}
		else if(e.getActionCommand().matches("goTo_" + EmployeePage.name + "_.+"))
		{//loading an employee to the employee page    command format: "goTo_EmployeePage_ID"
			String[] command = e.getActionCommand().split("_", 3);
			int id = Integer.valueOf(command[2]);
			loadPage(command[1]);
			
			EmployeePage pageInstance = (EmployeePage) getInstanceOfClass(EmployeePage.name);
			if(pageInstance != null)
			{
				pageInstance.loadEmployeeInformation(id);
			}else
			{
				System.out.println("View::ActionPerformed - Could not load employee to inventory page");
			}
		}
		else if(e.getActionCommand().equals("goTo_" + InventoryListPage.name))
		{
			String[] command = e.getActionCommand().split("_", 2);
			loadPage(InventoryListPage.name);
			
			InventoryListPage ilp = (InventoryListPage) getInstanceOfClass(InventoryListPage.name);
			ilp.populateInventoryList();
		}
		else if(e.getActionCommand().equals("goTo_" + EmployeeListPage.name))
		{
			String[] command = e.getActionCommand().split("_", 2);
			loadPage(EmployeeListPage.name);
			
			EmployeeListPage elp = (EmployeeListPage) getInstanceOfClass(EmployeeListPage.name);
			elp.populateEmployeeList();
		}
		else if(e.getActionCommand().matches("goTo_.+"))
		{
			loadPage(e.getActionCommand().split("_", 2)[1]);
		}
	}
}











