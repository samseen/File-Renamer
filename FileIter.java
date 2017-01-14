import java.io.*;
import java.util.*;

public class FileIter {

   

	public static void main(String... args) {
        File[] files = new File("c:/Users/cotote/Desktop/Temp").listFiles();
        showFiles(files);
    }

	public static void showFiles(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                showFiles(file.listFiles()); // Calls same method again.
                
            } else {
                //System.out.println("File: " + file.getName());
                FilePath fp = new FilePath(file);
                
                File file1 = new File(file.getAbsolutePath());
                File file2 = new File(fp.getNewName());
                file1.renameTo(file2); 
                System.out.println("old: " + file.getName());
                System.out.println("new: " + fp.getNewDisplayName()); 
            }
        }
    }
}
