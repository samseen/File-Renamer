import java.io.*;
import java.util.*;

public class CheckEmpty {

	public static void main(String... args) {
        File[] files = new File("c:/Users/cotote/Desktop/bigsmallFilled").listFiles();
        showFiles(files);
    }

	public static void showFiles(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                showFiles(file.listFiles()); 
            } else {
                System.out.println("File: " + file.getName());                                
            }
        }
    }
}