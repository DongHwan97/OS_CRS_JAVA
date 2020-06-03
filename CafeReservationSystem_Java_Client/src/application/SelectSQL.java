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
	String url = "jdbc:mysql://localhost:1111/info?serverTimezone=Asia/Seoul&useSSL=false";
	String user = "root";
	String password = "1111";

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
			// select문 생성 후 DB에 질희한 결과를 ResultSet에 저장
			ResultSet result = state.executeQuery("SELECT * FROM USER WHERE userID = '" + id + "'");

			if (!result.next()) {	// 질의의 결과가 없다면 = 해당 아이디에 관한 정보가 없다면 = 중복되지 않는 아이디라면
				con.close();
				state.close();
				return "OK";		// 확인 메시지 리턴
			}
			else {					// 중복되는 아이디라면
				state.close();
				con.close();
				return "NO";		// 거절 메시지 리턴
			}
		} catch (SQLException e) {
			return "서버가 불안정합니다. 다음에 다시 이용해주세요!!";	// SQL 오류가 나면 서버가 불안정하다는 메시지 리턴
		}
	}
/*
	// 로그인을 위해 해당 유저가 사용자 DB에 존재하는지
	// 그리고 해당 유저가 어딘가에서 로그인 중인지 (login DB에 존재하는지)
	public String login(String string) {
		String splitString = string.split(":")[1];
		String id = splitString.split("/")[0];
		String pw = splitString.split("/")[1];
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			// select문 생성 후 DB에 질희한 결과를 ResultSet에 저장
			ResultSet result = state.executeQuery(
					"SELECT * FROM user_info WHERE user_ID = '" + id + "' AND " + "user_PW = '" + pw + "'");
			if (result.next()) {
				
				 result = state.executeQuery("SELECT * FROM login_user WHERE user_ID = '" + id
				  + "'"); if (result.next()) { con.close(); state.close(); return "exist"; }
				 
				return "exist";
			}
			con.close();
			state.close();
			return "notExist";

		} catch (SQLException e) {
			return "SELECT 오류 : " + e.getMessage();
		}
	}
*/
	// ID 찾기를 위해 사용자의 정보로
	// 사용자 DB에 SELECT
	public String findID(String string) {
		String splitString = string.split(":")[1];
		String name = splitString.split("/")[0];
		String jumin = splitString.split("/")[1];
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			// select문 생성 후 DB에 질희한 결과를 ResultSet에 저장
			ResultSet result = state.executeQuery("SELECT * FROM USER WHERE userName = '" + name +
					"' AND + userBirth = '" + jumin + "'");
			
			if (result.next()) {					// 질의의 결과가 있다면
				String r = result.getString(1);		// String타입 r에 1번째 애트리뷰트 값 대입
				con.close();
				state.close();
				result.close();
				return r;							// r 리턴
			}
			else {									// 질의의 결과가 없다면
				state.close();
				con.close();
				return "NO";						// 거절 메시지 리턴
			}
		} catch (SQLException e) {
			return "서버가 불안정합니다. 다음에 다시 이용해주세요!!";	// SQL 오류가 나면 서버가 불안정하다는 메시지 리턴
		}
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
			// select문 생성 후 DB에 질희한 결과를 ResultSet에 저장
			ResultSet result = state.executeQuery("SELECT * FROM USER WHERE userName = '" + name
					+ "' AND userID = '" + id + "' AND userBirth = '" + jumin + "'");
			
			if (result.next()) {					// 질의의 결과가 있다면 
				String r = result.getString(3);		// String타입 r에 3번째 애트리뷰트 값 대입
				con.close();
				state.close();
				result.close();
				return r;							// r 리턴
			}
			else {									// 질의의 결과가 없다면
				state.close();
				con.close();
				return "NO";						// 거절 메시지 리턴
			}
		} catch (SQLException e) {
			return "서버가 불안정합니다. 다음에 다시 이용해주세요!!";	// SQL 오류가 나면 서버가 불안정하다는 메시지 리턴
		}
	}
}
