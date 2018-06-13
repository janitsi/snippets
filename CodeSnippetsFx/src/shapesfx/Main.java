package shapesfx;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Group root = new Group();
			Scene scene = new Scene(root, 500, 500, Color.BLACK);

			// Add blue rectangle 
			Rectangle r1 = new Rectangle(0,0,250,250);
	      r1.setFill(Color.BLUE);

	      // Add green rectangle
			Rectangle r2 = new Rectangle(250,0,250,250);
	      r2.setFill(Color.GREEN);

	      // Add red rectangle
			Rectangle r3 = new Rectangle(0,250,250,250);
	      r3.setFill(Color.RED);

	      // Add yellow rectangle
			Rectangle r4 = new Rectangle(250,250,250,250);
	      r4.setFill(Color.YELLOW);

	      root.getChildren().addAll(r1, r2, r3, r4);
				
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
