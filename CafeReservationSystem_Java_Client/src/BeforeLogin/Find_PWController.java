package BeforeLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
	
	public void btnClicked(ActionEvent e) {
		// 확인 눌렸을때
	}
	
	public void enterPressed(ActionEvent e) {
		if (e.getSource() == idField) {
			
		} else if (e.getSource() == nameField) {
			
		} else if (e.getSource() == juminField1) {
			
		} else {
			
		}
	}

}
