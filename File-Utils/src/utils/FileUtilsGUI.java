package utils;

import javafx.application.*;
import javafx.geometry.Orientation;
import javafx.scene.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.*;


public class FileUtilsGUI extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		stage.setTitle("File Utlities");

		FileChooser file1 = new FileChooser();
		file1.setTitle("File 1");
		// Put this inside a button event handler.
		file1.showOpenDialog(stage);
		FlowPane root = new FlowPane(Orientation.VERTICAL);
		Scene scene = new Scene(root, 300, 400);
		stage.setScene(scene);
		stage.show();
	}
}
