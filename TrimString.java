import java.util.*;
public class TrimString {
	private String myString;
	ArrayList<Character> myChar;
	public TrimString(String theString) {
		trimString(theString);
		removeSpaces(theString);

	}
	public void trimString(String theString) {
		String trimmedString = theString.trim();
		setString(trimmedString);
	}
	public void setString(String theString) {
		myString = theString;
	}
	public String getString() {
		return myString;
	}
	public void removeSpaces(String theString) {
		/** split the theString into a char ArrayList
		*	iterate through the array and check if 
		*	two consecutive characters is equal to a
		*	space. Then remove one of the spaces.
		*/
		setCharArray(getString());
		chkArrForSpace();
		//Print the content of myChar
		for (int i = 0; i < myChar.size(); i++) {
			System.out.print(myChar.get(i));	
		}
		

	}
	// Converts a string into an ArrayList of characters
	public void setCharArray(String theString) {
		char update = ' ';
		myChar = new ArrayList<Character>();

		
		for (int i = 0; i < theString.length(); i++) {
			update = theString.charAt(i);
			myChar.add(update);
		}
		
		//System.out.print("Size of Character Array: " + myChar.size());
	}
	public ArrayList<Character> getCharArray() {
		return myChar;
	}
	//Checks for double consecutive spaces and removes the last one
	public void chkArrForSpace() {
		for (int i = 0; i < getCharArray().size(); i++) {
			while(i < getCharArray().size()) {
				if ((myChar.get(i) == ' ') & (myChar.get(i + 1) == ' ')) {
					myChar.remove(i+1);
				}
			}
		}
	}
}