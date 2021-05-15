import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DbHelper;

public class SubATheater {

	private int tiyatroID;
	private String tiyatroName;
	private String tiyatroType;
	private String tiyatroDate;
	private String tiyatroSalon;
	private String tiyatroSaat;

	Connection connection = null;
	DbHelper dbHelper = new DbHelper();
	Statement statement;

	public SubATheater() {

	}

	public SubATheater(int tiyatroID, String tiyatroName, String tiyatroType, String tiyatroDate, String tiyatroSalon,
			String tiyatroSaat) {
		this.tiyatroID = tiyatroID;
		this.tiyatroName = tiyatroName;
		this.tiyatroType = tiyatroType;
		this.tiyatroDate = tiyatroDate;
		this.tiyatroSalon = tiyatroSalon;
		this.tiyatroSaat = tiyatroSaat;
	}

	public ArrayList<SubATheater> theaterList() throws SQLException {
		ArrayList<SubATheater> oyunList = new ArrayList<>();
		try {
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM booking.tiyatro");
			SubATheater tiyatro;
			while (result.next()) {
				tiyatro = new SubATheater(result.getInt("tiyatroID"), result.getString("tiyatroName"),
						result.getString("tiyatroType"), result.getString("tiyatroDate"),
						result.getString("tiyatroSalon"), result.getString("tiyatroSaat"));
				oyunList.add(tiyatro);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return oyunList;
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

}
