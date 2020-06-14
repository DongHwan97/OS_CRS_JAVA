package BeforeLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
	@FXML ImageView nameImage;
	@FXML ImageView idImage;
	@FXML ImageView birthImage;

	@FXML Button checkBtn;

	@FXML TextField idField;
	@FXML TextField nameField;
	@FXML TextField juminField1;
	@FXML PasswordField juminField2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		checkBtn.setOnAction(event -> btnClicked(event));
		idField.setOnAction(event -> enterPressed(event));
		nameField.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		
		back.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		nameImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/16.png")));
		idImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/11.png")));
		birthImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/17.png")));
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
		
		String pw;

		// ���̵� ��ĭ�� ���
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "���̵�� ������ �� �����ϴ�.", "���̵� �Է����ּ���.").show();
		}
		// �̸��� ��ĭ�� ���
		else if (name.equals("")) {
			f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸� �Է����ּ���.").show();
		}
		// �ֹε�Ϲ�ȣ�� ��ĭ�� ���
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� ������ �� �����ϴ�.", "�ֹε�Ϲ�ȣ�� �Է����ּ���.").show();
		}
		// ������ ��� �Է����� ���
		else {
			// ������ ��й�ȣ ã��� ���ڿ� ���� ("�޽���Ÿ��_�̸�_���̵�_�ֹε�Ϲ�ȣ")
			try {
				f.wrtieServer("FP_" + name + "_" + id + "_" + jumin1 + jumin2);
				// (�����κ��� �о���� ���ڿ� = pw)
				if ((pw = f.readServer()).equals("fail")) {	// �о���� ���ڿ��� fail �̸�
					f.popUp(AlertType.WARNING, "�ش� ȸ���� �������� �ʽ��ϴ�!!!", "�ٽ� �Է����ֽñ� �ٶ��ϴ�.").show();
				} else if (pw.equals(null)) {	// �о���� ���ڿ��� null �̸�
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				} else {	// �о���� ���ڿ��� ����pw�̸�
					f.popUp(AlertType.INFORMATION, "�Է��Ͻ� ������ �ش��ϴ� ��й�ȣ��", pw + " �Դϴ�!!!").showAndWait();
					f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
				}
			} catch(IOException ex) {
				f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
			}
			//f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
		}
	}

	// TextField���� ���͸� ĥ ���
	public void enterPressed(ActionEvent e) {
		// TextField�鿡�Լ� text�� ��������
		String id = idField.getText();
		String name = nameField.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();
		
		String pw;

		// ���̵� ��ĭ�� ���
		if (id.equals("")) {
			f.popUp(AlertType.WARNING, "���̵�� ������ �� �����ϴ�.", "���̵� �Է����ּ���.").show();
		}
		// �̸��� ��ĭ�� ���
		else if (name.equals("")) {
			f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸� �Է����ּ���.").show();
		}
		// �ֹε�Ϲ�ȣ�� ��ĭ�� ���
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� ������ �� �����ϴ�.", "�ֹε�Ϲ�ȣ�� �Է����ּ���.").show();
		}
		// ������ ��� �Է����� ���
		else {
			// ������ ��й�ȣ ã��� ���ڿ� ���� ("�޽���Ÿ��_�̸�_���̵�_�ֹε�Ϲ�ȣ")
			try {
				f.wrtieServer("FP_" + name + "_" + id + "_" + jumin1 + jumin2);
				// (�����κ��� �о���� ���ڿ� = pw)
				if ((pw = f.readServer()).equals("fail")) {	// �о���� ���ڿ��� fail �̸�
					f.popUp(AlertType.WARNING, "�ش� ȸ���� �������� �ʽ��ϴ�!!!", "�ٽ� �Է����ֽñ� �ٶ��ϴ�.").show();
				} else if (pw.equals(null)) {	// �о���� ���ڿ��� null �̸�
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				} else {	// �о���� ���ڿ��� ����pw�̸�
					f.popUp(AlertType.INFORMATION, "�Է��Ͻ� ������ �ش��ϴ� ��й�ȣ��", pw + " �Դϴ�!!!").showAndWait();
					f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
				}
			} catch(IOException ex) {
				f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
			}
			//f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
		}
	}
}
