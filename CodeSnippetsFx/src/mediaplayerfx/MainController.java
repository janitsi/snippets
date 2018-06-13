package mediaplayerfx;

import java.io.File;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController {
	
	@FXML private MenuItem menuOpenFile;
	@FXML private MenuItem menuQuit;
	@FXML private MediaView mView;
	@FXML private Label lblSpeed;
	@FXML private Slider volumeSlider;
	private MediaPlayer mPlayer;
	private Media media;
	private double speed = 1;
	
	@FXML
	void initialize() {
		//		fileChooser(new ActionEvent());
	}
	
	public void closeApp() {
		Platform.exit();
		System.exit(0);
	}
	
	// Function used to open media file
	public void fileChooser(ActionEvent event) {
		
		FileChooser fc = new FileChooser();
		// Set default folder
		String path = System.getenv("HOMEDRIVE") + "/" + System.getenv("HOMEPATH");
		if (path != null) {
			fc.setInitialDirectory(new File(path));
		}
		// Set filters for supported file types
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("MPEG4 Media file", "*.mp4"),
				new ExtensionFilter("MovieWorks file", "*.mwv"));
		File selectedFile = fc.showOpenDialog(null);
		
		// Show media file
		if (selectedFile != null) {
			media = new Media(selectedFile.toURI().toString());
			mPlayer = new MediaPlayer(media);
			mView.setMediaPlayer(mPlayer);
			mPlayer.setAutoPlay(true);
			
			// Set MediaView to fit screen while preserving video ratio
			DoubleProperty width = mView.fitWidthProperty();
			DoubleProperty height = mView.fitHeightProperty();
			width.bind(Bindings.selectDouble(mView.sceneProperty(), "width"));
			height.bind(Bindings.selectDouble(mView.sceneProperty(), "height"));
			volumeSlider.setValue(mPlayer.getVolume() * 100);
			volumeSlider.valueProperty()
					.addListener(e -> mPlayer.setVolume(volumeSlider.getValue() / 100));
			
		}
	}
	
	public void play(ActionEvent event) {
		mPlayer.play();
	}
	
	public void pause(ActionEvent event) {
		mPlayer.pause();
	}
	
	public void fast(ActionEvent event) {
		if (speed < 2) { // speed up until double speed
			speed += 0.1;
			mPlayer.setRate(speed);
			String s = String.format("Speed : %.1f", speed);
			lblSpeed.setText(String.valueOf(s));
		}
	}
	
	public void slow(ActionEvent event) {
		if (speed >= 0.6) { // slow down until half speed
			speed -= 0.1;
			mPlayer.setRate(speed);
			String s = String.format("Speed : %.1f", speed);
			lblSpeed.setText(String.valueOf(s));
		}
	}
	
	public void reload(ActionEvent event) {
		mPlayer.seek(mPlayer.getStartTime());
		mPlayer.play();
	}
	
	public void start(ActionEvent event) {
		mPlayer.seek(mPlayer.getStartTime());
		mPlayer.stop();
	}
	
	public void last(ActionEvent event) {
		mPlayer.seek(mPlayer.getTotalDuration());
		mPlayer.stop();
	}

}
