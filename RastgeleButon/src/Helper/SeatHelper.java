package Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

public class SeatHelper extends JButton {
	private int row,col,count;
	private boolean SeatOn,SeatOff,SeatSelect;
	DbHelper dbhelper = new DbHelper();
	Connection connection = null;
	PreparedStatement pStatement;
	Statement statement ;  
	ResultSet result ;
	
	public SeatHelper() {}
	
	public SeatHelper(int row, int col)
	{
		this.row = row;
		this.col = col;
		this.count = count;
		this.SeatOn = false;
		this.SeatOff = false;
		this.SeatSelect = false;
	}
	
	public boolean seatAdd(String seatName ,String stype ) {

        int key = 0;

        boolean duplicate = false;
		try {
			connection = dbhelper.getConnection();

			statement = connection.createStatement();
	        result = statement.executeQuery("Select * from seat where type ='d' and name = ' " + seatName + " ' ");


	            while (result.next()) {
	                duplicate = true;
	                Metod_Helper.showMsg("Kullanýcý zaten mevcut ");

	                break;

	            }
			
	            
			if (!duplicate) {
				pStatement=connection.prepareStatement("insert  into seat (type ,name) values (?,?) ");
				pStatement.setString(1, stype); 
				pStatement.setString(2, seatName);
				pStatement.executeUpdate();
				key=1;
			}
			
		} catch (SQLException e) {
			dbhelper.showErrorMessage(e);
		}
		
		   if (key == 1) {
	            return true;
	        } else
	            return false;
	}
	
	
	
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isSeatOn() {
		return SeatOn;
	}
	public void setSeatOn(boolean seatOn) {
		SeatOn = seatOn;
	}
	public boolean isSeatOff() {
		return SeatOff;
	}
	public void setSeatOff(boolean seatOff) {
		SeatOff = seatOff;
	}
	public boolean isSeatSelect() {
		return SeatSelect;
	}
	public void setSeatSelect(boolean seatSelect) {
		SeatSelect = seatSelect;
	}
}
