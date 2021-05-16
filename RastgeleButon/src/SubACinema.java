import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DbHelper;

public class SubACinema {

	private int filmID;
	private String filmName;
	private String filmType;
	private String filmDirector;
	private String filmDate;
	private String filmSalon;
	private String filmSeans;

	Connection connection = null;
	DbHelper dbHelper = new DbHelper();
	PreparedStatement pStatement;
	Statement statement;

	public SubACinema() {

	}

	public SubACinema(int filmID, String filmName, String filmType, String filmDirector, String filmDate,
			String filmSalon, String filmSeans) {
		this.filmID = filmID;
		this.filmName = filmName;
		this.filmType = filmType;
		this.filmDirector = filmDirector;
		this.filmDate = filmDate;
		this.filmSalon = filmSalon;
		this.filmSeans = filmSeans;
	}

	public ArrayList<SubACinema> cinemaList() throws SQLException {
		ArrayList<SubACinema> filmList = new ArrayList<>();
		try {
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM booking.cinema");
			SubACinema sinema;
			while (result.next()) {
				sinema = new SubACinema(result.getInt("filmID"), result.getString("filmName"),
						result.getString("filmType"), result.getString("filmDirector"), result.getString("filmDate"),
						result.getString("filmSalon"), result.getString("filmSeans"));
				filmList.add(sinema);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return filmList;
	}
	
	
	public boolean insertPic(FileInputStream fs ) {
		int c =0;
		
		try {
			connection  =dbHelper.getConnection();
			pStatement =connection.prepareStatement("instert into cinema(pic) values(?)");
			pStatement.setBinaryStream(1, fs, fs.available());
			pStatement.executeUpdate();
			c++;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (c==1) {
			
			return true;
			
		}else
		return false;
		
	} 

	public int getFilmID() {
		return filmID;
	}

	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmType() {
		return filmType;
	}

	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}

	public String getFilmDirector() {
		return filmDirector;
	}

	public void setFilmDirector(String filmDirector) {
		this.filmDirector = filmDirector;
	}

	public String getFilmDate() {
		return filmDate;
	}

	public void setFilmDate(String filmDate) {
		this.filmDate = filmDate;
	}

	public String getFilmSalon() {
		return filmSalon;
	}

	public void setFilmSalon(String filmSalon) {
		this.filmSalon = filmSalon;
	}

	public String getFilmSeans() {
		return filmSeans;
	}

	public void setFilmSeans(String filmSeans) {
		this.filmSeans = filmSeans;
	}

}

//------------------------------------------------------------------------------------------------
//try {
//	FileInputStream fis= new FileInputStream("gora.jpg");
//	
//	boolean control =sinema.insertPic(fis);
//	if (control) {
//		System.out.println("islem basarýlý");
//	}else
//		System.out.println("bir yanlýþlýk oldu");
//
//} catch (FileNotFoundException e1) {
//	e1.printStackTrace();
//}

//-------------------------------------------------------------------------------------------------