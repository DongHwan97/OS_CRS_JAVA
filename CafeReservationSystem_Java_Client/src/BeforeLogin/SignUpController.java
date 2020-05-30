package BeforeLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SignUpController implements Initializable {

	Function f = new Function();
	
	@FXML Button overlapCheckBtn;
	@FXML Button checkBtn;
	
	@FXML TextField idField;
	@FXML TextField nameField;
	@FXML TextField pwField1;
	@FXML TextField pwField2;
	@FXML TextField juminField1;
	@FXML TextField juminField2;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		overlapCheckBtn.setOnAction(event -> btnClicked(event));
		checkBtn.setOnAction(event -> btnClicked(event));
		
		idField.setOnAction(event -> enterPressed(event));
		nameField.setOnAction(event -> enterPressed(event));
		pwField1.setOnAction(event -> enterPressed(event));
		pwField2.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
	}
	
	public void btnClicked(ActionEvent e) {
		
		// TextField�鿡�Լ� text�� ��������
		String name = nameField.getText();
		String id = idField.getText();
		String pw1 = pwField1.getText();
		String pw2 = pwField2.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();
		
		// �ߺ�Ȯ�� ��ư�� ������ ���
		if (e.getSource() == overlapCheckBtn) {
			// �ߺ�Ȯ��
		}
		// Ȯ�� ��ư�� ������ ���
		else {
			// �̸��� ��ĭ�� ���
			if (name.equals("")) {
				f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸��� �Է����ּ���.");
			}
			// ���̵� ��ĭ�� ���
			else if (id.equals("")) {
				f.popUp(AlertType.WARNING, "���̵�� ������ �� �����ϴ�.", "���̵� �Է����ּ���.");
			}
			// �н����尡 ��ĭ�� ���
			else if (pw1.equals("") || pw2.equals("")) {
				f.popUp(AlertType.WARNING, "�н������ ������ �� �����ϴ�.", "�н����带 �Է����ּ���.");
			}
			// �ֹε�Ϲ�ȣ�� ��ĭ�� ���
			else if (jumin1.equals("") || jumin2.equals("")) {
				f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� ������ �� �����ϴ�.", "�ֹε�Ϲ�ȣ�� �Է����ּ���.");
			}
			// �н������ �н����� Ȯ���� ���� �ٸ� ��
			else if (!pw1.equals(pw2)) {
				f.popUp(AlertType.WARNING, "�н����尡 �ٸ��ϴ�.", "�н����带 ��Ȯ�� �Է����ּ���.");
			}
			// ������ ��� �Է����� ���
			else {
				f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
			}
		}
	}
	
	// TextField���� ���͸� �Է����� ���
	public void enterPressed(ActionEvent e) {
		
		// TextField�鿡�Լ� text�� ��������
		String name = nameField.getText();
		String id = idField.getText();
		String pw1 = pwField1.getText();
		String pw2 = pwField2.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();
		
		// �̸��� ��ĭ�� ���
		if (name.equals("")) {
			f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸��� �Է����ּ���.");
		}
		// ���̵� ��ĭ�� ���
		else if (id.equals("")) {
			f.popUp(AlertType.WARNING, "���̵�� ������ �� �����ϴ�.", "���̵� �Է����ּ���.");
		}
		// �н����尡 ��ĭ�� ���
		else if (pw1.equals("") || pw2.equals("")) {
			f.popUp(AlertType.WARNING, "�н������ ������ �� �����ϴ�.", "�н����带 �Է����ּ���.");
		}
		// �ֹε�Ϲ�ȣ�� ��ĭ�� ���
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� ������ �� �����ϴ�.", "�ֹε�Ϲ�ȣ�� �Է����ּ���.");
		}
		// �н������ �н����� Ȯ���� ���� �ٸ� ��
		else if (!pw1.equals(pw2)) {
			f.popUp(AlertType.WARNING, "�н����尡 �ٸ��ϴ�.", "�н����带 ��Ȯ�� �Է����ּ���.");
		}
		// ������ ��� �Է����� ���
		else {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
		}
	}
}
