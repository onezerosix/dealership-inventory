# CATALOG: 		SKU, Type, Make, Model, Model_Year, 
#			 	Model_Trim, Color 
# INVENTORY:	VIN, Car_SKU, Mileage, Price
# EMPLOYEE:		Emp_ID, SSN, FName, Minit, LName,
# 				Title, WPhone, PPhone, Salary
# CUSTOMER:		Cust_ID, FName, Minit, LName, Phone,
#				Address, Email
# SALE:			EID, CID, Sold_VIN, Date_Year, 
#				Date_Month, Date_Day


###################
# CATALOG Records #
###################
#Civics
INSERT INTO CAR (VIN, Type, Make, Model, Model_Year, Model_Trim, Color, Mileage, Price)
VALUES ('H0000000000000001', 'Coupe', 'Honda', 'Civic', 1992, 'Base', 'Black', 190000, 2300),
VALUES ('H0000000000000002', 'Hatchback', 'Honda', 'Civic', 1993, 'S', 'White',153020, 4000),
VALUES ('H0000000000000003', 'Coupe', 'Honda', 'Civic', 1995, 'LS', 'Red', 165000, 4200),
VALUES ('H0000000000000004', 'Sedan', 'Honda', 'Civic', 1994, 'Base', 'Silver', 210339, 2000),
VALUES ('H0000000000000005', 'Sedan', 'Honda', 'Accord', 1995, 'S', 'White', 100324, 6700),
VALUES ('H0000000000000006', 'Sedan', 'Honda', 'Accord', 1992, 'LS', 'Blue', 124006, 5320),
VALUES ('H0000000000000007', 'Sedan', 'Honda', 'Accord', 1994, 'Base', 'Black', 84003, 8300),
VALUES ('H0000000000000008', 'Sedan', 'Honda', 'Accord', 1992, 'Base', 'White', 145623, 4500),
VALUES ('H0000000000000009', 'Coupe', 'Honda', 'Prelude', 1992, 'SI', 'Green', 203453, 1999),
VALUES ('H0000000000000010', 'Coupe', 'Honda', 'Prelude', 1996, 'Base', 'White', 111894, 7400);


####################################################
# EMPLOYEE:		Emp_ID, SSN, FName, Minit, LName,  #
# 				Title, WPhone, PPhone, Salary      #
####################################################
INSERT INTO EMPLOYEE (Emp_ID, SSN, FName, Minit, LName, Title, WPhone, PPhone, Salary)
VALUES ('E00001', '657483957', 'Eric', '', 'Poe', 'Salesperson', '9098831221', '7143445674', 45000),
VALUES ('E00002', '659183343', 'Carl', 'R', 'Jermaine', 'Salesperson', '9513234569', '7146263883', 45000),
VALUES ('E00003', '695823742', 'Jessica', 'J', 'Smith', 'Salesperson', '9514032873', '7149887667', 45000),
VALUES ('E00004', '534289301', 'Jen', '', 'Artemis', 'Inventory Manager', '9099339733', '7149207773', 60000),
VALUES ('E00005', '668392012', 'Chase', 'L', 'Steele', 'Sales Manager', '9098623110', '6264822219', 60000),
VALUES ('E00006', '776483241', 'Patrick', 'S', 'Tomb', 'General Manager', '9095623190', '7143239887', 80000),
VALUES ('E00007', '621321190', 'Debra', '', 'Gonzalez', 'CEO', '9518187600', '7143663291', 100000);


##################################################
INSERT INTO CUSTOMER (Cust_ID, FName, Minit, LName, Phone, Address, Email)
VALUES ('C00000001', 'James', 'E', 'Jones', '7145622882', '1234 W. Some st. City, State 91111', 'cust1@email.com'),
VALUES ('C00000002', 'Christina', 'H', 'Lopez', '7564800012', '4321 E. Another st. City, State 91111', 'cust2@email.com'),
VALUES ('C00000003', 'Jay', '', 'Bauman', '8183552199', '4955 W. Fake Ave. City, State 91111', 'cust3@email.com'),
VALUES ('C00000004', 'Denise', '', 'Lewis', '9096548888', '2377 S. Different rd. City, State 91111', 'cust4@email.com'),
VALUES ('C00000005', 'Darius', 'J', 'Jacobs', '7146649930', '1111 N. Green st. City, State 91111', 'cust5@email.com'),
VALUES ('C00000006', 'Lizeth', 'B', 'Bernice', '9517440066', '9889 W. Blue st. City, State 91111', 'cust6@email.com');


##################################################
INSERT INTO SALE (EID, CID, Sold_VIN, Date_Year,Date_Month,Date_Day)
VALUES ('E00003', 'C00000004', 'H0000000000000011', '2015', '12', '24'),
VALUES ('E00005', 'C00000002', 'H0000000000000012', '2015', '08', '11'),
VALUES ('E00001', 'C00000001', 'H0000000000000013', '2015', '04', '9');

####################################
#Update SQL Statement for changing Car record
UPDATE Car
SET VIN = 'something', Type = 'something', Make = 'something', Model = 'something', Model_Year = 0000, Model_Trim = 'something', Color = 'something', Mileage = 00, Price = 00
WHERE Car_ID = 1;

# Show all
SELECT *
FROM Car;

#Make New REcord
INSERT INTO CAR (VIN, Type, Make, Model, Model_Year, Model_Trim, Color, Mileage, Price)
VALUES ('H0000000000000001', 'Coupe', 'Honda', 'Civic', 1992, 'Base', 'Black', 190000, 2300);
