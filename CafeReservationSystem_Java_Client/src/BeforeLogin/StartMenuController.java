package BeforeLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class StartMenuController implements Initializable {

	Function f = new Function();
	
	@FXML ImageView startImage;
	@FXML ImageView exitImage;
	
	@FXML Button startBtn;
	@FXML Button exitBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		startBtn.setOnAction(event -> btnClicked(event));
		exitBtn.setOnAction(event -> btnClicked(event));
		
		startImage.setImage(new Image(getClass().getResourceAsStream("/Pictures/15.png")));
		exitImage.setImage(new Image(getClass().getResourceAsStream("/Pictures/12.png")));
	}
	
	public void btnClicked(ActionEvent e) {
		// 로그인 화면으로 버튼을 눌렀을 때
		if (e.getSource() == startBtn) {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", startBtn);
		}
		// 종료 버튼을 눌렀을 때
		else {
			// 확인 팝업창 띄워주기
			Alert check = f.popUp(AlertType.CONFIRMATION, 
					"정말 종료하시겠습니까?", "'확인' 버튼을 누르시면 프로그램을 종료합니다.");
			// 팝업창에서 확인을 눌렀을 시 프로그램 종료
			if (check.showAndWait().get() == ButtonType.OK) {
				System.exit(0);
			}
		}
	}
}
