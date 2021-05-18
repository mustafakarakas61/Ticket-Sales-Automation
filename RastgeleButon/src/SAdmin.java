import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DbHelper;

public class SAdmin {

	private int filmID;
	private String filmName;
	private String filmType;
	private String filmDirector;
	private String filmDate;
	private String filmSalon;
	private String filmSeans;

	private int tiyatroID;
	private String tiyatroName;
	private String tiyatroType;
	private String tiyatroDate;
	private String tiyatroSalon;
	private String tiyatroSaat;

	private int concertID;
	private String concertName;
	private String concertPlace;
	private String concertArtist;
	private String concertDate;
	private String concertTime;

	Connection connection = null;
	DbHelper dbHelper = new DbHelper();
	Statement statement;
	PreparedStatement pStatement;

	public SAdmin() {

	}

	public SAdmin(int filmID, String filmName, String filmType, String filmDirector, String filmDate, String filmSalon,
			String filmSeans) {
		this.filmID = filmID;
		this.filmName = filmName;
		this.filmType = filmType;
		this.filmDirector = filmDirector;
		this.filmDate = filmDate;
		this.filmSalon = filmSalon;
		this.filmSeans = filmSeans;
	}

	public SAdmin(int tiyatroID, String tiyatroName, String tiyatroType, String tiyatroDate, String tiyatroSalon,
			String tiyatroSaat) {
		this.tiyatroID = tiyatroID;
		this.tiyatroName = tiyatroName;
		this.tiyatroType = tiyatroType;
		this.tiyatroDate = tiyatroDate;
		this.tiyatroSalon = tiyatroSalon;
		this.tiyatroSaat = tiyatroSaat;
	}

	 public SAdmin( String concertName,int concertID, String concertPlace,String concertArtist, String concertDate, String concertTime) {
	
		this.concertName = concertName;
		this.concertID = concertID;
		this.concertPlace = concertPlace;
		this.concertArtist=concertArtist;
		this.concertDate = concertDate;
		this.concertTime = concertTime;
	}

	public ArrayList<SAdmin> cinemaList() throws SQLException {
		ArrayList<SAdmin> filmList = new ArrayList<>();
		try {
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM booking.cinema");
			SAdmin sinema;
			while (result.next()) {
				sinema = new SAdmin(result.getInt("filmID"), result.getString("filmName"), result.getString("filmType"),
						result.getString("filmDirector"), result.getString("filmDate"), result.getString("filmSalon"),
						result.getString("filmSeans"));
				filmList.add(sinema);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return filmList;
	}

	public ArrayList<SAdmin> theaterList() throws SQLException {
		ArrayList<SAdmin> oyunList = new ArrayList<>();
		try {
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM booking.tiyatro");
			SAdmin tiyatro;
			while (result.next()) {
				tiyatro = new SAdmin(result.getInt("tiyatroID"), result.getString("tiyatroName"),
						result.getString("tiyatroType"), result.getString("tiyatroDate"),
						result.getString("tiyatroSalon"), result.getString("tiyatroSaat"));
				oyunList.add(tiyatro);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return oyunList;
	}

	public ArrayList<SAdmin> concertList() throws SQLException {
		ArrayList<SAdmin> konserList = new ArrayList<>();
		try {
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM booking.concert");
			SAdmin konser;
			while (result.next()) {
				konser = new SAdmin(result.getString("concertName"),result.getInt("concertID"), 	
						result.getString("concertPlace"), result.getString("concertArtist"),
						result.getString("concertDate"), result.getString("concertTime"));
				konserList.add(konser);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return konserList;
	}

	public boolean delCinema(int filmID) throws SQLException {
		boolean key;
		String query = "DELETE FROM booking.cinema WHERE filmID = ?";
		pStatement = connection.prepareStatement(query);
		pStatement.setInt(1, filmID);
		pStatement.executeUpdate();
		key = true;

		if (key) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delTheater(int tiyatroID) throws SQLException {
		boolean key;
		String query = "DELETE FROM booking.tiyatro WHERE tiyatroID = ?";
		pStatement = connection.prepareStatement(query);
		pStatement.setInt(1, tiyatroID);
		pStatement.executeUpdate();
		key = true;

		if (key) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delConcert(int concertID) throws SQLException {
		boolean key;
		String query = "DELETE FROM booking.concert WHERE concertID = ?";
		pStatement = connection.prepareStatement(query);
		pStatement.setInt(1, concertID);
		pStatement.executeUpdate();
		key = true;

		if (key) {
			return true;
		} else {
			return false;
		}
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

	public int getTiyatroID() {
		return tiyatroID;
	}

	public void setTiyatroID(int tiyatroID) {
		this.tiyatroID = tiyatroID;
	}

	public String getTiyatroName() {
		return tiyatroName;
	}

	public void setTiyatroName(String tiyatroName) {
		this.tiyatroName = tiyatroName;
	}

	public String getTiyatroType() {
		return tiyatroType;
	}

	public void setTiyatroType(String tiyatroType) {
		this.tiyatroType = tiyatroType;
	}

	public String getTiyatroDate() {
		return tiyatroDate;
	}

	public void setTiyatroDate(String tiyatroDate) {
		this.tiyatroDate = tiyatroDate;
	}

	public String getTiyatroSalon() {
		return tiyatroSalon;
	}

	public void setTiyatroSalon(String tiyatroSalon) {
		this.tiyatroSalon = tiyatroSalon;
	}

	public String getTiyatroSaat() {
		return tiyatroSaat;
	}

	public void setTiyatroSaat(String tiyatroSaat) {
		this.tiyatroSaat = tiyatroSaat;
	}

	public int getConcertID() {
		return concertID;
	}

	public void setConcertID(int concertID) {
		this.concertID = concertID;
	}

	public String getConcertName() {
		return concertName;
	}

	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}

	public String getConcertPlace() {
		return concertPlace;
	}

	public void setConcertPlace(String concertPlace) {
		this.concertPlace = concertPlace;
	}
	
	public String getConcertArtist() {
		return concertArtist;
	}

	public void setConcertArtist(String concertArtist) {
		this.concertArtist = concertArtist;
	}

	public String getConcertDate() {
		return concertDate;
	}

	public void setConcertDate(String concertDate) {
		this.concertDate = concertDate;
	}

	public String getConcertTime() {
		return concertTime;
	}

	public void setConcertTime(String concertTime) {
		this.concertTime = concertTime;
	}

}
