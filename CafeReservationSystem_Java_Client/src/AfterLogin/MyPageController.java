package AfterLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MyPageController implements Initializable {

	Function f = new Function();
	
	@FXML Button logoutBtn;
	@FXML Button myInfoBtn;
	@FXML Button reservationBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		logoutBtn.setOnAction(event -> btnClicked(event));
		myInfoBtn.setOnAction(event -> btnClicked(event));
		reservationBtn.setOnAction(event -> btnClicked(event));
	}
	
	public void btnClicked(ActionEvent e) {
		// 로그아웃 버튼을 눌렀을 때
		if (e.getSource() == logoutBtn) {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", logoutBtn);
		}
		// 회원정보 확인 버튼을 눌렀을 때
		else if (e.getSource() == myInfoBtn) {
			f.changeScene("../AfterLogin/MyInfo.fxml", myInfoBtn);
		}
		// 예약 확인 및 취소 버튼을 눌렀을 때
		else {
			f.changeScene("../AfterLogin/CafeTables.fxml", reservationBtn);
		}
	}
}
