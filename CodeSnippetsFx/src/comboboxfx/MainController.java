package comboboxfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class MainController implements Initializable {
	
	@FXML private ComboBox<String> comboBox;
	@FXML private Button button;
	@FXML private Label nameLabel;
	@FXML private ListView<String> listView;
	
	private ObservableList<String> list = FXCollections
			.observableArrayList("Jani", "Taru", "Luka", "Sanni");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		comboBox.setItems(list);
		listView.setItems(list);
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		// combobox can be extended on the fly...
		comboBox.getItems().addAll("Pena", "Make", "Jannu", "Urpo", "Paavo");
		listView.getItems().addAll("Mervi", "Leila", "Tiina", "Sami", "Antti");
		
	}
	
	public void comboChanged(ActionEvent event) {
		
		nameLabel.setText(comboBox.getValue());
		
	}
	
	public void ButtonAction(ActionEvent event) {
		
		// comboBox.getItems().addAll("Pena", "Make", "Jannu", "Urpo", "Paavo");
		
		ObservableList<String> names = listView.getSelectionModel().getSelectedItems();
		names.forEach(System.out::println);
		
	}
	
}
