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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ReservationCancelController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff");
	
	@FXML ImageView back;
	
	@FXML TextField reservationInfo;
	
	@FXML Button cancelBtn;
	
	@FXML Rectangle backBorder1;
	@FXML Rectangle backBorder2;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cancelBtn.setOnAction(event -> reservationCancel(event));
		
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
		f.changeScene("../AfterLogin/MyPage.fxml", cancelBtn);
		back.setEffect(null);
	}
	// 예약 취소 버튼을 눌렀을 때
	public void reservationCancel(ActionEvent e) {
		Optional<ButtonType> result = f.popUp(AlertType.CONFIRMATION, "예약을 취소하시겠습니까?", "").showAndWait();
		if (result.get() == ButtonType.OK) {	// 확인 버튼을 눌렀을 경우
			// DB 딜리트 
			// DB 딜리트한 값 읽어오기
		}
	}
}