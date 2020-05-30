package BeforeLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Find_PWController implements Initializable {

	Function f = new Function();

	@FXML Button checkBtn;

	@FXML TextField idField;
	@FXML TextField nameField;
	@FXML TextField juminField1;
	@FXML TextField juminField2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		checkBtn.setOnAction(event -> btnClicked(event));
		idField.setOnAction(event -> enterPressed(event));
		nameField.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
	}

	// 확인 버튼을 눌렸을 때
	public void btnClicked(ActionEvent e) {
		// TextField들에게서 text값 가져오기
		String id = idField.getText();
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();

		// 아이디가 빈칸일 경우
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "아이디는 공백일 수 없습니다.", "아이디를 입력해주세요.");
		}
		// 이름이 빈칸일 경우
		else if (name.equals("")) {
			f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름 입력해주세요.");
		}
		// 주민등록번호가 빈칸일 경우
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "주민등록번호는 공백일 수 없습니다.", "주민등록번호를 입력해주세요.");
		}
		// 정보를 모두 입력했을 경우
		else {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
			//DB에 질의하기
		}
	}

	// TextField에서 엔터를 칠 경우
	public void enterPressed(ActionEvent e) {
		// TextField들에게서 text값 가져오기
		String id = idField.getText();
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();

		// 아이디가 빈칸일 경우
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "아이디는 공백일 수 없습니다.", "아이디를 입력해주세요.");
		}
		// 이름이 빈칸일 경우
		else if (name.equals("")) {
			f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름 입력해주세요.");
		}
		// 주민등록번호가 빈칸일 경우
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "주민등록번호는 공백일 수 없습니다.", "주민등록번호를 입력해주세요.");
		}
		// 정보를 모두 입력했을 경우
		else {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
			//DB에 질의하기
		}
	}
}
