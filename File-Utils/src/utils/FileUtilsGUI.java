package utils;

import java.io.File;

import javafx.application.*;
import javafx.geometry.Orientation;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.*;

import utils.FileUtils;

public class FileUtilsGUI extends Application {
	
	String filepath1 = "";
	String filepath2 = "";
	boolean showDifferences = false;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		stage.setTitle("File Utlities");
		
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL);
		Label label = new Label("");

		Button chooseButton1 = new Button("File 1");
		Button chooseButton2 = new Button("File 2");
		
		CheckBox viewDifferences = new CheckBox("Show Differences");
		
		Button compareFiles = new Button("Compare");
		
		FileChooser file1 = new FileChooser();
		FileChooser file2 = new FileChooser();
		file1.setTitle("Select File 1");
		file2.setTitle("Select File 2");
		
		
		rootNode.getChildren().addAll(label, chooseButton1, chooseButton2, viewDifferences, compareFiles);
		Scene scene = new Scene(rootNode, 300, 400);
		stage.setScene(scene);
		stage.show();
		
		
		// Event Handling
		chooseButton1.setOnAction((actionEvent) -> {
			File selectedFile = file1.showOpenDialog(stage);
			try {
				filepath1 = selectedFile.toString();
				label.setText(filepath1);
			}
			catch(NullPointerException e) { // Closing without selecting a file.	
			}
		});
		
		chooseButton2.setOnAction((actionEvent) -> {
			File selectedFile = file1.showOpenDialog(stage);
			try {
				filepath2 = selectedFile.toString();
				label.setText(filepath2);
			}
			catch(NullPointerException e) { // Closing without selecting a file.	
			}
		});
		
		compareFiles.setOnAction((actionEvent) -> {
			if(!filepath1.contentEquals("") & !filepath2.contentEquals("")) {
				
				boolean result = FileUtils.compareFiles(filepath1, filepath2, showDifferences);

				
			}
			
		});
		
		
		viewDifferences.setOnAction((actionEvent) -> {
			if(viewDifferences.isSelected())
				showDifferences = true;
		});
		
	
	}	
}
