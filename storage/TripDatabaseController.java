package storage;
import java.sql.Connection;


import java.sql.Date;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Trip;

// C:\Users\ÓlafurKonráð\workspace\Daytrip

/* !!!! ------ THINGS IN THIS CODE THAT ARE STILL WAITING TO BE DONE ------- !!!!
 * + change the values on the getters so i can get them
 * 		- date(date) and revew(char)
 * + can connect to the database and create the SQL command but nothing happens for some reason
 * 		and no error report at all. Starting to suspect that the jar files are not being accsessed
 * + Figure out a proper way to relay the array with the SQL results */
//------------------------------------------------------------------------------
/*
+ TripDatabaseController() : void
+ getTripsByParameter(lowprice. int, highprice: int, lowDate: Date,
       highDate: Date category: String....) : ResultSet
+ addReview(review : Review) : void
*/

public class TripDatabaseController {

	// JDBC driver
		static final String JDBC_DRIVER = "org.sqlite.JDBC";
		static final String DB_URL = "jdbc:sqlite:C:\\Users\\stein\\workspace\\Daytrip\\src\\storage\\DayTrips.sqlite";

	public static void main(String [] args){

		String [] TOrders;  // hardcoding for testing supposed intake of info
		TOrders = new String [13];
		TOrders[0] = "NA"; // tripID
		TOrders[1] = "NA"; // name
		TOrders[2] = "NA";  // date low
		TOrders[3] = "NA"; // date high
		TOrders[4] = "NA"; // price low
		TOrders[5] = "NA"; // price high
		TOrders[6] = "NA"; // Category
		TOrders[7] = "NA"; // Location (part of the country)

		/* - NEEDS TO BE FIXED
		 * name
		 * date low
		 * date high
		 * price low
		 * price high
		 * category
		 * location (part of the country)
		*/
	}

||||||| .r72

=======
>>>>>>> .r75

<<<<<<< .mine

||||||| .r72
=======
		// aðferðin þarf að líta svona svona á endanum
		public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray) {
			return new ArrayList<Trip>();
		}

>>>>>>> .r75
		public static String [][] getTripsByParameter(String [] ViewTripOrder){
			Connection conn = null;
			Statement stmt = null;
			int numberOfLines = 0;
			String [][] sqlreturn;
			sqlreturn = new String [numberOfLines][10];
			try{
			 //STEP 2: Register JDBC driver
			 Class.forName(JDBC_DRIVER);
			 //STEP 3: Open a connection
			 System.out.println("Connecting to database...");
			 conn = DriverManager. getConnection(DB_URL);
			 //STEP 4: Execute a query
			 System.out.println("Creating statement...");
			 stmt = conn.createStatement();
			 /* - NEEDS TO BE FIXED
				 * name
				 * date low
				 * date high
				 * price low
				 * price high
				 * category
				 * location (part of the country)
				*/

				String and = "";
				int start = 0;
				String sqlinput="SELECT * FROM Daytrips ";// the string that is the SQL command
			for(int i=1; i< ViewTripOrder.length;i++ ){

				if(ViewTripOrder[i] != "NA"){ // if the compartment is empty then skip this array slot.
					start++;
					if(start == 1){ // to seperate searching for everything versus specific search
						sqlinput = sqlinput + " WHERE";

							}
					if(start==2 ){// starting an sql where querey with AND relays only errors, this should prevent that.
						and= " AND";
						start++;
					      }

							    	  			if(i==0){// TripId
													sqlinput = sqlinput + and + " ( TripId == '" + ViewTripOrder[i] + "' )";
												}if(i==1){// TripName
													sqlinput = sqlinput + and + " ( TripName == '" + ViewTripOrder[i] + "' )";
												}if(i==2){// TripDate_lower or same as
												sqlinput = sqlinput + and + " ( TripDate >= " + ViewTripOrder[i] + " )";}

												if(i==3){// TripDate higher or same as
													sqlinput = sqlinput + and + " ( TripDate <= " + ViewTripOrder[i] + " )";
												}if(i==4){// TripPrice_lower or same
													sqlinput = sqlinput + and + " ( TripReviews >= '" + ViewTripOrder[i] + "' )";
												}if(i==5){// TripPrice_higer or same
													sqlinput = sqlinput + and + " ( TripLocation <= '" + ViewTripOrder[i] + "' )";}
												if(i==6){// Category
													sqlinput = sqlinput + and + " ( TripLocation == '" + ViewTripOrder[i] + "' )";}
												if(i==7){// Location
													sqlinput = sqlinput + and + " ( TripLocation == '" + ViewTripOrder[i] + "' )";}


				System.out.println(sqlinput);

				sqlinput = sqlinput + ";"; // to end the command
				 System.out.println(sqlinput);
			 //-------------------------------------------------------------------------------------------------------------

				start = 1;
			     ResultSet rs = stmt.executeQuery(sqlinput);// Send in completed SQL query.

			 //------------------------------- COLLECT THE RESAULTS FROM SQL COMMAND -----------------------------------------



				// STEP 5: Extract data from result set
				 while(rs.next()){
							 //Retrieve by column name
							 int id = rs.getInt("TripId");
							 String id2 = Integer.toString(id);
							 String name = rs.getString("TripName");
							 String Date = rs.getString("TripDate");
							// String Date2 = Integer.toString(Date);
							String Reviews = rs.getString("TripReviews");
							 String Location = rs.getString("TripLocation");
							 int Price = rs.getInt("TripPrice");
							 String Price2 = Integer.toString(Price);
							 String Description = rs.getString("TripDescription");
							 int Seats = rs.getInt("TripCategory");
							 String Seats2 = Integer.toString(Seats);
							 String Guides = rs.getString("TripGuides");

							 System.out.print(id2+ " : ");
							 System.out.print(name+ " : ");
							 System.out.print(Date+ " : ");
							 System.out.print(Reviews+ " : ");
							 System.out.print(Location+ " : ");
							 System.out.print(Price2+ ":");
							 System.out.print(Description+ " : ");
							 System.out.print(Seats+ " : ");
							 System.out.println(Guides+ " : ");

			// --------------------------------------------------------------------------------------------------------------

			//------------------------> INSERT SQL RESULT INTO ARRAY VARIABLE TO BE SENT FORWARD <------------------------------------
				 // Insert the newly gotten line into the array that will be returned to other classes


							 for(int i =0;i<=9;i++){

								 if(i==0)
								 sqlreturn [numberOfLines][i] = id2 ;
								 if(i==1)
								 sqlreturn [numberOfLines][i] = name ;
								  if(i==2){
								sqlreturn [numberOfLines][i] = Date; }
								 if(i==3)
								 sqlreturn [numberOfLines][i] =  Reviews ;
								 if(i==4)
								 sqlreturn [numberOfLines][i] = Location ;
								 if(i==5)
								 sqlreturn [numberOfLines][i] = Price2 ;
								 if(i==6)
								 sqlreturn [numberOfLines][i] = Description ;
								 if(i==7)
								 sqlreturn [numberOfLines][i] = Seats2 ;
								 if(i==8)
									 sqlreturn [numberOfLines][i] = Guides ;

						 numberOfLines++;

						 //Display values
						 System.out.print("ID: " + id);
						 System.out.print(", Name: " + name);
						 //System.out.print(", Date: " + Date);
						// System.out.print(", Reviews: " + Reviews );
						 System.out.print(", Location: " + Location );
						 System.out.print(", Price: " + Price );
						 System.out.print(", Description: " + Description);
						 System.out.println(", Seats: " + Seats );

							} }
				 if(rs != null){
						rs.close();
					}
					if(stmt != null){
						stmt.close();
					}
					if(conn != null){
						conn.close();
						}


			//------------------------------------------------------------------------------------------------------------------------------------

				}catch(SQLException se){
				 //Handle errors for JDBC
				 se.printStackTrace();
				}catch(Exception e){
				 //Handle errors for Class.forName
				 e.printStackTrace();
				}finally{
					return sqlreturn;
				}

		}


}	//end
