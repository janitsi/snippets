package csslessonfx;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class HBox1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = new BorderPane();
			HBox hbox = addHBox();
			hbox.setPrefWidth(300);
			root.setTop(hbox);
			Scene scene = new Scene(root, 700, 700);
//			scene.getStylesheets().add(HBox.class.getResource("HBox1.css").toExternalForm());
			scene.getStylesheets().add(getClass().getResource("HBox1.css").toExternalForm());

				
			primaryStage.setScene(scene);
			primaryStage.show();
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #337777;");

	    Button btn1 = new Button("Button1");
	    btn1.setPrefSize(100, 20);

	    Button btn2 = new Button("Button2");
	    btn2.setPrefSize(100, 20);

	    Button btn3 = new Button("Button3");
	    btn3.setPrefSize(100, 20);

	    Button btn4 = new Button("Button4");
	    btn4.setPrefSize(100, 20);

	    hbox.getChildren().addAll(btn1, btn2, btn3, btn4);

	    return hbox;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
