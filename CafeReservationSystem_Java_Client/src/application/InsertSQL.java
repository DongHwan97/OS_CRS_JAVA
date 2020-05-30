package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSQL {

	Connection con = null;
	Statement state = null;
	String url = "jdbc:mysql://localhost:3365/USER?serverTimezone=Asia/Seoul&useSSL=false";
	String user = "root";
	String password = "1234";
	
	public InsertSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			return;
		}
	}
	
	//사용자 DB에 회원가입 하는 사용자 정보 저장
	public String signUp(String string) {
		String splitString = string.split(":")[1];
		String name = splitString.split("/")[0];
		String id = splitString.split("/")[1];
		String pw = splitString.split("/")[2];
		String tel = splitString.split("/")[3];
		String jumin = splitString.split("/")[4];
		
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			state.executeUpdate("INSERT INTO user_info VALUES ('" + name + "','"
					+ id + "','" + pw + "','" + tel + "','" + jumin + "')");
			state.close();
			con.close();
			return "OK";
		} catch(SQLException e) {
			return "SELECT 오류 : " + e.getMessage();
		}
	}
	
	// login DB에 유저 ID 저장
	public String login(String string) {
		String splitString = string.split(":")[1];
		String id = splitString.split("/")[0];
		
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			state.executeUpdate("INSERT INTO login_user VALUES ('" + id + "')");
			state.close();
			con.close();
			return "OK";
		} catch(SQLException e) {
			return "SELECT 오류 : " + e.getMessage();
		}
	}
}
