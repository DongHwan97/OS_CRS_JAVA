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
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LoginMenuController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	DropShadow teduri2 = new DropShadow();
	
	Color teduri = Color.web("#0022ff");
	
	@FXML Button loginBtn;
	
	@FXML TextField idField;
	@FXML TextField pwField;
	
	@FXML Rectangle backBorder1;
	@FXML Rectangle backBorder2;

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
		backBorder2.setOnMouseExited(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		teduri2.setColor(teduri);
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		backBorder1.setEffect(teduri1);
	}
	
	public void mousePressed(MouseEvent e) {
		
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
