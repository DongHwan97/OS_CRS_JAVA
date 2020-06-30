package AfterLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CafeMenuController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff"); 
	
	@FXML Label label;
	
	@FXML ImageView back;
	@FXML ImageView image_1;
	@FXML ImageView image_2;
	@FXML ImageView image_3;
	@FXML ImageView image_4;
	@FXML ImageView image_5;
	@FXML ImageView image_6;
	@FXML ImageView image_7;
	@FXML ImageView image_8;
	@FXML ImageView image_9;
	@FXML ImageView image_10;
	@FXML ImageView image_11;
	@FXML ImageView image_12;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		back.setOnMouseExited(event -> mouseExited(event));
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("/Pictures/backBtn.png")));
		image_1.setImage(new Image(getClass().getResourceAsStream("/Pictures/americano.jpg")));
		image_2.setImage(new Image(getClass().getResourceAsStream("/Pictures/latte.jpg")));
		image_3.setImage(new Image(getClass().getResourceAsStream("/Pictures/caramel.jpg")));
		image_4.setImage(new Image(getClass().getResourceAsStream("/Pictures/greentea.jpg")));
		image_5.setImage(new Image(getClass().getResourceAsStream("/Pictures/strawberry.jpg")));
		image_6.setImage(new Image(getClass().getResourceAsStream("/Pictures/banana.jpg")));
		image_7.setImage(new Image(getClass().getResourceAsStream("/Pictures/icetea.jpg")));
		image_8.setImage(new Image(getClass().getResourceAsStream("/Pictures/lemon.jpg")));
		image_9.setImage(new Image(getClass().getResourceAsStream("/Pictures/cake.jpg")));
		image_10.setImage(new Image(getClass().getResourceAsStream("/Pictures/bread.jpg")));
		image_11.setImage(new Image(getClass().getResourceAsStream("/Pictures/sandwich.jpg")));
		image_12.setImage(new Image(getClass().getResourceAsStream("/Pictures/cookie.jpeg")));
	}

	// 뒤로가기 이미지에 마우스가 들어왔을 때
	public void mouseEntered(MouseEvent e) {
		back.setEffect(teduri1);
	}
	// 뒤로가기 이미지에서 마우스가 나갔을 때
	public void mouseExited(MouseEvent e) {
		back.setEffect(null);
	}
	// 뒤로가기 이미지를 클릭했을 때
	public void mousePressed(MouseEvent e) {
		f.changeScene("/AfterLogin/MainMenu.fxml", label);
		back.setEffect(null);
	}
}
