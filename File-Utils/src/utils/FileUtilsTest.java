package utils;

public class FileUtilsTest {

	public static void main(String[] args) {
		
		FileUtils f = new FileUtils();
		String[] filenames = {"Files/f1.txt", "Files/f2.txt", "Files/f3.txt"};
		
		/* ReadFiles test.
		String[] results = f.readFiles(filenames);
		
		for(String result: results) {
			System.out.println("--------------------");
			System.out.println(result);
		}
		*/
		
		f.writeFile("wontwork.txt", false);
		
		
		
	}
}
