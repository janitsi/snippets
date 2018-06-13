package loginfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
	
	@FXML private Label lblStatus;
	@FXML private TextField txtUsername;
	@FXML private PasswordField txtPassword;
	
	@FXML
	public void login(ActionEvent event) throws Exception {
		
		if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) {

			lblStatus.setText("Login successful!");
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Main application");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} else {
			lblStatus.setText("Invalid login!");
		}
		
	}
	
}
