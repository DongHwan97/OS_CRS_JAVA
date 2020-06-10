package BeforeLogin;

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LoginMenuController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff");
	
	@FXML ImageView back;
	@FXML ImageView pwImage;
	@FXML ImageView idImage;
	
	@FXML Button loginBtn;
	
	@FXML TextField idField;
	@FXML PasswordField pwField;
	
	@FXML Label findPW;
	@FXML Label findID;
	@FXML Label signUp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		loginBtn.setOnAction(event -> btnClicked(event));
		
		idField.setOnAction(event -> enterPressed(event));
		pwField.setOnAction(event -> enterPressed(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		
		back.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		
		findPW.setOnMouseEntered(event -> labelEntered(event));
		findID.setOnMouseEntered(event -> labelEntered(event));
		signUp.setOnMouseEntered(event -> labelEntered(event));
		
		findPW.setOnMouseExited(event -> labelExited(event));
		findID.setOnMouseExited(event -> labelExited(event));
		signUp.setOnMouseExited(event -> labelExited(event));
		
		findPW.setOnMousePressed(event -> labelPressed(event));
		findID.setOnMousePressed(event -> labelPressed(event));
		signUp.setOnMousePressed(event -> labelPressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		pwImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/6.png")));
		idImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/11.png")));
		
		
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
		f.changeScene("/BeforeLogin/StartMenu.fxml", idField);
		back.setEffect(null);
	}
	
	public void labelEntered(MouseEvent e) {
		// IDã�⿡ ���콺�� �÷��� ��
		if (e.getSource() == findID) {
			findID.setEffect(teduri1);
		}
		// PWã�⿡ ���콺�� �÷��� ��
		else if (e.getSource() == findPW) {
			findPW.setEffect(teduri1);
		}
		// ȸ�����Կ� ���콺�� �÷��� ��
		else {
			signUp.setEffect(teduri1);
		}
	}
	
	public void labelExited(MouseEvent e) {
		// IDã�⿡�� ���콺�� ������ ��
		if (e.getSource() == findID) {
			findID.setEffect(null);
		}
		// PWã�⿡�� ���콺�� ������ ��
		else if (e.getSource() == findPW) {
			findPW.setEffect(null);
		}
		// ȸ�����Կ��� ���콺�� ������ ��
		else {
			signUp.setEffect(null);
		}
	}

	public void labelPressed(MouseEvent e) {
		
		Optional<ButtonType> result;
		
		// IDã�⸦ ���콺�� ������ ��
		if (e.getSource() == findID) {
			result = f.popUp(AlertType.CONFIRMATION, "'ID ã��' ȭ������ �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� IDã�� ȭ������ �̵��մϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("/BeforeLogin/Find_ID.fxml", signUp);
			}
			findID.setEffect(teduri1);
		}
		// PWã�⸦ ���콺�� ������ ��
		else if (e.getSource() == findPW) {
			result = f.popUp(AlertType.CONFIRMATION, "'PW ã��' ȭ������ �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� PWã�� ȭ������ �̵��մϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("/BeforeLogin/Find_PW.fxml", signUp);
			}
			findPW.setEffect(teduri1);
		}
		// ȸ�������� ���콺�� ������ ��
		else {
			result = f.popUp(AlertType.CONFIRMATION, "'ȸ������' ȭ������ �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� ȸ������ ȭ������ �̵��մϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("/BeforeLogin/SignUp.fxml", signUp);
			}
			signUp.setEffect(teduri1);
		}
	}

	public void btnClicked(ActionEvent e) {
		// idField�� text ��������
		String id = idField.getText();
		// pwField�� text ��������
		String pw = pwField.getText();

		// ���̵� ��й�ȣ �Է� ĭ�� ��ĭ�� ���
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "���̵�� ��ĭ�� �� �����ϴ�.", "���̵� �Է����ּ���.").show();
		} else if (pw.equals("")) {
			f.popUp(AlertType.WARNING, "�н������ ��ĭ�� �� �����ϴ�.", "�н����带 �Է����ּ���.").show();
		}
		// TextField�� ID, PW�� �Է��Ͽ��� ���
		else {
			f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			//DB�� ����
			/*
			 * if ((f.sdb.login("S:" + id + "/" + pw).equals("exist"))) {
			 * f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			 * JOptionPane.showMessageDialog(null, "���ӹ����� �����մϴ�", "Message",
			 * JOptionPane.INFORMATION_MESSAGE); try { data.writeUTF("S: + _id + / pw"); }
			 * catch (IOException e1) { e1.printStackTrace(); } }
			 */
		}
	}

	public void enterPressed(ActionEvent e) {
		// idField�� ��������
		String id = idField.getText();
		// pwField�� ��������
		String pw = pwField.getText();

		// ���̵� ��й�ȣ �Է� ĭ�� ��ĭ�� ���
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "���̵�� ��ĭ�� �� �����ϴ�.", "���̵� �Է����ּ���.").show();
		} else if (pw.equals("")) {
			f.popUp(AlertType.WARNING, "�н������ ��ĭ�� �� �����ϴ�.", "�н����带 �Է����ּ���.").show();
		}
		// TextField�� ID, PW�� �Է��Ͽ��� ���
		else {
			f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			//DB�� ����
			/*
			 * if ((f.sdb.login("S:" + id + "/" + pw).equals("exist"))) {
			 * f.changeScene("../AfterLogin/MainMenu.fxml", pwField);
			 * JOptionPane.showMessageDialog(null, "���ӹ����� �����մϴ�", "Message",
			 * JOptionPane.INFORMATION_MESSAGE); try { data.writeUTF("S: + _id + / pw"); }
			 * catch (IOException e1) { e1.printStackTrace(); } }
			 */
		}
	}
}
