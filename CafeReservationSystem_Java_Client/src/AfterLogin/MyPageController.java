package AfterLogin;

import java.net.URL;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MyPageController implements Initializable {

	Function f = new Function();
	
	@FXML Button logoutBtn;
	@FXML Button myInfoBtn;
	@FXML Button reservationBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		logoutBtn.setOnAction(event -> btnClicked(event));
		myInfoBtn.setOnAction(event -> btnClicked(event));
		reservationBtn.setOnAction(event -> btnClicked(event));
	}
	
	public void btnClicked(ActionEvent e) {
		// �α׾ƿ� ��ư�� ������ ��
		if (e.getSource() == logoutBtn) {
			f.changeScene("/BeforeLogin/LoginMenu.fxml", logoutBtn);
		}
		// ȸ������ Ȯ�� ��ư�� ������ ��
		else if (e.getSource() == myInfoBtn) {
			f.changeScene("../AfterLogin/MyInfo.fxml", myInfoBtn);
		}
		// ���� Ȯ�� �� ��� ��ư�� ������ ��
		else {
			f.changeScene("../AfterLogin/CafeTables.fxml", reservationBtn);
		}
	}
}
