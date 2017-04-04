package storage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;


import java.sql.Date;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Trip;
import model.TripSearchCriteria;

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

public class TripDatabaseControllerOli {

		static String DB_URL;
		private static Connection conn;
		private ArrayList<Trip> results;

		
		//Connects to database.
		private static void connect() throws ClassNotFoundException, SQLException
		{
			 //File resourcesDirectory = new File("src/storage");
			 //DB_URL = "jdbc:sqlite:" + resourcesDirectory.getAbsolutePath()+"\\DayTrip.db" ;
			 DB_URL = "jdbc:sqlite:TripDatabase.db";
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager.getConnection(DB_URL);
		}
		
				
		
		public static ArrayList<Trip> getTripsByParameter(TripSearchCriteria criteria){

			Statement stmt = null;
			int numberOfLines = 0;
			String [][] sqlreturn;
			sqlreturn = new String [numberOfLines][10];
			try{
				connect();
				stmt = conn.createStatement();
				String and = "";
				int start = 0;
				String sqlinput="SELECT * FROM Daytrips";// the string that is the SQL command
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
				}
			}
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


							 for(int j =0;j<=9;j++){

								 if(j==0)
								 sqlreturn [numberOfLines][j] = id2 ;
								 if(j==1)
								 sqlreturn [numberOfLines][j] = name ;
								  if(j==2){
								sqlreturn [numberOfLines][j] = Date; }
								 if(j==3)
								 sqlreturn [numberOfLines][j] =  Reviews ;
								 if(j==4)
								 sqlreturn [numberOfLines][j] = Location ;
								 if(j==5)
								 sqlreturn [numberOfLines][j] = Price2 ;
								 if(j==6)
								 sqlreturn [numberOfLines][j] = Description ;
								 if(j==7)
								 sqlreturn [numberOfLines][j] = Seats2 ;
								 if(j==8)
									 sqlreturn [numberOfLines][j] = Guides ;

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

							}
							 }
				 
				 if(rs != null){
						rs.close();
					}
					if(stmt != null){
						stmt.close();
					}
					if(conn != null){
						conn.close();
						}
					return sqlreturn;

			//------------------------------------------------------------------------------------------------------------------------------------

				}catch(SQLException se){
				 //Handle errors for JDBC
				 se.printStackTrace();
				}catch(Exception e){
				 //Handle errors for Class.forName
				 e.printStackTrace();
				}finally{
					}

		}

		
		//Just used for testing
		public static void main(String[] args) throws ClassNotFoundException, SQLException
		{
			connect();	
			conn.createStatement("SELECT * FROM trips;")
		}
			
}	//end
