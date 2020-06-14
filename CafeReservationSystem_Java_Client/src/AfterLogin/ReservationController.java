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
	
	Color teduri = Color.web("#0022ff");
	
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		mypageBtn.setOnAction(event -> btnClicked(event));
		
		back.setOnMouseEntered(event -> mouseEntered(event));
		firstTime.setOnMouseEntered(event -> mouseEntered(event));
		secondTime.setOnMouseEntered(event -> mouseEntered(event));
		thirdTime.setOnMouseEntered(event -> mouseEntered(event));
		fourthTime.setOnMouseEntered(event -> mouseEntered(event));
		fifthTime.setOnMouseEntered(event -> mouseEntered(event));
		sixthTime.setOnMouseEntered(event -> mouseEntered(event));
	
		back.setOnMouseExited(event -> mouseExited(event));
		firstTime.setOnMouseExited(event -> mouseExited(event));
		secondTime.setOnMouseExited(event -> mouseExited(event));
		thirdTime.setOnMouseExited(event -> mouseExited(event));
		fourthTime.setOnMouseExited(event -> mouseExited(event));
		fifthTime.setOnMouseExited(event -> mouseExited(event));
		sixthTime.setOnMouseExited(event -> mouseExited(event));
		
		back.setOnMousePressed(event -> mousePressed(event));
		firstTime.setOnMousePressed(event -> mousePressed(event));
		secondTime.setOnMousePressed(event -> mousePressed(event));
		thirdTime.setOnMousePressed(event -> mousePressed(event));
		fourthTime.setOnMousePressed(event -> mousePressed(event));
		fifthTime.setOnMousePressed(event -> mousePressed(event));
		sixthTime.setOnMousePressed(event -> mousePressed(event));
		
		teduri1.setColor(teduri);
		
		back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
		mypageImage.setImage(new Image(getClass().getResourceAsStream("../Pictures/18.png")));
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
	
	// �ڷΰ��� �̹����� ���콺�� ������ ��
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == back) {
			back.setEffect(teduri1);
		} else if (e.getSource() == firstTime) {
			firstTime.setEffect(teduri1);
		} else if (e.getSource() == secondTime) {
			secondTime.setEffect(teduri1);
		} else if (e.getSource() == thirdTime) {
			thirdTime.setEffect(teduri1);
		} else if (e.getSource() == fourthTime) {
			fourthTime.setEffect(teduri1);
		} else if (e.getSource() == fifthTime) {
			fifthTime.setEffect(teduri1);
		} else {
			sixthTime.setEffect(teduri1);
		}
	}
	// �ڷΰ��� �̹������� ���콺�� ������ ��
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
		} else {
			sixthTime.setEffect(null);
		}
	}
	// �ڷΰ��� �̹����� Ŭ������ ��
	public void mousePressed(MouseEvent e) {
		
		Optional<ButtonType> result;
		
		if (e.getSource() == back) {
			f.changeScene("/AfterLogin/CafeTables.fxml", mypageBtn);
			back.setEffect(null);
		}
		else if (e.getSource() == firstTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'10�� ~ 12��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					 f.wrtieServer("CT_" + Function.table + "_one");
					f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				}
			}
		} else if (e.getSource() == secondTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'12�� ~ 14��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					 f.wrtieServer("CT_" + Function.table + "_two");
					f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				}
			}
		} else if (e.getSource() == thirdTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'14�� ~ 16��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					 f.wrtieServer("CT_" + Function.table + "_three");
					f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				}
			}
		} else if (e.getSource() == fourthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'16�� ~ 18��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					f.wrtieServer("CT_" + Function.table + "_four");
					f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				}
			}
		} else if (e.getSource() == fifthTime) {
			result = f.popUp(AlertType.CONFIRMATION, "'18�� ~ 20��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					 f.wrtieServer("CT_" + Function.table + "_five");
					f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				}
			}
		} else {
			result = f.popUp(AlertType.CONFIRMATION, "'20�� ~ 22��' �����Ͻðڽ��ϱ�?", "").showAndWait();
			if (result.get() == ButtonType.OK) {
				// ������ ����� ���ڿ� ����
				try {
					f.wrtieServer("CT_" + Function.table + "_six");
					f.popUp(AlertType.INFORMATION, "������ �Ϸ�Ǿ����ϴ�!!!", "���� ������ �������������� Ȯ�� �����մϴ�.").show();
				} catch(IOException ex) {
					f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
				}
			}
		}
	}
}