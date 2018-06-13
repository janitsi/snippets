package piechartfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MainController {
	
	@FXML PieChart pie;
	@FXML Label status;
	
	@FXML
	private void initialize() {
	}
	
	public void loadChart(ActionEvent event) {
		ObservableList<Data> list = FXCollections.observableArrayList(new PieChart.Data("Java", 40),
				new PieChart.Data("C++", 20), new PieChart.Data("Python", 25),
				new PieChart.Data("C#", 15));
		pie.setData(list);
		
		// On mouse hover, show pie data value on label
		for (final PieChart.Data data : list) {
			Double value = data.getPieValue();
			data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED,
					e -> status.setText(value.toString()));
			data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED,
					e -> status.setText(""));
		}
	}
	
}
