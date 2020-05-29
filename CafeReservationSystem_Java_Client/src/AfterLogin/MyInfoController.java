package AfterLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class MyInfoController implements Initializable {

	Function f = new Function();
	
	@FXML TextField nameField;
	@FXML TextField idField;
	@FXML TextField pwField;
	@FXML TextField birthField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
