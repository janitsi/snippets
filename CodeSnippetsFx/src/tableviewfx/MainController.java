package tableviewfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
	
	@FXML private TableView<Student> table;
	@FXML private TableColumn<Student, Integer> id;
	@FXML private TableColumn<Student, String> name;
	@FXML private TableColumn<Student, String> surname;
	@FXML private TableColumn<Student, Integer> age;
	
	public ObservableList<Student> list = FXCollections.observableArrayList(
			new Student(1, "Jani", "Aho", 50), new Student(2, "Taru", "Aho", 42),
			new Student(3, "Sanni", "Aho", 14), new Student(4, "Luka", "Aho", 11));
	
	@FXML
	public void initialize() {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		table.setItems(list);
		
	}
	
}
