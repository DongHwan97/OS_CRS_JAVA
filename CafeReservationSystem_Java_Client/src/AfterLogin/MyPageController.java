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
			if (result.get() == ButtonType.OK) {						// �˾�â���� Ȯ�� ��ư Ŭ����
				f.changeScene("/BeforeLogin/LoginMenu.fxml", logoutBtn);	// �α��θ޴��� �̵� = �α׾ƿ� ��Ű��
			}
		}
		// ȸ������ Ȯ�� ��ư�� ������ ��
		else if (e.getSource() == myInfoBtn) {
			
			Optional<ButtonType> result = f.popUp(AlertType.CONFIRMATION, "ȸ������ Ȯ�� ȭ������ �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� �̵��մϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {						// �˾�â���� Ȯ�� ��ư Ŭ����
				f.changeScene("../AfterLogin/MyInfo.fxml", myInfoBtn);	// ȸ������ Ȯ�� â���� ȭ�� ��ȯ
			}
		}
		// ���� Ȯ�� �� ��� ��ư�� ������ ��
		else {
			Optional<ButtonType> result = f.popUp(AlertType.CONFIRMATION, "���� Ȯ�� ȭ������ �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� �̵��մϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {						// �˾�â���� Ȯ�� ��ư Ŭ����
				f.changeScene("../AfterLogin/ReservationCancel.fxml", reservationBtn);	// ���� â���� ȭ�� ��ȯ
			}
		}
	}
}
