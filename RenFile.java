//This class accepts the absolute path(string) of the file to be renamed and uses the upper 
//directory to get the idCode(), nameTag() and folderTag()
//which it stores in it's private variables

import java.util.*;
import java.io.*;

public class RenFile {
  	RenFile(File myFile) {
  		setFileName(myFile);
  	}

  	private String idCode;
  	private String nameTag;
  	private String fileName; //The main String needed to rename a file
  	private String folderTag;
  	private String folderName;
	private NameFormatter nf;

	public char getFirstLetter(String name) {
		char id = ' ';
		id = name.charAt(0);
		return id;
	}

	public void computeNameTag(String tag) { //reverses the tag name
		String temp = "";
		int token = tag.length();
		while (token > 0) {
			temp += tag.charAt(token - 1);
			token--;
		}
		setNameTag(temp);
	} 

	public void splitFileName(File myFile) { //Use this method to set the necessary parameters
		/* Sets the idCode, nameTag, and the folderTag */
		
		String fileName = myFile.getAbsolutePath(); //returns the absolute path of the file
		//System.out.print("FileName: " + fileName);
		//nf = new NameFormatter(fileName);
		//String toUse = nf.getTheFileName(); //The formatted String to be used to rename
		//System.out.println("TO USE: " + toUse);
		
		String[] tag = fileName.split("\\\\"); //works with TryThis
		
		cork(tag[5]); //for setting the idCode and nameTag

		setFolderName(tag[tag.length - 2]);
		//System.out.print(getFolderName());

		setFolderTag(getFolderName()); //for setting the folderTag

		//Checks if the directory is not a patient record folder e.g ANC by checking if the firstElement is a string
		if(isNumeric(tag[0])) { 
			setIdCode(tag[0]);
			/*Check the numbers of array in the element, and knows the amount of names a patient has */
			int nameNos = (tag.length) - 1; //Number of names a patient has
			String reversedName = "";
			//Get the first letters of everyname in the array, passing the names in the array from the Last index
			while (nameNos > 0) {
				reversedName += getFirstLetter(tag[nameNos]);
				nameNos--;
			}	
			computeNameTag(reversedName);
		}
				
	}

	public void cork(String bullet) {
		String [] bulletArr = bullet.split(" "); //works with TryThis
		if(isNumeric(bulletArr[0])) { 
			setIdCode(bulletArr[0]);
			int nameNos = (bulletArr.length) - 1; //Number of names a patient has
			String reversedName = "";
			//Get the first letters of everyname in the array, passing the names in the array from the Last index
			while (nameNos > 0) {
				reversedName += getFirstLetter(bulletArr[nameNos]);
				nameNos--;
			}	
			computeNameTag(reversedName);
		}
	}

	/* An example of patRecFolder is ANC, CLERKING SHEET, ARCHIVE, OPERATION NOTES, e.t.c */
	public void setFolderTag(String patRecFolder) {
		//compare the patRecFolder with the 'ANC' and the likes to know the folderTag.
		//folderTag are: ANC, A, CS, DC, DS, D, L, E, S, X, MR, NC, ON. 
		String tag = "";
		String chk = patRecFolder.substring(0, 3);
		if (chk.equalsIgnoreCase("ANC")) {
			//The folderTag is ANC:ANC
			tag = "ANC";
		} else if (chk.equalsIgnoreCase("ARC")) {
			//The folderTag is A:ARCHIVE
			tag = "A";
		} else if (chk.equalsIgnoreCase("CLE")) {
			//The folderTag is CS:CLERKING SHEET
			tag = "CS";
		} else if (chk.equalsIgnoreCase("DIA")) {
			//The folderTag is DC:DIALYSIS CHART
			tag = "DC";
		} else if (chk.equalsIgnoreCase("DIS")) {
			//The folderTag is DS:DISCHARGE SUMMARY
			tag = "DS";
		} else if (chk.equalsIgnoreCase("DRU")) {
			//The folderTag is D:DRUGS
			tag = "D";
		} else if (chk.equalsIgnoreCase("LAB")) {
			//The folderTag is L:LABORATORY 
			tag = "L";
		} else if (chk.equalsIgnoreCase("ECG")) {
			//The folderTag is E:ECG
			tag = "E";
		} else if (chk.equalsIgnoreCase("SCA")) {
			//The folderTag is S:SCAN
			tag = "S";
		} else if (chk.startsWith("X")) {
			//The folderTag is X:XRAY
			tag = "X";
		} else if (chk.equalsIgnoreCase("MED")) {
			//The folderTag is ME: Medical Report
			tag = "MR";
		} else if (chk.equalsIgnoreCase("NUR")) {
			//The folderTag is NC:NURSING CHART
			tag = "NC";
		} else if (chk.equalsIgnoreCase("OPE")) {
			//The folderTag is ON:OPERATION NOTE
			tag = "ON";
		} else { //The folderTag is null
			tag = "NULL";
		}
		folderTag = tag;
	}


	public void setIdCode(String code) {
		idCode = code;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setNameTag(String name) {
		nameTag = name;
	}

	public String getNameTag() {
		return nameTag;
	}

	public static boolean isNumeric(String str) { //Works with TryThis
  		return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	public void setFileName(File workFile) { //computes the name. E.g IMG_12345_ASO_ANC/A/CSL..e.t.c
		splitFileName(workFile); 
		String toBeNamed = "IMG_" + getIdCode() + "_" + getNameTag() + "_" + getFolderTag();
		fileName = toBeNamed.toUpperCase();
	}

	public String getFileName() {
		return fileName;
	}

	public String getFolderTag() {
		return folderTag;
	}

	public void setFolderName(String name) {
		folderName = name;
	}

	public String getFolderName() {
		return folderName;
	}
	/** Unit Testing
	* public static void main(String[] args) {
	*	File filer = new File("3018 Ogbe Nathaniel .   J");
	*	RenFile rf = new RenFile(filer);
	*	rf.splitFileName(filer);
	*}
	*/
}