package webviewfx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;

public class MainController {
	
	@FXML private WebView webView;
	@FXML private Label lblJavaScriptEnabled;
	@FXML private Label lblHistory;
	@FXML private CheckBox cbJavaScript;
	
	private WebEngine engine;
	
	@FXML
	public void initialize() {
		engine = webView.getEngine();
	}
	
	public void btn1(ActionEvent event) {
		// Example one: load web page
		engine.load("http://google.com");
	}
	
	public void btn2(ActionEvent event) {
		// Example two: check if JavaScript is enabled (and) run JavaScript
		if (engine.isJavaScriptEnabled())
			engine.executeScript("window.location = \"http://bing.com\");");
		else
			lblJavaScriptEnabled.setText("JavaScript is disabled");
	}
	
	public void btn3(ActionEvent event) {
		// Example three: load HTML content
		engine.loadContent("<html><body><h1>Hello World</h1></body></html>");
	}
	
	public void btn4(ActionEvent event) {
		// Example four: reload page
		engine.reload();
	}
	
	public void btn5(ActionEvent event) {
		// Example five: get browsing history
		WebHistory webHistory = engine.getHistory();
		ObservableList<Entry> list = webHistory.getEntries();
		String history = "";
		for (Entry entry : list) {
			history += entry.getTitle() + "\n";
		}
		lblHistory.setText(history);
		
	}
	
	public void checkBox(ActionEvent event) {
		if (cbJavaScript.isSelected())
			engine.setJavaScriptEnabled(true);
		else
			engine.setJavaScriptEnabled(false);
	}
	
	// Further functions available on WebEngine ...explore with engine object!!
	
}
