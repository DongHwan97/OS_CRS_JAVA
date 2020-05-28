package BeforeLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignUpController implements Initializable {

	Function f = new Function();
	
	@FXML Button overlapCheckBtn;
	@FXML Button checkBtn;
	@FXML TextField idField;
	@FXML TextField nameField;
	@FXML TextField pwField1;
	@FXML TextField pwField2;
	@FXML TextField juminField1;
	@FXML TextField juminField2;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		overlapCheckBtn.setOnAction(event -> btnClicked(event));
		checkBtn.setOnAction(event -> btnClicked(event));
		idField.setOnAction(event -> enterPressed(event));
		nameField.setOnAction(event -> enterPressed(event));
		pwField1.setOnAction(event -> enterPressed(event));
		pwField2.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
	}
	
	public void btnClicked(ActionEvent e) {
		if (e.getSource() == overlapCheckBtn) {
			// 중복확인
		} else {
			// 확인버튼
		}
	}
	
	public void enterPressed(ActionEvent e) {
		if (e.getSource() == idField) {
			
		} else if (e.getSource() == nameField) {
			
		} else if (e.getSource() == pwField1) {
			
		} else if (e.getSource() == pwField2) {
			
		} else if (e.getSource() == juminField1) {
			
		} else {
			
		}
	}

}
