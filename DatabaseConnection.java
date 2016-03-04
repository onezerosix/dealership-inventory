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
	
	public void saveVehicletoDatabase(Vehicle v)
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
	{//TODO get this list from the database
		
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
	
}
