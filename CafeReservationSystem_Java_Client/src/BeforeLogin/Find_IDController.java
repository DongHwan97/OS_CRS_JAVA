package BeforeLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Find_IDController implements Initializable {

	Function f = new Function();

	@FXML
	TextField nameField;
	@FXML
	TextField juminField1;
	@FXML
	TextField juminField2;

	@FXML
	Button checkBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		nameField.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
		checkBtn.setOnAction(event -> btnClicked(event));
	}

	public void enterPressed(ActionEvent e) {

		// TextField�鿡�Լ� text �� ��������
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();

		// �̸��� ��ĭ�̸�
		if (name.equals("")) {
			f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸��� �Է����ּ���.");
		}
		// �ֹε�Ϲ�ȣ�� ��ĭ�̸�
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� ������ �� �����ϴ�.", "�ֹε�Ϲ�ȣ�� �Է����ּ���.");
		}
		// ������ ��� �Է����� ���
		else {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", nameField);
		}
	}

	public void btnClicked(ActionEvent e) {
		// TextField�鿡�Լ� text �� ��������
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();

		// �̸��� ��ĭ�̸�
		if (name.equals("")) {
			f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸��� �Է����ּ���.");
		}
		// �ֹε�Ϲ�ȣ�� ��ĭ�̸�
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� ������ �� �����ϴ�.", "�ֹε�Ϲ�ȣ�� �Է����ּ���.");
		}
		// ������ ��� �Է����� ���
		else {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", nameField);
		}
	}
}
