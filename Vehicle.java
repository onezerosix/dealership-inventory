
public class Vehicle
{
	int id = -1;
	String vin, vehicleType, make, model, trim, color;
	int year, mileage, price;
	final static String[] vehicleAttributeNames = {"ID", "Vin", "VehicleType", "Make", "Model", "Year", "Trim", "Color", "Mileage", "Price"};
	
	Vehicle(int id,
			String vin,
			String vehicleType,
			String make,
			String model,
			int year,
			String trim,
			String color,
			int mileage,
			int price)
	{
		this.id = id;
		this.vin = vin;
		this.vehicleType = vehicleType;
		this.make = make;
		this.model = model;
		this.year = year;
		this.trim = trim;
		this.color = color;
		this.mileage = mileage;
		this.price = price;
	}
	
	Vehicle(Vehicle v)
	{
		this(v.id, v.vin, v.vehicleType, v.make, v.model, v.year, v.trim, v.color, v.mileage, v.price);
	}
}
