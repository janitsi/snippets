package filechooserfx;

import java.io.File;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController {
	
	@FXML private Button btnSingle;
	@FXML private Button btnMulti;
	@FXML private ListView<String> txtFileList;
	
	public void mouseBtnSingle(ActionEvent event) {
		
		FileChooser fc = new FileChooser();
		String path = System.getenv("LOCALAPPDATA");
		if (path != null) {
			fc.setInitialDirectory(new File(path));
		}
		fc.getExtensionFilters().add(new ExtensionFilter("Text files", "*.txt"));
		File selectedFile = fc.showOpenDialog(null);
		
		if (selectedFile != null) {
			txtFileList.getItems().add(selectedFile.getName());
		} else {
			System.err.println("Invalid file!");
		}
		
	}
	
	public void mouseBtnMulti(ActionEvent event) {
		
		FileChooser fc = new FileChooser();
		String path = System.getenv("LOCALAPPDATA");
		if (path != null) {
			fc.setInitialDirectory(new File(path));
		}
		fc.getExtensionFilters().add(new ExtensionFilter("Text files", "*.txt"));
		List<File> selectedFiles = fc.showOpenMultipleDialog(null);
		
		if (!selectedFiles.isEmpty()) {
			for (File filename : selectedFiles) {
				txtFileList.getItems().add(filename.getName());
			}
		} else {
			System.err.println("No files selected");
		}
		
	}
	
}
