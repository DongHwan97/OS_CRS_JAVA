package BeforeLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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

public class SignUpController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	boolean overlap = true;
	
	Color teduri = Color.web("#0022ff");
	
	@FXML ImageView back;
	@FXML ImageView nameImage;
	@FXML ImageView idImage;
	@FXML ImageView pwImage;
	@FXML ImageView birthImage;
	
	@FXML Button overlapBtn;
	@FXML Button checkBtn;
	
	@FXML TextField idField;
	@FXML TextField nameField;
	@FXML TextField pwField1;
	@FXML TextField pwField2;
	@FXML TextField juminField1;
	@FXML PasswordField juminField2;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		overlapBtn.setOnAction(event -> btnClicked(event));
		checkBtn.setOnAction(event -> btnClicked(event));
		
		idField.setOnAction(event -> enterPressed(event));
		nameField.setOnAction(event -> enterPressed(event));
		pwField1.setOnAction(event -> enterPressed(event));
		pwField2.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		
		back.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		nameImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/16.png")));
		idImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/11.png")));
		pwImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/6.png")));
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
	
	public void btnClicked(ActionEvent e) {
		
		// TextField�鿡�Լ� text�� ��������
		String name = nameField.getText();
		String id = idField.getText();
		String pw1 = pwField1.getText();
		String pw2 = pwField2.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();
		
		// �ߺ�Ȯ�� ��ư�� ������ ���
		if (e.getSource() == overlapBtn) {	// �̸��� ��ĭ�� ���
			if (name.equals("")) {
				f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸��� �Է����ּ���.").show();
			}
			else {	// ��ĭ�� �ƴ� ���
				// ������ �ߺ�Ȯ�ο� ���ڿ� ������ ("�޽��� Ÿ��_id")
				try {
					f.wrtieServer("CI_" + id);
					if (f.readServer().equals("false")) {
						f.popUp(AlertType.INFORMATION, "�ߺ�Ȯ�� ����!!!", "��� ������ ���̵��Դϴ�.").show();
						overlap = false;
						idField.setEditable(false);
						overlapBtn.setDisable(true);
					} else {
						f.popUp(AlertType.INFORMATION, "�ߺ�Ȯ�� ����!!!", "�̹� ����ϰ� �ִ� ���̵� �Դϴ�.").show();
						overlap = true;
					}
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
					overlap = true;
				}
			}
		}
		// Ȯ�� ��ư�� ������ ���
		else {
			// �̸��� ��ĭ�� ���
			if (name.equals("")) {
				f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸��� �Է����ּ���.").show();
			}
			// ���̵� ��ĭ�� ���
			else if (id.equals("")) {
				f.popUp(AlertType.WARNING, "���̵�� ������ �� �����ϴ�.", "���̵� �Է����ּ���.").show();
			}
			// �ߺ�Ȯ���� ���� �ʾ��� ���
			else if (overlap) {
				f.popUp(AlertType.WARNING, "���̵� �ߺ�Ȯ���� ���� �ʾҽ��ϴ�.", "�ߺ�Ȯ���� ���ּ���.").show();
			}
			// �н����尡 ��ĭ�� ���
			else if (pw1.equals("") || pw2.equals("")) {
				f.popUp(AlertType.WARNING, "�н������ ������ �� �����ϴ�.", "�н����带 �Է����ּ���.").show();
			}
			// �ֹε�Ϲ�ȣ�� ��ĭ�� ���
			else if (jumin1.equals("") || jumin2.equals("")) {
				f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� ������ �� �����ϴ�.", "�ֹε�Ϲ�ȣ�� �Է����ּ���.").show();
			}
			// �ֹε�Ϲ�ȣ �� 6�ڸ� Ȥ�� �� 7�ڸ�, ��, �ڸ����� ��Ű�� �ʾ��� ���
			else if (jumin1.length() != 6 || jumin2.length() != 7) {
				f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� �߸� �ԷµǾ����ϴ�.", "��Ȯ�� ���� �Է����ּ���.").show();
			}
			// �н������ �н����� Ȯ���� ���� �ٸ� ��
			else if (!pw1.equals(pw2)) {
				f.popUp(AlertType.WARNING, "�н����尡 �ٸ��ϴ�.", "�н����带 ��Ȯ�� �Է����ּ���.").show();
				pwField1.setText("");
				pwField2.setText("");
			}
			// ������ ��� �Է����� ���
			else {
				// �ֹε�Ϲ�ȣ getText���� integer�� �ٲپ� ���ڷθ� �̷�����ִ��� Ȯ��
				try {
					Integer.parseInt(jumin1);
					Integer.parseInt(jumin2);
				} catch (NumberFormatException e1) {	// ���ڰ� �ƴ� �͵��� ���� ��� �˾�â�� ���� ���Ͻ�Ŵ
					f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� �߸��ԷµǾ����ϴ�.", "�ٽ� �Է����ּ���.").show();
					return;
				}
				// ������ ��� �������� ��
				// ������ ȸ�����Կ� ���ڿ� ������ ("�޽��� Ÿ��_�̸�_���̵�_�н�����_�ֹε�Ϲ�ȣ")
				try {
					f.wrtieServer("MJ_" + name + "_" + id + "_" + pw1 + "_" + jumin1 + jumin2);
					f.popUp(AlertType.INFORMATION, "ȸ������ ����!!!", "�α��� ȭ������ �̵��մϴ�.").showAndWait();
					f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				}
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
			f.popUp(AlertType.WARNING, "�̸��� ������ �� �����ϴ�.", "�̸��� �Է����ּ���.").show();
		}
		// ���̵� ��ĭ�� ���
		else if (id.equals("")) {
			f.popUp(AlertType.WARNING, "���̵�� ������ �� �����ϴ�.", "���̵� �Է����ּ���.").show();
		}
		// �ߺ�Ȯ���� ���� �ʾ��� ���
		else if (overlap) {
			f.popUp(AlertType.WARNING, "���̵� �ߺ�Ȯ���� ���� �ʾҽ��ϴ�.", "�ߺ�Ȯ���� ���ּ���.").show();
		}
		// �н����尡 ��ĭ�� ���
		else if (pw1.equals("") || pw2.equals("")) {
			f.popUp(AlertType.WARNING, "�н������ ������ �� �����ϴ�.", "�н����带 �Է����ּ���.").show();
		}
		// �ֹε�Ϲ�ȣ�� ��ĭ�� ���
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� ������ �� �����ϴ�.", "�ֹε�Ϲ�ȣ�� �Է����ּ���.").show();
		}
		// �ֹε�Ϲ�ȣ �� 6�ڸ� Ȥ�� �� 7�ڸ�, ��, �ڸ����� ��Ű�� �ʾ��� ���
		else if (jumin1.length() != 6 || jumin2.length() != 7) {
			f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� �߸� �ԷµǾ����ϴ�.", "��Ȯ�� ���� �Է����ּ���.").show();
		}
		// �н������ �н����� Ȯ���� ���� �ٸ� ��
		else if (!pw1.equals(pw2)) {
			f.popUp(AlertType.WARNING, "�н����尡 �ٸ��ϴ�.", "�н����带 ��Ȯ�� �Է����ּ���.").show();
			pwField1.setText("");
			pwField2.setText("");
		}
		// ������ ��� �Է����� ���
		else {
			// �ֹε�Ϲ�ȣ getText���� integer�� �ٲپ� ���ڷθ� �̷�����ִ��� Ȯ��
			try {
				Integer.parseInt(jumin1);
				Integer.parseInt(jumin2);
			} catch (NumberFormatException e1) {	// ���ڰ� �ƴ� �͵��� ���� ��� �˾�â�� ���� ���Ͻ�Ŵ
				f.popUp(AlertType.WARNING, "�ֹε�Ϲ�ȣ�� �߸��ԷµǾ����ϴ�.", "�ٽ� �Է����ּ���.").show();
				return;
			}
			// ������ ��� �������� ��
			// ������ ȸ�����Կ� ���ڿ� ������ ("�޽��� Ÿ��_�̸�_���̵�_�н�����_�ֹε�Ϲ�ȣ")
			try {
				f.wrtieServer("MJ_" + name + "_" + id + "_" + pw1 + "_" + jumin1 + jumin2);
				f.popUp(AlertType.INFORMATION, "ȸ������ ����!!!", "�α��� ȭ������ �̵��մϴ�.").showAndWait();
				f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
			} catch(IOException ex) {
				f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
			}
		}
	}
}
