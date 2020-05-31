package AfterLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	
	@FXML Rectangle backBorder1;
	@FXML Rectangle backBorder2;
	
	@FXML Button logoutBtn;
	@FXML Button myInfoBtn;
	@FXML Button reservationBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		logoutBtn.setOnAction(event -> btnClicked(event));
		myInfoBtn.setOnAction(event -> btnClicked(event));
		reservationBtn.setOnAction(event -> btnClicked(event));
		
		backBorder1.setOnMouseEntered(event -> mouseEntered(event));
		backBorder2.setOnMouseEntered(event -> mouseEntered(event));
		
		backBorder1.setOnMouseExited(event -> mouseExited(event));
		backBorder2.setOnMouseExited(event -> mouseExited(event));
		
		backBorder1.setOnMousePressed(event -> mousePressed(event));
		backBorder2.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../back.png")));
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
			f.changeScene("/BeforeLogin/LoginMenu.fxml", logoutBtn);
		}
		// 회원정보 확인 버튼을 눌렀을 때
		else if (e.getSource() == myInfoBtn) {
			f.changeScene("../AfterLogin/MyInfo.fxml", myInfoBtn);
		}
		// 예약 확인 및 취소 버튼을 눌렀을 때
		else {
			f.changeScene("../AfterLogin/ReservationCancel.fxml", reservationBtn);
		}
	}
}
