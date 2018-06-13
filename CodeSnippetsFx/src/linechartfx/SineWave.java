package linechartfx;
	
import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class SineWave extends Application {
		
	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Defining X axis  
			NumberAxis xAxis = new NumberAxis(0, 1000, 100); 
			xAxis.setLabel("Sample"); 
			        
			//Defining y axis 
			NumberAxis yAxis = new NumberAxis(-1.2, 1.2, 0.2); 
			yAxis.setLabel("Amplitude");
			
			
			//Prepare data
			XYChart.Series series = new XYChart.Series(); 
			series.setName("Sine wave");

/*			// Fill data series "old style" with for loop:
*			for (int n = 0; n < 1000; n++) {
*				series.getData().add(new XYChart
*						.Data(n, Math.sin(2 * Math.PI * (50.0/8192.0) * n))); 
*			}
*/
			
			//Fill data series "new style" using streams: 
			IntStream.range(0,1000).forEach(n ->
				series.getData().add(new XYChart
						.Data(n, Math.sin(2 * Math.PI * (50.0/8192.0) * n))));  
			
			//Set the data to Line chart    
			LineChart linechart = new LineChart(xAxis, yAxis);
			linechart.getData().add(series);

			// Create layout and add elements
			Group root = new Group();
			Scene scene = new Scene(root,600,400);
			root.getChildren().addAll(linechart);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
