package Helper;

import java.awt.Color;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Packed.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class SeatHelper extends JButton {
	
	private int row,col,filmID,userID;
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	private boolean SeatOn,SeatOff,SeatSelect;
	private String SeatName;
	
	
	DbHelper dbhelper = new DbHelper();
	Connection connection = null;
	PreparedStatement pStatement;
	Statement statement ;  
	ResultSet result ;
	
	public SeatHelper() {
		
	}
	
	public SeatHelper(int row, int col)
	{
		this.row = row;
		this.col = col;
		this.SeatOn = false;
		this.SeatOff = false;
		this.SeatSelect = false;
	}
	
	
	public SeatHelper (int filmID, String SeatName,int userID) {
		
		this.filmID = filmID;
		this.SeatName = SeatName;
		this.userID=userID;
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
	
	public String getFilm(int id ) {
		
		String  name =null;
		
        try {

    		connection = dbhelper.getConnection();

    		statement = connection.createStatement();
			result = statement.executeQuery("Select * from cinema where filmID= "+id);
			
			while (result.next()) {
			
				name = result.getString("filmName");
			
			}
			
		} catch (SQLException e) {
			dbhelper.showErrorMessage(e);
		}

    	return name;
		
	} 
	
	
	
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
	
	
	
	
	
	
	public boolean delMemberSeat(int ID, String userSelectSeatName) throws SQLException {
		boolean key;
		String query = "DELETE FROM booking.seat WHERE userID = ? and name ?";
		statement = connection.createStatement();
		pStatement = connection.prepareStatement(query);
		pStatement.setInt(1, ID);
		pStatement.setString(2, userSelectSeatName);
		pStatement.executeUpdate();
		key = true;

		if (key) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<SeatHelper> userSeatfilmTickets() throws SQLException {
		ArrayList<SeatHelper> userSeatfilmList = new ArrayList<>();
		try {
		
			connection = dbhelper.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM seat WHERE userID="+MainScreen.memberID);
			SeatHelper sinemaTickets;
			while (result.next()) {
				sinemaTickets = new SeatHelper(result.getInt("filmID"),result.getString("name"),result.getInt("userID"));
				userSeatfilmList.add(sinemaTickets);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return userSeatfilmList;
	}
	
	
	
	
	
	
	
	
	
	
	
	public int getFilmID() {
		return filmID;
	}

	public void setFilmID(int filmID) {
		this.filmID = filmID;
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
	public String getSeatName() {
		return SeatName;
	}

	public void setSeatName(String seatName) {
		SeatName = seatName;
	}
}
