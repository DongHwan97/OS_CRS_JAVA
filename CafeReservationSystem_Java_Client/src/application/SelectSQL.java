package application;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//DBMS에 SELECT문 입력
public class SelectSQL {

	Connection con = null;
	Statement state = null;
	String url = "jdbc:mysql://127.0.0.1/hong?serverTimezone=Asia/Seoul&useSSL=false";
	String user = "root";
	String password = "1234";

	public SelectSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			return;
		}
	}

	// 중복확인
	// DB user 테이블에 SELECT문 작성
	public String overlap(String string) {
		String id = string.split(":")[1];
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM user_info WHERE user_ID = '" + id + "'");

			if (!result.next()) {
				con.close();
				state.close();
				return "OK";
			}
			state.close();
			con.close();
		} catch (SQLException e) {
			return "SELECT 오류 : " + e.getMessage();
		}
		return "NO";
	}

	// 로그인을 위해 해당 유저가 사용자 DB에 존재하는지
	// 그리고 해당 유저가 어딘가에서 로그인 중인지 (login DB에 존재하는지)
	public String login(String string) {
		String splitString = string.split(":")[1];
		String id = splitString.split("/")[0];
		String pw = splitString.split("/")[1];
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			ResultSet result = state.executeQuery(
					"SELECT * FROM user_info WHERE user_ID = '" + id + "' AND " + "user_PW = '" + pw + "'");
			if (result.next()) {
				/*
				 * result = state.executeQuery("SELECT * FROM login_user WHERE user_ID = '" + id
				 * + "'"); if (result.next()) { con.close(); state.close(); return "exist"; }
				 */
				return "exist";
			}
			con.close();
			state.close();
			return "notExist";

		} catch (SQLException e) {
			return "SELECT 오류 : " + e.getMessage();
		}
	}

	// 사용자가 회원가입을 하기 전에 본인확인을 하는 과정
	// 사용자 DB에 이름과 주민번호만으로 SELECT해서 값이 존재하는지 확인
	public String userCheck(String string) {

		String splitString = string.split(":")[1];
		String name = splitString.split("/")[0];
		String jumin = splitString.split("/")[1];
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			ResultSet result = state.executeQuery(
					"SELECT * FROM user_info WHERE user_Name = '" + name + "' AND user_Jumin = '" + jumin + "'");
			if (!result.next()) {
				con.close();
				state.close();
				return "OK";
			}
			state.close();
			con.close();
		} catch (SQLException e) {
			return "SELECT 오류 : " + e.getMessage();
		}
		return "NO";
	}
	// ID 찾기를 위해 사용자의 정보로
	// 사용자 DB에 SELECT
	public String findID(String string) {

		String splitString = string.split(":")[1];
		String name = splitString.split("/")[0];
		String jumin = splitString.split("/")[1];
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println(name);
			System.out.println(jumin);
			state = con.createStatement();
			System.out.println(name);
			// SELECT * FROM user_info WHERE user_Name = '홍정인' AND user_Jumin = '9707231199119'
			//"SELECT * FROM user_info WHERE user_ID = '" + id + "' AND " + "user_PW = '" + pw + "'"
			ResultSet result = state.executeQuery("SELECT * FROM user_info WHERE user_Name = '" + name +
					"' AND + user_Jumin = '" + jumin + "'");
			System.out.println(name);
			if (result.next()) {
				String r = result.getString(2);
				System.out.println(name);
				con.close();
				state.close();
				result.close();
				return r;
			}
			state.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		return "NO";
	}

	// PW 찾기를 위해 사용자의 정보로
	// 사용자 DB에 SELECT
	public String findPW(String string) {
		String splitString = string.split(":")[1];
		String name = splitString.split("/")[0];
		String id = splitString.split("/")[1];
		String jumin = splitString.split("/")[2];

		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM user_info WHERE user_Name = '" + name
					+ "' AND user_jumin = '" + jumin + "' AND user_ID = '" + id + "'");
			if (result.next()) {
				String r = result.getString(3);
				con.close();
				state.close();
				result.close();
				return r;
			}
			state.close();
			con.close();
		} catch (SQLException e) {

		}
		return "NO";
	}
}
