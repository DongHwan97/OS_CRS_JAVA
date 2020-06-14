package AfterLogin;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;

public class MainMenuController implements Initializable {

	Function f = new Function();
	
	@FXML Button logoutBtn;
	@FXML Button menuBtn;
	@FXML Button mypageBtn;
	@FXML Button homepageBtn;
	@FXML Button reservationBtn;
	
	@FXML ImageView reservImage;
	@FXML ImageView menuImage;
	@FXML ImageView mypageImage;
	@FXML ImageView homeImage;
	@FXML ImageView logoutImage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		logoutBtn.setOnAction(event -> btnClicked(event));
		menuBtn.setOnAction(event -> btnClicked(event));
		mypageBtn.setOnAction(event -> btnClicked(event));
		homepageBtn.setOnAction(event -> btnClicked(event));
		reservationBtn.setOnAction(event -> btnClicked(event));
		
		reservImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/26.png")));
		menuImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/25.png")));
		mypageImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/18.png")));
		homeImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/19.png")));
		logoutImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/24.png")));
	}
	
	public void btnClicked(ActionEvent e) {
		
		Optional<ButtonType> result;
		
		// �α׾ƿ� ��ư�� ������ ��
		if (e.getSource() == logoutBtn) {
			result = f.popUp(AlertType.CONFIRMATION, "�α׾ƿ��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� �α׾ƿ� �˴ϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("/BeforeLogin/LoginMenu.fxml", logoutBtn);
			}
		}
		// ī�� �޴� ��ư�� ������ ��
		else if (e.getSource() == menuBtn) {
			result = f.popUp(AlertType.CONFIRMATION, "ī�� �޴� ȭ������ �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� ȭ���� ��ȯ�˴ϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("../AfterLogin/CafeMenu.fxml", menuBtn);
			}
		}
		// ���� ������ ��ư�� ������ ��
		else if (e.getSource() == mypageBtn) {
			result = f.popUp(AlertType.CONFIRMATION, "���������� ȭ������ �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� ȭ���� ��ȯ�˴ϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("../AfterLogin/MyPage.fxml", mypageBtn);
			}
		}
		// Ȩ������ �̵� ��ư�� ������ ��
		else if (e.getSource() == homepageBtn) {
			result = f.popUp(AlertType.CONFIRMATION, "Ȩ�������� �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� Ȩ�������� �̵��մϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {
				// Ȩ�������� �̵� �ϴ� �ڵ�!!
				new homePage();//�̵�
			}
		}
		// �ڸ� Ȯ�� �� ���� ��ư�� ������ ��
		else {
			result = f.popUp(AlertType.CONFIRMATION, "�ڸ� ���� ȭ������ �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư�� ���� �� ȭ���� ��ȯ�˴ϴ�.").showAndWait();
			if (result.get() == ButtonType.OK) {
				f.changeScene("../AfterLogin/CafeTables.fxml", reservationBtn);
			}
		}
	}
}
