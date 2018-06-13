package calculatorfx;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class VerySimpleCalculator extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			HBox root = new HBox();
			Scene scene = new Scene(root, 800, 200);
			
			Label nr1 = new Label("Nr1");
			Label nr2 = new Label("Nr2");
			TextField in1 = new TextField("0");
			TextField in2 = new TextField("0");
			Label labelSum = new Label("Summa");
			TextField sum = new TextField("0");
			
			Button calcSum = new Button();
			calcSum.autosize();
			calcSum.setOnAction((e) -> {
				
				try {
					double a = Double.parseDouble(in1.getText());
					double b = Double.parseDouble(in2.getText());
					sum.setText(Double.toString(a + b));
				} catch (NumberFormatException e1) {
					sum.setText("Not a number");
				}
			});
			
			root.getChildren().addAll(nr1, in1, nr2, in2, labelSum, sum, calcSum);
					
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
