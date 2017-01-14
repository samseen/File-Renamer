import java.io.*;
import java.util.*;

public class FileTest {

	
	
	public static void main(String[] args) {
		//File dir = new File("c:/Users/cotote/Desktop/Phlegm/64295 MAINA HADIZA/Clerking Sheet/gijgfy.pdf");
		String name = "c:/Users/cotote/Desktop/Phlegm/64295 MAINA HADIZA/Clerking Sheet/IMG_67249_IK_ON";
		File file = new File(name);

    	// File (or directory) with new name
    	File file2 = new File("c:/Users/cotote/Desktop/Phlegm/64295 MAINA HADIZA/Clerking Sheet/newname.pdf");
    	//if(file2.exists()) throw new java.io.IOException("file exists");

    	// Rename file (or directory)
    	boolean success = file.renameTo(file2);
    	if (!success) {
        	// File was not successfully renamed
    	}
	}
}