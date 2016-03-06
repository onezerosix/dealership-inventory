import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmployeePage extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static final String name = "UserManagmentPage";

	ActionListener pageLoadDelegate;
	
	Model model;
	int employeeID;
	
	JLabel ssn_label;
	JLabel firstName_label;
	JLabel middleInitial_label;
	JLabel lastName_label;
	JLabel title_label;
	JLabel workPhone_label;
	JLabel personalPhone_label;
	JLabel salary_label;
	
	JTextField ssn_text;
	JTextField firstName_text;
	JTextField middleInitial_text;
	JTextField lastName_text;
	JTextField title_text;
	JTextField workPhone_text;
	JTextField personalPhone_text;
	JTextField salary_text;
	
	JButton save_button;
	JButton delete_button;
	

	EmployeePage(Model model, ActionListener pageLoadDelegate)
	{
		this.setName(name);
		this.model = model;
		this.pageLoadDelegate = pageLoadDelegate;

		buildContentPane();
		buildNavPane();
	}
	
	public void loadEmployeeInformation(int id)
	{
		resetPage();
		Employee e = model.getEmployee(id);
		employeeID = e.id;
		
		if(employeeID != -1)
		{
			ssn_text.setText(e.ssn);
			firstName_text.setText(e.firstName);
			middleInitial_text.setText(e.MI);
			lastName_text.setText(e.lastName);
			title_text.setText(e.title);
			workPhone_text.setText(e.workPhone);
			personalPhone_text.setText(e.personalPhone);
			salary_text.setText( String.valueOf(e.salary) );
		}else
		{
			ssn_text.setText("");
			firstName_text.setText("");
			middleInitial_text.setText("");
			lastName_text.setText("");
			title_text.setText("");
			workPhone_text.setText("");
			personalPhone_text.setText("");
			salary_text.setText("");
		}
		
	}
	
	private void resetPage()
	{
		ssn_text.setText("");
		firstName_text.setText("");
		middleInitial_text.setText("");
		lastName_text.setText("");
		title_text.setText("");
		workPhone_text.setText("");
		personalPhone_text.setText("");
		salary_text.setText("");
	}
	
	private void buildContentPane()
	{
		ssn_label = new JLabel("SSN");
		firstName_label = new JLabel("First");
		middleInitial_label = new JLabel("M");
		lastName_label = new JLabel("Last");
		title_label = new JLabel("Title");
		workPhone_label = new JLabel("Work Phone");
		personalPhone_label = new JLabel("Personal Phone");
		salary_label = new JLabel("Salary");
		
		ssn_text = new JTextField();
		firstName_text = new JTextField();
		middleInitial_text = new JTextField();
		lastName_text = new JTextField();
		title_text = new JTextField();
		workPhone_text = new JTextField();
		personalPhone_text = new JTextField();
		salary_text = new JTextField();
		
		Dimension textFieldSize = new Dimension(100, 25);
		
		ssn_text.setPreferredSize(textFieldSize);
		firstName_text.setPreferredSize(textFieldSize);
		middleInitial_text.setPreferredSize(textFieldSize);
		lastName_text.setPreferredSize(textFieldSize);
		title_text.setPreferredSize(textFieldSize);
		workPhone_text.setPreferredSize(textFieldSize);
		personalPhone_text.setPreferredSize(textFieldSize);
		salary_text.setPreferredSize(textFieldSize);
		
		this.add(ssn_label);
		this.add(ssn_text);
		this.add(firstName_label);
		this.add(firstName_text);
		this.add(middleInitial_label);
		this.add(middleInitial_text);
		this.add(lastName_label);
		this.add(lastName_text);
		this.add(title_label);
		this.add(title_text);
		this.add(workPhone_label);
		this.add(workPhone_text);
		this.add(personalPhone_label);
		this.add(personalPhone_text);
		this.add(salary_label);
		this.add(salary_text);
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
	
	private void saveEmployee()
	{
		model.saveEmployee(new Employee(employeeID, ssn_text.getText(), firstName_text.getText(), middleInitial_text.getText(), lastName_text.getText(), title_text.getText(),
				workPhone_text.getText(), personalPhone_text.getText(), Integer.valueOf(salary_text.getText()) ));
	}
	
	private void deleteEmployee()
	{
		model.deleteEmployee(employeeID);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals("save"))
		{
			saveEmployee();
			ActionEvent ae = new ActionEvent(this, 1, "goTo_" + EmployeeListPage.name);
			pageLoadDelegate.actionPerformed(ae);
		}else if(command.equals("delete"))
		{
			deleteEmployee();
			ActionEvent ae = new ActionEvent(this, 1, "goTo_" + EmployeeListPage.name);
			pageLoadDelegate.actionPerformed(ae);
		}
		
	}
	
}







