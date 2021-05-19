package Packed;
import java.sql.SQLException;
import java.util.ArrayList;

import Helper.DbHelper;
import Helper.Metod_Helper;

public class Member extends user {

	private int ID;
	private String TC_No;
	private String Name;
	private String Surname;

	DbHelper dbhelper = new DbHelper();

	public Member() {
		super();
	}

	public Member(int ID, String TC_No, String name, String surname) {
		this.ID = ID;
		this.TC_No = TC_No;
		this.Name = name;
		this.Surname = surname;
	}

	public boolean register(String tcno, String pass, String name ,String email, String surname) {

        int key = 0;

        boolean duplicate = false;
        String query = "insert into register (TC_No,Pass,Name,Email,Surname) values (?,?,?,?,?)";

        try {
            connection = dbhelper.getConnection();

            statement = connection.createStatement();
            result = statement.executeQuery("Select * from register where TC_No = ' " + tcno + " ' ");


            while (result.next()) {
                duplicate = true;
                Metod_Helper.showMsg("Kullanýcý zaten mevcut");

                break;

            }
            if (!duplicate) {

                pStatement = connection.prepareStatement(query);
                pStatement.setString(1, tcno);
                pStatement.setString(2, pass);
                pStatement.setString(3, name);
                pStatement.setString(4, email);
                pStatement.setString(5, surname);
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

	public ArrayList<Member> memberList() throws SQLException {
		ArrayList<Member> uyeList = new ArrayList<Member>();
		try {
			connection = dbhelper.getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM booking.register");
			Member member;
			while (result.next()) {
				member = new Member(result.getInt("ID"), result.getString("TC_No"), result.getString("Name"),
						result.getString("Surname"));
				uyeList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uyeList;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTC_No() {
		return TC_No;
	}

	public void setID(String TC_No) {
		this.TC_No = TC_No;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		this.Surname = surname;
	}

}