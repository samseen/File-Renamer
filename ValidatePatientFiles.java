/** This program validates that the files
*	in a patient file is equal to ten(10)
*/
import java.io.File;
public class ValidatePatientFiles {
	private long patFolderCount;
	public ValidatePatientFiles() {
		/* Store the whole files in the path in an array */
		File[] patFiles = new File("c:/Users/cotote/Desktop/toDel").listFiles(); 
		for (File patFolder : patFiles) { // Loop through the patient Files
			/* Store the content of each folder in an array */
			File[] patFilesArr = patFolder.listFiles();
			patFolderCount = patFilesArr.length;
			System.out.println("Length of the files for " + patFolder.getName() + " are: " + patFolderCount);
		}
		
	}

	public static void main(String[] args) {
		ValidatePatientFiles vpf = new ValidatePatientFiles();

	}
}