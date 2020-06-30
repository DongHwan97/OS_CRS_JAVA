package BeforeLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Find_IDController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff"); 
	
	@FXML ImageView back;
	@FXML ImageView nameImage;
	@FXML ImageView birthImage;

	@FXML
	TextField nameField;
	@FXML
	TextField juminField1;
	@FXML
	PasswordField juminField2;

	@FXML
	Button checkBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		nameField.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
		checkBtn.setOnAction(event -> btnClicked(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		
		back.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("/Pictures/backBtn.png")));
		nameImage.setImage(new Image(getClass().getResourceAsStream("/Pictures/16.png")));
		birthImage.setImage(new Image(getClass().getResourceAsStream("/Pictures/17.png")));
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
		f.changeScene("/BeforeLogin/LoginMenu.fxml", nameField);
		back.setEffect(null);
	}

	public void enterPressed(ActionEvent e) {

		// TextField들에게서 text 값 가져오기
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();
		
		String id;

		// 이름이 빈칸이면
		if (name.equals("")) {
			f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름을 입력해주세요.").show();
		}
		// 주민등록번호가 빈칸이면
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "주민등록번호는 공백일 수 없습니다.", "주민등록번호는 입력해주세요.").show();
		}
		// 정보를 모두 입력했을 경우
		else {
			// 서버로 아이디 찾기용 문자열 전송 ("메시지타입_이름_주민등록번호")
			
			try {
				f.wrtieServer("FI_" + name + "_" + jumin1 + jumin2);
				// (서버로부터 읽어들인 문자열 = id)
				if ((id = f.readServer()).equals("fail")) {	// 읽어들인 문자열이 fail 이면
					f.popUp(AlertType.WARNING, "아이디가 존재하지 않습니다!!!", "다시 입력해주시기 바랍니다.").show();
				} else if (id.equals(null)) {	// 읽어들인 문자열이 null 이면
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				} else {	// 읽어들인 문자열이 정상id이면
					f.popUp(AlertType.INFORMATION, "입력하신 정보에 해당하는 아이디는", id + " 입니다!!!").showAndWait();
					f.changeScene("/BeforeLogin/LoginMenu.fxml", nameField);
				}
			} catch(IOException ex) {
				f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
			}
		}
	}

	public void btnClicked(ActionEvent e) {
		// TextField들에게서 text 값 가져오기
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();

		String id;
		
		// 이름이 빈칸이면
		if (name.equals("")) {
			f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름을 입력해주세요.").show();
		}
		// 주민등록번호가 빈칸이면
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "주민등록번호는 공백일 수 없습니다.", "주민등록번호는 입력해주세요.").show();
		}
		// 정보를 모두 입력했을 경우
		else {
			// 서버로 아이디 찾기용 문자열 전송 ("메시지타입_이름_주민등록번호")
			
			try {
				f.wrtieServer("FI_" + name + "_" + jumin1 + jumin2);
				// (서버로부터 읽어들인 문자열 = id)
				if ((id = f.readServer()).equals("fail")) {	// 읽어들인 문자열이 fail 이면
					f.popUp(AlertType.WARNING, "아이디가 존재하지 않습니다!!", "다시 입력해주시기 바랍니다.").show();
				} else if (id.equals(null)) {	// 읽어들인 문자열이 null 이면
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				} else {	// 읽어들인 문자열이 정상id이면
					f.popUp(AlertType.INFORMATION, "입력하신 정보에 해당하는 아이디는", id + " 입니다!!!").showAndWait();
					f.changeScene("/BeforeLogin/LoginMenu.fxml", nameField);
				}
			} catch(IOException ex) {
				f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
			}
		}
	}
}
