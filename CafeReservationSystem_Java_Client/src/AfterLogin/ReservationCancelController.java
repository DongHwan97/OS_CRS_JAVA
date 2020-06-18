package AfterLogin;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ReservationCancelController implements Initializable {

   Function f = new Function();
   
   DropShadow teduri1 = new DropShadow();
   
   Color teduri = Color.web("#0022ff");
   
   String reservTime;
   
   boolean reserved = false;
   
   @FXML ImageView back;
   
   @FXML TextArea reservationInfo;
   
   @FXML Button cancelBtn;
   
   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      
      cancelBtn.setOnAction(event -> reservationCancel(event));
      
      back.setOnMouseEntered(event -> mouseEntered(event));
      back.setOnMouseExited(event -> mouseExited(event));
      back.setOnMousePressed(event -> mousePressed(event));
      
      teduri1.setColor(teduri);
      
      back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
      
      reservationInfo();
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
      
      if (result.get() == ButtonType.OK) {   // 확인 버튼을 눌렀을 경우
         // 서버로 예약취소용 문자열 전송 ("메시지타입_아이디_테이블번호_시간");
         try {
            f.wrtieServer("CR_" + Function.table + "_" + reservTime);
            f.popUp(AlertType.INFORMATION, "예약이 취소되었습니다!!!", "").showAndWait();
            f.changeScene("../AfterLogin/MyPage.fxml", cancelBtn);   // 마이페이지 창으로 화면 전환
         } catch (IOException ex) {
            f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
         }
      }
   }
   
   // DB에 질의해서 해당 사용자의 예약 정보 TextArea에 삽입
   public void reservationInfo() {
	  String info;
      String tableNo;
      String time;
      
      try {
         f.wrtieServer("SR_" + Function.id);	// 서버로 예약정보확인용 문자열 전송
         info = f.readServer();
         
         if (info.equals("fail")) {				// 서버로부터 읽은 문자열이 "fail"일 경우
        	 reservationInfo.appendText("\n");	// 해당 사용자에게 예약 정보가 없다는 문자열을 TextArea로 append하기
        	 reservationInfo.appendText(Function.id +" 님의\n");
        	 reservationInfo.appendText("예약 정보가\n");
        	 reservationInfo.appendText("존재하지 않습니다.");
        	 reserved = false;	// 예약하지 않은 사용자
        	 cancelBtn.setDisable(true);
        	 return;
         }
         
         // 문자열이 "fail"이 아니라면 아래의 코드들 실행
         
         tableNo = info.split("_")[0];	// 서버로부터 받은 문자열
         time = info.split("_")[1];		// split해서 저장
         
         Function.table = tableNo;
         reservTime = time;
         reserved = true;	// 예약한 사용자라
         
         if (time.equals("one")) {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" 님은\n");
        	 reservationInfo.appendText(tableNo + "번 테이블의\n");
        	 reservationInfo.appendText("10시 ~ 12시에 예약하셨습니다.");
         } else if (time.equals("two")) {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" 님은\n");
        	 reservationInfo.appendText(tableNo + "번 테이블의\n");
        	 reservationInfo.appendText("12시 ~ 14시에 예약하셨습니다.");
         } else if (time.equals("three")) {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" 님은\n");
        	 reservationInfo.appendText(tableNo + "번 테이블의\n");
        	 reservationInfo.appendText("14시 ~ 16시에 예약하셨습니다.");
         } else if (time.equals("four")) {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" 님은\n");
        	 reservationInfo.appendText(tableNo + "번 테이블의\n");
        	 reservationInfo.appendText("16시 ~ 18시에 예약하셨습니다.");
         } else if (time.equals("five")) {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" 님은\n");
        	 reservationInfo.appendText(tableNo + "번 테이블의\n");
        	 reservationInfo.appendText("18시 ~ 20시에 예약하셨습니다.");
         } else {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" 님은\n");
        	 reservationInfo.appendText(tableNo + "번 테이블의\n");
        	 reservationInfo.appendText("20시 ~ 22시에 예약하셨습니다.");
         }
      } catch(IOException e) {
         f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
         reserved = false;	// 예약하지 않은 사용자 or 서버 에러
      }
   }
}