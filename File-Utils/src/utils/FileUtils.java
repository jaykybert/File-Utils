package utils;

import java.io.*;


public class FileUtils {
	
	
	void displayFile(String filename) {
		String content;
		try(BufferedReader readFile = new BufferedReader(new FileReader(""))) {
			
			while((content = readFile.readLine()) != null) {
				System.out.println(content);
			}
			
		}
		catch(FileNotFoundException exc) {
			System.out.println(exc);
		}
		catch(IOException exc) {
			System.out.println(exc);
		}
	}

	
	
	
}
