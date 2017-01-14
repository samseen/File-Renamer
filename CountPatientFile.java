/** This class checks if the content in 
*	a folder of a patient is more than 10.
*/
import java.io.*;
import java.util.*;
public class CountPatientFile {
	List<File> incompleteFolders = new ArrayList<File>();
	public CountPatientFile() {
		File[] patFiles = new File("c:/Users/cotote/Desktop/ANNEX ARCHIEVEs").listFiles();
		//System.out.println(patFiles.length);
		
		for (File aFile : patFiles) { // Loop through the Patient Directory
			File[] theFile = aFile.listFiles(); //Split each Patient Directory probably into 10

			if (theFile.length != 10) {
				incompleteFolders.add(aFile); // Adds the incomplete file to an arrayList
			}
		}
		System.out.println(incompleteFolders.size()); //Prints the number of defective files
		for (File toPrint : incompleteFolders) {
			System.out.println(toPrint.getName());
		}
		
	}
	public static void main(String[] args) {
		CountPatientFile cpf = new CountPatientFile();
	}
}