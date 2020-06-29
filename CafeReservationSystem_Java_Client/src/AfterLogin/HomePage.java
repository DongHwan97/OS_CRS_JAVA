package AfterLogin;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HomePage {
	public HomePage() {
		try {
	         Desktop.getDesktop().browse(new URI("http://localhost:18080/CafeReservationSystem/main.jsp"));

	      }catch(IOException e) {
	         e.printStackTrace();
	      }catch(URISyntaxException e) {
	         e.printStackTrace();
	      }
	}
}