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

//기능 클래스
public class Function {
	Socket socket = Main.socket;
	OutputStream outStream;
	InputStream inStream;
	DataOutputStream dataOutStream;
	DataInputStream dataInStream;
	
	public static String id;	// 회원의 아이디 값 static 변수로 제어
	public static int table;
	
	public Function() {
		try {
			inStream = socket.getInputStream();
			dataInStream = new DataInputStream(inStream);
			outStream = socket.getOutputStream();
			dataOutStream = new DataOutputStream(outStream);
		} catch	(IOException e) {
			popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
		}
	}
	
	public String readServer() throws IOException {
		String msg = null;
		try {
			msg = dataInStream.readUTF();
		} catch(SocketException e) {
			popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
		}
		return msg;
	}
	public void wrtieServer(String msg) throws IOException {
		try {
			dataOutStream.writeUTF(msg);
		} catch(SocketException e) {
			popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
		}
	}

	//윈도우의 Scene을 바꿔주는 메소드
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
		a.initStyle(StageStyle.TRANSPARENT);// 팝업창의 스타일 설정
		
		return a;
	}
}