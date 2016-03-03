CREATE TABLE CAR (
	Car_ID MEDIUMINT NOT NULL AUTO_INCREMENT,
	VIN VARCHAR(18) NOT NULL,
	Car_Type VARCHAR(15) NOT NULL,
	Make VARCHAR(40) NOT NULL,
	Model VARCHAR(40) NOT NULL,
	Model_Year INT NOT NULL,
	Model_Trim VARCHAR(20) NOT NULL,
	Color VARCHAR(40) NOT NULL,
	Mileage INT NOT NULL,
	Price INT NOT NULL,
	
	CONSTRAINT pk_CAR
		PRIMARY KEY (Car_ID)
);

CREATE TABLE EMPLOYEE (
	Emp_ID VARCHAR(6) NOT NULL,
	SSN VARCHAR(9) NOT NULL,
	FName VARCHAR(30) NOT NULL,
	Minit VARCHAR(1),
	LName VARCHAR(30) NOT NULL,
	Title VARCHAR(50) NOT NULL,
	WPhone VARCHAR(10) NOT NULL,
	PPhone VARCHAR(10) NOT NULL,
	Salary INT NOT NULL,
	
	CONSTRAINT pk_EMPLOYEE
		PRIMARY KEY (Emp_ID)
		
);

CREATE TABLE CUSTOMER (
	Cust_ID VARCHAR(9) NOT NULL,
	FName VARCHAR(30) NOT NULL,
	Minit VARCHAR(1),
	LName VARCHAR(30) NOT NULL,
	Phone VARCHAR(10) NOT NULL,
	Address VARCHAR(60) NOT NULL,
	Email VARCHAR(40),
	
	CONSTRAINT pk_CUSTOMER
		PRIMARY KEY (Cust_ID)
	
);


CREATE TABLE SALE (
	EID VARCHAR(6) NOT NULL,
	CID VARCHAR(9) NOT NULL,
	Sold_VIN VARCHAR(18) UNIQUE NOT NULL,
	Date_Year SMALLINT(4) NOT NULL, 
	Date_Month TINYINT(2) NOT NULL,
	Date_Day TINYINT(2) NOT NULL,
	
	CONSTRAINT pk_SALE
		PRIMARY KEY (EID, CID, Sold_VIN),
	CONSTRAINT fk_SALE_EMPLOYEE
		FOREIGN KEY (EID)
			REFERENCES EMPLOYEE (Emp_ID),
	CONSTRAINT fk_SALE_CUSTOMER
		FOREIGN KEY (CID)
			REFERENCES CUSTOMER (Cust_ID),
		
);
