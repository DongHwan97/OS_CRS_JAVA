package BeforeLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Find_IDController implements Initializable {

	Function f = new Function();

	@FXML
	TextField nameField;
	@FXML
	TextField juminField1;
	@FXML
	TextField juminField2;

	@FXML
	Button checkBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		nameField.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
		checkBtn.setOnAction(event -> btnClicked(event));
	}

	public void enterPressed(ActionEvent e) {

		// TextField들에게서 text 값 가져오기
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();

		// 이름이 빈칸이면
		if (name.equals("")) {
			f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름을 입력해주세요.");
		}
		// 주민등록번호가 빈칸이면
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "주민등록번호는 공백일 수 없습니다.", "주민등록번호는 입력해주세요.");
		}
		// 정보를 모두 입력했을 경우
		else {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", nameField);
		}
	}

	public void btnClicked(ActionEvent e) {
		// TextField들에게서 text 값 가져오기
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();

		// 이름이 빈칸이면
		if (name.equals("")) {
			f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름을 입력해주세요.");
		}
		// 주민등록번호가 빈칸이면
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "주민등록번호는 공백일 수 없습니다.", "주민등록번호는 입력해주세요.");
		}
		// 정보를 모두 입력했을 경우
		else {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", nameField);
		}
	}
}
