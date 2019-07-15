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
		PrintWriter writeConsole = new PrintWriter(System.out, true);
		
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
				writeConsole.println(ex);
			}
			
		}
		return allContents;
	}
	
	
	/**
	 * Read input from the keyboard and write it to a file.
	 * @param filename: name of the file (and path).
	 */
	void writeFile(String filename) {
		writeFile(filename, false);
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
			writeConsole.println("Text written.");
		}
		catch(IOException ex) {
			System.out.println(ex);
		}	
	}
	
	
	/** Iterate through two files, return true if they are the same.
	 * 	@param f1: File 1.
	 * 	@param f2: File 2.
	 *  @return: true/false depending on if the files are the same.
	 */
	boolean compareFiles(String f1, String f2) {
		String content1 = "";
		String content2 = "";
		
		PrintWriter writeConsole = new PrintWriter(System.out, true);
		try(BufferedReader file1 = new BufferedReader(new FileReader(f1));
			BufferedReader file2 = new BufferedReader(new FileReader(f2))) {
			
			while((content1 = file1.readLine()) != null | (content2 = file2.readLine()) != null) {
				
				// Check for end of files.
				if(content1 == null) content1 = "<End of File>";
				if(content2 == null) content2 = "<End of File>";
				
				if(!content1.contentEquals(content2)) return false;	
			}	
			return true;			
		}
		catch(IOException ex) {
			writeConsole.println(ex);
			return false;
		}	
	}
	
	
	/** Iterate through two files, write any differences to a results file,
	 *  and return true/false.
	 *  @param f1: File 1.
	 *  @param f2: File 2.
	 *  @param resultsFile: The output file.
	 *  @return: true/false depending on if the files are the same.
	 */
	boolean compareFiles(String f1, String f2, String resultsFile) {

		boolean equals = true;
		int lineCounter = 0;
		String content1 = "";
		String content2 = "";
		
		PrintWriter writeConsole = new PrintWriter(System.out, true);
		
		try(BufferedReader file1 = new BufferedReader(new FileReader(f1));
			BufferedReader file2 = new BufferedReader(new FileReader(f2));
			FileWriter writeFile = new FileWriter(resultsFile)) {
			
			while((content1 = file1.readLine()) != null | (content2 = file2.readLine()) != null) {
				lineCounter++;
				
				// Check for end of files.
				if(content1 == null) content1 = "<End of File>";
				if(content2 == null) content2 = "<End of File>";
				
				// Write the difference to an output file.
				if(!content1.contentEquals(content2)) {
					equals = false;
					writeFile.write("Line " + lineCounter + ":");
					writeFile.write("\n" + f1 + ":\t" + content1);
					writeFile.write("\n" + f2 + ":\t" + content2 + "\n\n");
				}	
			}	
			return equals;
		}
		catch(IOException ex) {
			writeConsole.println(ex);
			return false;
		}
	}
	
}	
