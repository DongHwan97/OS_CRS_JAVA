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
		
		if (e.getSource() == myPageBtn) {	// ���������� ��ư Ŭ�� ��
			result = f.popUp(AlertType.CONFIRMATION, "������������ �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư Ŭ���� �̵��մϴ�.").showAndWait(); // �˾�â ����
			if (result.get() == ButtonType.OK) {	// �˾�â���� 'OK' ��ư Ŭ����
				f.changeScene("/AfterLogin/MyPage.fxml", myPageBtn);	// ������������ ȭ�� ��ȯ
			}
		} else if (e.getSource() == firstTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'10�� ~ 12��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB�� ���� ����
			}
		} else if (e.getSource() == secondTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'12�� ~ 14��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB�� ���� ����
			}
		} else if (e.getSource() == thirdTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'14�� ~ 16��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB�� ���� ����
			}
		} else if (e.getSource() == fourthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'16�� ~ 18��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB�� ���� ����
			}
		} else if (e.getSource() == fifthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'18�� ~ 20��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB�� ���� ����
			}
		} else {
			result = f.popUp(AlertType.CONFIRMATION, "'20�� ~ 22��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// DB�� ���� ����
			}
		}
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
		f.changeScene("/AfterLogin/CafeTables.fxml", myPageBtn);
		back.setEffect(null);
	}
}