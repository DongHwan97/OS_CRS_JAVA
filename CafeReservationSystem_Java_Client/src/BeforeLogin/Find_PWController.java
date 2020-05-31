package BeforeLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert.AlertType;

public class Find_PWController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff"); 
	
	@FXML ImageView back; 
	
	@FXML Rectangle backBorder1;
	@FXML Rectangle backBorder2;

	@FXML Button checkBtn;

	@FXML TextField idField;
	@FXML TextField nameField;
	@FXML TextField juminField1;
	@FXML TextField juminField2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		checkBtn.setOnAction(event -> btnClicked(event));
		idField.setOnAction(event -> enterPressed(event));
		nameField.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
		
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
		f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
		back.setEffect(null);
	}

	// Ȯ�� ��ư�� ������ ��
	public void btnClicked(ActionEvent e) {
		// TextField�鿡�Լ� text�� ��������
		String id = idField.getText();
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();

		// ���̵� ��ĭ�� ���
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "���̵�� ������ �� �����ϴ�.", "���̵� �Է����ּ���.");
		}
		// �̸��� ��ĭ�� ���
		else if (name.equals("")) {
			f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸� �Է����ּ���.");
		}
		// �ֹε�Ϲ�ȣ�� ��ĭ�� ���
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� ������ �� �����ϴ�.", "�ֹε�Ϲ�ȣ�� �Է����ּ���.");
		}
		// ������ ��� �Է����� ���
		else {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
			//DB�� �����ϱ�
		}
	}

	// TextField���� ���͸� ĥ ���
	public void enterPressed(ActionEvent e) {
		// TextField�鿡�Լ� text�� ��������
		String id = idField.getText();
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();

		// ���̵� ��ĭ�� ���
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "���̵�� ������ �� �����ϴ�.", "���̵� �Է����ּ���.");
		}
		// �̸��� ��ĭ�� ���
		else if (name.equals("")) {
			f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸� �Է����ּ���.");
		}
		// �ֹε�Ϲ�ȣ�� ��ĭ�� ���
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� ������ �� �����ϴ�.", "�ֹε�Ϲ�ȣ�� �Է����ּ���.");
		}
		// ������ ��� �Է����� ���
		else {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
			//DB�� �����ϱ�
		}
	}
}
