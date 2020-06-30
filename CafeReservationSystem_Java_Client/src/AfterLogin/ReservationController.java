package AfterLogin;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ReservationController implements Initializable {

	Function f = new Function();
	
	DropShadow teduri1 = new DropShadow();
	DropShadow teduri2 = new DropShadow();
	
	Color teduri = Color.BLUE;
	Color color4 = Color.web("#000000b2");
	
	@FXML ImageView back;
	@FXML ImageView mypageImage;
	
	@FXML TextField tableInfo;
	
	@FXML Button mypageBtn;
	
	@FXML Rectangle firstTime;
	@FXML Rectangle secondTime;
	@FXML Rectangle thirdTime;
	@FXML Rectangle fourthTime;
	@FXML Rectangle fifthTime;
	@FXML Rectangle sixthTime;
	@FXML Rectangle impossible;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		selectReservation();
		
		tableInfo.setText(Function.table + "�� ���̺�");
		
		mypageBtn.setOnAction(event -> btnClicked(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		back.setOnMouseExited(event -> mouseExited(event));
		back.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		teduri2.setColor(teduri);
		impossible.setFill(color4);
		
		back.setImage(new Image(getClass().getResourceAsStream("/Pictures/backBtn.png")));
		mypageImage.setImage(new Image(getClass().getResourceAsStream("/Pictures/18.png")));
	}
	
	public void btnClicked(ActionEvent e) {
		
		Optional<ButtonType> result;
		
		if (e.getSource() == mypageBtn) {	// ���������� ��ư Ŭ�� ��
			result = f.popUp(AlertType.CONFIRMATION, "������������ �̵��Ͻðڽ��ϱ�?", "'Ȯ��' ��ư Ŭ���� �̵��մϴ�.").showAndWait(); // �˾�â ����
			if (result.get() == ButtonType.OK) {	// �˾�â���� 'OK' ��ư Ŭ����
				f.changeScene("/AfterLogin/MyPage.fxml", mypageBtn);	// ������������ ȭ�� ��ȯ
			}
		}
	}
	
	public void selectReservation() {
		
		String msg;
		String[] splitMsg = {"", "", "", "", "", ""};
		Rectangle[] tangle = { firstTime, secondTime, thirdTime, fourthTime, fifthTime, sixthTime };
		
		try {
			f.wrtieServer("ST_" + Function.table);
			msg = f.readServer();
			
			for (int i = 0; i < 6; i++) {
				splitMsg[i] = msg.split("_")[i];
				if (!splitMsg[i].equals("null")) {
					tangle[i].setFill(color4);
				} else {
					tangle[i].setOnMouseEntered(event -> mouseEntered(event));
					tangle[i].setOnMousePressed(event -> mousePressed(event));
					tangle[i].setOnMouseExited(event -> mouseExited(event));
				}
			}
		} catch(IOException e) {
			f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
		}
	}
	// �ð� �����̳� �ڷΰ��� ��ư�� ���콺�� ������ ��
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == back) {
			back.setEffect(teduri1);
		} else if (e.getSource() == firstTime) {
			firstTime.setEffect(teduri2);
		} else if (e.getSource() == secondTime) {
			secondTime.setEffect(teduri2);
		} else if (e.getSource() == thirdTime) {
			thirdTime.setEffect(teduri2);
		} else if (e.getSource() == fourthTime) {
			fourthTime.setEffect(teduri2);
		} else if (e.getSource() == fifthTime) {
			fifthTime.setEffect(teduri2);
		} else if (e.getSource() == sixthTime) {
			sixthTime.setEffect(teduri2);
		}
	}
	// �ð� �����̳� �ڷΰ��� ��ư�� ���콺�� ������ ��
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == back) {
			back.setEffect(null);
		} else if (e.getSource() == firstTime) {
			firstTime.setEffect(null);
		} else if (e.getSource() == secondTime) {
			secondTime.setEffect(null);
		} else if (e.getSource() == thirdTime) {
			thirdTime.setEffect(null);
		} else if (e.getSource() == fourthTime) {
			fourthTime.setEffect(null);
		} else if (e.getSource() == fifthTime) {
			fifthTime.setEffect(null);
		} else if (e.getSource() == sixthTime) {
			sixthTime.setEffect(null);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		
		Optional<ButtonType> result;
		
		if (e.getSource() == back) {
			f.changeScene("/AfterLogin/CafeTables.fxml", tableInfo);	// ���̺� ���� ȭ������ ��ȯ
			back.setEffect(null);
		} else if (e.getSource() == firstTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'10�� ~ 12��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					f.wrtieServer("CT_" + Function.table + "_one");
					if (f.readServer().equals("fail")) {
						f.popUp(AlertType.WARNING, "���� ����!!!", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
					} else {
						f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
					}
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				} finally {
					f.changeScene("/AfterLogin/MainMenu.fxml", mypageBtn);	// ���θ޴��� ȭ�� ��ȯ
				}
			}
			firstTime.setEffect(null);
		} else if (e.getSource() == secondTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'12�� ~ 14��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					f.wrtieServer("CT_" + Function.table + "_two");
					if (f.readServer().equals("fail")) {
						f.popUp(AlertType.WARNING, "���� ����!!!", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
					} else {
						f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
					}
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				} finally {
					f.changeScene("/AfterLogin/MainMenu.fxml", mypageBtn);	// ���θ޴��� ȭ�� ��ȯ
				}
			}
			secondTime.setEffect(null);
		} else if (e.getSource() == thirdTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'14�� ~ 16��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					f.wrtieServer("CT_" + Function.table + "_three");
					if (f.readServer().equals("fail")) {
						f.popUp(AlertType.WARNING, "���� ����!!!", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
					} else {
						f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
					}
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				} finally {
					f.changeScene("/AfterLogin/MainMenu.fxml", mypageBtn);	// ���θ޴��� ȭ�� ��ȯ
				}
			}
			thirdTime.setEffect(null);
		} else if (e.getSource() == fourthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'16�� ~ 18��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					f.wrtieServer("CT_" + Function.table + "_four");
					if (f.readServer().equals("fail")) {
						f.popUp(AlertType.WARNING, "���� ����!!!", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
					} else {
						f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
					}
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				} finally {
					f.changeScene("/AfterLogin/MainMenu.fxml", mypageBtn);	// ���θ޴��� ȭ�� ��ȯ
				}
			}
			fourthTime.setEffect(null);
		} else if (e.getSource() == fifthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'18�� ~ 20��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					f.wrtieServer("CT_" + Function.table + "_five");
					if (f.readServer().equals("fail")) {
						f.popUp(AlertType.WARNING, "���� ����!!!", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
					} else {
						f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
					}
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				} finally {
					f.changeScene("/AfterLogin/MainMenu.fxml", mypageBtn);	// ���θ޴��� ȭ�� ��ȯ
				}
			}
			fifthTime.setEffect(null);
		} else if (e.getSource() == sixthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'20�� ~ 22��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					f.wrtieServer("CT_" + Function.table + "_six");
					if (f.readServer().equals("fail")) {
						f.popUp(AlertType.WARNING, "���� ����!!!", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
					} else {
						f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
					}
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				} finally {
					f.changeScene("/AfterLogin/MainMenu.fxml", mypageBtn);	// ���θ޴��� ȭ�� ��ȯ
				}
			}
			sixthTime.setEffect(null);
		}
	}
}