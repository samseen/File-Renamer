/** This class renames a file by taking two arguments a string and a string.
* The File object is the file to be renamed
*/

import java.util.*;
import java.io.*;

public class FileNamer {
	private String newFileName;
	private String oldFileName;
	private String rootDir; //returns the path of the parent directory to be used for the nameToUse 

	private String name;

	FileNamer(String newName, String oldName) { //Using the oldPath as the rootFolder source
		String [] brokenOldName = oldName.split("/");
		int posNewName = brokenOldName.length - 2;
		String realName = "";
		int i = 0;
		while (i < posNewName) {
			realName += brokenOldName[i] + "/";
			i++;
		}
		setRootDir(realName);
		String nameToUse = getRootDir() + newName;
		setNewFileName(nameToUse);
		setOldFileName(oldName);
		//System.out.println("Concatenated NewName: " + getNewFileName());
		rename(getNewFileName(), getOldFileName());
	}

	public void rename(String newFileName, String oldFileName) {
		File file = new File(newFileName);

    	// File (or directory) with new name
    	File file2 = new File(oldFileName);
    	

    	// Rename file (or directory)
    	boolean success = file2.renameTo(file);  //This renames the file
    	if (!success) {
        	// File was not successfully renamed
    	}

	}

	public void setNewFileName(String myName) {
		newFileName = myName;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setOldFileName(String myFile) {
		oldFileName = myFile;
	}

	public String getOldFileName() {
		return oldFileName;
	}

	private void setRootDir(String rootPath) {
		rootDir = rootPath;
	}

	private String getRootDir() {
		return rootDir;
	}
}