package application;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//DBMS�� SELECT�� �Է�
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

	// �ߺ�Ȯ��
	// DB user ���̺� SELECT�� �ۼ�
	public String overlap(String string) {
		String id = string.split(":")[1];
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			// select�� ���� �� DB�� ������ ����� ResultSet�� ����
			ResultSet result = state.executeQuery("SELECT * FROM USER WHERE userID = '" + id + "'");

			if (!result.next()) {	// ������ ����� ���ٸ� = �ش� ���̵� ���� ������ ���ٸ� = �ߺ����� �ʴ� ���̵���
				con.close();
				state.close();
				return "OK";		// Ȯ�� �޽��� ����
			}
			else {					// �ߺ��Ǵ� ���̵���
				state.close();
				con.close();
				return "NO";		// ���� �޽��� ����
			}
		} catch (SQLException e) {
			return "������ �Ҿ����մϴ�. ������ �ٽ� �̿����ּ���!!";	// SQL ������ ���� ������ �Ҿ����ϴٴ� �޽��� ����
		}
	}
/*
	// �α����� ���� �ش� ������ ����� DB�� �����ϴ���
	// �׸��� �ش� ������ ��򰡿��� �α��� ������ (login DB�� �����ϴ���)
	public String login(String string) {
		String splitString = string.split(":")[1];
		String id = splitString.split("/")[0];
		String pw = splitString.split("/")[1];
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			// select�� ���� �� DB�� ������ ����� ResultSet�� ����
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
			return "SELECT ���� : " + e.getMessage();
		}
	}
*/
	// ID ã�⸦ ���� ������� ������
	// ����� DB�� SELECT
	public String findID(String string) {
		String splitString = string.split(":")[1];
		String name = splitString.split("/")[0];
		String jumin = splitString.split("/")[1];
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			// select�� ���� �� DB�� ������ ����� ResultSet�� ����
			ResultSet result = state.executeQuery("SELECT * FROM USER WHERE userName = '" + name +
					"' AND + userBirth = '" + jumin + "'");
			
			if (result.next()) {					// ������ ����� �ִٸ�
				String r = result.getString(1);		// StringŸ�� r�� 1��° ��Ʈ����Ʈ �� ����
				con.close();
				state.close();
				result.close();
				return r;							// r ����
			}
			else {									// ������ ����� ���ٸ�
				state.close();
				con.close();
				return "NO";						// ���� �޽��� ����
			}
		} catch (SQLException e) {
			return "������ �Ҿ����մϴ�. ������ �ٽ� �̿����ּ���!!";	// SQL ������ ���� ������ �Ҿ����ϴٴ� �޽��� ����
		}
	}

	// PW ã�⸦ ���� ������� ������
	// ����� DB�� SELECT
	public String findPW(String string) {
		String splitString = string.split(":")[1];
		String name = splitString.split("/")[0];
		String id = splitString.split("/")[1];
		String jumin = splitString.split("/")[2];

		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			// select�� ���� �� DB�� ������ ����� ResultSet�� ����
			ResultSet result = state.executeQuery("SELECT * FROM USER WHERE userName = '" + name
					+ "' AND userID = '" + id + "' AND userBirth = '" + jumin + "'");
			
			if (result.next()) {					// ������ ����� �ִٸ� 
				String r = result.getString(3);		// StringŸ�� r�� 3��° ��Ʈ����Ʈ �� ����
				con.close();
				state.close();
				result.close();
				return r;							// r ����
			}
			else {									// ������ ����� ���ٸ�
				state.close();
				con.close();
				return "NO";						// ���� �޽��� ����
			}
		} catch (SQLException e) {
			return "������ �Ҿ����մϴ�. ������ �ٽ� �̿����ּ���!!";	// SQL ������ ���� ������ �Ҿ����ϴٴ� �޽��� ����
		}
	}
}
