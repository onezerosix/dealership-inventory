import java.awt.List;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

public class Model
{
	private DatabaseConnection db;
	
	Vector<Vehicle> inventory;
	Hashtable<String, String> userPass;
	boolean loggedIn = false;
	
	Model()
	{
		db = new DatabaseConnection();
		
		inventory = new Vector<Vehicle>();
		populateInventory();
		
		userPass = new Hashtable<String, String>();
		populateUsernamesAndPasswords();
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
		db.saveVehicletoDatabase(v);
		populateInventory();
	}

	void deleteVehicle(int id)
	{
		db.deleteVehicle(id);
		populateInventory();
	}
	
	// --- users and passwords ---
	void populateUsernamesAndPasswords()
	{//TODO: populate from database
		userPass.put("admin", "password");
	}

	boolean logIn(String username, String password)
	{
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


	
}









