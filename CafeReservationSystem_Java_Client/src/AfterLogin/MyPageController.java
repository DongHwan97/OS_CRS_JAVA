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
		f.changeScene("/AfterLogin/MainMenu.fxml", logoutBtn);
		back.setEffect(null);
	}
		
	public void btnClicked(ActionEvent e) {
		// �α׾ƿ� ��ư�� ������ ��
		if (e.getSource() == logoutBtn) {
			// �˾�â ����ֱ�
			Optional<ButtonType> result = f.popUp(AlertType.CONFIRMATION, "�α׾ƿ��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� �α׾ƿ� �˴ϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {							// �˾�â���� Ȯ�� ��ư Ŭ����
				f.changeScene("/BeforeLogin/LoginMenu.fxml", logoutBtn);	// �α��θ޴��� �̵� = �α׾ƿ� ��Ű��
			}
		}
		// ȸ������ Ȯ�� ��ư�� ������ ��
		else if (e.getSource() == myInfoBtn) {
			f.changeScene("../AfterLogin/MyInfo.fxml", myInfoBtn);	// ȸ������ â���� ȭ�� ��ȯ
		}
		// ���� Ȯ�� �� ��� ��ư�� ������ ��
		else {
			f.changeScene("../AfterLogin/ReservationCancel.fxml", reservationBtn);	// ���� â���� ȭ�� ��ȯ
		}
	}
}
