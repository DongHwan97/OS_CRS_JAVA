package BeforeLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert.AlertType;

public class SignUpController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	
	boolean overlap = true;
	
	Color teduri = Color.web("#0022ff");
	
	@FXML ImageView back;
	@FXML ImageView nameImage;
	@FXML ImageView idImage;
	@FXML ImageView pwImage;
	@FXML ImageView birthImage;
	
	@FXML Button overlapBtn;
	@FXML Button checkBtn;
	
	@FXML TextField idField;
	@FXML TextField nameField;
	@FXML TextField pwField1;
	@FXML TextField pwField2;
	@FXML TextField juminField1;
	@FXML PasswordField juminField2;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		overlapBtn.setOnAction(event -> btnClicked(event));
		checkBtn.setOnAction(event -> btnClicked(event));
		
		idField.setOnAction(event -> enterPressed(event));
		nameField.setOnAction(event -> enterPressed(event));
		pwField1.setOnAction(event -> enterPressed(event));
		pwField2.setOnAction(event -> enterPressed(event));
		juminField1.setOnAction(event -> enterPressed(event));
		juminField2.setOnAction(event -> enterPressed(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		
		back.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		nameImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/16.png")));
		idImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/11.png")));
		pwImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/6.png")));
		birthImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/17.png")));
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
		f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
		back.setEffect(null);
	}
	
	public void btnClicked(ActionEvent e) {
		
		// TextField들에게서 text값 가져오기
		String name = nameField.getText();
		String id = idField.getText();
		String pw1 = pwField1.getText();
		String pw2 = pwField2.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();
		
		// 중복확인 버튼을 눌렸을 경우
		if (e.getSource() == overlapBtn) {	// 이름이 빈칸일 경우
			if (name.equals("")) {
				f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름을 입력해주세요.").show();
			}
			else {	// 빈칸이 아닐 경우
				// 서버로 중복확인용 문자열 보내기 ("메시지 타입_id")
				try {
					f.wrtieServer("CI_" + id);
					if (f.readServer().equals("false")) {
						f.popUp(AlertType.INFORMATION, "중복확인 성공!!!", "사용 가능한 아이디입니다.").show();
						overlap = false;
						idField.setEditable(false);
						overlapBtn.setDisable(true);
					} else {
						f.popUp(AlertType.INFORMATION, "중복확인 실패!!!", "이미 사용하고 있는 아이디 입니다.").show();
						overlap = true;
					}
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
					overlap = true;
				}
			}
		}
		// 확인 버튼을 눌렀을 경우
		else {
			// 이름이 빈칸일 경우
			if (name.equals("")) {
				f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름을 입력해주세요.").show();
			}
			// 아이디가 빈칸일 경우
			else if (id.equals("")) {
				f.popUp(AlertType.WARNING, "아이디는 공백일 수 없습니다.", "아이디를 입력해주세요.").show();
			}
			// 중복확인이 되지 않았을 경우
			else if (overlap) {
				f.popUp(AlertType.WARNING, "아이디 중복확인이 되지 않았습니다.", "중복확인을 해주세요.").show();
			}
			// 패스워드가 빈칸일 경우
			else if (pw1.equals("") || pw2.equals("")) {
				f.popUp(AlertType.WARNING, "패스워드는 공백일 수 없습니다.", "패스워드를 입력해주세요.").show();
			}
			// 주민등록번호가 빈칸일 경우
			else if (jumin1.equals("") || jumin2.equals("")) {
				f.popUp(AlertType.WARNING, "주민등록번호는 공백일 수 없습니다.", "주민등록번호를 입력해주세요.").show();
			}
			// 주민등록번호 앞 6자리 혹은 뒤 7자리, 즉, 자릿수를 지키지 않았을 경우
			else if (jumin1.length() != 6 || jumin2.length() != 7) {
				f.popUp(AlertType.WARNING, "주민등록번호가 잘못 입력되었습니다.", "정확한 값을 입력해주세요.").show();
			}
			// 패스워드와 패스워드 확인의 값이 다를 때
			else if (!pw1.equals(pw2)) {
				f.popUp(AlertType.WARNING, "패스워드가 다릅니다.", "패스워드를 정확히 입력해주세요.").show();
				pwField1.setText("");
				pwField2.setText("");
			}
			// 정보를 모두 입력했을 경우
			else {
				// 주민등록번호 getText값을 integer로 바꾸어 숫자로만 이루어져있는지 확인
				try {
					Integer.parseInt(jumin1);
					Integer.parseInt(jumin2);
				} catch (NumberFormatException e1) {	// 숫자가 아닌 것들이 있을 경우 팝업창을 띄우고 리턴시킴
					f.popUp(AlertType.WARNING, "주민등록번호가 잘못입력되었습니다.", "다시 입력해주세요.").show();
					return;
				}
				// 조건을 모두 만족했을 때
				// 서버로 회원가입용 문자열 보내기 ("메시지 타입_이름_아이디_패스워드_주민등록번호")
				try {
					f.wrtieServer("MJ_" + name + "_" + id + "_" + pw1 + "_" + jumin1 + jumin2);
					f.popUp(AlertType.INFORMATION, "회원가입 성공!!!", "로그인 화면으로 이동합니다.").showAndWait();
					f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
				}
			}
		}
	}
	
	// TextField에서 엔터를 입력했을 경우
	public void enterPressed(ActionEvent e) {
		
		// TextField들에게서 text값 가져오기
		String name = nameField.getText();
		String id = idField.getText();
		String pw1 = pwField1.getText();
		String pw2 = pwField2.getText();
		String jumin1 = juminField1.getText();
		String jumin2 = juminField2.getText();
		
		// 이름이 빈칸일 경우
		if (name.equals("")) {
			f.popUp(AlertType.WARNING, "이름은 공백일 수 없습니다.", "이름을 입력해주세요.").show();
		}
		// 아이디가 빈칸일 경우
		else if (id.equals("")) {
			f.popUp(AlertType.WARNING, "아이디는 공백일 수 없습니다.", "아이디를 입력해주세요.").show();
		}
		// 중복확인이 되지 않았을 경우
		else if (overlap) {
			f.popUp(AlertType.WARNING, "아이디 중복확인이 되지 않았습니다.", "중복확인을 해주세요.").show();
		}
		// 패스워드가 빈칸일 경우
		else if (pw1.equals("") || pw2.equals("")) {
			f.popUp(AlertType.WARNING, "패스워드는 공백일 수 없습니다.", "패스워드를 입력해주세요.").show();
		}
		// 주민등록번호가 빈칸일 경우
		else if (jumin1.equals("") || jumin2.equals("")) {
			f.popUp(AlertType.WARNING, "주민등록번호는 공백일 수 없습니다.", "주민등록번호를 입력해주세요.").show();
		}
		// 주민등록번호 앞 6자리 혹은 뒤 7자리, 즉, 자릿수를 지키지 않았을 경우
		else if (jumin1.length() != 6 || jumin2.length() != 7) {
			f.popUp(AlertType.WARNING, "주민등록번호가 잘못 입력되었습니다.", "정확한 값을 입력해주세요.").show();
		}
		// 패스워드와 패스워드 확인의 값이 다를 때
		else if (!pw1.equals(pw2)) {
			f.popUp(AlertType.WARNING, "패스워드가 다릅니다.", "패스워드를 정확히 입력해주세요.").show();
			pwField1.setText("");
			pwField2.setText("");
		}
		// 정보를 모두 입력했을 경우
		else {
			// 주민등록번호 getText값을 integer로 바꾸어 숫자로만 이루어져있는지 확인
			try {
				Integer.parseInt(jumin1);
				Integer.parseInt(jumin2);
			} catch (NumberFormatException e1) {	// 숫자가 아닌 것들이 있을 경우 팝업창을 띄우고 리턴시킴
				f.popUp(AlertType.WARNING, "주민등록번호가 잘못입력되었습니다.", "다시 입력해주세요.").show();
				return;
			}
			// 조건을 모두 만족했을 때
			// 서버로 회원가입용 문자열 보내기 ("메시지 타입_이름_아이디_패스워드_주민등록번호")
			try {
				f.wrtieServer("MJ_" + name + "_" + id + "_" + pw1 + "_" + jumin1 + jumin2);
				f.popUp(AlertType.INFORMATION, "회원가입 성공!!!", "로그인 화면으로 이동합니다.").showAndWait();
				f.changeScene("/BeforeLogin/LoginMenu.fxml", idField);
			} catch(IOException ex) {
				f.popUp(AlertType.ERROR, "서버와의 연결이 원활하지 않습니다.", "다음에 다시 이용해주시기 바랍니다.").show();
			}
		}
	}
}
