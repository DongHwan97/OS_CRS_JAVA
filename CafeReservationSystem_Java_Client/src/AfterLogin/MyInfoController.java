package AfterLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyInfoController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff"); 
	
	@FXML ImageView back;
	@FXML ImageView nameImage;
	@FXML ImageView idImage;
	@FXML ImageView pwImage;
	@FXML ImageView birthImage;
	
	@FXML Rectangle backBorder1;
	@FXML Rectangle backBorder2;
	
	@FXML TextField nameField;
	@FXML TextField idField;
	@FXML TextField pwField;
	@FXML TextField birthField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		back.setOnMouseEntered(event -> mouseEntered(event));
		
		back.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		nameImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/16.png")));
		idImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/11.png")));
		pwImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/6.png")));
		birthImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/17.png")));
		
		showInfo();
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
		f.changeScene("/AfterLogin/MyPage.fxml", idField);
		back.setEffect(null);
	}
	
	// DB���� ȸ�� ���� �޾ƿ� �Ŀ� TextField �鿡 ����
	public void showInfo() {
		String info;
		try {
			f.wrtieServer("MP_" + Function.id);	// ������ ȸ�������� ���ڿ� ����
			//�̸�_���̵�_pw_����
			if ((info = f.readServer()).equals("fail")) {
				System.out.println("����");
			}
			//info = f.readServer();					// �����κ��� �о���� ���ڿ� info�� ����
			nameField.setText(info.split("_")[0]);		// split() �޼ҵ带 ����Ͽ� ���ڿ� ����
			idField.setText(info.split("_")[1]);
			pwField.setText(info.split("_")[2]);
			birthField.setText(info.split("_")[3]);
		} catch (IOException e) {
			f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
		}
	}
}
