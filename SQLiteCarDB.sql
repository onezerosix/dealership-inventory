CREATE TABLE CAR (
	Car_ID integer 		NOT NULL primary key AUTOINCREMENT,
	VIN VARCHAR(18) 	NOT NULL,
	Car_Type VARCHAR(15) NOT NULL,
	Make VARCHAR(40) NOT NULL,
	Model VARCHAR(40) NOT NULL,
	Model_Year INT NOT NULL,
	Model_Trim VARCHAR(20) NOT NULL,
	Color VARCHAR(40) NOT NULL,
	Mileage INT NOT NULL,
	Price INT NOT NULL,
	Status VARCHAR(7) NOT null 		DEFAULT "Available"
);

CREATE TABLE EMPLOYEE (
	Emp_ID integer 		NOT NULL 	primary key autoincrement,
	SSN VARCHAR(9) 		NOT NULL,
	FName VARCHAR(30)	NOT NULL,
	Minit VARCHAR(1),
	LName VARCHAR(30) 	NOT NULL,
	Title VARCHAR(50) 	NOT NULL,
	WPhone VARCHAR(10) 	NOT NULL,
	PPhone VARCHAR(10) 	NOT NULL,
	Salary INT 			NOT NULL,
	AccessLevel INT(1) 	NOT NULL,
	UserName VARCHAR(40) NOT NULL 	UNIQUE,
	Password VARCHAR(60) NOT NULL 
);

CREATE TABLE CUSTOMER (
	Cust_ID integer 	NOT NULL primary key autoincrement,
	FName VARCHAR(30) 	NOT NULL,
	Minit VARCHAR(1),
	LName VARCHAR(30) 	NOT NULL,
	Phone VARCHAR(10) 	NOT NULL,
	Address VARCHAR(60) NOT NULL,
	Email VARCHAR(40)
);

CREATE TABLE SALE (
	Sale_ID integer not null primary key autoincrement,
	EID integer NOT NULL,
	CID integer NOT NULL,
	Sold_Car_ID integer NOT NULL,
	Date_Year INT(4) NOT NULL, 
	Date_Month INT(2) NOT NULL,
	Date_Day INT(2) NOT NULL,
	PriceSold INT(6) NOT NULL,

	CONSTRAINT fk_SALE_EMPLOYEE
		FOREIGN KEY (EID)
			REFERENCES EMPLOYEE (Emp_ID),

	CONSTRAINT fk_SALE_CUSTOMER
		FOREIGN KEY (CID)
			REFERENCES CUSTOMER (Cust_ID),

	CONSTRAINT fk_SALE_CAR
		FOREIGN KEY (Sold_Car_ID)
			REFERENCES CAR (Car_ID)
);
