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

//기능 클래스
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
			System.out.println("IOException이래");
		}
	}
	
	public String readServer() throws IOException {
		return dataInStream.readUTF();
	}
	public void wrtieServer(String msg) throws IOException {
		dataOutStream.writeUTF(msg);
	}

	//프레임의 장면을 바꿔주는 메소드
	public void changeScene(String string, Control object) {
		try {
			// SignUp_2.fxml의 Scene 가져오기
			Parent parent = FXMLLoader.load(getClass().getResource(string));
			Scene scene = new Scene(parent);
			// object의 윈도우 가져오기
			Stage primaryStage = (Stage) object.getScene().getWindow();
			primaryStage.setScene(scene); // 현재 윈도우를 string의 Scene으로 덮어쓰기
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	} 
}
