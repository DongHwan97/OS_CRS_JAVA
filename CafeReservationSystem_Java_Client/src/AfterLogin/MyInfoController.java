package AfterLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyInfoController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff"); 
	
	@FXML ImageView back;
	@FXML ImageView nameImage;
	@FXML ImageView idImage;
	@FXML ImageView pwImage;
	@FXML ImageView birthImage;
	
	@FXML Rectangle backBorder1;
	@FXML Rectangle backBorder2;
	
	@FXML TextField nameField;
	@FXML TextField idField;
	@FXML TextField pwField;
	@FXML TextField birthField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		back.setOnMouseEntered(event -> mouseEntered(event));
		
		back.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		nameImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/16.png")));
		idImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/11.png")));
		pwImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/6.png")));
		birthImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/17.png")));
		
		showInfo();
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
		f.changeScene("/AfterLogin/MyPage.fxml", idField);
		back.setEffect(null);
	}
	
	// DB에서 회원 정보 받아온 후에 TextField 들에 삽입
	public void showInfo() {
		String info;
		try {
			f.wrtieServer("MP_" + Function.id);	// 서버로 회원정보용 문자열 전송
			//이름_아이디_pw_생일
			if ((info = f.readServer()).equals("fail")) {
				System.out.println("고쳐");
			}
			//info = f.readServer();					// 서버로부터 읽어들인 문자열 info에 저장
			nameField.setText(info.split("_")[0]);		// split() 메소드를 사용하여 문자열 분해
			idField.setText(info.split("_")[1]);
			pwField.setText(info.split("_")[2]);
			birthField.setText(info.split("_")[3]);
		} catch (IOException e) {
			f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
		}
	}
}
