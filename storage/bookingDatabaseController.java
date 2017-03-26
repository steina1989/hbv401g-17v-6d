package storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
+ BookingDatabaseController() : void
+ getUserBookings( userInfo : Object ) : ResultSet
+ setUserBookings( booking : Booking ) : void
+ cancelBooking( bookingID : String ) : void
*/

public class bookingDatabaseController {

	// JDBC driver
			static final String JDBC_DRIVER = "org.sqlite.JDBC";
			static final String DB_URL = "jdbc:sqlite:C:\\Users\\ÓlafurKonráð\\workspace\\Daytrip\\src\\storage\\DayTrips.sqlite";	
	
			public static void main(String [] args){	
				Connection conn = null;
				Statement stmt = null;
				try{
				 //STEP 2: Register JDBC driver
				 Class.forName(JDBC_DRIVER);
				 //STEP 3: Open a connection
				 System.out.println("Connecting to database...");
				 conn = DriverManager. getConnection(DB_URL);
				 //STEP 4: Execute a query
				 System.out.println("Creating statement...");
				 stmt = conn.createStatement();
				 
// ------------ BOOKING A TRIP -------------------------------------------------------				 
		String [] BOrders;
		BOrders = new String[6];
		BOrders[0] = "'1'"; //Booking id
		BOrders[1] = "'2'"; // Trip id, can be several numbers separated by a comma for several trips
		BOrders[2] = "'4'"; // Number of seats ordered, can be several numbers separated by a comma  for several trips 
		BOrders[3] = "'Hjalmtir'"; // Name of person placing the booking 
		BOrders[4] = "'8778765'"; // phone number of the person placing the booking
		BOrders[5] = "'Pimt@pimpin.com'"; // Email of the person placing the booking
		

		
// Example of a insert command INSERT INTO TABLE_NAME [(column1, column2, column3,...columnN)]  
		//		VALUES (value1, value2, value3,...valueN);	

// INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
//		VALUES (1, 'Paul', 32, 'California', 20000.00 );	

		
		String sqlinput = "INSERT INTO Bookings(BookingId,TripId,NumberOfSeats,NameOfBuyer,PhoneOfBuyer,EmailOfBuyer)"
				+ "VALUES ( ";
		for(int i=0; i< BOrders.length;i++ ){ // creating the insert booking command
			
			if(i==0)sqlinput = sqlinput + BOrders[i];
			
			if(i>0)sqlinput = sqlinput +" , "+ BOrders[i];
			System.out.println(sqlinput);
			}
		sqlinput = sqlinput + ");"; // to end the command
		System.out.println(sqlinput);
		
		ResultSet rs = stmt.executeQuery(sqlinput);// Send in completed SQL query.
		
		
				 
// -------------------GET USER bOOKINGS -------------------------------------------------------

				
				 
				 
// ---------------------------------------------------------------------------------------------
				
			}catch(SQLException se){
				 //Handle errors for JDBC
				 se.printStackTrace();
				}catch(Exception e){
				 //Handle errors for Class.forName
				 e.printStackTrace();
				}finally{
					 
				}
	
			}
}
