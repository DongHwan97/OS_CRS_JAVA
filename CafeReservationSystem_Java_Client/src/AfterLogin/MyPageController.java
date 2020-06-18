package AfterLogin;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyPageController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff");
	
	@FXML ImageView back;
	@FXML ImageView logoutImage;
	@FXML ImageView infoImage;
	@FXML ImageView reservImage;
	
	@FXML Button logoutBtn;
	@FXML Button myInfoBtn;
	@FXML Button reservationBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		logoutBtn.setOnAction(event -> btnClicked(event));
		myInfoBtn.setOnAction(event -> btnClicked(event));
		reservationBtn.setOnAction(event -> btnClicked(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		back.setOnMouseExited(event -> mouseExited(event));
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		logoutImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/24.png")));
		infoImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/16.png")));
		reservImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/26.png")));
	}
	
	
	// 뒤로가기 이미지에 마우스가 들어왔을 때
	public void mouseEntered(MouseEvent e) {
		back.setEffect(teduri1);
	}
	// 뒤로가기 이미지에서 마우스가 나갔을 때
	public void mouseExited(MouseEvent e) {
		back.setEffect(null);
	}
	// 뒤로가기 이미지를 클릭했을 때
	public void mousePressed(MouseEvent e) {
		f.changeScene("/AfterLogin/MainMenu.fxml", logoutBtn);
		back.setEffect(null);
	}
		
	public void btnClicked(ActionEvent e) {
		// 로그아웃 버튼을 눌렀을 때
		if (e.getSource() == logoutBtn) {
			// 팝업창 띄워주기
			Optional<ButtonType> result = f.popUp(AlertType.CONFIRMATION, "로그아웃하시겠습니까?", "'확인' 버튼을 누를 시 로그아웃 됩니다.").showAndWait();
			if (result.get() == ButtonType.OK) {						// 팝업창에서 확인 버튼 클릭시
				f.changeScene("/BeforeLogin/LoginMenu.fxml", logoutBtn);	// 로그인메뉴로 이동 = 로그아웃 시키기
			}
		}
		// 회원정보 확인 버튼을 눌렀을 때
		else if (e.getSource() == myInfoBtn) {
			
			Optional<ButtonType> result = f.popUp(AlertType.CONFIRMATION, "회원정보 확인 화면으로 이동하시겠습니까?", "'확인' 버튼을 누를 시 이동합니다.").showAndWait();
			if (result.get() == ButtonType.OK) {						// 팝업창에서 확인 버튼 클릭시
				f.changeScene("../AfterLogin/MyInfo.fxml", myInfoBtn);	// 회원정보 확인 창으로 화면 전환
			}
		}
		// 예약 확인 및 취소 버튼을 눌렀을 때
		else {
			Optional<ButtonType> result = f.popUp(AlertType.CONFIRMATION, "예약 확인 화면으로 이동하시겠습니까?", "'확인' 버튼을 누를 시 이동합니다.").showAndWait();
			if (result.get() == ButtonType.OK) {						// 팝업창에서 확인 버튼 클릭시
				f.changeScene("../AfterLogin/ReservationCancel.fxml", reservationBtn);	// 예약 창으로 화면 전환
			}
		}
	}
}
