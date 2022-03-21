import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
/*
 * Henry Patrick Karugendo
 * 21/03/2022
 * 
 * Small program to help me move files and break down large folders into smaller ones, 
 * efficiently and quickly!
 * 
 */
public class FileManager {

	public static void main(String[] args) {
		final String DIR_STRING = "C:/Users/owner/Downloads";
		final File MAIN_DIR = new File(DIR_STRING);
		int moved = 0;
		int folder = 1;
		final int limit = 2000;
		
		try {
			for(final File f: MAIN_DIR.listFiles()) {
				File fd = new File(DIR_STRING + "/" + folder);
				
				if(!fd.exists()) {
					fd.mkdir();
				}
				
				if(!f.isDirectory()) {
					Files.move(Paths.get(DIR_STRING + "/" + f.getName()), 
							Paths.get(DIR_STRING + "/" + folder + "/" + f.getName()), 
							StandardCopyOption.REPLACE_EXISTING);
					moved++;
				}
				
				if(moved == limit) {
					moved = 0;
					folder++;
					System.out.println("Moved " + limit + " Files!");
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR MOVING FILES!!!");
		}
		
		
	}

}
