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

	// �ߺ�Ȯ��
	// DB user ���̺� SELECT�� �ۼ�
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
			return "SELECT ���� : " + e.getMessage();
		}
		return "NO";
	}

	// �α����� ���� �ش� ������ ����� DB�� �����ϴ���
	// �׸��� �ش� ������ ��򰡿��� �α��� ������ (login DB�� �����ϴ���)
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
			return "SELECT ���� : " + e.getMessage();
		}
	}

	// ����ڰ� ȸ�������� �ϱ� ���� ����Ȯ���� �ϴ� ����
	// ����� DB�� �̸��� �ֹι�ȣ������ SELECT�ؼ� ���� �����ϴ��� Ȯ��
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
			return "SELECT ���� : " + e.getMessage();
		}
		return "NO";
	}
	// ID ã�⸦ ���� ������� ������
	// ����� DB�� SELECT
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
			// SELECT * FROM user_info WHERE user_Name = 'ȫ����' AND user_Jumin = '9707231199119'
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
