package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

//��� Ŭ����
public class Function {
	Socket socket = Main.socket;
	OutputStream outStream;
	InputStream inStream;
	DataOutputStream dataOutStream;
	DataInputStream dataInStream;
	
	public SelectSQL sdb = new SelectSQL();
	public InsertSQL idb = new InsertSQL();
	
	public Function() {
		try {
			inStream = socket.getInputStream();
			dataInStream = new DataInputStream(inStream);
			outStream = socket.getOutputStream();
			dataOutStream = new DataOutputStream(outStream);
		} catch	(IOException e) {
			System.out.println("IOException�̷�");
		}
	}
	
	public String readServer() throws IOException {
		return dataInStream.readUTF();
	}
	public void wrtieServer(String msg) throws IOException {
		dataOutStream.writeUTF(msg);
	}

	//�������� ����� �ٲ��ִ� �޼ҵ�
	public void changeScene(String string, Control object) {
		try {
			// SignUp_2.fxml�� Scene ��������
			Parent parent = FXMLLoader.load(getClass().getResource(string));
			Scene scene = new Scene(parent);
			// object�� ������ ��������
			Stage primaryStage = (Stage) object.getScene().getWindow();
			primaryStage.setScene(scene); // ���� �����츦 string�� Scene���� �����
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	} 
}
