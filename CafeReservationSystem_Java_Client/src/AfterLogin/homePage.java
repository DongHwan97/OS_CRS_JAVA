package AfterLogin;

import java.io.IOException;

public class homePage {
	public homePage() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(
					"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe http://localhost:18080/CafeReservationSystem/main.jsp");
		} catch (IOException ex) {

		}
	}
}
