package storage;

import java.sql.*;
import javax.swing.*;

public class SqlConnection {
	Connection conn=null;
	public static Connection dbConnector(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Ólafur\\Skóli\\Tölvunarfræði\\Annað ár\\Vor\\Þróun Hugnúnaðar\\Gagnagrunnur\\Dagsferdir.sqlite");
			JOptionPane.showMessageDialog(null,"connection succsessfull"); // message that the connection was succsesfull
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}
// This is a raw database connection and it refers to a database that is in my computer. 
// If you want to try it out for yourself with your own database then just change the path and segrigate as is done here above 


