/** This program checks a folder if it contains
*	other files, whilst listing the folders it sees
*	PLEASE REMOVE THE ELSE IF NOT NEEDED!!!
*/


import java.io.*;
import java.util.*;
public class FileAvailability {
	/* An array for keeping the found files */
	
	public static void main(String[] args) {
		ArrayList<String> foundFiles = new ArrayList<String>();
		ArrayList<String> notFoundFiles = new ArrayList<String>();
		File[] theFiles = new File("E:/PATIENT DETAILS").listFiles(); //What i'm checking with
		File[] toBeChecked = new File("D:/STNDATA2/OKAY UPLOAD").listFiles(); //Where I want to Check
		outer:

			for (int i = 0; i < theFiles.length; i++) { //Iterates through theFiles
				for (int j = 0; j < toBeChecked.length; j++) { //Iterates through toBeChecked
					/* Checks if an element of theFiles is present in toBeChecked */
					String theFileName = theFiles[i].getName();
					String checkedIn = toBeChecked[j].getName();
					if (theFileName.equals(checkedIn)) {
						//System.out.println(theFiles[i].getName());
						foundFiles.add(theFileName); //Adds the found file name to an array
						continue outer;
					} else { 
						notFoundFiles.add(theFileName);
					}
				}
			}

		/* This displays the whole files found */
		
		System.out.println("They are:");
		System.out.println("***************************");
		for (String finds : foundFiles) {
			System.out.println(finds);
		}
		System.out.println(foundFiles.size() + " were found");

		System.out.println(notFoundFiles.size() + " were not found");
	}
}