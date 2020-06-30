package BeforeLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class StartMenuController implements Initializable {

	Function f = new Function();
	
	@FXML ImageView startImage;
	@FXML ImageView exitImage;
	
	@FXML Button startBtn;
	@FXML Button exitBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		startBtn.setOnAction(event -> btnClicked(event));
		exitBtn.setOnAction(event -> btnClicked(event));
		
		startImage.setImage(new Image(getClass().getResourceAsStream("/Pictures/15.png")));
		exitImage.setImage(new Image(getClass().getResourceAsStream("/Pictures/12.png")));
	}
	
	public void btnClicked(ActionEvent e) {
		// �α��� ȭ������ ��ư�� ������ ��
		if (e.getSource() == startBtn) {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", startBtn);
		}
		// ���� ��ư�� ������ ��
		else {
			// Ȯ�� �˾�â ����ֱ�
			Alert check = f.popUp(AlertType.CONFIRMATION, 
					"���� �����Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� �����ø� ���α׷��� �����մϴ�.");
			// �˾�â���� Ȯ���� ������ �� ���α׷� ����
			if (check.showAndWait().get() == ButtonType.OK) {
				System.exit(0);
			}
		}
	}
}
