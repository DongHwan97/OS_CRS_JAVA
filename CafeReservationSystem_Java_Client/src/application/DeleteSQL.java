package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQL {
	
	Connection con = null;
	Statement state = null;
	String url = "jdbc:mysql://localhost:3365/USER?serverTimezone=Asia/Seoul&useSSL=false";
	String user = "root";
	String password = "1234";
	
	public DeleteSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			return;
		}
	}
	/*
	public String(String string) {
		String splitString = string.split(":")[1];
		String id = splitString.split("/")[0];
		
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			state.executeUpdate("DELETE FROM ")
		}
	}
	*/
}
