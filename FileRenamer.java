import java.io.*;
import java.util.*;

public class FileRenamer {
  public static void main(String[] args) {
    File dir = new File("c:/Users/cotote/Desktop/Phlegm"); //Gets the File object from it's location

    /**if (dir.isDirectory()) {
      *String [] dirContents = dir.list() ;
      *
      *for (int i = 0; i < dirContents.length; i++) {
      *  System.out.println(dirContents[i]);

      *}
    }
    */
    //prints the list of each subdirectory files in phlegm
    if (dir.isDirectory()) { //Gives the source of the whole record, e.g Archive Night
      ArrayList<File[]> myFiles = new ArrayList<File[]>(); // makes an arraylist of dir
      myFiles.add(dir.listFiles());        
      for (File [] myF : myFiles) { // Iterates through the myFiles Arraylist i.e all their files, Regina and co.,e.t.c
        for (File f : myF) { // A file of a Patient such as Uwajeh Regina
          /* This are where the subfiles in the files are */
          if (f.isDirectory()) { // Checks if Uwajeh Regina is a directory 
            ArrayList<File[]> patientDocs = new ArrayList<File[]>();
            patientDocs.add(f.listFiles()); //Puts Uwajeh Regina on an arraylist
            for (File [] fileOfPD : patientDocs) {  //Array holding different Records e.g ANC, ARCHIVE, e.t.c
              for (File note : fileOfPD) { //This should be the pdf document in each Folder, holding ANC e.g STNicholas1.pdf
                String [] noteContents = note.list(); //Array holding the names of docs in Folder if it's more than one
      
                for (int i = 0; i < noteContents.length; i++) {
                  System.out.println(noteContents[i]);
                }

              }
            }

          }
          //for ( : ) {
            
          //}
          String [] subDirFile = f.list();  
          System.out.println("**********************************");
          for (int i = 0; i < subDirFile.length; i++) { //prints the elements of the subdirectory array hopefully ANC,ARCHIVE...
            System.out.println(subDirFile[i]);           
          }
        }
      }
    }
  }
}