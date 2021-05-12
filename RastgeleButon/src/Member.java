import java.sql.SQLException;

import Helper.DbHelper;
import Helper.Metod_Helper;

public class Member extends user{

	DbHelper dbhelper = new DbHelper();

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int id, String name, String surname, String pass, String TC_No, String email ,String type) {

	}

	
	
	public boolean register(String tcno, String pass, String name) {

		int key = 0;

		boolean duplicate = false;
		String query = "insert into register (TC_No,Pass,Name) values (?,?,?)";

		try {
			connection = dbhelper.getConnection();

			statement = connection.createStatement();
			result = statement.executeQuery("Select * from register where TC_No = ' " + tcno + " ' ");


			while (result.next()) {
				duplicate = true;
				Metod_Helper.showMsg("Hasta zaten mevcut (TC)");

				break;

			}
			if (!duplicate) {

				pStatement = connection.prepareStatement(query);
				pStatement.setString(1, tcno);
				pStatement.setString(2, pass);
				pStatement.setString(3, name);
				pStatement.executeUpdate();
				key = 1;
			}

		} catch (SQLException e) {
			dbhelper.showErrorMessage(e);
		}

		if (key == 1) {
			return true;
		} else
			return false;
	}
	
	
	//------------------------------Ayarlanacak----------------------------------
	public boolean buyTicket(int doctor_id, String doctor_name, int hasta_id, String hasta_name,
			String app_date) {

		int key = 0;

		String query = "insert into ticket (doctor_id,doctor_name,hasta_id,hasta_name,app_date) values (?,?,?,?,?)";

		try {
			connection = dbhelper.getConnection();


			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, doctor_id);
			pStatement.setString(2, doctor_name);
			pStatement.setInt(3, hasta_id);
			pStatement.setString(4, hasta_name);
			pStatement.setString(5, app_date);

			pStatement.executeUpdate();
			key = 1;

		} catch (SQLException e) {
			dbhelper.showErrorMessage(e);
		}

		if (key == 1) {
			return true;
		} else
			return false;
	}
	
	public boolean updateTicket(int ticket_id, String wdate ) {

		int key = 0;

		String query = "UPDATE whour SET status = ? where doctor_id = ? and wdate=?";

		try {
			connection = dbhelper.getConnection();


			pStatement = connection.prepareStatement(query);
			pStatement.setString(1,"p");
			pStatement.setInt(2, ticket_id);
			pStatement.setString(3, wdate);
			
			pStatement.executeUpdate();
			key = 1;

		} catch (SQLException e) {
			dbhelper.showErrorMessage(e);
		}

		if (key == 1) {
			return true;
		} else
			return false;
	}

	
}
