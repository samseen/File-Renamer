/** This class checks if a file can open
* and stores the PatientFile as a string in an arrayList
* while displaying and indicating the particular file that can't be opened
*/
import java.io.*;

public class FileReader {
	public static void main(String[] args) {
		//if a file can't be read, tell us
		File aFile = new File("c:/Users/cotote/Desktop/Bad.pdf");
		if(aFile.canExecute()) {
			System.out.print("It can be read");
		} else {
			System.out.print("It can't be read");
		}	
	}
	
}