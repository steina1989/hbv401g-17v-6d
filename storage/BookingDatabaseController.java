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

public class BookingDatabaseController {

	public static void main(String [] args){
// Main will be used only for testing other parts of the class

		BookingDatabaseController bdc = new BookingDatabaseController();
 /*
		 String BookingOrders [];
		 BookingOrders = new String[6];
		 BookingOrders[0] = "1";// BookingId
		 BookingOrders[1] = "3,5,4";// TripId
		 BookingOrders[2] = "5";// NumberOfSeats
		 BookingOrders[3] = "Magnus";// NameOfBuyer
		 BookingOrders[4] = "8332900";// PhoneOfBuyer
		 BookingOrders[5] = "manney@manney.is";// EmailOfBuyer

		 bdc.setUserBookings(BookingOrders);
*/
  /*
		 String [] DeleteOrder;
		 DeleteOrder = new String[3];
		 DeleteOrder [0] = "1"; // bookingId
		 DeleteOrder [1] = "2"; // TripId
		 DeleteOrder [2] = "3"; // number of seats to be canceled.
		 bdc.cancelBooking(DeleteOrder);

	*/
// /*
		 String [] BookingView; // supposed array that is inserted
			BookingView = new String[6];
			BookingView[0] = "'2'"; //Booking id
			BookingView[1] = "'NA'"; // Trip id, can be several numbers separated by a comma for several trips
			BookingView[2] = "'NA'"; // Number of seats ordered, can be several numbers separated by a comma  for several trips
			BookingView[3] = "'NA'"; // Name of person placing the booking
			BookingView[4] = "'NA'"; // phone number of the person placing the booking
			BookingView[5] = "'NA'"; // Email of the person placing the booking
		String [] ViewBooking = bdc.getUserBookings(BookingView);
// */

	}

	// JDBC driver
			static final String JDBC_DRIVER = "org.sqlite.JDBC";
			static final String DB_URL = "jdbc:sqlite:" + resourcesDirectory.getAbsolutePath() + "\\TripDatabase.db";

		public void cancelBooking(String [] DeleteOrder){ // --------------->! CALNCEL BOOKING (cancelBooking)
			// DeleteOrder[0] = The booking id to be deleted
			// DeleteOrder[1] = the trip id of the trip to be removed from booking
			// DeleteOrder[2] = the booked seats to be returned
			Connection conn = null;
			Statement stmt = null;
			String DeleteBooking = "Booking deleted";
			try{
			 //STEP 2: Register JDBC driver
			 Class.forName(JDBC_DRIVER);
			 //STEP 3: Open a connection
			 System.out.println("Connecting to database...");
			 conn = DriverManager. getConnection(DB_URL);
			 //STEP 4: Execute a query
			 System.out.println("Creating statement...");
			 stmt = conn.createStatement();

			 String sqlinput3 = "DELETE FROM Bookings WHERE BookingId == " + DeleteOrder[0] + " ;";
			 System.out.println(sqlinput3);
			 String sqlinput4 = "SELECT TripSeatsAvailable FROM Daytrips WHERE TripId == " + DeleteOrder[1] + " ;";
			 System.out.println(sqlinput4);


			 stmt.executeQuery(sqlinput3);// Send in completed SQL query to delete.
			 ResultSet rs3 = stmt.executeQuery(sqlinput4); // send in the sql query to get the current number of seats


			 int seats = rs3.getInt("TripSeatsAvailable"); //
			 int seats2 = Integer.parseInt(DeleteOrder[2]); // to get the number of seats booked by the person who is deleting their order.
			 int SeatsFixed = seats + seats2; // add the cancel seats to the number of seats open.
			 String sqlinput5 = "INSERT INTO Bookings(TripSeatsAvailable) VALUE( '" + SeatsFixed + "' );"; // replace the former number with this updated number
			 System.out.println(sqlinput5);

			 stmt.executeQuery(sqlinput5); // sends inn the sql


				if(rs3 != null){
					rs3.close();
				}
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
		public void setUserBookings(String [] BookingOrders){
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

			// Example of a insert command INSERT INTO TABLE_NAME [(column1, column2, column3,...columnN)]
				//		VALUES (value1, value2, value3,...valueN);

		// INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
//				VALUES (1, 'Paul', 32, 'California', 20000.00 );


				String sqlinput = "INSERT INTO Bookings(BookingId,TripId,NumberOfSeats,NameOfBuyer,PhoneOfBuyer,EmailOfBuyer) VALUES ( ";
				/*
				+ booking.buyer + ","
						+ booking.bookingId + ","
						+ booking.trip[i].id + ","
						...
					*/

						;
				for(int i=0; i< BookingOrders.length;i++ ){ // creating the insert booking command

					if(i==0)sqlinput = sqlinput + BookingOrders[i];

					if(i>0)sqlinput = sqlinput +" , '"+ BookingOrders[i] + "'";

					System.out.println(sqlinput);
					}
				sqlinput = sqlinput + ");"; // to end the command
				System.out.println(sqlinput);

				ResultSet rs = stmt.executeQuery(sqlinput);// Send in completed SQL query.

				if(rs != null){
					rs.close();
				}if(stmt != null){
					stmt.close();
				} if(conn != null){
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

		public String [] getUserBookings(String [] BookingView){ // -------------------> VIEW USER BOOKINGS
			Connection conn = null;
			Statement stmt = null;
			 String BookingInfoArray [];
			 BookingInfoArray = new String [6];
			try{
			 //STEP 2: Register JDBC driver
			 Class.forName(JDBC_DRIVER);
			 //STEP 3: Open a connection
			 System.out.println("Connecting to database...");
			 conn = DriverManager. getConnection(DB_URL);
			 //STEP 4: Execute a query
			 System.out.println("Creating statement...");
			 stmt = conn.createStatement();

			 String sqlinput2 = "SELECT * FROM Daytrips ";
				String and = "";
				int start = 1;
				for(int i =0;i<=BookingView.length;i++)
				{
					if(BookingView[i] != "'NA'"){ // if the compartment is empty then skip this array slot.
						if(start == 1){ // to seperate searching for everything versus specific search
							sqlinput2 = sqlinput2 + " WHERE";}

						if(start==2 ){// starting an sql where querey with AND relays only errors, this should prevent that.
							and= " AND";
							start++; }

						  start++;
						  			if(i<3){
											if(i==0)sqlinput2 = sqlinput2 + and + " ( BookingId == " + BookingView[i] + ")";
											if(i==1)sqlinput2 = sqlinput2 + and + " ( TripId == " + BookingView[i] + ")";
											if(i==2)sqlinput2 = sqlinput2 + and + " ( NumberOfSeats == " + BookingView[i] + ")";
						  			}else{
											if(i==3)sqlinput2 = sqlinput2 + and + " ( NameOfBuyer == " + BookingView[i] + ")";
											if(i==4)sqlinput2 = sqlinput2 + and + " ( PhoneOfBuyer == " + BookingView[i] + ")";
											if(i==5)sqlinput2 = sqlinput2 + and + " ( EmailOfBuyer == " + BookingView[i] + ")";
						  			}
						  			System.out.println(sqlinput2);
							}
				    }
				sqlinput2 = sqlinput2 + ";"; // to end the command

				ResultSet rs2 = stmt.executeQuery(sqlinput2);// Send in completed SQL query.

				// BookingId,TripId,NumberOfSeats,NameOfBuyer,PhoneOfBuyer,EmailOfBuyer

// ----------------------> 	GET THE RESULT OF THE SQL COMMAND
				 int j=0;
				 while(rs2.next()){
					 //Retrieve by column name
					 int BookId = rs2.getInt("BookingId");

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

// ------------------------> 	PUT THE RESULT INTO AN ARRAY

						if(j==0)BookingInfoArray [j] = BookId;
						if(j==1)BookingInfoArray [j] = TripId;
						if(j==2)BookingInfoArray [j] = SeatsBooked;
						if(j==3)BookingInfoArray [j] = Name;
						if(j==4)BookingInfoArray [j] = phone;
						if(j==5)BookingInfoArray [j] = Email;
						j++;
					 }


				if(rs2 != null){
					rs2.close();
				}if(stmt != null){
					stmt.close();
				} if(conn != null){
					conn.close();
				}

			}catch(SQLException se){
				 //Handle errors for JDBC
				 se.printStackTrace();
				}catch(Exception e){
				 //Handle errors for Class.forName
				 e.printStackTrace();
				}finally{
					return BookingInfoArray;
				}

		}
}
