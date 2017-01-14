import java.io.*;
public class FilePack {
	private String idCode; //a class variable for unique id's
	//PatName name; //A class for storing a patient name
	private String patName; //Lazily loading the patient's name
	/** This method splits the name of a patient file into
	* 	the idCode and the PatName(name)
	*	@param file of type File
	*/
	public FilePack(File file) {
		patName = file.getName();  // Get's the name of the file
		String[] names = patName.split(" ");  // Split's the name into an array, delimited by whitespaces
		idCode = names[0]; // Set's the first array element as the idCode
		String myName = "";
		/* Keeps the remaining of the array element into the myName variable*/
		for (int i = 1; i < names.length; i++) {
			myName += names[i] + " ";
		}
		//name.setPatName(myName); //Set's the PatName setPatName method
	}
	public String getIdCode() {
		return idCode;
	}
	
}