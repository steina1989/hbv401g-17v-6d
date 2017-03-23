package storage;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* Things in this code still left to do  
 * + change the values on the getters
 * 		- date, price and others
 * + compile the code
 * + Figure out a proper way to relay the array with the SQL results */



public class tripDatabaseController {

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
	
	
//------------------ INPUT TEST ----------------------------------------------
	String [] orders;  // hardcoding for testing supposid intake of info
	orders = new String [12];
	orders[0] = "NA"; // row number??
	orders[1] = "NA"; // TripId
	orders[2] = "Whale trip";  // TripName
	orders[3] = "NA"; // TripDate_higer than
	orders[4] = "NA"; // TripDate lower than
	orders[5] = "NA"; // TripReviews
	orders[6] = "NA"; // TripLocation
	orders[7] = "NA"; // TripPrice higher than
	orders[8] = "NA"; // TripPrice lower than
	orders[9] = "NA"; // TripDescription
	orders[10] = "NA"; // TripSeats
	orders[11] = "Adventure Trip"; // TripCategory
// ---------------------------------------------------------------------
	
// ------------ CREATING THE SQL COMMAND FROM INPUT -----------------------------------------------------------
	
	String and = "";
	int start = 1;
	String sqlinput="SELECT * FROM Daytrips ";// the string that makes the SQL command
	for(int i=1; i< orders.length;i++ ){
		
	if(orders[i] != "NA"){ // if the compartment is empty then skip this array slot.
		if(start == 1){ // to seperate searching for everything versus specific search
			sqlinput = sqlinput + " WHERE ";
					if(start==1){
						and = "";
					}	
				}
		if(start==2 ){// starting an sql where querey with AND relays only errors, this should prevent that.
			and= " And ";
			start++;
		      } 		if(i<6){ 
		    	  
		    	  				if(i<3){
									if(i==0){}
				    	  			if(i==1){// TripId
										sqlinput = sqlinput + and + " ( TripId = " + orders[i] + " )";
									}if(i==2){// TripName
										sqlinput = sqlinput + and + " ( TripName = " + orders[i] + " )"; }
								}else{	
									
									}if(i==3){// TripDate_higer or same as
										sqlinput = sqlinput + and + " ( TripDate >= " + orders[i] + " )";
									}if(i==4){// TripDate lower or same as
										sqlinput = sqlinput + and + " ( TripDate <= " + orders[i] + " )";
									}if(i==5){// TripReviews
										sqlinput = sqlinput + and + " ( TripReviews = " + orders[i] + " )"; }
		    	  				
		            	}else{	
		            			if(i<9){
									if(i==6){// TripLocation
										sqlinput = sqlinput + and + " ( TripLocation = " + orders[i] + " )";
									}if(i==7){// TripPrice higher than
										sqlinput = sqlinput + and + " ( TripPrice >= " + orders[i] + " )";
									}if(i==8){// TripPrice lower than
										sqlinput = sqlinput + and + " ( TripPrice <= " + orders[i] + " )";}
		            			}else{
									
									if(i==9){// TripDescription
										sqlinput = sqlinput + and + " ( TripDescription = " + orders[i] + " )";
									}if(i==10){// TripSeats
										sqlinput = sqlinput + and + " ( TripSeats = " + orders[i] + " )";
									}if(i==11){// TripCategory
										sqlinput = sqlinput + and + " ( TripCategory = " + orders[i] + " )";}
		            				}
		            		}
				
	 }
	System.out.println(sqlinput);
	}
 //-------------------------------------------------------------------------------------------------------------
	
	start = 1;	
     ResultSet rs = stmt.executeQuery(sqlinput);// Send in compleated sql query.
    
 //------------------------------- COLLECT THE RESAULTS FROM SQL COMMAND -----------------------------------------    
     String [][] sqlreturn;
     int numberOfLines = 1;
	 //STEP 5: Extract data from result set
	 while(rs.next()){
	 //Retrieve by column name
	 int id = rs.getInt("TripId");
	 String id2 = Integer.toString(id);
	 String name = rs.getString("TripName");
	 String Date = rs.getString("TripDate");
	 String Reviews = rs.getString("TripReviews");
	 String Location = rs.getString("TripLocation");
	 String Price = rs.getString("TripPrice");
	 String Description = rs.getString("TripDescription");
	 String Seats = rs.getString("TripCategory");
// --------------------------------------------------------------------------------------------------------------
	 
//------------------------INSERT SQL RESULT INTO VARIABLE TO BE SENT FORWARD ------------------------------------	 
	 // Insert the newly gotten line into the array that will be returned to other classes
	 sqlreturn = new String [numberOfLines][8];
	 for(int i =0;i<=8;i++){
		
		 if(i==1)
		 sqlreturn [numberOfLines][i] = id2 ;
		 if(i==2)
		 sqlreturn [numberOfLines][i] = name ;
		 if(i==3)
		 sqlreturn [numberOfLines][i] = Date ;
		 if(i==4)
		 sqlreturn [numberOfLines][i] = Reviews ;
		 if(i==5)
		 sqlreturn [numberOfLines][i] = Location ;
		 if(i==6)
		 sqlreturn [numberOfLines][i] = Price ;
		 if(i==7)
		 sqlreturn [numberOfLines][i] = Description ;
		 if(i==8)
		 sqlreturn [numberOfLines][i] = Seats ;
		 
	 }
	 numberOfLines++;
	 //Display values
	 System.out.print("ID: " + id);
	 System.out.print(", Name: " + name);
	 System.out.print(", Date: " + Date);
	 System.out.print(", Reviews: " + Reviews );
	 System.out.print(", Location: " + Location );
	 System.out.print(", Price: " + Price );
	 System.out.print(", Description: " + Description);
	 System.out.println(", Seats: " + Seats );
	
	 }
//------------------------------------------------------------------------------------------------------------------------------------	 
	  //return [][] sqlreturn; // sends the outcome of the SQL query back
     
     if(rs != null){
			rs.close();
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
	}
	}
}	//end