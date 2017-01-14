/** This program checks if a folder contains some files
*	it prints the number of found files, the ones not found.
*	It also prints the idCode of all the found and unfound files.
*/


import java.util.ArrayList;
import java.io.File;

public class FileCombat {
	FilePack fp;
	ArrayList<String> toBeSearchedID = new ArrayList<String>();
	ArrayList<String> searcherID = new ArrayList<String>();
	ArrayList<String> searcherID2 = new ArrayList<String>();
	ArrayList<String> found = new ArrayList<String>();
	ArrayList<String> notFound = new ArrayList<String>();
	public FileCombat() {
		File[] destArray = new File("c:/Users/cotote/Desktop/toDel").listFiles(); // Destination folder source
		File[] searchArray = new File("c:/Users/cotote/Desktop/toDel2").listFiles(); //Checking folder source
		for(File myFile : destArray) {
			stripDest(myFile);
		}
		for (File myFile : searchArray) {
			stripSearcher(myFile);
		}
		arena();
		fileInfo();
	}
	public void printFile(ArrayList<String> al) {
		for(String s : al) {
			System.out.println(s);
		}
	}

	public void fileInfo() {
		System.out.println("*******FOUND FILE(S)*******");
		printFile(found);
		System.out.println("*******FILE(S) NOT FOUND*******");
		printFile(searcherID);
		System.out.println("*******************************");
		System.out.println(found.size() + " file(s) was/were found");
		System.out.println(searcherID.size() + " file(s) was/were not found");
	}
	/*Get the idCode for the Destination file @param File file */
	public void stripDest(File file) {
		fp = new FilePack(file);
		toBeSearchedID.add(fp.getIdCode());
	}	
	/*Get the idCode for the Source file @param File file */
	public void stripSearcher(File file) {
		fp = new FilePack(file);
		String theId = fp.getIdCode();
		searcherID.add(theId);
		searcherID2.add(theId);
	}

	/* The idCode for the searchArray is been checked for in the destArray */
	public void arena() {
		
		for (int i = 0; i < searcherID2.size(); i++) {
			String ph = searcherID2.get(i);
			if (toBeSearchedID.contains(ph)) {
				found.add(ph);
				searcherID.remove(ph);
			} 
		}
		
	}
	public static void main(String[] args) {
		FileCombat fc = new FileCombat();
	}
}