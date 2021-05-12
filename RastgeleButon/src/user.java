import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class user {
	
	private int  id ; 
	private String Name ,Surname , Pass , TC_No , Email;
	Statement statement = null;
	Connection connection = null;
	ResultSet result = null;
	PreparedStatement pStatement = null;
	
	public user() {}
	
	
	public user(int id, String name, String surname, String pass, String TC_No, String email) {
		super();
		this.id = id;
		Name = name;
		Surname = surname;
		Pass = pass;
		TC_No = TC_No;
		Email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public String getTC_No() {
		return TC_No;
	}
	public void setTC_No(String tC_No) {
		TC_No = tC_No;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
	

}
