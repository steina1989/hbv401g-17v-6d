import java.sql.*;
import javax.swing.*;

public class SqlConnection {
	Connection conn=null;
	public static Connection dbConnector(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Ólafur\\Skóli\\Tölvunarfræði\\Annað ár\\Vor\\Þróun Hugnúnaðar\\Gagnagrunnur\\Dagsferdir.sqlite");
			JOptionPane.showMessageDialog(null,"connection succsessfull");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}

// þetta er database connector sem ég var buinn að taka samann við database sem ég er með á tölvunni minni.
// ef þið viljið tengja þetta við ykkar eiginn gagnagrunn þá bara breyta slóðinni.
