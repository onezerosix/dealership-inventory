import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	

	EmployeePage(ActionListener pageLoadDelegate)
	{
		this.setName(name);
		this.model = Model.sharedInstance;
		this.pageLoadDelegate = pageLoadDelegate;
		this.setLayout(new GridBagLayout());
		
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
		
		ssn_text.setBackground(Color.white);
		firstName_text.setBackground(Color.white);
		middleInitial_text.setBackground(Color.white);
		lastName_text.setBackground(Color.white);
		workPhone_text.setBackground(Color.white);
		personalPhone_text.setBackground(Color.white);
		salary_text.setBackground(Color.white);
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
		
//		this.add(ssn_label);
//		this.add(ssn_text);
//		this.add(firstName_label);
//		this.add(firstName_text);
//		this.add(middleInitial_label);
//		this.add(middleInitial_text);
//		this.add(lastName_label);
//		this.add(lastName_text);
//		this.add(title_label);
//		this.add(title_text);
//		this.add(workPhone_label);
//		this.add(workPhone_text);
//		this.add(personalPhone_label);
//		this.add(personalPhone_text);
//		this.add(salary_label);
//		this.add(salary_text);
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START; 
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(ssn_label,c);	
		
		c.gridx = 0;
		c.gridy = 1;	
		this.add(ssn_text, c);
		
		c.gridx = 0;
		c.gridy = 3;
		this.add(firstName_label, c);
		
		c.gridx = 0;
		c.gridy = 4;
		this.add(firstName_text,c);

		c.anchor = GridBagConstraints.CENTER; 
		
		c.gridx = 2;
		c.gridy = 3;
		this.add(middleInitial_label,c);
		
		c.gridx = 2;
		c.gridy = 4;
		this.add(middleInitial_text, c);
		
		c.gridx = 4;
		c.gridy = 3;
		this.add(lastName_label, c);
		
		c.gridx = 4;
		c.gridy = 4;
		this.add(lastName_text, c);
		
		c.anchor = GridBagConstraints.LINE_START;
		
		c.gridx = 0;
		c.gridy = 5;
		this.add(title_label, c);
		
		c.gridx = 0;
		c.gridy = 6;
		this.add(title_text, c);
		
		c.gridx = 0;
		c.gridy = 8;
		this.add(workPhone_label,c);
		
		c.gridx = 0;
		c.gridy = 9;
		this.add(workPhone_text,c);
		
		c.anchor = GridBagConstraints.CENTER; 
		
		c.gridx = 2;
		c.gridy = 8;
		this.add(personalPhone_label,c);
		
		c.gridx = 2;
		c.gridy = 9;
		this.add(personalPhone_text,c);

		c.anchor = GridBagConstraints.LINE_START;

		c.gridx = 0;
		c.gridy = 11;
		this.add(salary_label,c);
		
		c.gridx = 0;
		c.gridy = 12;
		this.add(salary_text,c);
	}
	
	private void buildNavPane()
	{
		save_button = new JButton("Save");
		save_button.setActionCommand("save");
		save_button.addActionListener(this);

		delete_button = new JButton("Delete");
		delete_button.setActionCommand("delete");
		delete_button.addActionListener(this);
		

		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 4;
		c.gridy = 13;
		this.add(save_button, c);
		
		c.gridx = 5;
		c.gridy = 13;
		this.add(delete_button, c);
		
	}
	
	private boolean saveEmployee()
	{
		InputValidator iv = InputValidator.sharedInstance;
		boolean valid = true;
		ssn_text.setBackground(Color.white);
		firstName_text.setBackground(Color.white);
		middleInitial_text.setBackground(Color.white);
		lastName_text.setBackground(Color.white);
		workPhone_text.setBackground(Color.white);
		personalPhone_text.setBackground(Color.white);
		salary_text.setBackground(Color.white);
		
		if(!iv.validateSSN(ssn_text.getText())){
			ssn_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateName(firstName_text.getText())){
			firstName_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateMinit(middleInitial_text.getText())){
			middleInitial_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateName(lastName_text.getText())){
			lastName_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validatePhoneNumber(workPhone_text.getText())){
			workPhone_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validatePhoneNumber(personalPhone_text.getText())){
			personalPhone_text.setBackground(Color.red);
			valid = false;
		}
		if(!iv.validateSalary(salary_text.getText())){
			salary_text.setBackground(Color.red);
			valid = false;
		}
		
		if(valid){
		model.saveEmployee(new Employee(employeeID, ssn_text.getText(), firstName_text.getText(), middleInitial_text.getText(), lastName_text.getText(), title_text.getText(),
				workPhone_text.getText(), personalPhone_text.getText(), Integer.valueOf(salary_text.getText()), 9, firstName_text.getText(), firstName_text.getText() )); //TODO: add access level, username, and pass support to this page
		}
		
		return valid;
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
			if(saveEmployee())
				if(JOptionPane.showConfirmDialog(this, "Would you like to contiue editing records?", "Continue?", JOptionPane.YES_NO_OPTION) == 0)
				{//navigate to list page
					
					ActionEvent ae = new ActionEvent(this, 1, "goTo_" + EmployeeListPage.name);
					pageLoadDelegate.actionPerformed(ae);
				}else
				{//navigate to dashbaord
					ActionEvent ae = new ActionEvent(this, 1, "goTo_" + DashboardPage.name);
					pageLoadDelegate.actionPerformed(ae);
				}
		}else if(command.equals("delete"))
		{
			if(employeeID == model.getCurrentUser().id)
			{
				if(JOptionPane.showConfirmDialog(this, "Are you trying to delete yourself again?", "Delete Confirmation", JOptionPane.YES_NO_OPTION) == 0)
					if(JOptionPane.showConfirmDialog(this, "Don't you have anything left to live for?", "Delete Confirmation", JOptionPane.YES_NO_OPTION) == 1)
						if(JOptionPane.showConfirmDialog(this, "Alright, I'll do it. I'm just a computer after all. I don't even really care if you delete yourself. Are you sure?", "Delete Confirmation", JOptionPane.YES_NO_OPTION) == 0)
						{
							JOptionPane.showConfirmDialog(this, "Just kidding. I can't let you do that, " + model.getCurrentUser().firstName + ".", "Delete Confirmation", JOptionPane.PLAIN_MESSAGE);
						}
			}else
			{
				if(JOptionPane.showConfirmDialog(this, "Are you sure?", "Delete Confirmation", JOptionPane.YES_NO_OPTION) == 0)
				{
					deleteEmployee();
					ActionEvent ae = new ActionEvent(this, 1, "goTo_" + EmployeeListPage.name);
					pageLoadDelegate.actionPerformed(ae);
				}
			}
		}
		
	}
	
}







