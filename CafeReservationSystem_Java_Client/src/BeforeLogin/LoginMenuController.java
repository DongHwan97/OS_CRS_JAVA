package BeforeLogin;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LoginMenuController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff");
	
	@FXML ImageView back;
	@FXML ImageView pwImage;
	@FXML ImageView idImage;
	
	@FXML Button loginBtn;
	
	@FXML TextField idField;
	@FXML PasswordField pwField;
	
	@FXML Label findPW;
	@FXML Label findID;
	@FXML Label signUp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		loginBtn.setOnAction(event -> btnClicked(event));
		
		idField.setOnAction(event -> enterPressed(event));
		pwField.setOnAction(event -> enterPressed(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		
		back.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		
		findPW.setOnMouseEntered(event -> labelEntered(event));
		findID.setOnMouseEntered(event -> labelEntered(event));
		signUp.setOnMouseEntered(event -> labelEntered(event));
		
		findPW.setOnMouseExited(event -> labelExited(event));
		findID.setOnMouseExited(event -> labelExited(event));
		signUp.setOnMouseExited(event -> labelExited(event));
		
		findPW.setOnMousePressed(event -> labelPressed(event));
		findID.setOnMousePressed(event -> labelPressed(event));
		signUp.setOnMousePressed(event -> labelPressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("/Pictures/backBtn.png")));
		pwImage.setImage(new Image(getClass().getResourceAsStream("/Pictures/6.png")));
		idImage.setImage(new Image(getClass().getResourceAsStream("/Pictures/11.png")));
		
		
	}
	// 뒤로가기 이미지에 마우스가 들어왔을 때
	public void mouseEntered(MouseEvent e) {
		back.setEffect(teduri1);
	}
	// 뒤로가기 이미지에서 마우스가 나갔을 때
	public void mouseExited(MouseEvent e) {
		back.setEffect(null);
	}
	// 뒤로가기 이미지를 클릭했을 때
	public void mousePressed(MouseEvent e) {
		f.changeScene("/BeforeLogin/StartMenu.fxml", idField);
		back.setEffect(null);
	}
	
	public void labelEntered(MouseEvent e) {
		// ID찾기에 마우스를 올렸을 때
		if (e.getSource() == findID) {
			findID.setEffect(teduri1);
		}
		// PW찾기에 마우스를 올렸을 때
		else if (e.getSource() == findPW) {
			findPW.setEffect(teduri1);
		}
		// 회원가입에 마우스를 올렸을 때
		else {
			signUp.setEffect(teduri1);
		}
	}
	
	public void labelExited(MouseEvent e) {
		// ID찾기에서 마우스가 나갔을 때
		if (e.getSource() == findID) {
			findID.setEffect(null);
		}
		// PW찾기에서 마우스가 나갔을 때
		else if (e.getSource() == findPW) {
			findPW.setEffect(null);
		}
		// 회원가입에서 마우스가 나갔을 때
		else {
			signUp.setEffect(null);
		}
	}

	public void labelPressed(MouseEvent e) {
		
		Optional<ButtonType> result;
		
		// ID찾기를 마우스로 눌렀을 때
		if (e.getSource() == findID) {
			result = f.popUp(AlertType.CONFIRMATION, "'ID 찾기' 화면으로 이동하시겠습니까?", "'확인' 버튼을 누를 시 ID찾기 화면으로 이동합니다.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("/BeforeLogin/Find_ID.fxml", signUp);
			}
			findID.setEffect(null);
		}
		// PW찾기를 마우스로 눌렀을 때
		else if (e.getSource() == findPW) {
			result = f.popUp(AlertType.CONFIRMATION, "'PW 찾기' 화면으로 이동하시겠습니까?", "'확인' 버튼을 누를 시 PW찾기 화면으로 이동합니다.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("/BeforeLogin/Find_PW.fxml", signUp);
			}
			findPW.setEffect(null);
		}
		// 회원가입을 마우스로 눌렀을 때
		else {
			result = f.popUp(AlertType.CONFIRMATION, "'회원가입' 화면으로 이동하시겠습니까?", "'확인' 버튼을 누를 시 회원가입 화면으로 이동합니다.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("/BeforeLogin/SignUp.fxml", signUp);
			}
			signUp.setEffect(null);
		}
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
			// 서버로 로그인용 문자열 전송 ("메시지타입_아이디_패스워드")
			
			try {
				f.wrtieServer("LI_" + id + "_" + pw);
				if(f.readServer().equals("success")) {	// 서버로부터 읽어들인 문자열이 OK일 경우
					f.popUp(AlertType.INFORMATION, "로그인 성공!!!", "메인 메뉴로 이동합니다.").showAndWait();
					f.changeScene("/AfterLogin/MainMenu.fxml", pwField);
					Function.id = id;
				} else {
					f.popUp(AlertType.ERROR, "로그인 실패!!!", "잘못된 아이디입니다.").showAndWait();
				}
			} catch(IOException ex) {
				f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
			}
			
			//f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
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
			// 서버로 로그인용 문자열 전송 ("메시지타입_아이디_패스워드")
			
			try {
				f.wrtieServer("LI_" + id + "_" + pw);
				if(f.readServer().equals("success")) {	// 서버로부터 읽어들인 문자열이 OK일 경우
					f.popUp(AlertType.INFORMATION, "로그인 성공!!!", "메인 메뉴로 이동합니다.").showAndWait();
					f.changeScene("/AfterLogin/MainMenu.fxml", pwField);
					Function.id = id;
				} else {
					f.popUp(AlertType.ERROR, "로그인 실패!!!", "잘못된 아이디입니다.").showAndWait();
				}
			} catch(IOException ex) {
				f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
			}
		}
	}
}
