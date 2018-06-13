package menubarfx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;

public class MainController {
	
	@FXML private MenuItem close;
	@FXML private CheckBox cbox1;
	@FXML private CheckBox cbox2;
	@FXML private CheckBox cbox3;
	@FXML private CheckBox cbox4;
	@FXML private Label lblSelection;
	@FXML private Label lblCount;
	@FXML private RadioButton rbMale;
	@FXML private RadioButton rbFemale;
	@FXML private RadioButton rbTrans;
	@FXML private Label lblMessage;
	
	public void closeApp() {
		Platform.exit();
		System.exit(0);
	}
	
	@FXML
	private void initialize() {
	}
	
	public void cbEvent(ActionEvent event) {
		int count = 0;
		String selection = "";
		
		if (cbox1.isSelected()) {
			count++;
			selection += cbox1.getText() + "\n";
		}
		if (cbox2.isSelected()) {
			count++;
			selection += cbox2.getText() + "\n";
		}
		if (cbox3.isSelected()) {
			count++;
			selection += cbox3.getText() + "\n";
		}
		if (cbox4.isSelected()) {
			count++;
			selection += cbox4.getText() + "\n";
		}
		lblSelection.setText(selection);
		lblCount.setText("Items: " + count);
		
	}
	
	public void rbEvent(ActionEvent event) {
		String message = "";
		if (rbMale.isSelected()) {
			message += rbMale.getText() + "\n";
		}
		if (rbFemale.isSelected()) {
			message += rbFemale.getText() + "\n";
		}
		if (rbTrans.isSelected()) {
			message += rbTrans.getText() + "\n";
		}
		lblMessage.setText(message);
	}
}
