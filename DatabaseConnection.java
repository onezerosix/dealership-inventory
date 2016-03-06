import java.util.Hashtable;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	Connection c = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public void saveVehicle(Vehicle v)
	{
		if(v.id == -1)
			addNewVehicle(v);
		else
			updateExistingVehicle(v);
	}
	
	public void deleteVehicle(int id)
	{
		connect();
		
		String sql = "delete from car where Car_ID = " + id + "";
		
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconnect();
	}
	
	private Boolean connect()
	{
		try
		{
			if(c != null)
				c.close();
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite::resource:IHAA.db");
		} catch (Exception e)
		{
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	private void disconnect()
	{
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addNewVehicle(Vehicle v)
	{
		connect();
		
		String sql = "INSERT INTO CAR (VIN, Car_Type, Make, Model, Model_Year, Model_Trim, Color, Mileage, Price) VALUES"
			+ "('" + v.vin + "', '" + v.vehicleType + "', '" + v.make + "', '" + v.model + "', " + v.year + ", '" + v.trim + "', '" + v.color + "', " + v.mileage + ", " + v.price + ");";
		
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconnect();
	}
	
	private void updateExistingVehicle(Vehicle v)
	{
		connect();
		
		String sql = "UPDATE Car "
				+ "SET VIN = '" + v.vin + "', Car_Type = '" + v.vehicleType + "', Make = '" +v.make  + "', Model = '" + v.model + "', Model_Year = " + v.year + ", Model_Trim = '" + v.trim + "', Color = '" + v.color + "', Mileage = " + v.mileage + ", Price = " + v.price + " "
				+ "WHERE Car_ID = " + v.id +";";
		
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconnect();
	}
	
	public Vector<Vehicle> getInventory()
	{
		
		connect();
		
		Vector<Vehicle> i = new Vector<Vehicle>();
		
		String sql = "SELECT * FROM Car;";
		
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				i.add(new Vehicle(rs.getInt("Car_ID"), rs.getString("VIN"), rs.getString("Car_Type"), rs.getString("Make"),
						rs.getString("Model"), rs.getInt("Model_Year"), rs.getString("Model_Trim"), rs.getString("Color"), rs.getInt("Mileage"), rs.getInt("Price")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconnect();

		return i;
	}
	
	public Hashtable<String, String> getUserPassList()
	{
		Hashtable<String, String> up = new Hashtable<String, String>();
		up.put("admin", "password");
		
		return up;
		
		
	}

	
	//int id, String ssn, String firstName, String MI, String lastName, String title, String workPhone,  String personalPhone, int salary
	
	
	public Vector<Employee> getEmployees()
	{
		connect();
		
		Vector<Employee> e = new Vector<Employee>();
		
		String sql = "SELECT * FROM employee;";
		
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				e.add(new Employee(rs.getInt("emp_id"), rs.getString("ssn"), rs.getString("fname"), rs.getString("minit"), rs.getString("lname"),
						rs.getString("title"), rs.getString("wphone"), rs.getString("pphone"), rs.getInt("salary") ));
			}
		} catch (SQLException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
		}

		disconnect();

		return e;
	}

	private void addNewEmployee(Employee e)
	{
		connect();
		
		String sql = "INSERT INTO employee (ssn, fname, minit, lname, title, wphone, pphone, salary) VALUES"
			+ "('" + e.ssn + "', '" + e.firstName + "', '" + e.MI + "', '" + e.lastName + "', '" + e.title + "', '" + e.workPhone + "', '" + e.personalPhone
			+ "', " + e.salary + ");";
		
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
		}

		disconnect();
	}
	
	private void updateExistingEmployee(Employee e)
	{
		connect();
		
		String sql = "UPDATE employee "
				+ "SET ssn = '" + e.ssn + "', fname = '" + e.firstName + "', Minit = '" + e.MI  + "', lname = '" + e.lastName + "', title = '" + e.title
				+ "', wphone = '" + e.workPhone + "', pphone = '" + e.personalPhone + "', salary = " + e.salary + " where emp_id =" + e.id + ";";
		
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
		}

		disconnect();
	}
	
	public void saveEmployee(Employee e)
	{
		if(e.id == -1)
			addNewEmployee(e);
		else
			updateExistingEmployee(e);
	}
	
	public void deleteEmployee(int id)
	{
		connect();
		
		String sql = "delete from employee where Emp_ID = " + id + "";
		
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconnect();
	}

}
