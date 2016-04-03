
public class SaleRecord{

	int saleRecordID = -1, employeeID=-1, customerID= -1, vehicleID =-1, salePrice, year, month, day;
	String firstName, middleInitial, lastName, phone, address;
	final static String[] saleRecordNames = {"saleRecordID","employeeID","customerID","vehicleID"};
	
	
	SaleRecord(int saleRecordID, int employeeID, int customerID, int vehicleID, String firstName, String middleInitial, 
			String lastName, String phone, String address, int salePrice, int year, int month, int day)
	{
		this.saleRecordID = saleRecordID;
		this.employeeID = employeeID; //foreign key
		this.customerID = customerID;
		this.vehicleID =vehicleID;
		this.firstName = firstName; //customer
		this.middleInitial = middleInitial; //customer
		this.lastName = lastName; //customer
		this.phone = phone; //customer
		this.address = address;
		this.salePrice = salePrice;
		this.year = year;
		this.month = month;
		this.day = day;
		
	}
	
	SaleRecord(SaleRecord e)
	{
		this(e.saleRecordID, e.employeeID, e.customerID, e.vehicleID, e.firstName, e.middleInitial, e.lastName, e.phone, 
				e.address, e.salePrice, e.year, e.month, e.day);
	}
	
	
	
} 
