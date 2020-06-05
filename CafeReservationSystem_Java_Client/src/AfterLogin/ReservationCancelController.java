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
	
	// �ڷΰ��� �̹����� ���콺�� ������ ��
	public void mouseEntered(MouseEvent e) {
		back.setEffect(teduri1);
	}
	// �ڷΰ��� �̹������� ���콺�� ������ ��
	public void mouseExited(MouseEvent e) {
		back.setEffect(null);
	}
	// �ڷΰ��� �̹����� Ŭ������ ��
	public void mousePressed(MouseEvent e) {
		f.changeScene("../AfterLogin/MyPage.fxml", cancelBtn);
		back.setEffect(null);
	}
	// ���� ��� ��ư�� ������ ��
	public void reservationCancel(ActionEvent e) {
		Optional<ButtonType> result = f.popUp(AlertType.CONFIRMATION, "������ ����Ͻðڽ��ϱ�?", "").showAndWait();
		if (result.get() == ButtonType.OK) {	// Ȯ�� ��ư�� ������ ���
			// DB ����Ʈ 
			// DB ����Ʈ�� �� �о����
		}
	}
}