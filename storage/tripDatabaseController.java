package storage;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tripDatabaseController {
	
	// JDBC driver
	static final String JDBC_DRIVER = "org.sqlite.JDBC";
	static final String DB_URL = "jdbc:sqlite:C:\\Users\\ÓlafurKonráð\\workspace\\Daytrip\\src\\storage\\Dagsferdir.sqlite";

	// Database credentials

	public static void main(String[] args) {
	Connection conn = null;
	Statement stmt = null;
	try{
	 //STEP 2: Register JDBC driver
	 Class.forName(JDBC_DRIVER);
	 //STEP 3: Open a connection
	 System.out.println("Connecting to database...");
	 conn = DriverManager.getConnection(DB_URL);
	 //STEP 4: Execute a query
	 System.out.println("Creating statement...");
	 stmt = conn.createStatement();
	 String sql;
	 sql = "SELECT * FROM  ";
	String sqlRelaxingTrips = sql + "RelaxingTrips ";
	String sqlAdventureTrip = sql + "AdventureTrip ";
	
	 
	 ResultSet rs = stmt.executeQuery(sqlAdventureTrip);
	 //STEP 5: Extract data from result set
	 while(rs.next()){
	 //Retrieve by column name
	 int id = rs.getInt("ATripId");
	 String name = rs.getString("ATripName");
	 String location = rs.getString("ATripLocation");
	 //Display values
	 System.out.print("ID: " + id);
	 System.out.print(", Name: " + name);
	 System.out.println(", Local: " + location);
	 }

	 //STEP 6: Execute an Update - Insert
	//  sql = "insert into students values(5,'zaier','address 2')";
	// int number = stmt.executeUpdate(sql);
	// System.out.println(" the change 1: " + number);
	 //STEP 7: Execute an Update - Update
	// sql = "update students set address ='zied address’ where id=3”;
	// number = stmt.executeUpdate(sql);
	// System.out.println(" the change 2: " + number);
	 //STEP 8: Execute an Update - Delete
	// sql = “Delete from students where id=2’ ";
	// number = stmt.executeUpdate(sql);
	// System.out.println(" the change 2: " + number);

	 //STEP 9: Clean-up environment
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
	System.out.println("Goodbye!");
	
	}//end main
	}//end

	

