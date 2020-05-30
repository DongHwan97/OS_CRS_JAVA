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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		/*
		try {
			inStream = socket.getInputStream();
			dataInStream = new DataInputStream(inStream);
			outStream = socket.getOutputStream();
			dataOutStream = new DataOutputStream(outStream);
		} catch	(IOException e) {
			System.out.println("IOException이래");
		}
		*/
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
			// string의 Scene 가져오기
			Parent parent = FXMLLoader.load(getClass().getResource(string));
			Scene scene = new Scene(parent);
			// object의 윈도우 가져오기
			Stage primaryStage = (Stage) object.getScene().getWindow();
			primaryStage.setScene(scene); // 현재 윈도우를 string의 Scene으로 덮어쓰기
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	//팝업창을 띄워주는 메소드
	public Alert popUp(AlertType type, String headerText, String contentText) {
		
		Alert a = new Alert(type);			// 파라미터 삽입 (type형태의 팝업창 생성 (ex.경고창 등))
		a.setTitle("다온 Cafe 예약 시스템");		// 팝업창의 타이틀 설정
		a.setHeaderText(headerText);		// 파라미터 삽입 (메인 text)
		a.setContentText(contentText);		// 파라미터 삽입 (작은 설명 글)
		
		return a;
	}
}
