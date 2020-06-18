package AfterLogin;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ReservationCancelController implements Initializable {

   Function f = new Function();
   
   DropShadow teduri1 = new DropShadow();
   
   Color teduri = Color.web("#0022ff");
   
   String reservTime;
   
   boolean reserved = false;
   
   @FXML ImageView back;
   
   @FXML TextArea reservationInfo;
   
   @FXML Button cancelBtn;
   
   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      
      cancelBtn.setOnAction(event -> reservationCancel(event));
      
      back.setOnMouseEntered(event -> mouseEntered(event));
      back.setOnMouseExited(event -> mouseExited(event));
      back.setOnMousePressed(event -> mousePressed(event));
      
      teduri1.setColor(teduri);
      
      back.setImage(new Image(getClass().getResourceAsStream("../Pictures/backBtn.png")));
      
      reservationInfo();
   }
   
   // �ڷΰ��� �̹����� ���콺�� ������ ��
   public void mouseEntered(MouseEvent e) {
      back.setEffect(teduri1);
   }
   // �ڷΰ��� �̹������� ���콺�� ������ ��
   public void mouseExited(MouseEvent e) {
      back.setEffect(null);
   }
   // �ڷΰ��� �̹����� Ŭ������ ��
   public void mousePressed(MouseEvent e) {
      f.changeScene("../AfterLogin/MyPage.fxml", cancelBtn);
      back.setEffect(null);
   }
   
   // ���� ��� ��ư�� ������ ��
   public void reservationCancel(ActionEvent e) {
      Optional<ButtonType> result = f.popUp(AlertType.CONFIRMATION, "������ ����Ͻðڽ��ϱ�?", "").showAndWait();
      
      if (result.get() == ButtonType.OK) {   // Ȯ�� ��ư�� ������ ���
         // ������ ������ҿ� ���ڿ� ���� ("�޽���Ÿ��_���̵�_���̺��ȣ_�ð�");
         try {
            f.wrtieServer("CR_" + Function.table + "_" + reservTime);
            f.popUp(AlertType.INFORMATION, "������ ��ҵǾ����ϴ�!!!", "").showAndWait();
            f.changeScene("../AfterLogin/MyPage.fxml", cancelBtn);   // ���������� â���� ȭ�� ��ȯ
         } catch (IOException ex) {
            f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
         }
      }
   }
   
   // DB�� �����ؼ� �ش� ������� ���� ���� TextArea�� ����
   public void reservationInfo() {
	  String info;
      String tableNo;
      String time;
      
      try {
         f.wrtieServer("SR_" + Function.id);	// ������ ��������Ȯ�ο� ���ڿ� ����
         info = f.readServer();
         
         if (info.equals("fail")) {				// �����κ��� ���� ���ڿ��� "fail"�� ���
        	 reservationInfo.appendText("\n");	// �ش� ����ڿ��� ���� ������ ���ٴ� ���ڿ��� TextArea�� append�ϱ�
        	 reservationInfo.appendText(Function.id +" ����\n");
        	 reservationInfo.appendText("���� ������\n");
        	 reservationInfo.appendText("�������� �ʽ��ϴ�.");
        	 reserved = false;	// �������� ���� �����
        	 cancelBtn.setDisable(true);
        	 return;
         }
         
         // ���ڿ��� "fail"�� �ƴ϶�� �Ʒ��� �ڵ�� ����
         
         tableNo = info.split("_")[0];	// �����κ��� ���� ���ڿ�
         time = info.split("_")[1];		// split�ؼ� ����
         
         Function.table = tableNo;
         reservTime = time;
         reserved = true;	// ������ ����ڶ�
         
         if (time.equals("one")) {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" ����\n");
        	 reservationInfo.appendText(tableNo + "�� ���̺���\n");
        	 reservationInfo.appendText("10�� ~ 12�ÿ� �����ϼ̽��ϴ�.");
         } else if (time.equals("two")) {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" ����\n");
        	 reservationInfo.appendText(tableNo + "�� ���̺���\n");
        	 reservationInfo.appendText("12�� ~ 14�ÿ� �����ϼ̽��ϴ�.");
         } else if (time.equals("three")) {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" ����\n");
        	 reservationInfo.appendText(tableNo + "�� ���̺���\n");
        	 reservationInfo.appendText("14�� ~ 16�ÿ� �����ϼ̽��ϴ�.");
         } else if (time.equals("four")) {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" ����\n");
        	 reservationInfo.appendText(tableNo + "�� ���̺���\n");
        	 reservationInfo.appendText("16�� ~ 18�ÿ� �����ϼ̽��ϴ�.");
         } else if (time.equals("five")) {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" ����\n");
        	 reservationInfo.appendText(tableNo + "�� ���̺���\n");
        	 reservationInfo.appendText("18�� ~ 20�ÿ� �����ϼ̽��ϴ�.");
         } else {
        	 reservationInfo.appendText("\n");
        	 reservationInfo.appendText(Function.id +" ����\n");
        	 reservationInfo.appendText(tableNo + "�� ���̺���\n");
        	 reservationInfo.appendText("20�� ~ 22�ÿ� �����ϼ̽��ϴ�.");
         }
      } catch(IOException e) {
         f.popUp(AlertType.ERROR, "�������� ������ ��Ȱ���� �ʽ��ϴ�.", "������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.").show();
         reserved = false;	// �������� ���� ����� or ���� ����
      }
   }
}