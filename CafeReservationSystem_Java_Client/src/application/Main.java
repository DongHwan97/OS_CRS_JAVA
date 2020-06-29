package application;

import java.io.IOException;
import java.net.Socket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
	public static Socket socket;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			socket = new Socket("192.168.0.19", 7908);
		} catch (IOException e) {
			System.out.println("서버 연결 에러");
			System.exit(0);
		}
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/BeforeLogin/StartMenu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("다온 Cafe 예약 시스템");
			primaryStage.getIcons().add(new Image("/Pictures/favicon.png"));
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
