package sliderfx;

import java.text.NumberFormat;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class MainController {
	
	@FXML private Slider slider;
	@FXML private TextField txtField;
	
	private static final double INIT_VALUE = 50;

	@FXML
	private void initialize() {
		slider.setValue(INIT_VALUE);
		txtField.setText(new Double(INIT_VALUE).toString());
		txtField.textProperty().bindBidirectional(slider.valueProperty(),
				NumberFormat.getNumberInstance());
		
	}
	
}

