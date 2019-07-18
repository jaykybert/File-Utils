package utils;

public class FileUtilsTest {

	public static void main(String[] args) {

		String[] filenames = {"Files/f1.txt", "Files/f2.txt", "Files/f3.txt"};
		
		/* ReadFiles test.
		String[] results = f.readFiles(filenames);
		
		for(String result: results) {
			System.out.println("--------------------");
			System.out.println(result);
		}
		*/
		
		
		//f.writeFile("wontwork.txt", false);
		
		//System.out.println(FileUtils.compareFiles(filenames[0], filenames[1], "Files/output.txt"));
		
		FileUtils.copyFile("Files/f1.txt", "Files/f1_copied.txt");
		
		
	}
}
