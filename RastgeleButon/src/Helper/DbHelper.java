package Helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	
	
	String usr = "root"  , pass = "yakup0101",dbUrl="jdbc:mysql://localhost:3306/booking";
	//DbHelper dbHelper = new DbHelper();									
	
	public Connection getConnection() throws SQLException{
		
		
		return DriverManager.getConnection(dbUrl, usr, pass);
	
	}
	
	
	public void showErrorMessage(SQLException e) 
	{
		System.out.println(" Hata : " +e);
		System.out.println("Hata Kodu  : "+ e.getErrorCode());
		
	}
	

}
