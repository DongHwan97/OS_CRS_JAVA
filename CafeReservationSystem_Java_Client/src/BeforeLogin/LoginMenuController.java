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
		// idField값 가져오기
		String id = idField.getText();
		// pwField값 가져오기
		String pw = pwField.getText();

		// 아이디 비밀번호 입력 칸이 빈칸일 경우
		if (id.equals("")) {

		} else if (pw.equals("")) {

		}
		// DB에 질의하기
		else {
			f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			/*
			 * if ((f.sdb.login("S:" + id + "/" + pw).equals("exist"))) {
			 * f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			 * JOptionPane.showMessageDialog(null, "게임방으로 입장합니다", "Message",
			 * JOptionPane.INFORMATION_MESSAGE); try { data.writeUTF("S: + _id + / pw"); }
			 * catch (IOException e1) { e1.printStackTrace(); } }
			 */
		}
	}

	public void enterPressed(ActionEvent e) {
		// idField값 가져오기
		String id = idField.getText();
		// pwField값 가져오기
		String pw = pwField.getText();

		// 아이디 비밀번호 입력 칸이 빈칸일 경우
		if (id.equals("")) {

		} else if (pw.equals("")) {

		}
		// id, pw 둘 다 제대로 입력했을 경우
		else {
			f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			/*
			 * if ((f.sdb.login("S:" + id + "/" + pw).equals("exist"))) {
			 * f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			 * JOptionPane.showMessageDialog(null, "게임방으로 입장합니다", "Message",
			 * JOptionPane.INFORMATION_MESSAGE); try { data.writeUTF("S: + _id + / pw"); }
			 * catch (IOException e1) { e1.printStackTrace(); } }
			 */
		}
	}
}
