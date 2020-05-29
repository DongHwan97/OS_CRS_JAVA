package application;


import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static Socket socket;
	
	@Override
	public void start(Stage primaryStage) {
		/*
		try {
			socket = new Socket("192.168.219.128", 7875);
		} catch (IOException e) {
			System.out.println("Server is not opened");
		}
		*/
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/BeforeLogin/StartMenu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("�ٿ� Cafe ���� �ý���");
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