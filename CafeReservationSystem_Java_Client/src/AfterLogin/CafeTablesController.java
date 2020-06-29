package AfterLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CafeTablesController implements Initializable {
	
	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	Color teduri = Color.web("#0022ff");
	
	@FXML Label label;
	
	@FXML ImageView back;
	
	@FXML ImageView tableNo_1;
	@FXML ImageView tableNo_2;
	@FXML ImageView tableNo_3;
	@FXML ImageView tableNo_4;
	@FXML ImageView tableNo_5;
	@FXML ImageView tableNo_6;
	@FXML ImageView tableNo_7;
	@FXML ImageView tableNo_8;
	@FXML ImageView tableNo_9;
	@FXML ImageView tableNo_10;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		tableNo_1.setOnMouseEntered(event -> mouseEntered(event));
		tableNo_2.setOnMouseEntered(event -> mouseEntered(event));
		tableNo_3.setOnMouseEntered(event -> mouseEntered(event));
		tableNo_4.setOnMouseEntered(event -> mouseEntered(event));
		tableNo_5.setOnMouseEntered(event -> mouseEntered(event));
		tableNo_6.setOnMouseEntered(event -> mouseEntered(event));
		tableNo_7.setOnMouseEntered(event -> mouseEntered(event));
		tableNo_8.setOnMouseEntered(event -> mouseEntered(event));
		tableNo_9.setOnMouseEntered(event -> mouseEntered(event));
		tableNo_10.setOnMouseEntered(event -> mouseEntered(event));
		
		back.setOnMouseExited(event -> mouseExited(event));
		tableNo_1.setOnMouseExited(event -> mouseExited(event));
		tableNo_2.setOnMouseExited(event -> mouseExited(event));
		tableNo_3.setOnMouseExited(event -> mouseExited(event));
		tableNo_4.setOnMouseExited(event -> mouseExited(event));
		tableNo_5.setOnMouseExited(event -> mouseExited(event));
		tableNo_6.setOnMouseExited(event -> mouseExited(event));
		tableNo_7.setOnMouseExited(event -> mouseExited(event));
		tableNo_8.setOnMouseExited(event -> mouseExited(event));
		tableNo_9.setOnMouseExited(event -> mouseExited(event));
		tableNo_10.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		tableNo_1.setOnMousePressed(event -> mousePressed(event));
		tableNo_2.setOnMousePressed(event -> mousePressed(event));
		tableNo_3.setOnMousePressed(event -> mousePressed(event));
		tableNo_4.setOnMousePressed(event -> mousePressed(event));
		tableNo_5.setOnMousePressed(event -> mousePressed(event));
		tableNo_6.setOnMousePressed(event -> mousePressed(event));
		tableNo_7.setOnMousePressed(event -> mousePressed(event));
		tableNo_8.setOnMousePressed(event -> mousePressed(event));
		tableNo_9.setOnMousePressed(event -> mousePressed(event));
		tableNo_10.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		tableNo_1.setImage(new Image(getClass().getResourceAsStream("../Pictures/111.jpg")));
		tableNo_2.setImage(new Image(getClass().getResourceAsStream("../Pictures/222.jpg")));
		tableNo_3.setImage(new Image(getClass().getResourceAsStream("../Pictures/333.jpg")));
		tableNo_4.setImage(new Image(getClass().getResourceAsStream("../Pictures/444.jpg")));
		tableNo_5.setImage(new Image(getClass().getResourceAsStream("../Pictures/555.jpg")));
		tableNo_6.setImage(new Image(getClass().getResourceAsStream("../Pictures/666.jpg")));
		tableNo_7.setImage(new Image(getClass().getResourceAsStream("../Pictures/777.jpg")));
		tableNo_8.setImage(new Image(getClass().getResourceAsStream("../Pictures/888.jpg")));
		tableNo_9.setImage(new Image(getClass().getResourceAsStream("../Pictures/999.jpg")));
		tableNo_10.setImage(new Image(getClass().getResourceAsStream("../Pictures/1010.jpg")));
	}
	
	// 뒤로가기 이미지에 마우스가 들어왔을 때
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == back) {
			back.setEffect(teduri1);
		} else if (e.getSource() == tableNo_1) {
			tableNo_1.setEffect(teduri1);
		} else if (e.getSource() == tableNo_2) {
			tableNo_2.setEffect(teduri1);
		} else if (e.getSource() == tableNo_3) {
			tableNo_3.setEffect(teduri1);
		} else if (e.getSource() == tableNo_4) {
			tableNo_4.setEffect(teduri1);
		} else if (e.getSource() == tableNo_5) {
			tableNo_5.setEffect(teduri1);
		} else if (e.getSource() == tableNo_6) {
			tableNo_6.setEffect(teduri1);
		} else if (e.getSource() == tableNo_7) {
			tableNo_7.setEffect(teduri1);
		} else if (e.getSource() == tableNo_8) {
			tableNo_8.setEffect(teduri1);
		} else if (e.getSource() == tableNo_9) {
			tableNo_9.setEffect(teduri1);
		} else {
			tableNo_10.setEffect(teduri1);
		}
	}
	// 뒤로가기 이미지에서 마우스가 나갔을 때
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == back) {
			back.setEffect(null);
		} else if (e.getSource() == tableNo_1) {
			tableNo_1.setEffect(null);
		} else if (e.getSource() == tableNo_2) {
			tableNo_2.setEffect(null);
		} else if (e.getSource() == tableNo_3) {
			tableNo_3.setEffect(null);
		} else if (e.getSource() == tableNo_4) {
			tableNo_4.setEffect(null);
		} else if (e.getSource() == tableNo_5) {
			tableNo_5.setEffect(null);
		} else if (e.getSource() == tableNo_6) {
			tableNo_6.setEffect(null);
		} else if (e.getSource() == tableNo_7) {
			tableNo_7.setEffect(null);
		} else if (e.getSource() == tableNo_8) {
			tableNo_8.setEffect(null);
		} else if (e.getSource() == tableNo_9) {
			tableNo_9.setEffect(null);
		} else {
			tableNo_10.setEffect(null);
		}
	}
	// 뒤로가기 이미지를 클릭했을 때
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == back) {
			f.changeScene("/AfterLogin/MainMenu.fxml", label);
			back.setEffect(null);
			return;
		} else if (e.getSource() == tableNo_1) {
			Function.table = "1";
			tableNo_1.setEffect(null);
		} else if (e.getSource() == tableNo_2) {
			Function.table = "2";
			tableNo_2.setEffect(null);
		} else if (e.getSource() == tableNo_3) {
			Function.table = "3";
			tableNo_3.setEffect(null);
		} else if (e.getSource() == tableNo_4) {
			Function.table = "4";
			tableNo_4.setEffect(null);
		} else if (e.getSource() == tableNo_5) {
			Function.table = "5";
			tableNo_5.setEffect(null);
		} else if (e.getSource() == tableNo_6) {
			Function.table = "6";
			tableNo_6.setEffect(null);
		} else if (e.getSource() == tableNo_7) {
			Function.table = "7";
			tableNo_7.setEffect(null);
		} else if (e.getSource() == tableNo_8) {
			Function.table = "8";
			tableNo_8.setEffect(null);
		} else if (e.getSource() == tableNo_9) {
			Function.table = "9";
			tableNo_9.setEffect(null);
		} else {
			Function.table = "10";
			tableNo_10.setEffect(null);
		}
		f.changeScene("/AfterLogin/Reservation.fxml", label);
	}
}
