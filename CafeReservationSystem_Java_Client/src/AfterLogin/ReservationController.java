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
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ReservationController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff"); 
	
	@FXML ImageView back; 
	
	@FXML TextField tableInfo;
	
	@FXML Rectangle backBorder1;
	@FXML Rectangle backBorder2;
	
	@FXML Button myPageBtn;
	@FXML Button firstTime;
	@FXML Button secondTime;
	@FXML Button thirdTime;
	@FXML Button fourthTime;
	@FXML Button fifthTime;
	@FXML Button sixthTime;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		myPageBtn.setOnAction(event -> btnClicked(event));
		firstTime.setOnAction(event -> btnClicked(event));
		secondTime.setOnAction(event -> btnClicked(event));
		thirdTime.setOnAction(event -> btnClicked(event));
		fourthTime.setOnAction(event -> btnClicked(event));
		fifthTime.setOnAction(event -> btnClicked(event));
		sixthTime.setOnAction(event -> btnClicked(event));
		
		backBorder1.setOnMouseEntered(event -> mouseEntered(event));
		backBorder2.setOnMouseEntered(event -> mouseEntered(event));
		
		backBorder1.setOnMouseExited(event -> mouseExited(event));
		backBorder2.setOnMouseExited(event -> mouseExited(event));
		
		backBorder1.setOnMousePressed(event -> mousePressed(event));
		backBorder2.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../back.png")));
	}
	
	public void btnClicked(ActionEvent e) {
		
		Optional<ButtonType> result;
		
		if (e.getSource() == myPageBtn) {	// 마이페이지 버튼 클릭 시
			result = f.popUp(AlertType.CONFIRMATION, "마이페이지로 이동하시겠습니까?", "'확인' 버튼 클릭시 이동합니다.").showAndWait(); // 팝업창 띄우기
			if (result.get() == ButtonType.OK) {	// 팝업창에서 'OK' 버튼 클릭시
				f.changeScene("/AfterLogin/MyPage.fxml", myPageBtn);	// 마이페이지로 화면 전환
			}
		} else if (e.getSource() == firstTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'10시 ~ 12시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB에 정보 저장
			}
		} else if (e.getSource() == secondTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'12시 ~ 14시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB에 정보 저장
			}
		} else if (e.getSource() == thirdTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'14시 ~ 16시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB에 정보 저장
			}
		} else if (e.getSource() == fourthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'16시 ~ 18시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB에 정보 저장
			}
		} else if (e.getSource() == fifthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'18시 ~ 20시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB에 정보 저장
			}
		} else {
			result = f.popUp(AlertType.CONFIRMATION, "'20시 ~ 22시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB에 정보 저장
			}
		}
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
		f.changeScene("/AfterLogin/CafeTables.fxml", myPageBtn);
		back.setEffect(null);
	}
}