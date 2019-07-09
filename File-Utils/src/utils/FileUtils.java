package utils;

import java.io.*;


public class FileUtils {
	
	/** 
	 * Take x files and reads each one, returning an array
	 * containing the content of each file as a string.
	 * @param filenames: x amount of files.
	 * @return fileContents: Array of the files' content.
	 */
	String[] readFiles(String ... filenames) {
		String[] fileContents = new String[filenames.length];
		StringBuilder fileContent = new StringBuilder();
		String contentLine;
			
		for(int i=0; i < filenames.length; i++) {
			
			try(BufferedReader readFile = new BufferedReader(new FileReader(filenames[i]))) {

				while((contentLine = readFile.readLine()) != null) {
					fileContent.append(contentLine + "\n");
				}
				fileContents[i] = fileContent.toString(); // Store file contents.
				fileContent.setLength(0); // Reset StringBuilder.
			}
		
			catch(IOException exc) {
				System.out.println(exc);
			}
			
		}
		return fileContents;
	}





}

