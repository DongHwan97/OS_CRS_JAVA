package BeforeLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert.AlertType;

public class Find_PWController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff");
	
	@FXML ImageView back;
	@FXML ImageView nameImage;
	@FXML ImageView idImage;
	@FXML ImageView birthImage;

	@FXML Button checkBtn;

	@FXML TextField idField;
	@FXML TextField nameField;
	@FXML TextField juminField1;
	@FXML PasswordField juminField2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		checkBtn.setOnAction(event -> btnClicked(event));
		idField.setOnAction(event -> enterPressed(event));
		nameField.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		
		back.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		nameImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/16.png")));
		idImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/11.png")));
		birthImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/17.png")));
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
		f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
		back.setEffect(null);
	}

	// 확인 버튼을 눌렸을 때
	public void btnClicked(ActionEvent e) {
		// TextField들에게서 text값 가져오기
		String id = idField.getText();
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();
		
		String pw;

		// 아이디가 빈칸일 경우
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "아이디는 공백일 수 없습니다.", "아이디를 입력해주세요.").show();
		}
		// 이름이 빈칸일 경우
		else if (name.equals("")) {
			f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름 입력해주세요.").show();
		}
		// 주민등록번호가 빈칸일 경우
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "주민등록번호는 공백일 수 없습니다.", "주민등록번호를 입력해주세요.").show();
		}
		// 정보를 모두 입력했을 경우
		else {
			// 서버로 비밀번호 찾기용 문자열 전송 ("메시지타입_이름_아이디_주민등록번호")
			try {
				f.wrtieServer("FP_" + name + "_" + id + "_" + jumin1 + jumin2);
				// (서버로부터 읽어들인 문자열 = pw)
				if ((pw = f.readServer()).equals("fail")) {	// 읽어들인 문자열이 fail 이면
					f.popUp(AlertType.WARNING, "해당 회원은 존재하지 않습니다!!!", "다시 입력해주시기 바랍니다.").show();
				} else if (pw.equals(null)) {	// 읽어들인 문자열이 null 이면
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				} else {	// 읽어들인 문자열이 정상pw이면
					f.popUp(AlertType.INFORMATION, "입력하신 정보에 해당하는 비밀번호는", pw + " 입니다!!!").showAndWait();
					f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
				}
			} catch(IOException ex) {
				f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
			}
			//f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
		}
	}

	// TextField에서 엔터를 칠 경우
	public void enterPressed(ActionEvent e) {
		// TextField들에게서 text값 가져오기
		String id = idField.getText();
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();
		
		String pw;

		// 아이디가 빈칸일 경우
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "아이디는 공백일 수 없습니다.", "아이디를 입력해주세요.").show();
		}
		// 이름이 빈칸일 경우
		else if (name.equals("")) {
			f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름 입력해주세요.").show();
		}
		// 주민등록번호가 빈칸일 경우
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "주민등록번호는 공백일 수 없습니다.", "주민등록번호를 입력해주세요.").show();
		}
		// 정보를 모두 입력했을 경우
		else {
			// 서버로 비밀번호 찾기용 문자열 전송 ("메시지타입_이름_아이디_주민등록번호")
			try {
				f.wrtieServer("FP_" + name + "_" + id + "_" + jumin1 + jumin2);
				// (서버로부터 읽어들인 문자열 = pw)
				if ((pw = f.readServer()).equals("fail")) {	// 읽어들인 문자열이 fail 이면
					f.popUp(AlertType.WARNING, "해당 회원은 존재하지 않습니다!!!", "다시 입력해주시기 바랍니다.").show();
				} else if (pw.equals(null)) {	// 읽어들인 문자열이 null 이면
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				} else {	// 읽어들인 문자열이 정상pw이면
					f.popUp(AlertType.INFORMATION, "입력하신 정보에 해당하는 비밀번호는", pw + " 입니다!!!").showAndWait();
					f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
				}
			} catch(IOException ex) {
				f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
			}
			//f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
		}
	}
}
