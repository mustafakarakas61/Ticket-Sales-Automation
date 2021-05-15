import java.sql.Connection;
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
	private String filmSalon;
	private String filmSeance;

	Connection connection = null;
	DbHelper dbHelper = new DbHelper();
	Statement statement;

	public SubACinema() {

	}

	public SubACinema(int filmID, String filmName, String filmType, String filmDirector, String filmSalon,
			String filmSeance) {
		this.filmID = filmID;
		this.filmName = filmName;
		this.filmType = filmType;
		this.filmDirector = filmDirector;
		this.filmSalon = filmSalon;
		this.filmSeance = filmSeance;
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
						result.getString("filmType"), result.getString("filmDirector"), result.getString("filmSalon"),
						result.getString("filmSeance"));
				filmList.add(sinema);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return filmList;
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

	public String getFilmSalon() {
		return filmSalon;
	}

	public void setFilmSalon(String filmSalon) {
		this.filmSalon = filmSalon;
	}

	public String getFilmSeans() {
		return filmSeance;
	}

	public void setFilmSeans(String filmSeance) {
		this.filmSeance = filmSeance;
	}

}
