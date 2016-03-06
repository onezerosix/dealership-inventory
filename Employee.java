
public class Employee {

	int id = -1, salary;
	String ssn, firstName, MI, lastName, title, workPhone, personalPhone;
	final static String[] employeeAttributeNames = {"ID", "SSN", "FirstName", "MI", "LastName", "Title", "WorkPhone", "PersonalPhone", "Salary"};
	
	Employee(int id, String ssn, String firstName, String MI, String lastName, String title, String workPhone,  String personalPhone, int salary)
	{
		this.id = id;
		this.ssn = ssn;
		this.firstName = firstName;
		this.MI = MI;
		this.lastName = lastName;
		this.title = title;
		this.workPhone = workPhone;
		this.personalPhone = personalPhone;
		this.salary = salary;
	}
	
	Employee(Employee e)
	{
		this(e.id, e.ssn, e.firstName, e.MI, e.lastName, e.title, e.workPhone, e.personalPhone, e.salary);
	}
	
	
	
}
