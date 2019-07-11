package utils;

import java.io.*;
/* Change import statement (specify imports) */


public class FileUtils {
	
	/** 
	 * Take x files and reads each one, returning an array
	 * containing the content of each file as a string.
	 * @param filenames: x amount of files.
	 * @return allContents: Array of the files' content.
	 */
	String[] readFiles(String ... filenames) {
		
		String[] allContents = new String[filenames.length];
		StringBuilder fileContent = new StringBuilder();
		String contentLine;
			
		for(int i=0; i < filenames.length; i++) {
			
			try(BufferedReader readFile = new BufferedReader(new FileReader(filenames[i]))) {

				while((contentLine = readFile.readLine()) != null) {
					fileContent.append(contentLine + "\n");
				}
				allContents[i] = fileContent.toString(); // Store file contents.
				fileContent.setLength(0); // Reset StringBuilder.
			}
		
			catch(IOException ex) {
				System.out.println(ex);
			}
			
		}
		return allContents;
	}
	
	/**
	 * Read input from the keyboard and write it to a file.
	 * @param filename: name of the file (and path).
	 * @param append: Determines whether to overwrite or append to the file.
	 */
	void writeFile(String filename, boolean append) {
		
		BufferedReader readKeyboard = new BufferedReader(new InputStreamReader(System.in));
		boolean keepReading = true;
		
		String keyboardInput;

		try(FileWriter writeFile = new FileWriter(filename, append)) {
			System.out.println("File Created\nEnter text (enter exit to quit).");
			
			while(keepReading) {
				System.out.print("> ");
				keyboardInput = readKeyboard.readLine();
				
				if (keyboardInput.contentEquals("exit")) {
					keepReading = false;
				}
				else {
					writeFile.write(keyboardInput+"\n");
				}	
			}
			System.out.println("Text successfully written.");
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
		
		
		
	}



}

