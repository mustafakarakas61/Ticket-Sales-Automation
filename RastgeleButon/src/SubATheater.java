import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DbHelper;

public class SubATheater {

	private int TheaterID;
	private String TheaterName;
	private String TheaterType;
	private String TheaterDate;
	private String TheaterSalon;
	private String TheaterHour;

	Connection connection = null;
	DbHelper dbHelper = new DbHelper();
	Statement statement;

	public SubATheater() {

	}

	public SubATheater(int TheaterID, String TheaterName, String TheaterType, String TheaterDate, String TheaterSalon,
			String TheaterHour) {
		this.TheaterID = TheaterID;
		this.TheaterName = TheaterName;
		this.TheaterType = TheaterType;
		this.TheaterDate = TheaterDate;
		this.TheaterSalon = TheaterSalon;
		this.TheaterHour = TheaterHour;
	}

	public ArrayList<SubATheater> theaterList() throws SQLException {
		ArrayList<SubATheater> oyunList = new ArrayList<>();
		try {
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM booking.tiyatro");
			SubATheater tiyatro;
			while (result.next()) {
				tiyatro = new SubATheater(result.getInt("TheaterID"), result.getString("TheaterName"),
						result.getString("TheaterType"), result.getString("TheaterDate"),
						result.getString("TheaterSalon"), result.getString("TheaterHour"));
				oyunList.add(tiyatro);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return oyunList;
	}

	public int getTheaterID() {
		return TheaterID;
	}

	public void setTheaterID(int TheaterID) {
		this.TheaterID = TheaterID;
	}

	public String getTheaterName() {
		return TheaterName;
	}

	public void setTheaterName(String TheaterName) {
		this.TheaterName = TheaterName;
	}

	public String getTheaterType() {
		return TheaterType;
	}

	public void setTheaterType(String TheaterType) {
		this.TheaterType = TheaterType;
	}

	public String getTheaterDate() {
		return TheaterDate;
	}

	public void TheaterDate(String TheaterDate) {
		this.TheaterDate = TheaterDate;
	}

	public String getTheaterSalon() {
		return TheaterSalon;
	}

	public void setTheaterSalon(String TheaterSalon) {
		this.TheaterSalon = TheaterSalon;
	}

	public String getTheaterHour() {
		return TheaterHour;
	}

	public void setTheaterHour(String TheaterHour) {
		this.TheaterHour = TheaterHour;
	}

}
//
