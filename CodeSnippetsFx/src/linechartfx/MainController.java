package linechartfx;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public class MainController {
	
	private final String[] M = { "January", "February", "March", "April", "May",
			"June", "July", "August", "September", "October", "November", "December" };
	private static int year = 1990;
	
	@FXML LineChart<String, Number> line;
	@FXML Label lblXValue;
	
	@FXML
	private void initialize() {
	}
	
	public void clear(ActionEvent event) {
		line.getData().clear();
	}
	
	public void newData(ActionEvent event) {
		XYChart.Series<String, Number> s1 = new XYChart.Series<>();
		XYChart.Series<String, Number> s2 = new XYChart.Series<>();
		int year1 = year++;
		int year2 = year++;
		s1.setName("Year" + year1);
		s2.setName("Year" + year2);
		initialize(s1);
		initialize(s2);
		line.getData().add(s1);
		line.getData().add(s2);
		
		// On mouse hover, show the month correspondig to data point (for 1st series)
		for (final XYChart.Data<String, Number> data : s1.getData()) {
			onHover(data, event);
		}
		// On mouse hover, show the month correspondig to data point (for 1st series)
		for (final XYChart.Data<String, Number> data : s2.getData()) {
			onHover(data, event);
		}
	}
	
	private void onHover(XYChart.Data<String, Number> data, ActionEvent event) {
		data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
			lblXValue.setText("Month: " + data.getXValue());
			Tooltip.install(data.getNode(), new Tooltip(String.valueOf(data.getYValue())));
		});
		data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED,
				e -> lblXValue.setText(""));
	}
	
	private void initialize(XYChart.Series<String, Number> series) {
		for (String month : M) {
			int result = new Random().nextInt(2000);
			series.getData().add(new XYChart.Data<String, Number>(month, result));
		}
	}
	
}
