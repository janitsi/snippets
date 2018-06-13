package mousetrackingfx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class TrackMouse extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Group root = new Group();
			Scene scene = new Scene(root, 700, 700);
			
			Label text = new Label();
			root.getChildren().addAll(text);
			
			scene.setOnMouseMoved(e -> {
					double x = e.getSceneX();
					double y = e.getSceneY();
					String sX = String.valueOf(x);
					String sY = String.valueOf(y);
					text.setText(sX + " - " + sY);
			});
			
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
