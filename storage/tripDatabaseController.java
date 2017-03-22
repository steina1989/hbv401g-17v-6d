package storage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TripDatabaseController {

public static getTripsByParameter{
	get.DatabaseControlller.conn

	try{// main function
		
		// what you open first you must close last
		conne = DriverManager.getConnection(conn); // OPENS the connection
		stmt = stmt.con.createStatement(ResultSet.TIPE_SCROLLINSENSITIVE, ResultSet.CONCUR_READ_ONLY); // CREATES A STATEMENT
		rs = stmt.executeQuery("SELECT * FROM RelaxingTrips"); // Result set

	}catch(Exception e){// error report
		JOptionPane.showMessageDialog(null,e);
		
	}finally{// closing the connections
		
		if(rs != null){
			rs.close();
		}
		if(stmt != null){
			stmt.close();
		}
		if(conne != null){
			conne.close();
		}
	}
	
	
}
	
	
	
}

/*
Innihald tripDatabaseController 

+ TripDatabaseController() : void
+ getTripsByParameter(lowprice. int, highprice: int, lowDate: Date, 
       highDate: Date category: String....) : ResultSet
+ addReview(review : Review) : void

*/