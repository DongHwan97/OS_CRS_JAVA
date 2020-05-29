package BeforeLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginMenuController implements Initializable {

	Function f = new Function();

	@FXML
	Button loginBtn;
	@FXML
	TextField idField;
	@FXML
	TextField pwField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loginBtn.setOnAction(event -> btnClicked(event));
		idField.setOnAction(event -> enterPressed(event));
		pwField.setOnAction(event -> enterPressed(event));
	}

	public void btnClicked(ActionEvent e) {
		
		f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
		// idField�� ��������
		String id = idField.getText();
		// pwField�� ��������
		String pw = pwField.getText();

		// ���̵� ��й�ȣ �Է� ĭ�� ��ĭ�� ���
		if (id.equals("")) {

		} else if (pw.equals("")) {

		}
		// DB�� �����ϱ�
		else {
			f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			/*
			 * if ((f.sdb.login("S:" + id + "/" + pw).equals("exist"))) {
			 * f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			 * JOptionPane.showMessageDialog(null, "���ӹ����� �����մϴ�", "Message",
			 * JOptionPane.INFORMATION_MESSAGE); try { data.writeUTF("S: + _id + / pw"); }
			 * catch (IOException e1) { e1.printStackTrace(); } }
			 */
		}
	}

	public void enterPressed(ActionEvent e) {
		// idField�� ��������
		String id = idField.getText();
		// pwField�� ��������
		String pw = pwField.getText();

		// ���̵� ��й�ȣ �Է� ĭ�� ��ĭ�� ���
		if (id.equals("")) {

		} else if (pw.equals("")) {

		}
		// id, pw �� �� ����� �Է����� ���
		else {
			f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			/*
			 * if ((f.sdb.login("S:" + id + "/" + pw).equals("exist"))) {
			 * f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			 * JOptionPane.showMessageDialog(null, "���ӹ����� �����մϴ�", "Message",
			 * JOptionPane.INFORMATION_MESSAGE); try { data.writeUTF("S: + _id + / pw"); }
			 * catch (IOException e1) { e1.printStackTrace(); } }
			 */
		}
	}
}
