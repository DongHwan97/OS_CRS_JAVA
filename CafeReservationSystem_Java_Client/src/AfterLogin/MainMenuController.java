package AfterLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainMenuController implements Initializable {

	Function f = new Function();
	
	@FXML Button logoutBtn;
	@FXML Button menuBtn;
	@FXML Button mypageBtn;
	@FXML Button homepageBtn;
	@FXML Button reservationBtn;
	
	@FXML TextField idField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		logoutBtn.setOnAction(event -> btnClicked(event));
		menuBtn.setOnAction(event -> btnClicked(event));
		mypageBtn.setOnAction(event -> btnClicked(event));
		homepageBtn.setOnAction(event -> btnClicked(event));
		reservationBtn.setOnAction(event -> btnClicked(event));
	}
	
	public void btnClicked(ActionEvent e) {
		// �α׾ƿ� ��ư�� ������ ��
		if (e.getSource() == logoutBtn) {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", logoutBtn);
		}
		// ī�� �޴� ��ư�� ������ ��
		else if (e.getSource() == menuBtn) {
			f.changeScene("../AfterLogin/CafeMenu.fxml", menuBtn);
		}
		// ���� ������ ��ư�� ������ ��
		else if (e.getSource() == mypageBtn) {
			f.changeScene("../AfterLogin/MyPage.fxml", mypageBtn);
		}
		// Ȩ������ �̵� ��ư�� ������ ��
		else if (e.getSource() == homepageBtn) {
			// Ȩ�������� �̵� �ϴ� �ڵ�!!
			// ~~~~~~~~~~~~~~~~~~~~
		}
		// �ڸ� Ȯ�� �� ���� ��ư�� ������ ��
		else {
			f.changeScene("../AfterLogin/CafeTables.fxml", reservationBtn);
		}
	}
}
