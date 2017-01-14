/** This class checks for files that are more than 1 in 
*	a patient file. So as to know which PatRecs to be
*	combined.
*/
import java.io.*;
import java.util.*;

public class Superfluous {
	File[] myFile = new File("c:/Users/cotote/Desktop/ToWorkOn").listFiles(); //Path of the files to be checked
	ArrayList<File> guiltyFiles = new ArrayList<File>();
	DesignFile df;
	/** Checks if a directory has more than one file
	*	@param takes a file(patFile) where it wants to check
	*/
	public Superfluous() {
		//Give the checkFolder() files to work with
		for (File toDo : myFile) {
			checkFolder(toDo);
		}
		/*Print out the defective files*/
		System.out.println("**********************************");
		for (File guilty : guiltyFiles) {
			//System.out.println(guilty.getAbsolutePath());
			designFile(guilty);
		}
		System.out.println("The Number of files are: " + guiltyFiles.size());
	}
	public void checkFolder(File theFile) {
		File[] aFile = theFile.listFiles();
		for (File file : aFile) { // Loop through all the patient directory
			
			if (file.isDirectory()) {
				checkFolder(file); //Calls the same method until there is a file		
			}
			else {
				//System.out.println(myFile.getName());
				File chunk = file.getParentFile(); // Gets the parent file
				File[] chunkContent = chunk.listFiles(); //Pours the content of the parent file into an array
				/* Add the parent directory into an array if it's content is more than 1. */
				if (chunkContent.length > 1) { 
					guiltyFiles.add(chunk);
					break;
				}	
			}
		}
	}
	public void designFile(File aFile) {
		df = new DesignFile(aFile);
		System.out.println(df.getTheFileName() + " : " + df.getPatientFileName());
	}
	public static void main(String[] args) {
		Superfluous sf = new Superfluous();
	}
}