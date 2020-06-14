package AfterLogin;

import java.io.IOException;
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
	@FXML ImageView mypageImage;
	
	@FXML TextField tableInfo;
	
	@FXML Button mypageBtn;
	
	@FXML Rectangle firstTime;
	@FXML Rectangle secondTime;
	@FXML Rectangle thirdTime;
	@FXML Rectangle fourthTime;
	@FXML Rectangle fifthTime;
	@FXML Rectangle sixthTime;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		mypageBtn.setOnAction(event -> btnClicked(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		firstTime.setOnMouseEntered(event -> mouseEntered(event));
		secondTime.setOnMouseEntered(event -> mouseEntered(event));
		thirdTime.setOnMouseEntered(event -> mouseEntered(event));
		fourthTime.setOnMouseEntered(event -> mouseEntered(event));
		fifthTime.setOnMouseEntered(event -> mouseEntered(event));
		sixthTime.setOnMouseEntered(event -> mouseEntered(event));
	
		back.setOnMouseExited(event -> mouseExited(event));
		firstTime.setOnMouseExited(event -> mouseExited(event));
		secondTime.setOnMouseExited(event -> mouseExited(event));
		thirdTime.setOnMouseExited(event -> mouseExited(event));
		fourthTime.setOnMouseExited(event -> mouseExited(event));
		fifthTime.setOnMouseExited(event -> mouseExited(event));
		sixthTime.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		firstTime.setOnMousePressed(event -> mousePressed(event));
		secondTime.setOnMousePressed(event -> mousePressed(event));
		thirdTime.setOnMousePressed(event -> mousePressed(event));
		fourthTime.setOnMousePressed(event -> mousePressed(event));
		fifthTime.setOnMousePressed(event -> mousePressed(event));
		sixthTime.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		mypageImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/18.png")));
	}
	
	public void btnClicked(ActionEvent e) {
		
		Optional<ButtonType> result;
		
		if (e.getSource() == mypageBtn) {	// 마이페이지 버튼 클릭 시
			result = f.popUp(AlertType.CONFIRMATION, "마이페이지로 이동하시겠습니까?", "'확인' 버튼 클릭시 이동합니다.").showAndWait(); // 팝업창 띄우기
			if (result.get() == ButtonType.OK) {	// 팝업창에서 'OK' 버튼 클릭시
				f.changeScene("/AfterLogin/MyPage.fxml", mypageBtn);	// 마이페이지로 화면 전환
			}
		}
	}
	
	// 뒤로가기 이미지에 마우스가 들어왔을 때
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == back) {
			back.setEffect(teduri1);
		} else if (e.getSource() == firstTime) {
			firstTime.setEffect(teduri1);
		} else if (e.getSource() == secondTime) {
			secondTime.setEffect(teduri1);
		} else if (e.getSource() == thirdTime) {
			thirdTime.setEffect(teduri1);
		} else if (e.getSource() == fourthTime) {
			fourthTime.setEffect(teduri1);
		} else if (e.getSource() == fifthTime) {
			fifthTime.setEffect(teduri1);
		} else {
			sixthTime.setEffect(teduri1);
		}
	}
	// 뒤로가기 이미지에서 마우스가 나갔을 때
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == back) {
			back.setEffect(null);
		} else if (e.getSource() == firstTime) {
			firstTime.setEffect(null);
		} else if (e.getSource() == secondTime) {
			secondTime.setEffect(null);
		} else if (e.getSource() == thirdTime) {
			thirdTime.setEffect(null);
		} else if (e.getSource() == fourthTime) {
			fourthTime.setEffect(null);
		} else if (e.getSource() == fifthTime) {
			fifthTime.setEffect(null);
		} else {
			sixthTime.setEffect(null);
		}
	}
	// 뒤로가기 이미지를 클릭했을 때
	public void mousePressed(MouseEvent e) {
		
		Optional<ButtonType> result;
		
		if (e.getSource() == back) {
			f.changeScene("/AfterLogin/CafeTables.fxml", mypageBtn);
			back.setEffect(null);
		}
		else if (e.getSource() == firstTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'10시 ~ 12시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// 서버로 예약용 문자열 전송
				try {
					 f.wrtieServer("CT_" + Function.table + "_one");
					f.popUp(AlertType.INFORMATION, "예약이 완료되었습니다!!!", "예약 정보는 마이페이지에서 확인 가능합니다.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				}
			}
		} else if (e.getSource() == secondTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'12시 ~ 14시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// 서버로 예약용 문자열 전송
				try {
					 f.wrtieServer("CT_" + Function.table + "_two");
					f.popUp(AlertType.INFORMATION, "예약이 완료되었습니다!!!", "예약 정보는 마이페이지에서 확인 가능합니다.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				}
			}
		} else if (e.getSource() == thirdTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'14시 ~ 16시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// 서버로 예약용 문자열 전송
				try {
					 f.wrtieServer("CT_" + Function.table + "_three");
					f.popUp(AlertType.INFORMATION, "예약이 완료되었습니다!!!", "예약 정보는 마이페이지에서 확인 가능합니다.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				}
			}
		} else if (e.getSource() == fourthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'16시 ~ 18시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// 서버로 예약용 문자열 전송
				try {
					f.wrtieServer("CT_" + Function.table + "_four");
					f.popUp(AlertType.INFORMATION, "예약이 완료되었습니다!!!", "예약 정보는 마이페이지에서 확인 가능합니다.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				}
			}
		} else if (e.getSource() == fifthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'18시 ~ 20시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// 서버로 예약용 문자열 전송
				try {
					 f.wrtieServer("CT_" + Function.table + "_five");
					f.popUp(AlertType.INFORMATION, "예약이 완료되었습니다!!!", "예약 정보는 마이페이지에서 확인 가능합니다.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				}
			}
		} else {
			result = f.popUp(AlertType.CONFIRMATION, "'20시 ~ 22시' 예약하시겠습니까?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// 서버로 예약용 문자열 전송
				try {
					f.wrtieServer("CT_" + Function.table + "_six");
					f.popUp(AlertType.INFORMATION, "예약이 완료되었습니다!!!", "예약 정보는 마이페이지에서 확인 가능합니다.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				}
			}
		}
	}
}