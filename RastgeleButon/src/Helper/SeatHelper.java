package Helper;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SeatHelper extends JButton {
	private int row,col;
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
		this.SeatOn = false;
		this.SeatOff = false;
		this.SeatSelect = false;
	}
	
	public boolean seatAdd(String seatName ,String stype, int filmID, int userID) {

        int key = 0;

        boolean duplicate = false;
		try {
			connection = dbhelper.getConnection();

			statement = connection.createStatement();
	        result = statement.executeQuery("Select * from seat where type ='d' and name = '" + seatName + "' and filmID = '"+filmID+"'");


	            while (result.next()) {
	                duplicate = true;
	                Metod_Helper.showMsg("Bu Koltuk Dolu!");
	                
	                break;

	            }
			
	            
			if (!duplicate) {
				pStatement=connection.prepareStatement("insert  into seat (type ,name, filmID,userID) values (?,?,?,?) ");
				pStatement.setString(1, stype); 
				pStatement.setString(2, seatName);
				pStatement.setInt(3, filmID);
				pStatement.setInt(4, userID);
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
	
	public boolean seatGet(String seatName ,String stype, int filmID) {

        int key = 0;

        boolean duplicate = false;
		try {
			connection = dbhelper.getConnection();

			statement = connection.createStatement();
	        result = statement.executeQuery("Select * from seat where type ='d' and name = '" + seatName + "' and filmID = '"+filmID+"'");


	            while (result.next()) {
	                duplicate = true;
	              //DOLU KOLTUGU BULDU
	                
	                break;

	            }
			
	            
			if (duplicate) {
				
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
	
	
	/*public boolean seatGet(String seatName, String stype, int filmID) {
	
		int k =0;
		try {
			connection = dbhelper.getConnection();

			statement = connection.createStatement();
			   result = statement.executeQuery("Select * from seat where type ='d' and name = '" + seatName + "' and filmID = '"+filmID+"'");


	            while (result.next()) {
	               
	                Metod_Helper.showMsg("Bu Koltuk Dolu!");
	                ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/SeatOff.png"));
					
					//s.setIcon(imageIcon);
	                break;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return key;
	}*/
	
	
	
	public boolean seatAddTheater(String seatName ,String stype, int theaterID ,int userID) {

        int key = 0;

        boolean duplicate = false;
		try {
			connection = dbhelper.getConnection();

			statement = connection.createStatement();
	        result = statement.executeQuery("Select * from seattheater where type ='d' and name = '" + seatName + "' and theaterID = '"+theaterID+"'");


	            while (result.next()) {
	                duplicate = true;
	                Metod_Helper.showMsg("Bu Koltuk Dolu!");
	                
	                break;

	            }
			
	            
			if (!duplicate) {
				pStatement=connection.prepareStatement("insert  into seattheater (type ,name, theaterID,userID) values (?,?,?,?) ");
				pStatement.setString(1, stype); 
				pStatement.setString(2, seatName);
				pStatement.setInt(3, theaterID);
				pStatement.setInt(4, userID);
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
	
	public boolean seatGetTheater(String seatName ,String stype, int theaterID ) {

        int key = 0;

        boolean duplicate = false;
		try {
			connection = dbhelper.getConnection();

			statement = connection.createStatement();
	        result = statement.executeQuery("Select * from seattheater where type ='d' and name = '" + seatName + "' and theaterID = '"+theaterID+"'");


	            while (result.next()) {
	                duplicate = true;
	              //DOLU KOLTUGU BULDU
	                
	                break;

	            }
			
	            
			if (duplicate) {
				
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
