import java.sql.*;
import javax.swing.*;

public class SqlConnection {
	Connection conn=null;
	public static Connection dbConnector(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\�lafur\\Sk�li\\T�lvunarfr��i\\Anna� �r\\Vor\\�r�un Hugn�na�ar\\Gagnagrunnur\\Dagsferdir.sqlite");
			JOptionPane.showMessageDialog(null,"connection succsessfull");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}

// �etta er database connector sem �g var buinn a� taka samann vi� database sem �g er me� � t�lvunni minni.
// ef �i� vilji� tengja �etta vi� ykkar eiginn gagnagrunn �� bara breyta sl��inni.
