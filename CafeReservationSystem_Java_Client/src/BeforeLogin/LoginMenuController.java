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
import javafx.scene.control.Label;
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
	DropShadow teduri2 = new DropShadow();
	
	Color teduri = Color.web("#0022ff");
	Color green = Color.web("#00dd00");
	
	@FXML ImageView back;
	
	@FXML Button loginBtn;
	
	@FXML TextField idField;
	@FXML TextField pwField;
	
	@FXML Rectangle backBorder1;
	@FXML Rectangle backBorder2;
	
	@FXML Label idLabel;
	@FXML Label pwLabel;
	@FXML Label signLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		loginBtn.setOnAction(event -> btnClicked(event));
		
		idField.setOnAction(event -> enterPressed(event));
		pwField.setOnAction(event -> enterPressed(event));
		
		backBorder1.setOnMouseEntered(event -> mouseEntered(event));
		backBorder2.setOnMouseEntered(event -> mouseEntered(event));
		
		backBorder1.setOnMouseExited(event -> mouseExited(event));
		backBorder2.setOnMouseExited(event -> mouseExited(event));
		
		backBorder1.setOnMousePressed(event -> mousePressed(event));
		backBorder2.setOnMousePressed(event -> mousePressed(event));
		
		idLabel.setOnMouseEntered(event -> labelEntered(event));
		pwLabel.setOnMouseEntered(event -> labelEntered(event));
		signLabel.setOnMouseEntered(event -> labelEntered(event));
		
		idLabel.setOnMouseExited(event -> labelExited(event));
		pwLabel.setOnMouseExited(event -> labelExited(event));
		signLabel.setOnMouseExited(event -> labelExited(event));
		
		idLabel.setOnMousePressed(event -> labelPressed(event));
		pwLabel.setOnMousePressed(event -> labelPressed(event));
		signLabel.setOnMousePressed(event -> labelPressed(event));
		
		teduri1.setColor(teduri);
		teduri2.setColor(green);
		
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
		f.changeScene("/BeforeLogin/StartMenu.fxml", idField);
		back.setEffect(null);
	}
	
	public void labelEntered(MouseEvent e) {
		// IDã�⿡ ���콺�� �÷��� ��
		if (e.getSource() == idLabel) {
			idLabel.setEffect(teduri2);
		}
		// PWã�⿡ ���콺�� �÷��� ��
		else if (e.getSource() == pwLabel) {
			pwLabel.setEffect(teduri2);
		}
		// ȸ�����Կ� ���콺�� �÷��� ��
		else {
			signLabel.setEffect(teduri2);
		}
	}
	
	public void labelExited(MouseEvent e) {
		// IDã�⿡�� ���콺�� ������ ��
		if (e.getSource() == idLabel) {
			idLabel.setEffect(teduri1);
		}
		// PWã�⿡�� ���콺�� ������ ��
		else if (e.getSource() == pwLabel) {
			pwLabel.setEffect(teduri1);
		}
		// ȸ�����Կ��� ���콺�� ������ ��
		else {
			signLabel.setEffect(teduri1);
		}
	}

	public void labelPressed(MouseEvent e) {
		// IDã�⸦ ���콺�� ������ ��
		if (e.getSource() == idLabel) {
			f.changeScene("/BeforeLogin/Find_ID.fxml", idLabel);
			idLabel.setEffect(teduri1);
		}
		// PWã�⸦ ���콺�� ������ ��
		else if (e.getSource() == pwLabel) {
			f.changeScene("/BeforeLogin/Find_PW.fxml", pwLabel);
			idLabel.setEffect(teduri1);
		}
		// ȸ�������� ���콺�� ������ ��
		else {
			f.changeScene("/BeforeLogin/SignUp.fxml", signLabel);
			idLabel.setEffect(teduri1);
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
