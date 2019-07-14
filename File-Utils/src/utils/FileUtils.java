package utils;

import java.io.*;


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
		PrintWriter writeConsole = new PrintWriter(System.out, true);
		boolean keepReading = true;
		
		String keyboardInput;

		try(FileWriter writeFile = new FileWriter(filename, append)) {
			writeConsole.println("File Created\nEnter text (enter exit to quit).");
			
			while(keepReading) {
				writeConsole.println("> ");
				keyboardInput = readKeyboard.readLine();
				
				if (keyboardInput.contentEquals("exit")) {
					keepReading = false;
				}
				else {
					writeFile.write(keyboardInput+"\n");
				}	
			}
			writeConsole.println("Text successfully written.");
		}
		catch(IOException ex) {
			System.out.println(ex);
		}	
	}
	
	
	boolean compareFiles(String file1, String file2) {
		String resultsFile = "";
	
		return compareFiles(file1, file2, resultsFile);
	}
	
	
	boolean compareFiles(String f1, String f2, String resultsFile) {
		String content1 = "";
		String content2 = "";
		
		int lineCounter = 0;
		
		PrintWriter writeConsole = new PrintWriter(System.out, true);
		
		try(BufferedReader file1 = new BufferedReader(new FileReader(f1));
			BufferedReader file2 = new BufferedReader(new FileReader(f2))) {
			
			while( (content1 = file1.readLine()) != null | (content2 = file2.readLine()) != null) {
				lineCounter++;
				
				}
	
		return true;
	}
	
	
	/*
	boolean compareFiles(String f1, String f2, String resultsFile) {
		boolean equal = true;
		String content1 = "";
		String content2 = "";
		int lineCounter = 0;
		
		PrintWriter writeConsole = new PrintWriter(System.out, true);

		try(BufferedReader file1 = new BufferedReader(new FileReader(f1));
			BufferedReader file2 = new BufferedReader(new FileReader(f2))) {
			
			while(!content1.contentEquals("End Of File") & !content2.contentEquals("End Of File")) {
				content1 = file1.readLine();
				content2 = file2.readLine();
				lineCounter++;
				
				System.out.println("File 1: " + content1);
				System.out.println("File 2: " + content2);
				
				// Check for nulls.
				if(content1 == null) {
					content1 = "End Of File";
				}
	
				if(content2 == null) {
					content2 = "End Of File";
				}
				
	
				
				// When they differ...
				if(!content1.contentEquals(content2)) {
				
					equal = false;
					// Check if they want to write to a file.
					if(!resultsFile.contentEquals("")) {
					
						System.out.println("Abou to write, inside line 114.");
						try(FileWriter writeFile = new FileWriter(resultsFile)) {
							writeFile.write("Line " + lineCounter);
							writeFile.write("\n" + f1 + "\n\t" + content1);
							writeFile.write("\n" + f2 + "\n\t" + content2);	
							System.out.println("successful write.");
						}
						catch(IOException ex) {
							writeConsole.println(ex);
						}
					}
					
				} 
				if(content2 == null) {
					System.out.println("yeah still here, null");
				}
			} 		
		return equal;
		
		}
		catch(IOException ex) {
			writeConsole.println(ex);
			return false;
		}
		
	}

	*/
	
	
}
