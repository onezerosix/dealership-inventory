import java.awt.List;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

public class Model
{
	private DatabaseConnection db;
	
	Vector<Vehicle> inventory;
	boolean loggedIn = false;
	
	Model()
	{
		db = new DatabaseConnection();
		
		inventory = new Vector<Vehicle>();
		populateInventory();
	}
	
	
	// --- vehicles ---
	private void populateInventory()
	{//TODO: load inventory from database class
		inventory.clear();
		inventory = db.getInventory();
	}
	
	Vector<Vehicle> getInventory()
	{
		return new Vector<Vehicle>(inventory);
	}
	
	Vehicle getVehicle(int id)
	{
		for(Vehicle v : inventory)
		{
			if(v.id == id)
			{
				return new Vehicle(v);
			}
		}
		
		return new Vehicle(-1, "error", "error", "error", "error", 1995, "error", "error", 1, 1);
	}
	
	void saveVehicle(Vehicle v)
	{
		db.saveVehicle(v);
		populateInventory();
	}

	void deleteVehicle(int id)
	{
		db.deleteVehicle(id);
		populateInventory();
	}
	
	
	// --- employees and passwords ---

	boolean logIn(String username, String password)
	{
		Hashtable<String, String> userPass = db.getUserPassList();
		if(userPass.get(username) == null)
			return false;
		else if(userPass.get(username).equals(password))
		{
			loggedIn = true;
			return true;
		}
		else
			return false;

	}
	
	Vector<Employee> getEmployees()
	{
		return db.getEmployees();
	}
		
	Employee getEmployee(int id)
	{
		Employee ret = new Employee(-1, "error", "error", "error", "error", "error", "error", "error", 0);
		for(Employee e : getEmployees())
		{
			if(e.id == id)
			{
				ret = new Employee(e);
			}
		}
		return ret;
	}
	
	void saveEmployee(Employee e)
	{
		db.saveEmployee(e);
	}

	void deleteEmployee(int id)
	{
		db.deleteEmployee(id);
	}
	
	
	
	
}









