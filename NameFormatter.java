/* This class takes in a string and formats it according to it's 
*  Constructor's info
*/

public class NameFormatter {
	private String theFileName; //The Name of the File
	
	public NameFormatter(String fileName) {
		formatt(fileName);
		
	}
	
	//This method does three things: trims the string, removes the (.), removes the in-string more-than-one space
	public void formatt(String fileName) {
		setFileName(fileName);
		removeTrailingSpaces(getTheFileName());
		removeDot(getTheFileName());
		removeInlineSpace(getTheFileName());
		makeUpperCase(getTheFileName());
	}

	public void setFileName(String fileName) {
		theFileName = fileName;
	}

	/**
	* This is the formatted Name that is been returned
	*/
	public String getTheFileName() {
		return theFileName;
	}

	public void removeTrailingSpaces(String fileName) {
		String trimmedFileName = getTheFileName().trim();
		setFileName(trimmedFileName);
		
	}

	public void removeInlineSpace(String fileName) {
		String spaceRemoved = getTheFileName().replaceAll("( )+", " ");
		setFileName(spaceRemoved);
	}

	public void removeDot(String fileName) {
		String dotRemoved = getTheFileName().replaceAll("\\.+","");
		setFileName(dotRemoved);
	}

	public void makeUpperCase(String fileName) {
            String local = getTheFileName().toUpperCase();
            setFileName(local);
        }

}