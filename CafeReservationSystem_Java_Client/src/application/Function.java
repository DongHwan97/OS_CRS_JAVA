package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import javafx.css.Style;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Control;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//��� Ŭ����
public class Function {
	Socket socket = Main.socket;
	OutputStream outStream;
	InputStream inStream;
	DataOutputStream dataOutStream;
	DataInputStream dataInStream;
	
	public static String id;	// ȸ���� ���̵� �� static ������ ����
	public static int table;
	
	public Function() {
		try {
			inStream = socket.getInputStream();
			dataInStream = new DataInputStream(inStream);
			outStream = socket.getOutputStream();
			dataOutStream = new DataOutputStream(outStream);
		} catch	(IOException e) {
			popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
		}
	}
	
	public String readServer() throws IOException {
		String msg = null;
		try {
			msg = dataInStream.readUTF();
		} catch(SocketException e) {
			popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
		}
		return msg;
	}
	public void wrtieServer(String msg) throws IOException {
		try {
			dataOutStream.writeUTF(msg);
		} catch(SocketException e) {
			popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
		}
	}

	//�������� Scene�� �ٲ��ִ� �޼ҵ�
	public void changeScene(String string, Control object) {
		
		try {
			// string�� Scene ��������
			Parent parent = FXMLLoader.load(getClass().getResource(string));
			Scene scene = new Scene(parent);
			// object�� ������ ��������
			Stage primaryStage = (Stage) object.getScene().getWindow();
			primaryStage.setScene(scene); // ���� �����츦 string�� Scene���� �����
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	//�˾�â�� ����ִ� �޼ҵ�
	public Alert popUp(AlertType type, String headerText, String contentText) {
		
		Alert a = new Alert(type);			// �Ķ���� ���� (type������ �˾�â ���� (ex.���â ��))
		a.setTitle("�ٿ� Cafe ���� �ý���");		// �˾�â�� Ÿ��Ʋ ����
		a.setHeaderText(headerText);		// �Ķ���� ���� (���� text)
		a.setContentText(contentText);		// �Ķ���� ���� (���� ���� ��)
		a.initStyle(StageStyle.TRANSPARENT);// �˾�â�� ��Ÿ�� ����
		
		return a;
	}
}