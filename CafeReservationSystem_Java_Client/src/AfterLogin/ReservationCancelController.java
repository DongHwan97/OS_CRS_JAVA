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
	
	String reservTime;
	
	@FXML ImageView back;
	
	@FXML TextField reservationInfo;
	
	@FXML Button cancelBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cancelBtn.setOnAction(event -> reservationCancel(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		back.setOnMouseExited(event -> mouseExited(event));
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		//reservationInfo();
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
		/*
		if (result.get() == ButtonType.OK) {	// Ȯ�� ��ư�� ������ ���
			// ������ ������ҿ� ���ڿ� ���� ("�޽���Ÿ��_���̵�_���̺��ȣ_�ð�");
			try {
				f.wrtieServer("Ÿ��_" + Function.id + "_" + Function.table + "_" + reservTime);
				f.popUp(AlertType.INFORMATION, "������ ��ҵǾ����ϴ�!!!", "").showAndWait();
				f.changeScene("../AfterLogin/MyPage.fxml", cancelBtn);	// ���������� â���� ȭ�� ��ȯ
			} catch (IOException ex) {
				f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
			}
		}
		*/
		f.changeScene("../AfterLogin/MyPage.fxml", cancelBtn);	// ���������� â���� ȭ�� ��ȯ
	}
	
	// DB�� �����ؼ� �ش� ������� ���� ���� TextField�� ����
	public void reservationInfo() {
		String info;
		try {
			f.wrtieServer("Ÿ��_" + Function.id);	// ������ ��������Ȯ�ο� ���ڿ� ����
			info = f.readServer();					// �����κ��� �о���� ���ڿ� info�� ����
			info.split("");							// split() �޼ҵ带 ����Ͽ� ���ڿ� ����
		} catch(IOException e) {
			f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
		}
	}
}