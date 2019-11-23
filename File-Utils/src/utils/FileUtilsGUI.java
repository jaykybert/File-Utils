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
	String dir = "";

	File cssFile = new File("style.css");
	
	boolean validFilepath = false;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		stage.setTitle("File Utlities");


		FlowPane rootNode = new FlowPane(Orientation.VERTICAL);
		Label fileLabel1 = new Label("");
		Label fileLabel2 = new Label("");
		Label compareResult = new Label("");

		Button chooseButton1 = new Button("File 1");
		Button chooseButton2 = new Button("File 2");

		CheckBox saveDifferences = new CheckBox("Save Differences");

		Button compareFiles = new Button("Compare");

		FileChooser file1 = new FileChooser();
		FileChooser file2 = new FileChooser();
		file1.setTitle("Select File 1");
		file2.setTitle("Select File 2");


		rootNode.getChildren().addAll(chooseButton1, fileLabel1, chooseButton2, fileLabel2, saveDifferences, compareFiles, compareResult);
		Scene scene = new Scene(rootNode, 300, 400);
		scene.getStylesheets().clear();
		scene.getStylesheets().add("file:///" + cssFile.getAbsolutePath().replace("\\", "/"));
		
		stage.setScene(scene);
		stage.show();


		// Event Handling
		chooseButton1.setOnAction((actionEvent) -> {
			File selectedFile = file1.showOpenDialog(stage);
			try {
				filepath1 = selectedFile.toString();
				fileLabel1.setText(filepath1);
				validFilepath = true;
			}
			catch(NullPointerException e) { // Closing without selecting a file.
				fileLabel1.setText("Invalid Filepath");
			}
		});

		chooseButton2.setOnAction((actionEvent) -> {
			File selectedFile = file1.showOpenDialog(stage);
			try {
				filepath2 = selectedFile.toString();
				fileLabel2.setText(filepath2);
				validFilepath = true;
			}
			catch(NullPointerException e) { // Closing without selecting a file.
				fileLabel2.setText("Invalid Filepath");
			}
		});

		compareFiles.setOnAction((actionEvent) -> {
			if(validFilepath) {
				boolean result;
				if (saveDifferences.isSelected()) 
					result = FileUtils.compareFiles(filepath1, filepath2, dir);

				else 
					result = FileUtils.compareFiles(filepath1, filepath2);

				if(result) compareResult.setText("The files are the same.");
				else compareResult.setText("The files differ.");
			}
			else {
				compareResult.setText("Please enter two valid filepaths.");
			}
		});


		saveDifferences.setOnAction((actionEvent) -> {
			DirectoryChooser saveFile = new DirectoryChooser();
			saveFile.setTitle("Save Differences File");

			if (saveDifferences.isSelected()) {	
				File selectedDir = saveFile.showDialog(stage);
				if(selectedDir != null) {
					dir = selectedDir.getAbsolutePath();
				}
			}

		});
	}	
}
