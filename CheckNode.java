// This handles the case of INVESTIGATION
import java.io.*;

public class CheckNode {
	private int fileCount;
	public CheckNode(File file) {
		resetFileCount();
		computeNode(file);
	}
	public void computeNode(File myFile) {
		if (myFile.isDirectory()) {
			File[] myFileArr = myFile.listFiles(); //Allocates the content of myFile to an array
			for (File myFileArrEle : myFileArr) {
				computeNode(myFileArrEle); //Calls the same method until there is a file
			}
			
		}
		else {
			System.out.println(myFile.getName());
			setFileCount(getFileCount());
		}
	}
	public void setFileCount(int value) {
		fileCount = value + 1;
	}
	public int getFileCount() {
		return fileCount;
	}
	public void resetFileCount() {
		fileCount = 0;
	}
}