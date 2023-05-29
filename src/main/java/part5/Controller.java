package part5;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

	@FXML Text innput;
	@FXML TextField output;

	@FXML
	void handleKvadrer() {
		final String s = innput.getText();
		System.out.println(s);
	}

	/**	
	 * ! Skal ikke kunne FXML på eksamen - gjør dermed ikke denne oppgaven
	 */
}
