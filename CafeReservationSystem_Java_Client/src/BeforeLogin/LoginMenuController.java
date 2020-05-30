package BeforeLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LoginMenuController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	DropShadow teduri2 = new DropShadow();
	
	Color teduri = Color.web("#0022ff");
	
	@FXML Button loginBtn;
	
	@FXML TextField idField;
	@FXML TextField pwField;
	
	@FXML Rectangle backBorder1;
	@FXML Rectangle backBorder2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		loginBtn.setOnAction(event -> btnClicked(event));
		
		idField.setOnAction(event -> enterPressed(event));
		pwField.setOnAction(event -> enterPressed(event));
		
		backBorder1.setOnMouseEntered(event -> mouseEntered(event));
		backBorder2.setOnMouseEntered(event -> mouseEntered(event));
		
		backBorder1.setOnMouseExited(event -> mouseExited(event));
		backBorder2.setOnMouseExited(event -> mouseExited(event));
		
		backBorder1.setOnMousePressed(event -> mousePressed(event));
		backBorder2.setOnMouseExited(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		teduri2.setColor(teduri);
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}

	public void btnClicked(ActionEvent e) {
		// idField의 text 가져오기
		String id = idField.getText();
		// pwField의 text 가져오기
		String pw = pwField.getText();

		// 아이디 비밀번호 입력 칸이 빈칸일 경우
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "아이디는 빈칸일 수 없습니다.", "아이디를 입력해주세요.").show();
		} else if (pw.equals("")) {
			f.popUp(AlertType.WARNING, "패스워드는 빈칸일 수 없습니다.", "패스워드를 입력해주세요.").show();
		}
		// TextField에 ID, PW를 입력하였을 경우
		else {
			f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			//DB에 질의
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
			f.popUp(AlertType.WARNING, "아이디는 빈칸일 수 없습니다.", "아이디를 입력해주세요.").show();
		} else if (pw.equals("")) {
			f.popUp(AlertType.WARNING, "패스워드는 빈칸일 수 없습니다.", "패스워드를 입력해주세요.").show();
		}
		// TextField에 ID, PW를 입력하였을 경우
		else {
			f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			//DB에 질의
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
