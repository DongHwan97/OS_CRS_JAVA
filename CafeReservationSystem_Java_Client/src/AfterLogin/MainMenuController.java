package AfterLogin;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;

public class MainMenuController implements Initializable {

	Function f = new Function();
	
	@FXML Button logoutBtn;
	@FXML Button menuBtn;
	@FXML Button mypageBtn;
	@FXML Button homepageBtn;
	@FXML Button reservationBtn;
	
	@FXML ImageView reservImage;
	@FXML ImageView menuImage;
	@FXML ImageView mypageImage;
	@FXML ImageView homeImage;
	@FXML ImageView logoutImage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		logoutBtn.setOnAction(event -> btnClicked(event));
		menuBtn.setOnAction(event -> btnClicked(event));
		mypageBtn.setOnAction(event -> btnClicked(event));
		homepageBtn.setOnAction(event -> btnClicked(event));
		reservationBtn.setOnAction(event -> btnClicked(event));
		
		reservImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/26.png")));
		menuImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/25.png")));
		mypageImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/18.png")));
		homeImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/19.png")));
		logoutImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/24.png")));
	}
	
	public void btnClicked(ActionEvent e) {
		
		Optional<ButtonType> result;
		
		// 로그아웃 버튼을 눌렀을 때
		if (e.getSource() == logoutBtn) {
			result = f.popUp(AlertType.CONFIRMATION, "로그아웃하시겠습니까?", "'확인' 버튼을 누를 시 로그아웃 됩니다.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("/BeforeLogin/LoginMenu.fxml", logoutBtn);
			}
		}
		// 카페 메뉴 버튼을 눌렀을 때
		else if (e.getSource() == menuBtn) {
			result = f.popUp(AlertType.CONFIRMATION, "카페 메뉴 화면으로 이동하시겠습니까?", "'확인' 버튼을 누를 시 화면이 전환됩니다.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("../AfterLogin/CafeMenu.fxml", menuBtn);
			}
		}
		// 마이 페이지 버튼을 눌렀을 때
		else if (e.getSource() == mypageBtn) {
			result = f.popUp(AlertType.CONFIRMATION, "마이페이지 화면으로 이동하시겠습니까?", "'확인' 버튼을 누를 시 화면이 전환됩니다.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("../AfterLogin/MyPage.fxml", mypageBtn);
			}
		}
		// 홈페이지 이동 버튼을 눌렀을 때
		else if (e.getSource() == homepageBtn) {
			result = f.popUp(AlertType.CONFIRMATION, "홈페이지로 이동하시겠습니까?", "'확인' 버튼을 누를 시 홈페이지로 이동합니다.").showAndWait();
			if (result.get() == ButtonType.OK) {
				// 홈페이지로 이동 하는 코드!!
				new homePage();//이동
			}
		}
		// 자리 확인 및 예약 버튼을 눌렀을 때
		else {
			result = f.popUp(AlertType.CONFIRMATION, "자리 예약 화면으로 이동하시겠습니까?", "'확인' 버튼을 누를 시 화면이 전환됩니다.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("../AfterLogin/CafeTables.fxml", reservationBtn);
			}
		}
	}
}
