package AfterLogin;

import java.io.IOException;

public class HomePage {
	public HomePage() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("C:/Program Files/Internet Explorer/iexplorer.exe http://localhost:18080/CafeReservationSystem/main.jsp");
		} catch (IOException ex) {

		}
	}
}
