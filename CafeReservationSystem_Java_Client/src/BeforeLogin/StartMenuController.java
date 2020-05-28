package BeforeLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class StartMenuController implements Initializable {

	Function f = new Function();
	
	@FXML Button loginBtn;
	@FXML Button exitBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		loginBtn.setOnAction(event -> btnClicked(event));
		exitBtn.setOnAction(event -> btnClicked(event));
	}
	
	public void btnClicked(ActionEvent e) {
		if (e.getSource() == loginBtn) {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", loginBtn);
		} else {
			System.exit(0);
		}
	}
}
