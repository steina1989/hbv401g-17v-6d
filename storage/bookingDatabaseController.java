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
/*
ATH ++++ WHAT STILL NEEDS TO BE FIXED +++++ ATH
- insert and delete both work but still error reports
- still dealing with the inability to get the view result to work properly

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
		 
				 
// ------------ BOOKING A TRIP -----------------------------------------------------------------------------------------------------	
				 		 
		String [] BOrders; // supposed array that is inserted
		BOrders = new String[6];
		BOrders[0] = "'2'"; //Booking id
		BOrders[1] = "'3,4'"; // Trip id, can be several numbers separated by a comma for several trips
		BOrders[2] = "'4,2'"; // Number of seats ordered, can be several numbers separated by a comma  for several trips 
		BOrders[3] = "'Gunni'"; // Name of person placing the booking 
		BOrders[4] = "'8776765'"; // phone number of the person placing the booking
		BOrders[5] = "'Alaskan@pipeline.com'"; // Email of the person placing the booking
		
		/*	
		
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
		
		if(rs != null){
			rs.close();
		}
		*/
//------------------------------------------- BOOKING A TRIP FINISHED -------------------------------------------------
		
		
// -------------------GET USER BOOKINGS --------------------------------------------------------------------------------

		String [] BOrders2; // supposed array that is inserted
		BOrders2 = new String[6];
		BOrders2[0] = "'2'"; //Booking id
		BOrders2[1] = "'NA'"; // Trip id, can be several numbers separated by a comma for several trips
		BOrders2[2] = "'NA'"; // Number of seats ordered, can be several numbers separated by a comma  for several trips 
		BOrders2[3] = "'NA'"; // Name of person placing the booking 
		BOrders2[4] = "'NA'"; // phone number of the person placing the booking
		BOrders2[5] = "'NA'"; // Email of the person placing the booking				
		
 // ---------> CREATE THE SQL COMMAND LINE ------------------------------------------------------------------------------
		/*
		
		String sqlinput2 = "SELECT * FROM Daytrips ";
		String and = "";
		int start = 1;
		for(int i =0;i<=BOrders2.length;i++)
		{
			if(BOrders2[i] != "'NA'"){ // if the compartment is empty then skip this array slot.
				if(start == 1){ // to seperate searching for everything versus specific search
					sqlinput2 = sqlinput2 + " WHERE";}
				
				if(start==2 ){// starting an sql where querey with AND relays only errors, this should prevent that.
					and= " AND";
					start++; } 
				
				  start++;
				  			if(i<3){
									if(i==0)sqlinput2 = sqlinput2 + and + " ( BookingId == " + BOrders2[i] + ")";
									if(i==1)sqlinput2 = sqlinput2 + and + " ( TripId == " + BOrders2[i] + ")"; 	
									if(i==2)sqlinput2 = sqlinput2 + and + " ( NumberOfSeats == " + BOrders2[i] + ")"; 
				  			}else{		
									if(i==3)sqlinput2 = sqlinput2 + and + " ( NameOfBuyer == " + BOrders2[i] + ")"; 
									if(i==4)sqlinput2 = sqlinput2 + and + " ( PhoneOfBuyer == " + BOrders2[i] + ")"; 
									if(i==5)sqlinput2 = sqlinput2 + and + " ( EmailOfBuyer == " + BOrders2[i] + ")"; 
				  			}	
				  			System.out.println(sqlinput2);
					}
		    }
		sqlinput2 = sqlinput2 + ";"; // to end the command
		
		ResultSet rs2 = stmt.executeQuery(sqlinput2);// Send in completed SQL query.
		String BookingInfoArray [];
		 BookingInfoArray = new String [6];
		// BookingId,TripId,NumberOfSeats,NameOfBuyer,PhoneOfBuyer,EmailOfBuyer
		
// --------------> 	GET THE RESULT OF THE SQL COMMAND	
		 
		 while(rs2.next()){
			 //Retrieve by column name
			 String BookId = rs2.getString("BookingId");
			 String TripId = rs2.getString("TripId");
			 String SeatsBooked = rs2.getString("NumberOfSeats");
			 String Name = rs2.getString("NameOfBuyer");
			 String phone = rs2.getString("PhoneOfBuyer");
			 String Email = rs2.getString("EmailOfBuyer");
			
			 System.out.print(BookId+ " : ");
			 System.out.print(TripId+ " : ");
			 System.out.print(SeatsBooked+ " : ");
			 System.out.print(Name+ " : ");
			 System.out.print(phone+ " : ");
			 System.out.print(Email+ " : ");
			 
			
			 
// --------------> 	PUT THE RESULT INTO AN ARRAY			 
			
			 for(int j=0;j<=BookingInfoArray.length;j++){
				if(j==0)BookingInfoArray [j] = BookId; 
				if(j==1)BookingInfoArray [j] = TripId;  
				if(j==2)BookingInfoArray [j] = SeatsBooked;  
				if(j==3)BookingInfoArray [j] = Name;  
				if(j==4)BookingInfoArray [j] = phone;  
				if(j==5)BookingInfoArray [j] = Email;  
			 } 
		 }
		for(int i=0;i<=6;i++){
			System.out.print(" : " + BookingInfoArray[i]);
		}
		if(rs2 != null){
			rs2.close();
		}
		
	//	return BookingInfoArray; must find a sutable way to return the array 
// -------------------GET USER BOOKINGS - FINISHED --------------------------------------------------------------------------------	
		
	 */	
		
// --------------->! CALNCEL BOOKING !<------------------------------------------------------------------------------
	
	// example of delete code

		//DELETE FROM table_name
		//WHERE [condition];
		String BOrder3 = "'1'";
		String sqlinput3 = "DELETE FROM Bookings WHERE BookingId == " + BOrder3;
		ResultSet rs3 = stmt.executeQuery(sqlinput3);// Send in completed SQL query.
		if(rs3 != null){
			rs3.close();
		}			
// --------------->! CALNCEL BOOKING - FINIFHED !<------------------------------------------------------------------------------
		
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
			}
					
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
