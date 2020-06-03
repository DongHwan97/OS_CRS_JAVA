package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSQL {

	Connection con = null;
	Statement state = null;
	String url = "jdbc:mysql://localhost:1111/info?serverTimezone=Asia/Seoul&useSSL=false";
	String user = "root";
	String password = "1111";
	
	public InsertSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			return;
		}
	}
	
	// 사용자 DB에 회원가입 하는 사용자 정보 저장
	public String signUp(String string) {
		String splitString = string.split(":")[1];
		String id = splitString.split("/")[0];					// id
		String name = splitString.split("/")[1];				// 이름
		String pw = splitString.split("/")[2];					// pw
		String jumin = splitString.split("/")[3];				// 주민번호
		
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			state.executeUpdate("INSERT INTO user_info VALUES ('" + name + "','"		// insert문 생성 후
					+ id + "','" + pw + "','" + jumin + "')");							// DB 테이블에 삽입
			state.close();																
			con.close();
			return "회원 정보 저장 완료!!";													// commit되면 완료 메시지 리턴
		} catch(SQLException e) {
			return "서버가 불안정합니다. 나중에 다시 이용해주세요!!";								// SQL 오류가 나면 서버가 불안정하다는 메시지 리턴
		}
	}
}
