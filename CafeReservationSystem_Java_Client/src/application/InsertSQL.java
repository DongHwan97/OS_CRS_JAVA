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
	
	// ����� DB�� ȸ������ �ϴ� ����� ���� ����
	public String signUp(String string) {
		String splitString = string.split(":")[1];
		String id = splitString.split("/")[0];					// id
		String name = splitString.split("/")[1];				// �̸�
		String pw = splitString.split("/")[2];					// pw
		String jumin = splitString.split("/")[3];				// �ֹι�ȣ
		
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
			state.executeUpdate("INSERT INTO user_info VALUES ('" + name + "','"		// insert�� ���� ��
					+ id + "','" + pw + "','" + jumin + "')");							// DB ���̺� ����
			state.close();																
			con.close();
			return "ȸ�� ���� ���� �Ϸ�!!";													// commit�Ǹ� �Ϸ� �޽��� ����
		} catch(SQLException e) {
			return "������ �Ҿ����մϴ�. ���߿� �ٽ� �̿����ּ���!!";								// SQL ������ ���� ������ �Ҿ����ϴٴ� �޽��� ����
		}
	}
}
