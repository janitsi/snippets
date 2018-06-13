package datepickerfx;

import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class MainController {
	
	@FXML private DatePicker datepicker;
	@FXML private Label lblDate;
	
	@FXML
	public void initialize() {
	}
	
	public void showDate(ActionEvent event) {
		LocalDate ld = datepicker.getValue();
		lblDate.setText(ld.toString());
	}
	
}
