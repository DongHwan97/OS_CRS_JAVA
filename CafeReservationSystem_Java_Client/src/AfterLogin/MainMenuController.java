package AfterLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainMenuController implements Initializable {

	Function f = new Function();
	
	@FXML Button logoutBtn;
	@FXML Button menuBtn;
	@FXML Button mypageBtn;
	@FXML Button homepageBtn;
	@FXML Button reservationBtn;
	
	@FXML TextField idField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		logoutBtn.setOnAction(event -> btnClicked(event));
		menuBtn.setOnAction(event -> btnClicked(event));
		mypageBtn.setOnAction(event -> btnClicked(event));
		homepageBtn.setOnAction(event -> btnClicked(event));
		reservationBtn.setOnAction(event -> btnClicked(event));
	}
	
	public void btnClicked(ActionEvent e) {
		// 로그아웃 버튼을 눌렀을 때
		if (e.getSource() == logoutBtn) {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", logoutBtn);
		}
		// 카페 메뉴 버튼을 눌렀을 때
		else if (e.getSource() == menuBtn) {
			f.changeScene("../AfterLogin/CafeMenu.fxml", menuBtn);
		}
		// 마이 페이지 버튼을 눌렀을 때
		else if (e.getSource() == mypageBtn) {
			f.changeScene("../AfterLogin/MyPage.fxml", mypageBtn);
		}
		// 홈페이지 이동 버튼을 눌렀을 때
		else if (e.getSource() == homepageBtn) {
			// 홈페이지로 이동 하는 코드!!
			// ~~~~~~~~~~~~~~~~~~~~
		}
		// 자리 확인 및 예약 버튼을 눌렀을 때
		else {
			f.changeScene("../AfterLogin/CafeTables.fxml", reservationBtn);
		}
	}
}
