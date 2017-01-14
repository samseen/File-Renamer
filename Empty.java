import java.io.File;
import java.util.*;
/*This class check's if all it's file is empty
* It just returns empty if it contains no
* document in the patRec: ANC, ARCHIVE, DRUGS, E.T.C
**/
public class Empty {
	private int fileCount;
    private int count;
    private CheckNode handler;
    private int key;
    List<File> emptyFiles = new ArrayList<File>();
    
    public void loopThrough(File[] files) {

        /*
        Pass files into CheckNode to see if it is still a directory
        and it increments it if its not a directory. It gives the value to 
        an int variable here.
        */
        
        for (File patFile : files) { //Loops through the Patient Files
            resetFileCount();
            File[] patFileArr = patFile.listFiles();
            //prints the name of the patFile
            System.out.println("Patient File: " + patFile.getName());
            
            for (File patFolder : patFileArr) { //Loops through the Patient Records e.g ANC
                System.out.println("PatFolder: " + patFolder.getName());
                File[] patFolderArr = patFolder.listFiles();
                for (File patRec : patFolderArr) {
                    /* Checks if patRec is a folder
                        and returns the count if the patRec is a (pdf) File/Record 
                    */
                    handler = new CheckNode(patRec);                    
                    //System.out.println("patRec: " + patRec.getName());
                    setFileCount(handler.getFileCount());
                }               
            }
            System.out.println("The no of files are: " + getFileCount());
            key = getFileCount();
            if (key == 0) {
                emptyFiles.add(patFile);
            }
        }
    }
    public void printEmptyFiles() {
        System.out.println("**************************************");
        System.out.println("THE EMPTY FILES ARE: ");
        System.out.println(emptyFiles.size());
        for (File emptyFile : emptyFiles) {
            System.out.println(emptyFile.getName());
        }
    }
    public void setFileCount(int value) {
        fileCount = value + getFileCount();
    }
    public int getFileCount() {
        return fileCount;
    }
    public void resetFileCount() {
        fileCount = 0;
    }
} 