import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DbHelper;

public class SubAConcert {

	private int concertID;
	private String concertName;
	private String concertType;
	private String concertDate;
	private String concertTime;

	Connection connection = null;
	DbHelper dbHelper = new DbHelper();
	Statement statement;
	
	public SubAConcert() {
		
	}

	public SubAConcert(int concertID, String concertName, String concertType, String concertDate, String concertTime) {
		this.concertID = concertID;
		this.concertName = concertName;
		this.concertType = concertType;
		this.concertDate = concertDate;
		this.concertTime = concertTime;
	}

	public ArrayList<SubAConcert> concertList() throws SQLException {
		ArrayList<SubAConcert> konserList = new ArrayList<>();
		try {
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM booking.concert");
			SubAConcert konser;
			while (result.next()) {
				konser = new SubAConcert(result.getInt("concertID"), result.getString("concertName"),
						result.getString("concertType"), result.getString("concertDate"),
						result.getString("concertTime"));
				konserList.add(konser);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return konserList;
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

	public String getConcertType() {
		return concertType;
	}

	public void setConcertType(String concertType) {
		this.concertType = concertType;
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
